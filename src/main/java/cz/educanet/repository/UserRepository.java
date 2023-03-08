package cz.educanet.repository;

import cz.educanet.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.codec.digest.DigestUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepository {
    private String salt = "&T2@5s";
    public void register(UserModel userModel) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/users?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users.user (fullName, email, hashedPassword, createdAt, updatedAt) VALUES (?, ?, ?, NOW(), NOW())"
                );

        ) {
            System.out.println(userModel.getFullName());
            preparedStatement.setString(1, userModel.getFullName());
            preparedStatement.setString(2, userModel.getEmail());
            preparedStatement.setString(3, DigestUtils.sha256Hex(userModel.getHashedPassword() + salt));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserModel login(UserModel userModel) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT u.userId, u.fullName, u.email, u.hashedPassword FROM users.user AS u WHERE u.email = ? AND u.hashedPassword = ?"
                )) {
            UserModel userDatabase = null;
            preparedStatement.setString(1, userModel.getEmail());
            preparedStatement.setString(2, DigestUtils.sha256Hex(userModel.getHashedPassword() + salt));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    userDatabase = (new UserModel(
                            resultSet.getString("fullName"),
                            resultSet.getString("email"),
                            resultSet.getString("hashedPassword")
                    ));
                }
            }
            return userDatabase;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSalt() {
        return salt;
    }
}

package cz.educanet.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UserModel {
    private int userId;
    private String fullName;
    private String email;
    private String hashedPassword;
    private String createdAt;
    private String updatedAt;


    public UserModel() {
    }

    public UserModel(String fullName, String email, String hashedPassword) {
        this.fullName = fullName;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public UserModel(int userId, String fullName, String email, String hashedPassword, String createdAt, String updatedAt) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}

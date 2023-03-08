package cz.educanet.services;

import cz.educanet.model.UserModel;
import cz.educanet.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named
public class UserServices {
    @Inject
    private UserRepository userRepository;

    @Inject
    private CurrentUser currentUser;

    public void register(UserModel userModel) {
        this.userRepository.register(userModel);
    }

    public UserModel login(UserModel userModel) {
        UserModel user = this.userRepository.login(userModel);
        currentUser.setCurrentUser(user);
        return user;
    }
}

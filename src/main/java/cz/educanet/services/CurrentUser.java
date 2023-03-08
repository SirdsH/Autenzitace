package cz.educanet.services;

import cz.educanet.model.UserModel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@SessionScoped
public class CurrentUser implements Serializable {
    private UserModel currentUser;

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }
}

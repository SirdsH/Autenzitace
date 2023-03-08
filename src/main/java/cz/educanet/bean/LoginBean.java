package cz.educanet.bean;

import cz.educanet.model.UserModel;
import cz.educanet.services.UserServices;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class LoginBean {
    @Inject
    private UserServices userServices;

    private UserModel loginUser = new UserModel("", "", "");

    public void login() throws IOException {
            this.userServices.login(loginUser);
            FacesContext.getCurrentInstance().getExternalContext().redirect("loggedIn.xhtml");
    }

    public UserModel getLoginUser() {
        return loginUser;
    }


}

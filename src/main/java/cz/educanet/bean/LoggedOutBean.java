package cz.educanet.bean;

import cz.educanet.services.CurrentUser;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class LoggedOutBean {
    @Inject
    private CurrentUser currentUser;

    public void LogOut() throws IOException {
        currentUser.setCurrentUser(null);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }



}

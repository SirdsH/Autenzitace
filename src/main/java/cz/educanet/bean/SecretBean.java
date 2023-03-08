package cz.educanet.bean;

import cz.educanet.services.CurrentUser;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class SecretBean {
    @Inject
    private CurrentUser currentUser;

    public void before(ComponentSystemEvent event) throws IOException {
        if (currentUser.getCurrentUser() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else {
        }
    }
}

/**
 * @author
 *
 * IV1201 Design of Global Applications: Group 8
 * Arvid Persson Moosavi <amoosavi at kth.se>
 * Arvin Behshad <arvinb at kth.se>
 * Milad Barai <barai at kth.se>
 * Massar Almosawi <massar at kth.se>
 *
 */
package se.kth.ict.iv1201.recruitmentapp.view;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "appWeb")
@RequestScoped
public class AppWeb {

    @Inject
    private User userData;

    /**
     * Creates a new instance of AppWeb
     */
    public AppWeb() {
    }

    /**
     * Used to get Username of current user
     *
     * @return String, Username of current user
     */
    public String getUsername() {
        return userData.getName();
    }

    /**
     * Used to check the role of the user
     *
     *
     * @return String describing outcome of check
     */
    public String checkUser() {
        if (userData.getRole().equalsIgnoreCase("Applicant")) {
            return "";
        }
        return "failure";
    }

    /**
     * Used to Logout user invalidates entire session
     *
     * @return String, returns index page redirect
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
}

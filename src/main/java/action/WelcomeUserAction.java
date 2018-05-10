package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

/**
 *
 * @author Nakura-gui <Jisashi.Nakamura at Nakcom.org>
 */
public class WelcomeUserAction extends ActionSupport {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Action(value = "login", results = {
        @Result(name = SUCCESS, type = "dispatcher", location = "/login.jsp")})
    public String login() {
        return "success";
    }

    @Action(value = "Welcome", results = {
        @Result(name = SUCCESS, type = "dispatcher", location = "/welcome_user.jsp")})
    @Override
    public String execute() {
        setUsername(username + " bonito dia");
        return "success";
    }

}

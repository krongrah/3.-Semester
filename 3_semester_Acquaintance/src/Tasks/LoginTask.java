/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

/**
 *
 * @author Sebas
 */
public class LoginTask extends Task {

    private String username;
    private String hPassword;

    public LoginTask(String username, String password) {
        super(TaskTypes.LOGIN);
        this.username = username;
        hPassword = password;
    }

    public String getUsername() {
        return username;
    }

    public String gethPassword() {
        return hPassword;
    }

}

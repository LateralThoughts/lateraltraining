package models;

import controllers.Secure;
import models.User;
import play.libs.Crypto;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        User user = User.find("byEmail", username).first();
        return accountValid(user) && passwordMatch(username, password, user);
    }

    private static boolean isAdmin(User account) {
        return account.isAdmin;
    }

    private static boolean passwordMatch(String username, String password, User account) {
        return Crypto.passwordHash(password).equals(account.password);
    }

    private static boolean accountValid(User account) {
        return account != null;
    }
}

package models;

import controllers.Secure;
import play.libs.Crypto;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        Account account = Account.find("byEmail", username).first();
        return accountValid(account) && passwordMatch(username, password, account);
    }

    private static boolean isAdmin(Account account) {
        return account.isAdmin;
    }

    private static boolean passwordMatch(String username, String password, Account account) {
        return Crypto.passwordHash(password).equals(account.password);
    }

    private static boolean accountValid(Account account) {
        return account != null;
    }
}

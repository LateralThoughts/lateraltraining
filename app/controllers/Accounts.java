package controllers;

import models.Account;
import play.modules.router.Get;
import play.mvc.Controller;

import java.util.List;

public class Accounts extends Controller {

    @Get("/trainers")
    public static void list() {
        List<Account> accounts = Account.findAll();
        render(accounts);
    }

    @Get("/trainers/{trainerId}/image")
    public static void showImage(long trainerId) {
        Account account = Account.findById(trainerId);
        renderBinary(account.image.getFile());
    }

}
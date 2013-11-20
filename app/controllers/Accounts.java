package controllers;

import models.Account;
import play.data.validation.Valid;
import play.modules.router.Get;
import play.modules.router.Post;
import play.mvc.Controller;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;

public class Accounts extends Controller {

    @Get("/trainers")
    public static void list() {
        List<Account> accounts = Account.findAll();
        Collections.shuffle(accounts);
        render(accounts);
    }

    @Get("/trainers/{trainerId}/image")
    public static void showImage(long trainerId) {
        Account account = Account.findById(trainerId);
        renderBinary(new ByteArrayInputStream(account.image.getData()));
    }
}
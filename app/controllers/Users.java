package controllers;

import models.Category;
import models.Training;
import models.User;
import play.modules.router.Get;
import play.mvc.Controller;

import java.util.List;

public class Users extends Controller {

    @Get("/trainers")
    public static void list() {
        List<User> users = User.findAll();
        render(users);
    }

    @Get("/trainers/{trainerId}/image")
    public static void showImage(long trainerId) {
        User user = User.findById(trainerId);
        renderBinary(user.image.getFile());
    }

}
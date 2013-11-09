package controllers;

import models.Category;
import models.Training;
import play.db.jpa.GenericModel;
import play.db.jpa.JPABase;
import play.modules.router.Get;
import play.mvc.Controller;

import java.util.List;

public class Trainings extends Controller {

    @Get("/trainings")
    public static void list() {
        List<Category> categories = Category.findAll();
        render(categories);
    }

    @Get("/trainings/{trainingId}/{title}")
    public static void read(Long trainingId, String title) {
        Training training = Training.findById(trainingId);
        render(training);
    }

    @Get("/trainings/{trainingId}/image")
    public static void showImage(long trainingId) {
        Training training = Training.findById(trainingId);
        renderBinary(training.image.getFile());
    }

}
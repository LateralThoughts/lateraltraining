package controllers;

import models.Category;
import models.Training;
import play.modules.router.Get;
import play.mvc.Controller;

import java.util.List;

public class Categories extends Controller {

    @Get("/category/{categoryId}/image")
    public static void showImage(long categoryId) {
        Category category = Category.findById(categoryId);
        renderBinary(category.image.getFile());
    }

}
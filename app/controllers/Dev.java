package controllers;

import models.User;
import play.Play;
import play.modules.router.Get;
import play.mvc.Controller;
import play.test.Fixtures;

public class Dev extends Controller {

    @Get("/reload")
    public static void reload() {
        if (Play.mode == Play.Mode.DEV) {
            Fixtures.deleteAllModels();
            Fixtures.loadModels("test-datas.yml");
        }
        Application.index();
    }

}
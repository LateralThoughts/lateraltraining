package controllers.admin;

import controllers.CRUD;
import controllers.Secure;
import models.Category;
import models.Security;
import models.Training;
import play.modules.router.Get;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class Trainings extends CRUD {
}
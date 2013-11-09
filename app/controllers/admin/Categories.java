package controllers.admin;

import controllers.CRUD;
import controllers.Secure;
import models.Category;
import models.Security;
import play.mvc.With;

@CRUD.For(Category.class)
@With(Secure.class)
public class Categories extends CRUD {
}
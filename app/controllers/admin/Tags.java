package controllers.admin;

import controllers.CRUD;
import controllers.Secure;
import models.Security;
import play.mvc.With;

@With(Secure.class)
public class Tags extends CRUD {
}
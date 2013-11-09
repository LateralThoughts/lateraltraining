package controllers.admin;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.Security;
import play.mvc.With;

@With(Secure.class)
@Check("isAdmin")
public class Users extends CRUD {
}
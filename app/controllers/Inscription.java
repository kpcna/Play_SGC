package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.inscription;


/**
 * Created by kpcna on 3/6/15.
 */
public class Inscription extends Controller
{
    @Security.Authenticated(Secured.class)
    public static Result inscription() {return ok(inscription.render(User.find.byId(request().username())));
    }
}

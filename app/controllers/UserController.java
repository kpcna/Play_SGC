package controllers;

import models.User;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.user;


import java.util.List;

import static play.libs.Json.toJson;

public class UserController extends Controller {

    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(user.render(User.find.byId(request().username())));
    }

    @Security.Authenticated(Secured.class)
    public static Result addUser()
    {
        User user = Form.form(User.class).bindFromRequest().get();
        user.DefineUserTypeStr();
        user.save();
        return redirect(routes.UserController.index());
    }

    @Security.Authenticated(Secured.class)
    public static Result getUsers()
    {
        List<User> users = new Model.Finder(String.class, User.class).all();
        return ok(toJson(users));
    }
}


package controllers;

import models.Cours;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cours;


import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by kpcna on 3/7/15.
 */
public class CoursController extends Controller {

    public static Result index() {
        return ok(cours.render("MY not your new application is ready."));
    }

    public static Result addCours()
    {
        Cours cours = Form.form(Cours.class).bindFromRequest().get();
        cours.save();
        return redirect(routes.CoursController.index());
    }

    public static Result getCours()
    {
        List<Cours> courses = new Model.Finder(String.class, Cours.class).all();
        return ok(toJson(courses));
    }
}

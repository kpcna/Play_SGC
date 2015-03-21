package controllers;

import models.Cours;
import models.Horaire;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.horaire;

import java.util.List;

import static play.data.Form.form;
import static play.libs.Json.toJson;

public class HoraireController extends Controller {

    @Security.Authenticated(Secured.class)
    public static Result horaire() {
        return ok(horaire.render(User.find.byId(request().username())));
    }

    @Security.Authenticated(Secured.class)
    public static Result addHoraire()
    {
        Horaire horaire = Form.form(Horaire.class).bindFromRequest().get();
        horaire.save();
        return redirect(routes.HoraireController.horaire());
    }

    @Security.Authenticated(Secured.class)
    public static Result getHoraires()
    {
        List<Horaire> horaires = new Model.Finder(String.class, Horaire.class).all();
        return ok(toJson(horaires));
    }
}
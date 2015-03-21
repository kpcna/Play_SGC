package controllers;

import models.Cours;
import models.User;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import play.data.validation.Validation;
import views.html.inscription;
import play.mvc.Result.*;

import static play.data.Form.form;


/**
 * Created by kpcna on 3/6/15.
 */
public class Inscription extends Controller
{

    @Security.Authenticated(Secured.class)
    public static Result inscription(String errorMsg) {return ok(inscription.render(User.find.byId(request().username()),errorMsg));
    }

    @Security.Authenticated(Secured.class)
    public static Result inscriptionCours(){
        DynamicForm dynamicForm = form().bindFromRequest();
        User currUser = User.find.byId(request().username());

        if(currUser.password.equals(dynamicForm.get("password")))
        {
            Cours currCours = Cours.find.byId(dynamicForm.get("coursselectionne"));
            currUser.coursInscritList.add(currCours);
            currUser.save();
            return redirect(routes.Inscription.inscription("success"));
        }
        else
        {
            return redirect(routes.Inscription.inscription("error"));
        }
    }
}

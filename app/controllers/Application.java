package controllers;

import models.Person;
import models.User;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.data.Form.form;
import static play.libs.Json.toJson;

public class Application extends Controller {

    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render("MY not your new application is ready."));
    }

    @Security.Authenticated(Secured.class)
    public static Result addPerson()
    {
        Person person = form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }

    @Security.Authenticated(Secured.class)
    public static Result getPersons()
    {
        List<Person> persons = new Model.Finder(String.class, Person.class).all();
        return ok(toJson(persons));
    }

    public static Result login() {
        return ok(
                login.render(form(Login.class))
        );
    }

    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(
                    routes.Application.index()
            );
        }
    }

    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.Application.login()
        );
    }

    public static class Login {

        public String email;
        public String password;

        public String validate() {
            if (User.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }
}


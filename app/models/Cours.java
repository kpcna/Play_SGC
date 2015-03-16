package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by kpcna on 3/7/15.
 */
@Entity
public class Cours extends Model {
    @Id
    public String sigle;

    public String titre;

    public String description;

    public int credits;

    public String siglePrealable;

    public static Finder<String,Cours> find = new Finder<String,Cours>(
            String.class, Cours.class
    );
}

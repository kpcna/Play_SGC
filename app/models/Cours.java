package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by kpcna on 3/7/15.
 */
@Entity
public class Cours extends Model {
    @Id
    public String id;

    public String titre;

    public String description;

    public String sigle;

    public int credits;

    public List<Cours> prealables;
}

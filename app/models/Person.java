package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by kpcna on 3/6/15.
 */
@Entity
public class Person extends Model
{
    @Id
    public String id;

    public String name;
}

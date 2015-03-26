package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Horaire extends Model {
    @Id
    @GeneratedValue
    public Long id;

    public String journee;

    public String datedebut;

    public String datefin;

    public String heuredebut;

    public String heurefin;

    public String courssigle;

    public static Finder<String,Horaire> find = new Finder<String,Horaire>(
            String.class, Horaire.class
    );
}

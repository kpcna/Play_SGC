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

    public String DateDebut;

    public String DateFin;

    public String HeureDebut;

    public String HeureFin;

    public String CoursSigle;

    public static Finder<String,Horaire> find = new Finder<String,Horaire>(
            String.class, Horaire.class
    );
}

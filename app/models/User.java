package models;
import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

import java.util.List;

@Entity
public class User extends Model {
    public enum TypeOfUser {
        administrator(0), teacher(1), student(2);

        private final int value;
        private TypeOfUser(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Id
    public String email;
    public String name;
    public String password;
    public int userType;
    public String userTypeStr;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "coursinscrits")
    private List<Cours> coursInscritList;

    public User(String email, String name, String password, int userType) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public void DefineUserTypeStr() {
        if(userType == TypeOfUser.administrator.getValue())
        {
            userTypeStr = "Administrateur";
        }
        else if(userType == TypeOfUser.teacher.getValue())
        {
            userTypeStr = "Professeur";
        }
        else if(userType == TypeOfUser.student.getValue())
        {
            userTypeStr = "Etudiant";
        }
    }

    public static Finder<String,User> find = new Finder<String,User>(
            String.class, User.class
    );

    public static User authenticate(String email, String password) {
        return find.where().eq("email", email)
                .eq("password", password).findUnique();
    }
}
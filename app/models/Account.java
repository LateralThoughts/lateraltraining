package models;

import database.Blob;
import org.hibernate.annotations.Type;
import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account extends Model {

    @Required
    @Email
    public String email;

    @Lob
    @Type(type="database.Blob")
    public Blob image;

    @Required
    public String name;

    @Required
    @MaxSize(1000)
    public String description;

    public boolean isAdmin;

    @ManyToMany
    public List<Tag> tags = new ArrayList<>();

    @Required
    @Password
    public String password;

    @Override
    public String toString() {
        return name;
    }
}

package models;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.db.jpa.Blob;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account extends Model {

    @Required
    @Email
    public String email;

    public Blob image;

    @Required
    public String name;

    @Required
    @MaxSize(1000)
    public String description;

    public boolean isAdmin;

    @OneToMany
    public List<Tag> tags = new ArrayList<>();

    @Required
    @Password
    public String password;

    @Override
    public String toString() {
        return name;
    }
}

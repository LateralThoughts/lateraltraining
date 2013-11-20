package models;


import database.Blob;
import org.hibernate.annotations.Type;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Training extends Model {

    @Required
    public String title;

    @Required
    public Long length;

    @Required
    public Long price;

    public Long priceFreelance;

    @MaxSize(10000)
    public String audience;

    @MaxSize(10000)
    public String goals;

    @MaxSize(10000)
    public String methodology;

    @MaxSize(10000)
    public String prerequisites;

    @Required
    @MaxSize(10000)
    public String agenda;

    @Lob
    @Type(type="database.Blob")
    public Blob image;


    @ManyToMany
    public Set<Account> accounts = new HashSet<>();

    @ManyToMany
    public Set<Category> categories = new HashSet<>();

    @Override
    public String toString() {
        return title;
    }
}

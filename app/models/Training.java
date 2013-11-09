package models;


import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Blob;
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

    @Lob
    @MaxSize(10000)
    public String audience;

    @Lob
    @MaxSize(10000)
    public String goals;

    @Lob
    @MaxSize(10000)
    public String methodology;

    @Lob
    @MaxSize(10000)
    public String prerequisites;

    @Required
    @Lob
    @MaxSize(10000)
    public String agenda;

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

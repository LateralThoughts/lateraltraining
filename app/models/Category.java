package models;

import play.db.jpa.Blob;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Category extends Model {

    public String title;

    public String description;

    @ManyToMany(mappedBy = "categories")
    public Set<Training> trainings = new HashSet<>();

    //@Lob
    public Blob image;

    @Override
    public String toString() {
        return title;
    }
}

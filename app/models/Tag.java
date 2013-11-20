package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Tag extends Model {

    public String title;

    public Tag(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

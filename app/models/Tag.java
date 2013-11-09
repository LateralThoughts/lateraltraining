package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Tag extends Model {

    public String title;

    @Override
    public String toString() {
        return title;
    }
}

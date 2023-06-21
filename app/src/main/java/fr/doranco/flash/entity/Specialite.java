package fr.doranco.flash.entity;


import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "specialites",
        indices = {@Index(value = {"nom"}, unique = true ) }
)
public class Specialite {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nom;

    public Specialite() {
    }

    public Specialite(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "\n Specialite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}





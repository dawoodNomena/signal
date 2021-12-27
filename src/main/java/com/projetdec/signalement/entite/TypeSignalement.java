package com.projetdec.signalement.entite;
import java.sql.*;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class TypeSignalement{
    @Id @GeneratedValue Long id;
    String titre;

    public TypeSignalement construct(ResultSet res) throws Exception
    {
        TypeSignalement p=new TypeSignalement(res.getLong(1),res.getString(2));
        return p;
    }

    public TypeSignalement() {}
    public TypeSignalement(Long id,String titre){
        this.id = id;
        this.titre = titre;
    }

    public String getTitre(){
        return titre;
    }

    public void setTitre(String n) {
        titre = n;
    }

    public Long getId() {
        return this.id;
      }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof TypeSignalement))
        return false;
        TypeSignalement mons = (TypeSignalement) o;
        return Objects.equals(this.id, mons.id) && Objects.equals(this.titre, mons.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.titre);
    }
}
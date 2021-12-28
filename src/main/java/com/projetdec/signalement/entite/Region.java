package com.projetdec.signalement.entite;
import java.sql.*;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="region")
public class Region{
    @Id
    @GeneratedValue Long id;
    String nom;
    double coorX;
    double coorY;

    public Region construct(ResultSet res) throws Exception
    {
        Region p=new Region(res.getLong(1),res.getString(2),res.getDouble(3),res.getDouble(4));
        return p;
    }

    public Region() {}
    public Region(Long id,String nom, double coorX,double coorY){
        this.id = id;
        this.nom = nom;
        this.coorX = coorX;
        this.coorY = coorY;
    }

    public double getCoorX(){
        return coorX;
    }

    public void setCoorX(double n) {
        coorX = n;
    }

    public double getCoorY(){
        return coorY;
    }

    public void setCoorY(double n) {
        coorY = n;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String n) {
        nom = n;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Region))
        return false;
        Region admn = (Region) o;
        return Objects.equals(this.id, admn.id) && Objects.equals(this.nom, admn.nom) && Objects.equals(this.coorX, admn.coorX) && Objects.equals(this.coorY, admn.coorY) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.nom,this.coorX,this.coorY);
    }
}
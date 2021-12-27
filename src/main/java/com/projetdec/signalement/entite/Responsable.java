package com.projetdec.signalement.entite;
import java.sql.*;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Responsable{
    @Id @GeneratedValue Long id;
    String login;
    String nom;
    int idRegion;
    String mdp;

    public Responsable construct(ResultSet res) throws Exception
    {
        Responsable p=new Responsable(res.getLong(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5));
        return p;
    }

    public Responsable() {}
    public Responsable(Long id,String login,String nom, int idRegion,String mdp){
        this.id = id;
        this.nom = nom;
        this.login = login;
        this.idRegion = idRegion;
        this.mdp = mdp;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String n) {
        login = n;
    }
    
    public int getIdRegion(){
        return idRegion;
    }

    public void setIdRegion(int n) {
        idRegion = n;
    }
    
    public String getMdp(){
        return mdp;
    }

    public void setMdp(String n) {
        mdp = n;
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
        if (!(o instanceof Responsable))
        return false;
        Responsable mons = (Responsable) o;
        return Objects.equals(this.id, mons.id) && Objects.equals(this.nom, mons.nom) && Objects.equals(this.login, mons.login) && Objects.equals(this.idRegion, mons.idRegion) && Objects.equals(this.mdp, mons.mdp) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.nom,this.login,this.idRegion,this.mdp);
    }

}
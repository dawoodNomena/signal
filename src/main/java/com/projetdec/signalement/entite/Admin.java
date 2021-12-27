package com.projetdec.signalement.entite;
import java.sql.*;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Admin{
    @Id @GeneratedValue Long id;
    String login;
    String nom;
    String mdp;

    public Admin construct(ResultSet res) throws Exception
    {
        Admin p=new Admin(res.getLong(1),res.getString(2),res.getString(3),res.getString(4));
        return p;
    }

    public Admin() {}
    public Admin(Long id,String login, String nom,String mdp){
        this.id = id;
        this.login = login;
        this.nom = nom;
        this.mdp = mdp;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String n) {
        login = n;
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
        if (!(o instanceof Admin))
        return false;
        Admin admn = (Admin) o;
        return Objects.equals(this.id, admn.id) && Objects.equals(this.nom, admn.nom) && Objects.equals(this.login, admn.login) && Objects.equals(this.mdp, admn.mdp) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.nom,this.login,this.mdp);
    }
}
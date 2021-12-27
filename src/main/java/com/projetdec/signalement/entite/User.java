package com.projetdec.signalement.entite;
import java.sql.*;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class User{
    @Id @GeneratedValue Long id;
    String login;
    String nom;
    String mdp;

    public User construct(ResultSet res) throws Exception
    {
        User p=new User(res.getLong(1),res.getString(2),res.getString(3),res.getString(4));
        return p;
    }

    public User() {}
    public User(Long id,String login,String nom,String mdp){
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

    public String getNom(){
        return nom;
    }

    public void setNom(String n) {
        nom = n;
    }

    public String getMdp(){
        return mdp;
    }

    public void setMdp(String n) {
        mdp = n;
    }

    public Long getId() {
        return this.id;
      }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof User))
        return false;
        User mons = (User) o;
        return Objects.equals(this.id, mons.id) && Objects.equals(this.login, mons.login) && Objects.equals(this.nom, mons.nom) && Objects.equals(this.mdp, mons.mdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.login,this.nom,this.mdp);
    }
}
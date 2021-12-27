package com.projetdec.signalement.entite;
import java.sql.*;
import java.util.Objects;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Signalement{
    @Id @GeneratedValue Long id;
    int idRegion;
    int idUser;
    java.sql.Date date;
    int idType;
    String status;
    double coorX;
    double coorY;

    public Signalement construct(ResultSet res) throws Exception
    {
        Signalement p=new Signalement(res.getLong(1),res.getInt(2),res.getInt(3),res.getDate(4),res.getInt(5),res.getString(6),res.getDouble(7),res.getDouble(8));
        return p;
    }

    public Signalement() {}
    public Signalement(Long id,int idRegion,int idUser,java.sql.Date date,int idType,String status,double coorX,double coorY){
        this.id = id;
        this.idRegion = idRegion;
        this.idUser = idUser;
        this.date = date;
        this.idType = idType;
        this.status = status;
        this.coorX = coorX;
        this.coorY = coorY;
    }

    public double getCoorY(){
        return coorY;
    }

    public void setCoorY(double n) {
        coorY = n;
    }

    public double getCoorX(){
        return coorX;
    }

    public void setCoorX(double n) {
        coorX = n;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String n) {
        status = n;
    }

    public int getIdType(){
        return idType;
    }

    public void setIdType(int n) {
        idType = n;
    }

    public java.sql.Date getDate(){
        return date;
    }

    public void setDate(java.sql.Date n) {
        date = n;
    }

    public int getIdUser(){
        return idUser;
    }

    public void setIdUser(int n) {
        idUser = n;
    }

    public int getIdRegion(){
        return idRegion;
    }

    public void setIdRegion(int n) {
        idRegion = n;
    }

    public Long getId() {
        return this.id;
      }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Signalement))
        return false;
        Signalement mons = (Signalement) o;
        return Objects.equals(this.id, mons.id) && Objects.equals(this.idRegion, mons.idRegion) && Objects.equals(this.idUser, mons.idUser) && Objects.equals(this.date, mons.date)
        && Objects.equals(this.idType, mons.idType) && Objects.equals(this.status, mons.status) && Objects.equals(this.coorX, mons.coorX) && Objects.equals(this.coorY, mons.coorY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.idRegion,this.idUser,this.date,this.idType,this.status,this.coorX,this.coorY);
    }
}
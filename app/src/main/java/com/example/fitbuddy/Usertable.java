package com.example.giatorsjava.Roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Usertable")
public class Usertable {

    public String name;
    public String moblie;
    public String email;
    public String city;
    public String password;
    public String address;
    @PrimaryKey(autoGenerate = true) public Integer id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usertable(String name, String moblie, String email, String city, String password, String address, Integer id) {
        this.name = name;
        this.moblie = moblie;
        this.email = email;
        this.city = city;
        this.password = password;
        this.address = address;
        this.id = id;
    }
}

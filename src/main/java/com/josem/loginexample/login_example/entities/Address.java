package com.josem.loginexample.login_example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="addresses", schema="test")
public class Address {

    @Id
    private int id;

/*  JoinColumn indica el nombre de la clave en caso de que se le de otro nombre
    @JoinColumn(name="usuario_id")
    Relacion de las tablas, varias direcciones pertenecen a un usuario
    manyToOne por defecto crea un campo con la relacion y el nombre de la tabla
    en este caso se llama users, entonces el nombre por defecto que genera
    es user_id
 */
    @ManyToOne
    private User user;

    private String countryCode;
    private String province;
    private String city;
    private int zipCode;
    private String street;
    private int floor;
    private String door;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }
}

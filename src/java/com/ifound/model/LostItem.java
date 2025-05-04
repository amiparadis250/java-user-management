/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifound.model;
import java.sql.Timestamp;

/**
 *
 * @author ISHIMWE Ami Paradis
 */
public class LostItem {
    private int id;
    private String name;
    private String founder;
    private String location;
    private Timestamp date;

    public LostItem() {}

    public LostItem(int id, String name, String founder, String location, Timestamp date) {
        this.id = id;
        this.name = name;
        this.founder = founder;
        this.location = location;
        this.date = date;
    }

    public LostItem(String name, String founder, String location, Timestamp date) {
        this.name = name;
        this.founder = founder;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import other.AvailableState;
import other.ClothesState;

/**
 *
 * @author ADMIN
 */
public class Clothes {
    private int id;
    private String name;
    private String type;
    private double price;
    private ClothesState state;

    public Clothes() {
    }

    public Clothes(int id, String name, double price, String type, ClothesState state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.state = state;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ClothesState getState() {
        return state;
    }

    public void setState(ClothesState state) {
        this.state = state;
    }
    
    public void onInit(){
        state = new AvailableState();
    }
}

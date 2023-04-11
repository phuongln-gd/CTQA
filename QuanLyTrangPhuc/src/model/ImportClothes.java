/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ImportClothes {
    private int id;
    private int amount;
    private double price;
    private double saleoff;
    private String note;
    private Clothes clothes;

    public ImportClothes() {
    }

    public ImportClothes(int id, int amount, double price, double saleoff, String note, Clothes clothes) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.saleoff = saleoff;
        this.note = note;
        this.clothes = clothes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(double saleoff) {
        this.saleoff = saleoff;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
    
    
}

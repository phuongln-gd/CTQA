/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ImportBill {
    private int id;
    private String date;
    private String paymentMethod;
    private double totalCost;
    private String note;
    private ImportStaff staff;
    private ClothesSupplier supplier;
    private List<ImportClothes> importClothesList;

    public ImportBill() {
        importClothesList = new ArrayList<>();
    }

    public ImportBill(int id, String date, String paymentMethod, double totalCost, String note, ImportStaff staff, ClothesSupplier supplier) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.totalCost = totalCost;
        this.note = note;
        this.staff = staff;
        this.supplier = supplier;
        importClothesList = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ImportStaff getStaff() {
        return staff;
    }

    public void setStaff(ImportStaff staff) {
        this.staff = staff;
    }

    public ClothesSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(ClothesSupplier supplier) {
        this.supplier = supplier;
    }

    public List<ImportClothes> getImportClothesList() {
        return importClothesList;
    }

    public void setImportClothesList(List<ImportClothes> importClothesList) {
        this.importClothesList = importClothesList;
    }
}

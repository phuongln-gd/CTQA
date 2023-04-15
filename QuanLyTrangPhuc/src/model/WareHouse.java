/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClothesDAOImpl;

/**
 *
 * @author FunG
 */
public class WareHouse {
    private int id;
    private int id_clothes;
    private int quantity;

    public WareHouse() {
    }

    public WareHouse(int id, int id_clothes, int quantity) {
        this.id = id;
        this.id_clothes = id_clothes;
        this.quantity = quantity;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_clothes() {
        return id_clothes;
    }

    public void setId_clothes(int id_clothes) {
        this.id_clothes = id_clothes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Object[] toObjects(){
        Clothes clothes = ClothesDAOImpl.getInstance().findOne(id_clothes);
        return new Object[]{
            id,clothes.getName(),clothes.getType(),clothes.getPrice(),quantity
        };
    }
}

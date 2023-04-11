/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.ClothesSupplier;

/**
 *
 * @author ADMIN
 */
public interface SupplierDAO {
    void createTableSupplier();
    void deleteTbl();
    boolean insertSupplier(ClothesSupplier supplier);
    
    int updateInfor(int id, String name, String address, String tel,String email);

    void deleteSupplier(int id);

    List<ClothesSupplier> searchSupplier(String s);
    
    List<ClothesSupplier> getListClothesSupplier();
    
    ClothesSupplier findOne(String s);
}


package dao;

import java.util.List;
import model.ClothesSupplier;

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

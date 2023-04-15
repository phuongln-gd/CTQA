
package dao;

import java.util.List;
import model.Clothes;

public interface ClothesDAO {
    void createTbl();
    void deleteTbl();
    boolean insertItem(Clothes clothes);
    
    int updateInfor(int id, String name, String type, double price);

    void deleteItem(int id);

    List<Clothes> searchClothes(String s);
    
    List<Clothes> getAll();
    
    Clothes findOne(int id);
}

package dao;

import java.util.List;
import model.Clothes;
import model.WareHouse;

public interface WareHouseDAO {
    void createTbl();
    void deleteTbl();
    boolean insertItem(WareHouse wareHouse);
    
    int updateInfor(int id, int id_clothes, int quantity);

    void deleteItem(int id);

    List<WareHouse> searchClothes(String s);
    
    List<WareHouse> getAll();
    
    WareHouse findOne(int id);
}

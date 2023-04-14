package processor;

//import dao.UserDAOImpl;

import dao.SupplierDAOImpl;
import model.ClothesSupplier;

//import model.User;

public class InitDataProcessImp implements InitDataProcess {
    private static InitDataProcessImp sInstance;

    public static InitDataProcessImp getInstance() {
        if (sInstance == null) {
            sInstance = new InitDataProcessImp();
        }
        return sInstance;
    }
    
    @Override
    public void initData() {
//        UserDAOImpl userDAO = UserDAOImpl.getInstance();
//        userDAO.createTableUser();
//        userDAO.insertUser(new User("admin","Admin","1",0));
//        userDAO.insertUser(new User("nv","NhanVien","1",1));
        
        SupplierDAOImpl.getInstance().createTableSupplier();
        SupplierDAOImpl.getInstance().insertSupplier(new ClothesSupplier( "cua hang 1", "Ha Noi", "0123423", "a@gmail.com"));
        SupplierDAOImpl.getInstance().insertSupplier(new ClothesSupplier( "cua hang 2", "Hai Phong", "0972341", "b@gmail.com"));
    }

    @Override
    public void cleanData() {
//        UserDAOImpl.getInstance().deleteTbl();
    }
}

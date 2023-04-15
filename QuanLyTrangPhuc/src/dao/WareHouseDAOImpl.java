package dao;

import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Clothes;
import model.WareHouse;

public class WareHouseDAOImpl implements WareHouseDAO {

    private static WareHouseDAOImpl sInstance;

    public static WareHouseDAOImpl getInstance() {
        if (sInstance == null) {
            sInstance = new WareHouseDAOImpl();
        }
        return sInstance;
    }

    @Override
    public void createTbl() {
        // create if not exist
        // table user (tenTaiKhoan,matKhau,tenNhanVien,role,force_update_matKhau)
        PreparedStatement ps = null;
        Connection conn = MySQLConnection.getInstance().getConnection();

        //.. coding
        String sql = "CREATE TABLE IF NOT EXISTS tblwarehouse (\n"
                + "id int primary key auto_increment,\n"
                + "id_clothes int\n"
                + ", quantity int\n"
                + ", FOREIGN KEY (id_clothes) REFERENCES tblclothes(id)"
                + ");";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("Loi khi tao bang Clothes:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public void deleteTbl() {
        String sql = "delete from tblwarehouse";

        Connection conn = MySQLConnection.getInstance().getConnection();

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
            // MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public boolean insertItem(WareHouse wareHouse) {
        boolean status = false;
        //insert ,check exist user, role
        if (findOne(wareHouse.getId()) == null) {
//            if (!checkRole(user.getRoleId())) {
            String sql = "INSERT INTO tblwarehouse(id_clothes, quantity) VALUES (?,?);";
            Connection conn = MySQLConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, wareHouse.getId_clothes());
                ps.setInt(2, wareHouse.getQuantity());
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                System.out.println("Loi khi insert clothes:\n" + ex);
            } finally {
                MySQLConnection.getInstance().closePrepareStatement(ps);
//                MySQLConnection.getInstance().closeConn(conn);
            }
        }
        return status;
    }

    @Override
    public int updateInfor(int id, int id_clothes, int quantity) {
        int status = 0;
        String sql = "UPDATE tblwarehouse SET id_clothes = ?, quantity = ?  WHERE id = ?";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_clothes);
            ps.setInt(2, quantity);
            ps.setInt(3, id);
            ps.executeUpdate();
            conn.commit();
            status = 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            status = 0;
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
            //MySQLConnection.getInstance().closeConn(conn);
        }
        return status;
    }

    @Override
    public void deleteItem(int id) {
        //delete
        String sql = "DELETE FROM tblwarehouse WHERE id = ?";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
            // MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public List<WareHouse> searchClothes(String s) {
        List<WareHouse> list = new ArrayList<>();
        //get list 
        String sql = "SELECT c.name,c.type,c.price,wh.quantity FROM tblclothes c\n"
                + "join tblwarehouse wh"
                + " on wh.id_clothes = c.id\n"
                + "where c.name like %ao dai% ";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + s + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                WareHouse item = new WareHouse();
                item.setId_clothes(rs.getInt("id_clothes"));
                item.setQuantity(rs.getInt("quantity"));
                list.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
            //MySQLConnection.getInstance().closeConn(conn);
        }
        return list;
    }

    @Override
    public List<WareHouse> getAll() {
        List<WareHouse> list = new ArrayList<>();

        //get list 
        String sql = "SELECT * FROM tblwarehouse";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                WareHouse item = new WareHouse();
                item.setId_clothes(rs.getInt("id_clothes"));
                item.setQuantity(rs.getInt("quantity"));
                list.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
            //MySQLConnection.getInstance().closeConn(conn);
        }
        return list;
    }

    @Override
    public WareHouse findOne(int id) {
        String sql = "SELECT * FROM tblwarehouse WHERE id = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                WareHouse item = new WareHouse();
                item.setId_clothes(rs.getInt("id_clothes"));
                item.setQuantity(rs.getInt("quantity"));
                return item;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi tim Clothes:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return null;
    }

}

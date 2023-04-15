
package dao;

import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Clothes;
import model.ClothesSupplier;


public class ClothesDAOImpl implements ClothesDAO {

    private static ClothesDAOImpl sInstance;

    public static ClothesDAOImpl getInstance() {
        if (sInstance == null) {
            sInstance = new ClothesDAOImpl();
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
        String sql = "CREATE TABLE IF NOT EXISTS tblClothes (\n"
                + "id int primary key auto_increment,\n"
                + "name varchar(80)\n"
                + ", type varchar(80)	\n"
                + ", price float"
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
        String sql = "delete from tblClothes";

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
    public boolean insertItem(Clothes clothes) {
        boolean status = false;
        //insert ,check exist user, role
        if (findOne(clothes.getId()) == null) {
//            if (!checkRole(user.getRoleId())) {
            String sql = "INSERT INTO tblClothes(name, type, price) VALUES (?,?,?);";
            Connection conn = MySQLConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, clothes.getName());
                ps.setString(2, clothes.getType());
                ps.setDouble(3, clothes.getPrice());
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
    public int updateInfor(int id, String name, String type, double price) {
        int status = 0;
        String sql = "UPDATE tblClothes SET name = ?, type = ?, price = ?  WHERE id = ?";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setDouble(3, price);
            ps.setInt(4, id);
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
        String sql = "DELETE FROM tblClothes WHERE id = ?";

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
    public List<Clothes> searchClothes(String s) {
        List<Clothes> list = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM tblClothes where name LIKE ? ";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+s+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Clothes item = new Clothes();
                item.setName(rs.getString("name"));
                item.setType(rs.getString("type"));                
                item.setPrice(rs.getDouble("price"));
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
    public List<Clothes> getAll() {
        List<Clothes> list = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM tblClothes";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clothes item = new Clothes();
                item.setName(rs.getString("name"));
                item.setType(rs.getString("type"));                
                item.setPrice(rs.getDouble("price"));
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
    public Clothes findOne(int id) {
        String sql = "SELECT * FROM tblClothes WHERE id = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Clothes item = new Clothes();
                item.setName(rs.getString("name"));
                item.setType(rs.getString("type"));
                item.setPrice(rs.getDouble("price"));
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

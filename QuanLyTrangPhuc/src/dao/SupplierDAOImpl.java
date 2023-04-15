/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClothesSupplier;

/**
 *
 * @author ADMIN
 */
public class SupplierDAOImpl implements SupplierDAO {

    private static SupplierDAOImpl sInstance;

    public static SupplierDAOImpl getInstance() {
        if (sInstance == null) {
            sInstance = new SupplierDAOImpl();
        }
        return sInstance;
    }

    @Override
    public void createTableSupplier() {
        // create if not exist
        // table user (tenTaiKhoan,matKhau,tenNhanVien,role,force_update_matKhau)
        PreparedStatement ps = null;
        Connection conn = MySQLConnection.getInstance().getConnection();

        //.. coding
        String sql = "CREATE TABLE IF NOT EXISTS tblClothesSupplier (\n"
            + "id int primary key auto_increment,\n" +
            "name varchar(50)\n" +
            ", address varchar(20)	\n" +
            ", tel varchar(20)\n" +
            ", email varchar(20)"
                + ");";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("Loi khi tao bang Supplier:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
    }

    @Override
    public void deleteTbl() {
       String sql = "delete from tblClothesSupplier";

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
    public boolean insertSupplier(ClothesSupplier supplier) {
        boolean status = false;
        //insert ,check exist user, role
        if (findOne(supplier.getId()+"") == null) {
//            if (!checkRole(user.getRoleId())) {
            String sql = "INSERT INTO tblClothesSupplier(name, address, tel, email) VALUES (?,?,?,?);";
            Connection conn = MySQLConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, supplier.getName());
                ps.setString(2, supplier.getAddress());
                ps.setString(3, supplier.getTel());
                ps.setString(4, supplier.getEmail());
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                System.out.println("Loi khi insert user:\n" + ex);
            } finally {
                MySQLConnection.getInstance().closePrepareStatement(ps);
//                MySQLConnection.getInstance().closeConn(conn);
            }
        }
        return status;
    }

    
    @Override
    public void deleteSupplier(int id) {
        //delete
        String sql = "DELETE FROM tblClothesSupplier WHERE id = ?";

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
    public List<ClothesSupplier> searchSupplier(String s) {
        List<ClothesSupplier> clothesSuppliers = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM tblClothesSupplier where name LIKE ? ";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+s+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                ClothesSupplier supplier = new ClothesSupplier();
                supplier.setName(rs.getString("name"));
                supplier.setAddress(rs.getString("address"));                
                supplier.setTel(rs.getString("tel"));
                supplier.setEmail(rs.getString("email"));
                clothesSuppliers.add(supplier);
            }
        } catch (SQLException ex) {
            System.out.println("hello");
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
            //MySQLConnection.getInstance().closeConn(conn);
        }
        return clothesSuppliers;
    }

    @Override
    public ClothesSupplier findOne(String s) {
        String sql = "SELECT * FROM tblClothesSupplier WHERE id = ?";
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(s));
            rs = ps.executeQuery();
            if (rs.next()) {
                ClothesSupplier supplier = new ClothesSupplier();
                supplier.setName(rs.getString("name"));
                supplier.setAddress(rs.getString("address"));                
                supplier.setTel(rs.getString("tel"));
                supplier.setEmail(rs.getString("email"));
                return supplier;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Loi khi tim nha cung cap:\n" + ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
//            MySQLConnection.getInstance().closeConn(conn);
        }
        return null;
    }

    @Override
    public List<ClothesSupplier> getListClothesSupplier() {
        List<ClothesSupplier> clothesSuppliers = new ArrayList<>();
        //get list 
        String sql = "SELECT * FROM tblClothesSupplier";

        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClothesSupplier supplier = new ClothesSupplier();
                supplier.setName(rs.getString("name"));
                supplier.setAddress(rs.getString("address"));                
                supplier.setTel(rs.getString("tel"));
                supplier.setEmail(rs.getString("email"));
                clothesSuppliers.add(supplier);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            MySQLConnection.getInstance().closeResultSet(rs);
            MySQLConnection.getInstance().closePrepareStatement(ps);
            //MySQLConnection.getInstance().closeConn(conn);
        }
        return clothesSuppliers;
    }

    @Override
    public int updateInfor(int id,String name, String address, String tel, String email) {
        int status = 0;
        String sql = "UPDATE tblClothesSupplier SET name = ?, address = ?, tel = ? , email = ?  WHERE id = ?";
        
        Connection conn = MySQLConnection.getInstance().getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, tel);
            ps.setString(4, email);            
            ps.setInt(5, id);
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

}

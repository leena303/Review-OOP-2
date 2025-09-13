package student;

import java.sql.*;
import java.util.*;

public class SinhVienDAO {
    private Connection conn;

    public SinhVienDAO() {
        conn = DBConnection.getConnection();
    }

    public boolean insert(SinhVien sv) {
        String sql = "INSERT INTO students(maSV, hoTen, ngaySinh, nganhDaoTao, diemTB, lopSH) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setDate(3, sv.getNgaySinh());
            ps.setString(4, sv.getNganhDaoTao());
            ps.setDouble(5, sv.getDiemTB());
            ps.setString(6, sv.getLopSH());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SinhVien sv) {
        String sql = "UPDATE students SET hoTen=?, ngaySinh=?, nganhDaoTao=?, diemTB=?, lopSH=? WHERE maSV=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getHoTen());
            ps.setDate(2, sv.getNgaySinh());
            ps.setString(3, sv.getNganhDaoTao());
            ps.setDouble(4, sv.getDiemTB());
            ps.setString(5, sv.getLopSH());
            ps.setString(6, sv.getMaSV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String maSV) {
        String sql = "DELETE FROM students WHERE maSV=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM qlsv.students";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("maSV"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh"),
                        rs.getString("nganhDaoTao"),
                        rs.getDouble("diemTB"),
                        rs.getString("lopSH")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SinhVien> getByLop(String lop) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE lopSH=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("maSV"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh"),
                        rs.getString("nganhDaoTao"),
                        rs.getDouble("diemTB"),
                        rs.getString("lopSH")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SinhVien> getByNganh(String nganh) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE nganhDaoTao=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nganh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("maSV"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh"),
                        rs.getString("nganhDaoTao"),
                        rs.getDouble("diemTB"),
                        rs.getString("lopSH")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SinhVien> getByMonth(int month) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE MONTH(ngaySinh)=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("maSV"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh"),
                        rs.getString("nganhDaoTao"),
                        rs.getDouble("diemTB"),
                        rs.getString("lopSH")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SinhVien> getSortByDiem() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY diemTB DESC";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("maSV"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh"),
                        rs.getString("nganhDaoTao"),
                        rs.getDouble("diemTB"),
                        rs.getString("lopSH")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}


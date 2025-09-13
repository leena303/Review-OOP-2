package student;

import java.sql.Date;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private Date ngaySinh;
    private String nganhDaoTao;
    private double diemTB;
    private String lopSH;

    public SinhVien(String maSV, String hoTen, Date ngaySinh, 
                    String nganhDaoTao, double diemTB, String lopSH) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.nganhDaoTao = nganhDaoTao;
        this.diemTB = diemTB;
        this.lopSH = lopSH;
    }

    // Getter & Setter
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getLopSH() {
        return lopSH;
    }

    public void setLopSH(String lopSH) {
        this.lopSH = lopSH;
    }
}

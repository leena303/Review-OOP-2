package student;

import java.sql.Date;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVienDAO dao = new SinhVienDAO();
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Xem danh sách tất cả SV");
            System.out.println("5. Xem danh sách theo lớp");
            System.out.println("6. Xem danh sách theo ngành");
            System.out.println("7. Sắp xếp theo điểm");
            System.out.println("8. Tìm theo tháng sinh");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Mã SV: ");
                    String ma = sc.nextLine();
                    System.out.print("Họ tên: ");
                    String ten = sc.nextLine().trim().replaceAll("\\s+", " ");
                    System.out.print("Ngày sinh (yyyy-mm-dd): ");
                    String ns = sc.nextLine();
                    System.out.print("Ngành (CNTT/KTPM): ");
                    String nganh = sc.nextLine();
                    System.out.print("Điểm TB: ");
                    double diem = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Lớp SH: ");
                    String lop = sc.nextLine();
                    SinhVien sv = new SinhVien(ma, ten, Date.valueOf(ns), nganh, diem, lop);
                    if (dao.insert(sv)) {
                        System.out.println("Thêm sinh viên thành công!");
                    } else {
                        System.out.println("Thêm sinh viên thất bại!");
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã SV cần sửa: ");
                    ma = sc.nextLine();
                    System.out.print("Tên mới: ");
                    ten = sc.nextLine();
                    System.out.print("Ngày sinh mới (yyyy-mm-dd): ");
                    ns = sc.nextLine();
                    System.out.print("Ngành mới: ");
                    nganh = sc.nextLine();
                    System.out.print("Điểm TB mới: ");
                    diem = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Lớp mới: ");
                    lop = sc.nextLine();
                    sv = new SinhVien(ma, ten, Date.valueOf(ns), nganh, diem, lop);
                    if (dao.update(sv)) {
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Cập nhật thất bại!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã SV cần xóa: ");
                    ma = sc.nextLine();
                    if (dao.delete(ma)) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy sinh viên để xóa!");
                    }
                    break;

                case 4:
                    System.out.println("📋 Danh sách sinh viên:");
                    dao.getAll().forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Nhập lớp: ");
                    lop = sc.nextLine();
                    System.out.println("📋 Danh sách sinh viên lớp " + lop + ":");
                    dao.getByLop(lop).forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Nhập ngành: ");
                    nganh = sc.nextLine();
                    System.out.println("📋 Danh sách sinh viên ngành " + nganh + ":");
                    dao.getByNganh(nganh).forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("📊 Danh sách sinh viên (sắp xếp theo điểm):");
                    dao.getSortByDiem().forEach(System.out::println);
                    break;

                case 8:
                    System.out.print("Nhập tháng: ");
                    int m = sc.nextInt();
                    System.out.println("📅 Danh sách sinh viên sinh trong tháng " + m + ":");
                    dao.getByMonth(m).forEach(System.out::println);
                    break;
            }
        } while (choice != 0);

        sc.close();
        System.out.println("👋 Đã thoát chương trình.");
    }
}

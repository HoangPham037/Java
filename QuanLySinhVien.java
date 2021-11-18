package vn.devpro.qlsv.qlsv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlsv.qld.QuanLyDiem;

public class QuanLySinhVien {
	public static ArrayList<SinhVien> list= new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static int autoId = 1;
	
	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n===========CAP NHAT THONG TIN SINH VIEN========");
			System.out.println("lua chon chuc nang cap nhat hang hoa");
			System.out.println("\t1. Them moi mot sinh vien");
			System.out.println("\t2. Hien thi danh sach sinh vien");
			System.out.println("\t3. Sua thong tin sinh vien");
			System.out.println("\t4. Xoa thong tin sinh vien");
			System.out.println("\t0. Quay lai");
			System.out.println("lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themSinhVien();
				break;
			case 2:
				hienThiDanhSachSinhVien();
				break;
			case 3:
				suaThongTinSinhVien();
				break;
			case 4:
				xoaSinhVien();
				break;
			case 5:
				sapXepDsSinhVien();
				break;
			case 0:
				return;
			default:
				System.out.println("lua chon khong hop le!!!");
			}
		} while (true);
	}

	private static void themSinhVien() {
		System.out.println("\n=========Them moi sinh vien vao danh sach========");
		System.out.println("Nhap ten sinh vien: ");
		String hoDem = sc.nextLine();
		if(hoDem.trim().length() == 0) {
			System.out.println("\tHo dem khong duoc de trong!");
			return;
		}
		System.out.println("Ten: ");
		String ten = sc.nextLine();
		if(ten.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong!");
			return;
		}
		System.out.println("Ngay sinh (dd/mm/yyyy):");
		String ngaySinh = sc.nextLine();
		if(ngaySinh.trim().length() == 0) {
			System.out.println("\tNgay sinh khong duoc de trong!");
			return;
		}
		System.out.println("Gioi tinh: ");
		String gioiTinh = sc.nextLine();
		
		//khoi tao doi tuong sinh vien vao list
		SinhVien sv = new SinhVien(autoId, hoDem, ten, ngaySinh, gioiTinh);
		list.add(sv);
		autoId++;
		System.out.println("\tThem moi sinh vien thanh cong :)");
	}

	private static void hienThiDanhSachSinhVien() {
		System.out.println("\n============DANH SACH SINH VIEN=========");
		System.out.printf("%-3s %-6s %-25s %-10s %-10s %n",
				"STT", "Ma SV", "Ho va ten", "Ngay sinh", "Gioi tinh");
		int stt = 1;
		sapXepDsSinhVien();
		for (SinhVien sinhVien : list) {
			System.out.printf("%-3d", stt++);
			sinhVien.display();
		}
		if(stt == 1) {
			System.out.println("Danh sach sinh vien trong!!!");
		}
		
	}

	private static void suaThongTinSinhVien() {
		System.out.println("\n========SUA THONG TIN SINH VIEN========");
		System.out.println("\tNhap ma sinh vien can sua: ");
		int maSv = Integer.parseInt(sc.nextLine());
		int index = indexOf(maSv);
		if(index == -1) {
			System.out.println("Sinh vien co ma sinh vien " + index + " khong co trong danh sach");
			return;
		}
		do {
			System.out.println("\t1. Sua ho dem");
			System.out.println("\t2. Sua ten");
			System.out.println("\t3. Sua ngay sinh");
			System.out.println("\t4. Sua gioi tinh");
			System.out.println("\t5. Quay lai");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: suaHoDem(index); break;
			case 2: suaTen(index); break;
			case 3: suaNgaySinh(index); break;
			case 4: suaGioiTinh(index); break;
			case 0: return;
			default: System.out.println("\tNhap sai lua chon!!!!");
			}
			
		}while(true);
		
	}


	private static void suaHoDem(int index) {
		System.out.println("\tNhap ho dem moi: ");
		String hoDem = sc.nextLine();
		if(hoDem.trim().length() == 0) {
			System.out.println("ho dem khong duoc de trong!!!");
			return;
		}
		list.get(index).setHoDem(hoDem);
		System.out.println("\tSua ho dem thanh cong :)");
		
	}

	private static void suaTen(int index) {
		
		System.out.println("\tNhap ten moi: ");
		String ten = sc.nextLine();
		if(ten.trim().length() == 0) {
			System.out.println("Ten khong duoc de trong!!!");
			return;
		}
		list.get(index).setTen(ten);
		System.out.println("\tSua ten thanh cong :)");
	}

	private static void suaNgaySinh(int index) {
		System.out.println("\tNhap ngay sinh moi: ");
		String ngaySinh = sc.nextLine();
		if(ngaySinh.trim().length() == 0) {
			System.out.println("Ngay sinh khong duoc de trong!!!");
			return;
		}
		list.get(index).setNgaySinh(ngaySinh);
		System.out.println("\tSua ngay sinh thanh cong :)");
		
	}

	private static void suaGioiTinh(int index) {
		System.out.println("\tNhap lai gioi tinh: ");
		String gioiTinh = sc.nextLine();
		if(gioiTinh.trim().length() == 0) {
			System.out.println("Gio tinh khong duoc de trong!!!");
			return;
		}
		list.get(index).setGioiTinh(gioiTinh);
		System.out.println("\tSua ho dem thanh cong :)");
	}

	private static void xoaSinhVien() {
		System.out.println("\n======XOA THONG TIN SINH VIEN========");
		System.out.println("\tNhap ma sinh vien can xoa: ");
		int maSV = Integer.parseInt(sc.nextLine());
		int index = indexOf(maSV);
		if(index == -1) {
			System.out.println("Sinh vien co ma: " + maSV + " khong co trong danh sach!");
			return;
		}
		int i = 0;
		while(i < QuanLyDiem.list.size() && QuanLyDiem.list.get(i).getMaSv() != maSV) {
			System.out.println("\tSinh vien da hoc va da co diem, khong the xoa sinh vien nay!");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa thong tin thanh cong :)");
		
	}

	public static void sapXepDsSinhVien() {
		Collections.sort(list, new Comparator<SinhVien>() {
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getTen().trim().compareToIgnoreCase(o2.getTen().trim());
			}
		});
	}
	public static int indexOf(int id) {
		for(int index = 0; index< list.size(); index++) {
			if(list.get(index).getMaSv() == id) {
				return index;
			}
		}
		return -1;
	}
}

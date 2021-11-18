package vn.devpro.qlsv.main;

import java.util.IllegalFormatConversionException;
import java.util.Scanner;

import vn.devpro.qlsv.qld.Diem;
import vn.devpro.qlsv.qld.QuanLyDiem;
import vn.devpro.qlsv.qlmh.MonHoc;
import vn.devpro.qlsv.qlmh.QuanLyMonHoc;
import vn.devpro.qlsv.qlsv.QuanLySinhVien;
import vn.devpro.qlsv.qlsv.SinhVien;


public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
		do {
			System.out.println("\n===========CHUONG TRINH QUAN LY SINH VIEN===========");
			System.out.println("Chon chuc nang can quan ly ");
			System.out.println("\t1. Cap nhat thong tin he thong sinh vien");
			System.out.println("\t2. Quan ly sinh vien");
			System.out.println("\t3. Tim kiem thong tin");
			System.out.println("\t0. Thoat!");
			
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: capNhatThongTinHeThong(); break;
			case 2: quanLySinhVien(); break;
			case 3: timKiemThongTin(); break;
			case 0: System.out.println("Da thoat khoi chuong trinh");
				System.exit(0);
			default: System.out.println("Chon sai chuc nang!!!");
			}
		}while(true);
		}catch(IllegalFormatConversionException e) {
			System.out.println(e.getMessage());
		}catch(NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}

	}
	private static void capNhatThongTinHeThong() {
		int chon;
		do {
			System.out.println("\n=============CHUC NANG CAP NHAT TONG TIN HE THONG===========");
			System.out.println("chon mot chuc nang cap nhat");
			System.out.println("\t1. Cap nhat thong tin sinh vien");
			System.out.println("\t2. Cap nhat thong tin mon hoc");
			System.out.println("\t3. Cap nhat thong tin diem");
			System.out.println("\t0. Quay lai");
			System.out.println("Lua chon chuc nang cap nhat");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				QuanLySinhVien.capNhat();
				break;
			case 2:
				QuanLyMonHoc.capNhat();
				break;
			case 3:
				QuanLyDiem.capNhap();
				break;
			case 0:
				return;
			default:
				System.out.println("lua chon chuc nang cap nhat khong hop le!!!");
			}
		} while (true);
		
	}
	private static void quanLySinhVien() {
		System.out.println("\n=====Hien thi bang diem======");
		System.out.println("\t1. Hien thi diem  sinh vien");
		System.out.println("\t0. Quay lai");
		System.out.println("lua chon: ");
		int chon = Integer.parseInt(sc.nextLine());
		switch (chon) {
		case 1: hienThiTheoSinhVien(); break;
		case 0 : return;
		}
		
	}
	private static void hienThiTheoSinhVien() {
		QuanLyDiem.hienThi();
	}
	private static void timKiemThongTin() {
		do {
		System.out.println("\n=====TIM KIEM ========");
		System.out.println("\t1. Tim kiem theo ma sinh vien");
		System.out.println("\t2. Tim kiem theo ma mon hoc");
		System.out.println("\t0. Quay lai");
		int chon = Integer.parseInt(sc.nextLine());
		switch (chon) {
		case 1 : timTheoMaSv(); break;
		case 2: timTheoMamh(); break;
		case 0: return;
		
		}
		}while(true);
	}
	private static void timTheoMamh() {
		
		System.out.println("\tNhap ma mon hoc: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyMonHoc.indexOf(id);
		if(index == -1) {
			System.out.println("\tKhong tim thay ket qua nao");
			return;
		}
		QuanLyMonHoc.list.get(index).display();
	}
	private static void timTheoMaSv() {
		System.out.println("\tNhap ma sinh vien: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLySinhVien.indexOf(id);
		if(index == -1) {
			System.out.println("\tKhong tim thay ket qua nao");
			return;
		}
		QuanLySinhVien.list.get(index).display();

	}}


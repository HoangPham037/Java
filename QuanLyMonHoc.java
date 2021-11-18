package vn.devpro.qlsv.qlmh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlsv.qld.QuanLyDiem;
import vn.devpro.qlsv.qlsv.QuanLySinhVien;

public class QuanLyMonHoc {
	public static ArrayList<MonHoc> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static int autoId = 1;
	
	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n=======CAP NHAT THONG TIN MON HOC=======");
			System.out.println("lua chon chuc nang: ");
			System.out.println("\t1. Them moi mot mon hoc");
			System.out.println("\t2. Hien thi danh sach mon hoc");
			System.out.println("\t3. Sua thong tin mon hoc");
			System.out.println("\t4. Xoa thong tin mon hoc");
			System.out.println("\t0. Quay lai");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1 : themMonHoc(); break;
			case 2 : hienThiMonHoc(); break;
			case 3: suaThongTinMH(); break;
			case 4: xoaThongTinMH(); break;
			case 0: return;
			default: System.out.println("Chon sai lua chon!!!");
			}
		}while(true);
	}

	private static void themMonHoc() {
		System.out.println("\n=======CAP NHAT DANH SACH MON HOC=======");
		System.out.println("Nhap ten mon hoc:");
		String monHoc = sc.nextLine();
		if(monHoc.trim().length() == 0) {
			System.out.println("Ten mon hoc khong duoc de trong!");
			return;
		}
		System.out.println("Nhap he so mon:");
		double heSo = Double.parseDouble(sc.nextLine());
		if(heSo < 0) {
			System.out.println("He so khong duoc be hon 0");
			return;
		}
		MonHoc mh = new MonHoc(autoId, monHoc, heSo);
		list.add(mh);
		autoId++;
		System.out.println("Them moi mon hoc thanh cong");
	}

	private static void hienThiMonHoc() {
		System.out.println("\n=========DANH SACH MOM HOC========");
		System.out.printf("%3s %5s %25s %5s%n", "STT", "Ma MH", "Ten mon hoc", "He So");
		int stt = 1;
		sapXep();
		for (MonHoc monHoc : list) {
			System.out.printf("%-3d", stt++);
			monHoc.display();
		}
		if(stt == 1) {
			System.out.println("Danh sach mon hoc trong!");
		}
	}
	
	private static void suaThongTinMH() {
		System.out.println("\n======SUA THONG TIN MON HOC=======");
		System.out.println("\tNhap ma mon hoc:");
		int maMh = Integer.parseInt(sc.nextLine());
		int index = indexOf(maMh);
		if(index == -1) {
			System.out.println("Mon hoc co ma la: " + maMh + " khong có trong danh sach!");
			return;
		}
		do {
			System.out.println("Ban muon sua thong tin ve");
			System.out.println("\t1. Ten mon hoc");
			System.out.println("\t2. He so mon hoc");
			System.out.println("\t0. Quay lai.");
			System.out.println("lua chon cua ban la: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: suaTenMh(index); break;
			case 2: suaHeSo(index); break;
			case 0: return;
			default: System.out.println("Chon sai lua chon!!");
			}
			
		}while(true);
		
	}

	private static void suaTenMh(int index) {
		System.out.println("\n====Sua ten mon hoc=====");
		System.out.println("Nhap moi ten mon hoc: ");
		String tenMh = sc.nextLine();
		if(tenMh.trim().length() == 0) {
			System.out.println("Ten mon hoc khong duoc de trong!");
			return;
		}
		list.get(index).setTenMonHoc(tenMh);
		System.out.println("\tSua ten mon hoc thanh cong :)");
	}

	private static void suaHeSo(int index) {
		System.out.println("\n====Sua he so mon hoc=====");
		System.out.println("Nhap moi he so mon hoc: ");
		double heSo = Double.parseDouble(sc.nextLine());
		if(heSo < 0) {
			System.out.println("He so mon hoc khong duoc be hon 0!");
			return;
		}
		list.get(index).setHeSo(heSo);
		System.out.println("\tSua he so mon hoc thanh cong :)");
		
	}

	private static void xoaThongTinMH() {
		System.out.println("\n========XOA THONG TIN MON HOC========");
		System.out.println("\tNhap ma mon hoc can xoa: ");
		int maMh = Integer.parseInt(sc.nextLine());
		int index = indexOf(maMh);
		if(index == -1) {
			System.out.println("Mon hoc co ma la: " + maMh + " khong co trong danh sach!!!");
			return;
		}
		//co thi kiem tra mon hoc da duoc sv dang ki hoc chua?
		int i = 0;
		while(i < QuanLyDiem.list.size() && QuanLyDiem.list.get(i).getMaMh() != maMh) {
			i++;
		}
		if(i < QuanLyDiem.list.size()) {
			System.out.println("\tMon hoc da co sinh vien hoc. khong the xoa!");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa thong tin mon hoc thanh cong :)");
		
	}
	
	public static void sapXep() {
		Collections.sort(list, new Comparator<MonHoc>() {
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMonHoc().trim().compareToIgnoreCase(o2.getTenMonHoc().trim());
			}
		});
	}
	public static int indexOf(int id) {
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getMaMonHoc() == id) {
				return index;
			}
		}
		return -1;
	}
}

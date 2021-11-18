package vn.devpro.qlsv.qld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.devpro.qlsv.qlmh.MonHoc;
import vn.devpro.qlsv.qlmh.QuanLyMonHoc;
import vn.devpro.qlsv.qlsv.QuanLySinhVien;
import vn.devpro.qlsv.qlsv.SinhVien;

public class QuanLyDiem {
	public static ArrayList<Diem> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void capNhap() {
		int chon;
		do {
			System.out.println("\n===========CAP NHAT DIEM=========");
			System.out.println("\t1. Them diem");
			System.out.println("\t2. Sua diem");
			System.out.println("\t3. Xoa diem");
			System.out.println("\t4. Hien Thi diem");
			System.out.println("\t0. Quay lai");
			System.out.println("Lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: themDiem(); break;
			case 2: suaDiem(); break;
			case 3: xoaDiem(); break;
			case 4: hienThi(); break;
			case 0: return;
			default: System.out.println("Lua chon khong dung!!!");
			}
		}while(true);
		
	}
	public static void hienThi() {
		System.out.println("\n=====DANH SACH DIEM THEO TUNG SINH VIEN=====");
		int stt =1;
		System.out.printf("%-3s %-25s %-25s %-5s%n",
				"STT","Ten sinh vien", "Ten mon hoc", "Diem");
		for (Diem diem : list) {		
			System.out.printf("%-3d", stt++);
			diem.display();
		}
	}
	private static void themDiem() {
		System.out.println("\n=========THEM DIEM=======");
		//Nhap ma sinh vien kiem tra ma sv co trong danh sach ko
		System.out.println("\tNhap ma sinh vien: ");
		int maSv = Integer.parseInt(sc.nextLine());
		int index1 = QuanLySinhVien.indexOf(maSv);
		if(index1 == -1) {
			System.out.println("\tSinh vien co ma: " + maSv + " khong co trong danh sach");
			return;
		}
		
		System.out.println("\tNhap ma mon hoc: ");
		int maMh = Integer.parseInt(sc.nextLine());
		int index2 = QuanLyMonHoc.indexOf(maMh);
		if(index2 == -1) {
			System.out.println("Mon hoc co ma: " + maMh + " khong co trong danh sach!");
			return;
		}
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMaMh() == maMh && list.get(i).getMaSv() == maSv) {
				System.out.println("Sinh vien da hoc mon hoc nay!");
				return;
			}
		}
		System.out.println("\tNhap diem: ");
		double diem = Double.parseDouble(sc.nextLine());
		if(diem < 0 || diem > 10) {
			System.out.println("Diem phai lon hon khong hoac duoi 10!!!");
			return;
		}
		Diem d = new Diem(maSv, maMh, diem);
		list.add(d);
		System.out.println("Them diem thanh cong :)");
		
	}

	private static void suaDiem() {
		System.out.println("\n========Sua Diem======");
		System.out.println("Nhap ma sinh vien: ");
		int maSv = Integer.parseInt(sc.nextLine());
		int index1 = indexOf(maSv);
		if(index1 == -1) {
			System.out.println("Sinh vien co ma: " + maSv + " khong co trong danh sach!");
			return;
		}
		System.out.println("Nhap ma mon hoc: ");
		int maMh = Integer.parseInt(sc.nextLine());
		int index2 = indexOf(maMh);
		if(index2 == -1) {
			System.out.println("Mon hoc co ma: " + maMh + " khong co trong danh sach!");
			return;
		}
		
		System.out.println("Nhap diem moi: ");
		double diem = Double.parseDouble(sc.nextLine());
		if(diem < 0 || diem > 10) {
			System.out.println("nhap diem sai cu phap!");
			return;
		}
		list.get(index1).setDiem(diem);
		System.out.println("Sua diem thanh cong :)");
		
	}


	private static void xoaDiem() {
		System.out.println("\n========Xoa diem=======");
		System.out.println("Nhap ma sinh vien: ");
		int maSv = Integer.parseInt(sc.nextLine());
		int index = indexOf(maSv);
		if(index == -1) {
			System.out.println("sinh vien co ma " + maSv + " khong co trong danh sach");
			return;
		}
		list.remove(index);
		System.out.println("xoa thanh cong");
	}
	public static int indexOf(int id) {
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getMaMh() == id) {
				return index;
			}
		}
		return -1;
	}
}

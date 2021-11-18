package vn.devpro.qlsv.qld;

import vn.devpro.qlsv.qlmh.QuanLyMonHoc;
import vn.devpro.qlsv.qlsv.QuanLySinhVien;

public class Diem {
	private int maSv;
	private int maMh;
	private double diem;
	
	
	public void display() {
		int index = QuanLySinhVien.indexOf(maSv);
		if(index == -1) {
			return;
		}
		int index2 = QuanLyMonHoc.indexOf(maMh);
		if(index2 == -1) {
			return;
		}
		String hoDem = QuanLySinhVien.list.get(index).getHoDem();
		String name = QuanLySinhVien.list.get(index).getTen();
		String tenMh= QuanLyMonHoc.list.get(index2).getTenMonHoc();
		double heSo = QuanLyMonHoc.list.get(index2).getHeSo();
		System.out.printf("%-25s %-25s  %-5.2f %n",hoDem+ " " + name, tenMh, diem);
	}
	
	public Diem() {
		super();
	}
	public Diem(int maSv, int maMh, double diem) {
		super();
		this.maSv = maSv;
		this.maMh = maMh;
		this.diem = diem;
	}
	public int getMaSv() {
		return maSv;
	}
	public void setMaSv(int maSv) {
		this.maSv = maSv;
	}
	public int getMaMh() {
		return maMh;
	}
	public void setMaMh(int maMh) {
		this.maMh = maMh;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	
	
}

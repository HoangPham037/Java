package vn.devpro.qlsv.qlsv;

public class SinhVien {
	private int maSv;
	private String hoDem;
	private String ten;
	private String ngaySinh;
	private String gioiTinh;
	
	public void display() {
		System.out.printf("%-6d %-25s %-10s %-10s %n",maSv, hoDem + ten, ngaySinh, gioiTinh);
	}
	public SinhVien() {
		super();
	}
	public SinhVien(int maSv, String hoDem, String ten, String ngaySinh, String gioiTinh) {
		super();
		this.maSv = maSv;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	public int getMaSv() {
		return maSv;
	}
	public void setMaSv(int maSv) {
		this.maSv = maSv;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
}

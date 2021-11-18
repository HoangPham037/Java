package vn.devpro.qlsv.qlmh;

public class MonHoc {
	private int maMonHoc;
	private String tenMonHoc;
	private double heSo;
	
	public void display() {
		System.out.printf("%-5d %-25s %-5.2f%n",maMonHoc, tenMonHoc, heSo);
	}
	
	public MonHoc() {
		super();
	}
	public MonHoc(int maMonHoc, String tenMonHoc, double heSo) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.heSo = heSo;
	}
	public int getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(int maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public double getHeSo() {
		return heSo;
	}
	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
	
	
}

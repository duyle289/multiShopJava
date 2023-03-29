package multiShopJava.SpringMVC.model;



public class cart {
	private int masp;
	private int mamau;
	private String tensp;
	private String hinhanh;
	private int soluong;
	private Double dongia;
	private Double tongtien;
	private String tenmau;
	private int slton; // sồ lượng tồn
	
    public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public int getMamau() {
		return mamau;
	}
	public void setMamau(int mamau) {
		this.mamau = mamau;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Double getDongia() {
		return dongia;
	}
	public void setDongia(Double dongia) {
		this.dongia = dongia;
	}
	public Double getTongtien() {
		return tongtien;
	}
	public void setTongtien(Double tongtien) {
		this.tongtien = tongtien;
	}
	public String getTenmau() {
		return tenmau;
	}
	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	public int getSlton() {
		return slton;
	}
	public void setSlton(int slton) {
		this.slton = slton;
	}
	public cart(int Masp, int Mamau, int sl)
    {
        masp = Masp;
        mamau = Mamau;
        soluong = sl;

    }
	public cart(String tensp, String hinhanh, Double dongia, Double tongtien, String tenmau, int slton) {
		super();
		this.tensp = tensp;
		this.hinhanh = hinhanh;
		this.dongia = dongia;
		this.tongtien = tongtien;
		this.tenmau = tenmau;
		this.slton = slton;
	}
    
}

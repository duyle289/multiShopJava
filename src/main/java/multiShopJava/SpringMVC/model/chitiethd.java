package multiShopJava.SpringMVC.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "chitiethds")
public class chitiethd {
	private int id;
	private int SOLUONG;
	private double DONGIA;
	private hoadon hd;
	private mausac ms;
	private sanpham sp;
	
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSOLUONG() {
		return SOLUONG;
	}
	public void setSOLUONG(int sOLUONG) {
		SOLUONG = sOLUONG;
	}
	public double getDONGIA() {
		return DONGIA;
	}
	public void setDONGIA(double dONGIA) {
		DONGIA = dONGIA;
	}
	
	@ManyToOne
    @JoinColumn(name = "MAHD")
	public hoadon getHd() {
		return hd;
	}
	public void setHd(hoadon hd) {
		this.hd = hd;
	}
	@ManyToOne
    @JoinColumn(name = "MAMAU")
	public mausac getMs() {
		return ms;
	}
	public void setMs(mausac ms) {
		this.ms = ms;
	}
	@ManyToOne
    @JoinColumn(name = "MASP")
	public sanpham getSp() {
		return sp;
	}
	public void setSp(sanpham sp) {
		this.sp = sp;
	}
	
	
	
	
	
	
}

package multiShopJava.SpringMVC.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "chitiethds")
public class chitiethd implements Serializable{
	private int SOLUONG;
	private double DONGIA;
	private hoadon hd;
	private mausac ms;
	private sanpham sp;
	

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
	@Id
	@ManyToOne
    @JoinColumn(name = "MAHD")
	public hoadon getHd() {
		return hd;
	}
	public void setHd(hoadon hd) {
		this.hd = hd;
	}
	@Id
	@ManyToOne
    @JoinColumn(name = "MAMAU")
	public mausac getMs() {
		return ms;
	}
	public void setMs(mausac ms) {
		this.ms = ms;
	}
	@Id
	@ManyToOne
    @JoinColumn(name = "MASP")
	public sanpham getSp() {
		return sp;
	}
	public void setSp(sanpham sp) {
		this.sp = sp;
	}
	public chitiethd(int sOLUONG, double dONGIA, hoadon hd, mausac ms, sanpham sp) {
		super();
		SOLUONG = sOLUONG;
		DONGIA = dONGIA;
		this.hd = hd;
		this.ms = ms;
		this.sp = sp;
	}
	public chitiethd() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}

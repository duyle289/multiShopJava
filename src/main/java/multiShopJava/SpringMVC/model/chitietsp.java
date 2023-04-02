package multiShopJava.SpringMVC.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chitietsps")
public class chitietsp implements Serializable{
	private int SOLUONGTON;
	private mausac ms;
	private sanpham sp;
	
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
	public int getSOLUONGTON() {
		return SOLUONGTON;
	}

	public void setSOLUONGTON(int sOLUONGTON) {
		SOLUONGTON = sOLUONGTON;
	}
	public chitietsp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitietsp(int sOLUONGTON, mausac ms, sanpham sp) {
		super();
		SOLUONGTON = sOLUONGTON;
		this.ms = ms;
		this.sp = sp;
	}
	

}

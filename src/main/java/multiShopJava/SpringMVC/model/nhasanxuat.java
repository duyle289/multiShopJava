package multiShopJava.SpringMVC.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "nhasanxuats")
public class nhasanxuat {
	private int MANSX;
	private String TENNSX;
	private boolean TRANGTHAI;
	private String ICON;
	
	
	private Set<sanpham> sanpham;

	@Id
    @Column(name = "MANSX")
    @GeneratedValue
	public int getMANSX() {
		return MANSX;
	}
	public void setMANSX(int mANSX) {
		MANSX = mANSX;
	}
	public String getTENNSX() {
		return TENNSX;
	}
	public void setTENNSX(String tENNSX) {
		TENNSX = tENNSX;
	}
	public boolean isTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	public String getICON() {
		return ICON;
	}
	public void setICON(String iCON) {
		ICON = iCON;
	}
	
	
	@OneToMany(mappedBy = "nsx", cascade = CascadeType.ALL)
	public Set<sanpham> getSanpham() {
		return sanpham;
	}
	public void setSanpham(Set<sanpham> sanpham) {
		this.sanpham = sanpham;
	}
	public nhasanxuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhasanxuat(String tENNSX, boolean tRANGTHAI, String iCON) {
		super();
		TENNSX = tENNSX;
		TRANGTHAI = tRANGTHAI;
		ICON = iCON;
		
	}




}

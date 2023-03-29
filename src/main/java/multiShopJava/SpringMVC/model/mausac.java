package multiShopJava.SpringMVC.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "mausacs")
public class mausac {
	private int MAMAU;
	private String TENMAU;
	private boolean TRANGTHAI;
	private Set<chitietsp> chitietsanpham;
	private Set<chitiethd> chitiethd;
	
	
	@Id
	@GeneratedValue
	@Column(name = "MAMAU")
	public int getMAMAU() {
		return MAMAU;
	}
	public void setMAMAU(int mAMAU) {
		MAMAU = mAMAU;
	}
	public String getTENMAU() {
		return TENMAU;
	}
	public void setTENMAU(String tENMAU) {
		TENMAU = tENMAU;
	}
	public boolean isTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	@OneToMany(mappedBy = "ms", cascade = CascadeType.ALL)
	public Set<chitietsp> getChitietsanpham() {
		return chitietsanpham;
	}
	public void setChitietsanpham(Set<chitietsp> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}
	
	
	@OneToMany(mappedBy = "ms", cascade = CascadeType.ALL)
	public Set<chitiethd> getChitiethd() {
		return chitiethd;
	}
	public void setChitiethd(Set<chitiethd> chitiethd) {
		this.chitiethd = chitiethd;
	}
	public mausac() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mausac(String tENMAU, boolean tRANGTHAI) {
		super();
		TENMAU = tENMAU;
		TRANGTHAI = tRANGTHAI;
	}
	


}

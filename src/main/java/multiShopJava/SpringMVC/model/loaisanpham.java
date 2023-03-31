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
@Table(name = "loaisanphams")
public class loaisanpham {

	private int MALSP;
	private String TENLOAISP;
	private boolean TRANGTHAI;
	private String ICON;
	private Set<sanpham> sanpham;

	@Id
    @Column(name = "MALSP")
    @GeneratedValue
	public int getMALSP() {
		return MALSP;
	}
	public void setMALSP(int mALSP) {
		MALSP = mALSP;
	}
	public String getTENLOAISP() {
		return TENLOAISP;
	}
	public void setTENLOAISP(String tENLOAISP) {
		TENLOAISP = tENLOAISP;
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

	@OneToMany(mappedBy = "lsp", cascade = CascadeType.ALL)
	public Set<sanpham> getSanpham() {
		return sanpham;
	}
	public void setSanpham(Set<sanpham> sanpham) {
		this.sanpham = sanpham;
	}
	public loaisanpham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public loaisanpham(String tENLOAISP, boolean tRANGTHAI, String iCON
			) {
		super();
		TENLOAISP = tENLOAISP;
		TRANGTHAI = tRANGTHAI;
		ICON = iCON;
		
	}






}

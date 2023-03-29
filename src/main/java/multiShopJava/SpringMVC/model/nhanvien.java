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
@Table(name = "nhanviens")
public class nhanvien {
	private int MANV;
	private String TENNV;
	private String USERNAME;
	private String PASSWORD;
	private String SDT;
	private String CCCD;
	private String EMAIL;
	private boolean TRANGTHAI;
	private Set<hoadon> hoadon;

	@Id
	@GeneratedValue
	@Column(name = "MANV")
	public int getMANV() {
		return MANV;
	}
	public void setMANV(int mANV) {
		MANV = mANV;
	}
	public String getTENNV() {
		return TENNV;
	}
	public void setTENNV(String tENNV) {
		TENNV = tENNV;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public boolean isTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	@OneToMany(mappedBy = "nv", cascade = CascadeType.ALL)
	public Set<hoadon> getHoadon() {
		return hoadon;
	}
	public void setHoadon(Set<hoadon> hoadon) {
		this.hoadon = hoadon;
	}
	public nhanvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhanvien(String tENNV, String uSERNAME, String pASSWORD, String sDT, String cCCD, String eMAIL,
			boolean tRANGTHAI, Set<multiShopJava.SpringMVC.model.hoadon> hoadon) {
		super();
		TENNV = tENNV;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		SDT = sDT;
		CCCD = cCCD;
		EMAIL = eMAIL;
		TRANGTHAI = tRANGTHAI;
		this.hoadon = hoadon;
	}

}

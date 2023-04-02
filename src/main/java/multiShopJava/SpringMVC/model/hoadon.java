package multiShopJava.SpringMVC.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "hoadons")
public class hoadon {
	private String MAHD;
	private Date NGAYLAP;
	private Date NGAYGIAO;
	private double TONGTIEN;
	private int TRANGTHAI;
	private String DIACHIGIAOHANG;
	private String TENKH;
	private String SDTKH;
	private String YEUCAUKHAC;
	private khachhang kh;
	private nhanvien nv;
	private Set<chitiethd> chitiethd;
	@Id
	@Column(name = "MAHD")
	public String getMAHD() {
		return MAHD;
	}
	public void setMAHD(String mAHD) {
		MAHD = mAHD;
	}
	public Date getNGAYLAP() {
		return NGAYLAP;
	}
	public void setNGAYLAP(Date nGAYLAP) {
		NGAYLAP = nGAYLAP;
	}
	public Date getNGAYGIAO() {
		return NGAYGIAO;
	}
	public void setNGAYGIAO(Date nGAYGIAO) {
		NGAYGIAO = nGAYGIAO;
	}
	public double getTONGTIEN() {
		return TONGTIEN;
	}
	public void setTONGTIEN(double tONGTIEN) {
		TONGTIEN = tONGTIEN;
	}
	public int getTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(int tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	public String getDIACHIGIAOHANG() {
		return DIACHIGIAOHANG;
	}
	public void setDIACHIGIAOHANG(String dIACHIGIAOHANG) {
		DIACHIGIAOHANG = dIACHIGIAOHANG;
	}
	public String getTENKH() {
		return TENKH;
	}
	public void setTENKH(String tENKH) {
		TENKH = tENKH;
	}
	public String getSDTKH() {
		return SDTKH;
	}
	public void setSDTKH(String sDTKH) {
		SDTKH = sDTKH;
	}
	public String getYEUCAUKHAC() {
		return YEUCAUKHAC;
	}
	public void setYEUCAUKHAC(String yEUCAUKHAC) {
		YEUCAUKHAC = yEUCAUKHAC;
	}
	@ManyToOne
    @JoinColumn(name = "MAKH")
	public khachhang getKh() {
		return kh;
	}
	public void setKh(khachhang kh) {
		this.kh = kh;
	}
	@ManyToOne
    @JoinColumn(name = "MANV")
	public nhanvien getNv() {
		return nv;
	}
	public void setNv(nhanvien nv) {
		this.nv = nv;
	}


	



	@OneToMany(mappedBy = "hd", cascade = CascadeType.ALL)
	public Set<chitiethd> getChitiethd() {
		return chitiethd;
	}
	public void setChitiethd(Set<chitiethd> chitiethd) {
		this.chitiethd = chitiethd;
	}
	public hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadon(String mAHD, Date nGAYLAP, Date nGAYGIAO, double tONGTIEN, int tRANGTHAI, String dIACHIGIAOHANG,
			String tENKH, String sDTKH, String yEUCAUKHAC, khachhang kh, nhanvien nv) {
		super();
		MAHD = mAHD;
		NGAYLAP = nGAYLAP;
		NGAYGIAO = nGAYGIAO;
		TONGTIEN = tONGTIEN;
		TRANGTHAI = tRANGTHAI;
		DIACHIGIAOHANG = dIACHIGIAOHANG;
		TENKH = tENKH;
		SDTKH = sDTKH;
		YEUCAUKHAC = yEUCAUKHAC;
		this.kh = kh;
		this.nv = nv;
	}
	


}

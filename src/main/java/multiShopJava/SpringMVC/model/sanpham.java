package multiShopJava.SpringMVC.model;


import java.util.HashSet;
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
@Table(name = "sanphams")
public class sanpham {
	private int MASP;
	private String TENSP;
	private double DONGIA;
	private String HINHANH;
	private boolean TRANGTHAI;
	private boolean SANPHAMMOI;
	private boolean SPNOIBAT;
	private String CAUHINH;
	private String MOTA;
	private loaisanpham lsp;
	private nhasanxuat nsx;
	private Set<chitietsp> chitietsanpham;
	private Set<chitiethd> chitiethd;
	@Id
	@GeneratedValue
	@Column(name = "MASP")
	public int getMASP() {
		return MASP;
	}
	public void setMASP(int mASP) {
		MASP = mASP;
	}
	public String getTENSP() {
		return TENSP;
	}
	public void setTENSP(String tENSP) {
		TENSP = tENSP;
	}
	public double getDONGIA() {
		return DONGIA;
	}
	public void setDONGIA(double dONGIA) {
		DONGIA = dONGIA;
	}
	public String getHINHANH() {
		return HINHANH;
	}
	public void setHINHANH(String hINHANH) {
		HINHANH = hINHANH;
	}
	public boolean isTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	public boolean isSANPHAMMOI() {
		return SANPHAMMOI;
	}
	public void setSANPHAMMOI(boolean sANPHAMMOI) {
		SANPHAMMOI = sANPHAMMOI;
	}
	public boolean isSPNOIBAT() {
		return SPNOIBAT;
	}
	public void setSPNOIBAT(boolean sPNOIBAT) {
		SPNOIBAT = sPNOIBAT;
	}
	public String getCAUHINH() {
		return CAUHINH;
	}
	public void setCAUHINH(String cAUHINH) {
		CAUHINH = cAUHINH;
	}
	public String getMOTA() {
		return MOTA;
	}
	public void setMOTA(String mOTA) {
		MOTA = mOTA;
	}
	@ManyToOne
    @JoinColumn(name = "MALSP")
	public loaisanpham getLsp() {
		return lsp;
	}
	public void setLsp(loaisanpham lsp) {
		this.lsp = lsp;
	}
	
	@ManyToOne
    @JoinColumn(name = "MANSX")
	public nhasanxuat getNsx() {
		return nsx;
	}
	public void setNsx(nhasanxuat nsx) {
		this.nsx = nsx;
	}

	
	@OneToMany(mappedBy = "sp", cascade = CascadeType.ALL)
	public Set<chitietsp> getChitietsanpham() {
		return chitietsanpham;
	}
	public void setChitietsanpham(Set<chitietsp> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}
	
	
	
	
	@OneToMany(mappedBy = "sp", cascade = CascadeType.ALL)
	public Set<chitiethd> getChitiethd() {
		return chitiethd;
	}
	public void setChitiethd(Set<chitiethd> chitiethd) {
		this.chitiethd = chitiethd;
	}
	public sanpham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sanpham(String tENSP, double dONGIA, String hINHANH, boolean tRANGTHAI, boolean sANPHAMMOI, boolean sPNOIBAT,
			String cAUHINH, String mOTA, loaisanpham lsp, nhasanxuat nsx) {
		super();
		TENSP = tENSP;
		DONGIA = dONGIA;
		HINHANH = hINHANH;
		TRANGTHAI = tRANGTHAI;
		SANPHAMMOI = sANPHAMMOI;
		SPNOIBAT = sPNOIBAT;
		CAUHINH = cAUHINH;
		MOTA = mOTA;
		this.lsp = lsp;
		this.nsx = nsx;
	}







}

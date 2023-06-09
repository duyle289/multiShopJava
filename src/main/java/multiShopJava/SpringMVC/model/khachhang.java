package multiShopJava.SpringMVC.model;



import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "khachhangs")
public class khachhang {
	private int MAKH;
	@NotBlank(message = "Họ và tên không được để trống")
	private String TENKH;
	@NotBlank(message = "Địa chỉ không được để trống")
	@NotNull(message = "Địa chỉ không được để trống")
	private String DIACHI;
	@NotBlank(message = "Tên tài khoản không được để trống")
	@NotNull(message = "Tên tài khoản không được để trống")
	private String USERNAME;
	@NotBlank(message = "Mật khẩu không được để trống")
	@NotNull(message = "Mật khẩu không được để trống")
	private String PASSWORD;
	@Size(min = 10, max = 10, message = "Số điện thoại phải có độ dài 10 số")
	private String SDT;
	 @Size(min = 9, max = 12, message = "Số CCCD phải có độ dài từ 9 đến 12 số")
	private String CCCD;
	@NotNull(message = "Email không được để trống")
	@NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
	private String EMAIL;
	@NotNull(message = "Ngày sinh không được để trống")
	@Past(message = "Ngày sinh phải nhỏ hơn ngày hiện tại")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date NGAYSINH;
	private boolean TRANGTHAI;
	private Set<hoadon> hoadon;

	@Id
	@GeneratedValue
	@Column(name = "MAKH")
	public int getMAKH() {
		return MAKH;
	}
	public void setMAKH(int mAKH) {
		MAKH = mAKH;
	}
	public String getTENKH() {
		return TENKH;
	}
	public void setTENKH(String tENKH) {
		TENKH = tENKH;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
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
	public Date getNGAYSINH() {
		return NGAYSINH;
	}
	public void setNGAYSINH(Date nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}
	public boolean isTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	@OneToMany(mappedBy = "kh", cascade = CascadeType.ALL)
	public Set<hoadon> getHoadon() {
		return hoadon;
	}
	public void setHoadon(Set<hoadon> hoadon) {
		this.hoadon = hoadon;
	}
	public khachhang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhang(String tENKH, String dIACHI, String uSERNAME, String pASSWORD, String sDT, String cCCD,
			String eMAIL, Date nGAYSINH, boolean tRANGTHAI) {
		super();
		TENKH = tENKH;
		DIACHI = dIACHI;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		SDT = sDT;
		CCCD = cCCD;
		EMAIL = eMAIL;
		NGAYSINH = nGAYSINH;
		TRANGTHAI = tRANGTHAI;
	}




}

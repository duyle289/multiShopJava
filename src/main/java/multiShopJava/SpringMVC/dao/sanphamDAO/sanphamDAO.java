package multiShopJava.SpringMVC.dao.sanphamDAO;

import java.util.List;



import multiShopJava.SpringMVC.model.sanpham;



public interface sanphamDAO {
	public List<sanpham> list();
	public List<Object[]> listNSX();
	public List<Object[]> listLSP();
	public List<sanpham> listSPM();
	public List<sanpham> listSPNB();
	public sanpham getByID(int id);
	public List<sanpham> getProductByCaterogy(int idlsp);
}

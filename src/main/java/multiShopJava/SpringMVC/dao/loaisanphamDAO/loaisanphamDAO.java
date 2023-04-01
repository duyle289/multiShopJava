package multiShopJava.SpringMVC.dao.loaisanphamDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.loaisanpham;
import multiShopJava.SpringMVC.model.sanpham;

public interface loaisanphamDAO {
	public List<loaisanpham> list();
	public loaisanpham getById(int id);
	public void save(loaisanpham loaisanpham);
	public void update(int id,String TenSp, Boolean TrangThai, String icon);
	public void delete(int id);
}

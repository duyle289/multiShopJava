package multiShopJava.SpringMVC.dao.loaisanphamDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.loaisanpham;

public interface loaisanphamDAO {
	public List<loaisanpham> list();
	public loaisanpham getById(int id);
}

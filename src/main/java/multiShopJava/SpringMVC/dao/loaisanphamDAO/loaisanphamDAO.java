package multiShopJava.SpringMVC.dao.loaisanphamDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.loaisanpham;

public interface loaisanphamDAO {
	public List<loaisanpham> list();
	public loaisanpham getById(int id);
	public static void update(int id, String name, boolean isTT, String filename) {
		// TODO Auto-generated method stub
		
	}
}

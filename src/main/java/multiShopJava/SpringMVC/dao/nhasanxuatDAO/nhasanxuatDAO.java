package multiShopJava.SpringMVC.dao.nhasanxuatDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.nhasanxuat;

public interface nhasanxuatDAO {
	public List<nhasanxuat> list();
	public nhasanxuat getById(int id);
	public void save(nhasanxuat nhasanxuat);
	public void delete(nhasanxuat nhasanxuat);
	public void update(int id, String name, boolean isTT, String filename);
}

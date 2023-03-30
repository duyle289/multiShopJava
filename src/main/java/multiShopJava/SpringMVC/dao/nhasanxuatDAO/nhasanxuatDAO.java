package multiShopJava.SpringMVC.dao.nhasanxuatDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.nhasanxuat;

public interface nhasanxuatDAO {
	public List<nhasanxuat> list();
	public nhasanxuat getById(int id);
}

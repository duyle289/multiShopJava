package multiShopJava.SpringMVC.dao.hoadonDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.hoadon;

public interface hoadonDAO {
	List<hoadon> list();
	hoadon getOrderById(String id);
	
	public void save (hoadon hoadon);
	public void update (hoadon hoadon);
}

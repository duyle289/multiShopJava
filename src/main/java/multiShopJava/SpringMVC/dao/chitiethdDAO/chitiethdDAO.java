package multiShopJava.SpringMVC.dao.chitiethdDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.chitiethd;

public interface chitiethdDAO {
	List<chitiethd> listOrderDetailByOrderId(String id);
	List<chitiethd> list();
	void save (chitiethd cthd);
}

package multiShopJava.SpringMVC.dao.chitietspDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.chitietsp;

public interface chitietspDAO {
	public List<Object[]> getCTSP(int idsp);
	public  List<Object[]> getCTSP(int idsp, int idms);
}

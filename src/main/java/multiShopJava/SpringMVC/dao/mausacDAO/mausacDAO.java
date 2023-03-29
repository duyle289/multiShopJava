package multiShopJava.SpringMVC.dao.mausacDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.mausac;

public interface mausacDAO {
	public List<mausac> list();
	public mausac getById(int id);
}

package multiShopJava.SpringMVC.dao.khachhangDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.khachhang;

public interface khachhangDAO {
	void save(khachhang khachhang);

    void update(khachhang khachhang);

    void delete(khachhang khachhang);

    khachhang findByUsername(String username);
    khachhang findByEmail(String email);
    public List<khachhang> list();
}

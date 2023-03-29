package multiShopJava.SpringMVC.dao.nhanvienDAO;

import multiShopJava.SpringMVC.model.nhanvien;

public interface nhanvienDAO {
	void save(nhanvien nhanvien);

    void update(nhanvien nhanvien);

    void delete(nhanvien nhanvien);

    nhanvien findByUsername(String nhanvien);
}

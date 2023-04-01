package multiShopJava.SpringMVC.dao.nhanvienDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.nhanvien;
import multiShopJava.SpringMVC.model.nhasanxuat;

public interface nhanvienDAO {
	void save(nhanvien nhanvien);

    void update(nhanvien nhanvien);
    public void update2(int id,  String name, String email , String sdt , String cccd, String tk, String mk);
    void delete(nhanvien nhanvien);

    nhanvien findByUsername(String nhanvien);
    List<nhanvien> list();
    public nhanvien getById(int id);
}

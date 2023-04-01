package multiShopJava.SpringMVC.dao.loaisanphamDAO;

import java.util.List;

import multiShopJava.SpringMVC.model.loaisanpham;
import multiShopJava.SpringMVC.model.sanpham;

public interface loaisanphamDAO {
	public List<loaisanpham> list();
	public loaisanpham getById(int id);
<<<<<<< HEAD
	public static void update(int id, String name, boolean isTT, String filename) {
		// TODO Auto-generated method stub
		
	}
=======
	public void save(loaisanpham loaisanpham);
	public void update(int id,String TenSp, Boolean TrangThai, String icon);
	public void delete(int id);
>>>>>>> 895ceb91ed2315f4262762c17f130e8d30a4f237
}

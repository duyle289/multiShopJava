package multiShopJava.SpringMVC.dao.chitietspDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.chitietsp;
import multiShopJava.SpringMVC.model.sanpham;

public class chitietspDAOImpl implements chitietspDAO {
	
	
	
	private SessionFactory sessionFactory;

	public chitietspDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
    @Override
    public void save(chitietsp chitietsp) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "insert into chitietsps (SOLUONGTON, MAMAU, MASP) values (:SOLUONGTON, :MAMAU, :MASP)";
		Query query = session.createSQLQuery(sql);
		query.setParameter("SOLUONGTON", chitietsp.getSOLUONGTON());
		query.setParameter("MAMAU", chitietsp.getMs().getMAMAU());
		query.setParameter("MASP", chitietsp.getSp().getMASP());
		int result = query.executeUpdate();
    }
	
	@Transactional
	public  List<Object[]> getCTSP(int idsp) {
		
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "select * from chitietsps where MASP=:idsp";
		Query query = session.createSQLQuery(sql);
		query.setParameter("idsp", idsp);
		List<Object[]> results = query.list();
		
		return results;
		
	}
	@Transactional
	public  List<Object[]> getCTSP(int idsp, int idms) {
		
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "select * from chitietsps where MASP=:idsp && MAMAU=:idms";
		Query query = session.createSQLQuery(sql);
		query.setParameter("idsp", idsp);
		query.setParameter("idms", idms);
		List<Object[]> results = query.list();
		
		return results;
		
	}
}

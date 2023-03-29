package multiShopJava.SpringMVC.dao.nhanvienDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.nhanvien;

public class nhanvienDAOImpl implements nhanvienDAO{
	private SessionFactory sessionFactory;
	public nhanvienDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
    @Override
    public void save(nhanvien nhanvien) {
        sessionFactory.getCurrentSession().save(nhanvien);
    }
	@Transactional
    @Override
    public void update(nhanvien nhanvien) {
        sessionFactory.getCurrentSession().update(nhanvien);
    }
	@Transactional
    @Override
    public void delete(nhanvien nhanvien) {
        sessionFactory.getCurrentSession().delete(nhanvien);
    }
	@Transactional
    @Override
    public nhanvien findByUsername(String username) {
    	Session session = this.sessionFactory.getCurrentSession();
    	String sql ="FROM nhanvien WHERE USERNAME =:username";
    	Query query = session.createQuery(sql);
        query.setParameter("username", username);
        query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (nhanvien)query.uniqueResult();
    }
}

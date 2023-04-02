package multiShopJava.SpringMVC.dao.khachhangDAO;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.hibernate.Query;
import multiShopJava.SpringMVC.model.khachhang;
import multiShopJava.SpringMVC.model.sanpham;

public class khachhangDAOImpl implements khachhangDAO {
	private SessionFactory sessionFactory;
	public khachhangDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
    @Override
    public List<khachhang> list() {
    	@SuppressWarnings("unchecked")
		List<khachhang> listCus = sessionFactory.getCurrentSession().createCriteria(khachhang.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listCus;
    }
	@Transactional
    @Override
    public void save(khachhang khachhang) {
		Session session = sessionFactory.getCurrentSession();
		session.save(khachhang);
    }
	@Transactional
    @Override
    public void update(khachhang khachhang) {
        sessionFactory.getCurrentSession().update(khachhang);
    }
	@Transactional
    @Override
    public void delete(khachhang khachhang) {
        sessionFactory.getCurrentSession().delete(khachhang);
    }
	@Transactional
    @Override
    public khachhang findByUsername(String username) {
    	Session session = this.sessionFactory.getCurrentSession();
    	String sql ="FROM khachhang WHERE USERNAME =:username";
    	Query query = session.createQuery(sql);
        query.setParameter("username", username);
        query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (khachhang)query.uniqueResult();
    }
	@Transactional
    @Override
	public khachhang findByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
    	String sql ="FROM khachhang WHERE EMAIL =:email";
    	Query query = session.createQuery(sql);
        query.setParameter("email", email);
        query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (khachhang)query.uniqueResult();
	}
}

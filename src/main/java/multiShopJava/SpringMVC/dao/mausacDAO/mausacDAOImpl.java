package multiShopJava.SpringMVC.dao.mausacDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.mausac;
import multiShopJava.SpringMVC.model.sanpham;

public class mausacDAOImpl implements mausacDAO{
	private SessionFactory sessionFactory;

	public mausacDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<mausac> list() {
		@SuppressWarnings("unchecked")
		List<mausac> listmausac = sessionFactory.getCurrentSession().createCriteria(mausac.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listmausac;
	}
	@Transactional
	public mausac getById(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		mausac ms = (mausac) session.get(mausac.class, id);
		return ms;
	}
}

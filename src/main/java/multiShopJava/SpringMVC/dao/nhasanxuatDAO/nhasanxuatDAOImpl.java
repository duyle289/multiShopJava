package multiShopJava.SpringMVC.dao.nhasanxuatDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.mausac;
import multiShopJava.SpringMVC.model.nhasanxuat;

public class nhasanxuatDAOImpl implements nhasanxuatDAO{
	private SessionFactory sessionFactory;

	public nhasanxuatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public List<nhasanxuat> list() {
		@SuppressWarnings("unchecked")
		List<nhasanxuat> listNSX = sessionFactory.getCurrentSession().createCriteria(nhasanxuat.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listNSX;
	}
	@Transactional
	public nhasanxuat getById(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		nhasanxuat nsx = (nhasanxuat) session.get(nhasanxuat.class, id);
		return nsx;
	}
}

package multiShopJava.SpringMVC.dao.hoadonDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.hoadon;
import multiShopJava.SpringMVC.model.sanpham;

public class hoadonDAOImpl implements hoadonDAO{
	private SessionFactory sessionFactory;

	public hoadonDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<hoadon> list() {
		@SuppressWarnings("unchecked")
		List<hoadon> listOrder = sessionFactory.getCurrentSession().createCriteria(hoadon.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listOrder;
	}
	@Transactional
	public hoadon getOrderById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		hoadon hd = (hoadon) session.get(hoadon.class, id);
		return hd;
	}
	@Transactional
	public void save(hoadon hoadon) {
		this.sessionFactory.getCurrentSession().save(hoadon);
	}
	@Transactional
	public void update(hoadon hoadon) {
		this.sessionFactory.getCurrentSession().update(hoadon);
	}
	
}

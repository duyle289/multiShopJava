package multiShopJava.SpringMVC.dao.loaisanphamDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.loaisanpham;
import multiShopJava.SpringMVC.model.nhasanxuat;


public class loaisanphamDAOImpl implements loaisanphamDAO {
	private SessionFactory sessionFactory;

	public loaisanphamDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public List<loaisanpham> list() {
		@SuppressWarnings("unchecked")
		List<loaisanpham> listLSP = sessionFactory.getCurrentSession().createCriteria(loaisanpham.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listLSP;
	}
	@Transactional
	public loaisanpham getById(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		loaisanpham lsp = (loaisanpham) session.get(loaisanpham.class, id);
		return lsp;
	}
}

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
	@Transactional
	public void save(nhasanxuat nhasanxuat) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(nhasanxuat);
		
	}
	@Transactional
	public void delete(nhasanxuat nhasanxuat) {
		// TODO Auto-generated method stub
		
	}
//	@Override
//	public void update(nhasanxuat nhasanxuat) {
//		// TODO Auto-generated method stub
//		
//	}
	@Transactional
	public void update(int id, String name, boolean isTT, String filename) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		    nhasanxuat lsp =(nhasanxuat) session.get(nhasanxuat.class, id);
		    lsp.setTENNSX(name);
		    lsp.setTRANGTHAI(isTT);
		    lsp.setICON(filename);
		    session.update(lsp);
		
	}
}
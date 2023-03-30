package multiShopJava.SpringMVC.dao.sanphamDAO;


import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.sanpham;



public class sanphamDAOImpl implements sanphamDAO{

	private SessionFactory sessionFactory;

	public sanphamDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
    @Override
    public void save(sanpham sanpham) {
        sessionFactory.getCurrentSession().save(sanpham);
    }
	@Override
	@Transactional
	public List<sanpham> list() {
		@SuppressWarnings("unchecked")
		List<sanpham> listUser = sessionFactory.getCurrentSession().createCriteria(sanpham.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}
	@Transactional
	public List<Object[]> listNSX() {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT MALSP, s.MANSX,n.TENNSX FROM sanphams s, nhasanxuats n WHERE s.MANSX = n.MANSX GROUP BY s.MANSX, s.MALSP";
		Query query = session.createSQLQuery(sql);
		List<Object[]> results = query.list();

		return results;
	}
	@Transactional
	public List<Object[]> listLSP() {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "select l.TENLOAISP,count(MASP), l.ICON, l.MALSP from sanphams s, loaisanphams l WHERE s.MALSP = L.MALSP GROUP BY s.MALSP";
		Query query = session.createSQLQuery(sql);
		List<Object[]> results = query.list();
		
		return results;
	}
	@Transactional
	public List<sanpham> listSPM() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(sanpham.class);
		criteria.add(Restrictions.eq("SANPHAMMOI", true));
		List<sanpham> results = criteria.list();
		return results;
	}
	@Transactional
	public List<sanpham> listSPNB() {
		
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(sanpham.class);
		criteria.add(Restrictions.eq("SPNOIBAT", true));
		List<sanpham> results = criteria.list();
		return results;
	}
	@Transactional
	public sanpham getByID(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		sanpham sp = (sanpham) session.get(sanpham.class, id);
		return sp;
	}
	@Transactional
	public List<sanpham> getProductByCaterogy(int idlsp){
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(sanpham.class);
		criteria.createAlias("lsp", "l");
		criteria.add(Restrictions.eq("l.MALSP", idlsp));
		List<sanpham> results = criteria.list(); 
		return results;
	}
}

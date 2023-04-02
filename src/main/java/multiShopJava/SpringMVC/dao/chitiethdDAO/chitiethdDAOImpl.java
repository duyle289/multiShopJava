package multiShopJava.SpringMVC.dao.chitiethdDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.chitiethd;
import multiShopJava.SpringMVC.model.chitietsp;
import multiShopJava.SpringMVC.model.hoadon;

public class chitiethdDAOImpl implements chitiethdDAO{
	private SessionFactory sessionFactory;

	public chitiethdDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<chitiethd> list() {
		@SuppressWarnings("unchecked")
		List<chitiethd> listOrderDetail = sessionFactory.getCurrentSession().createCriteria(chitiethd.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listOrderDetail;
	}
	@Transactional
	public List<chitiethd> listOrderDetailByOrderId(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(chitiethd.class);
		criteria.createAlias("hd", "hd");
		criteria.add(Restrictions.eq("hd.MAHD", id));
		List<chitiethd> results = criteria.list(); 
		return results;
	}
	@Transactional
	@Override
    public void save(chitiethd cthd) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "insert into chitiethds (MAHD, MAMAU, MASP,SOLUONG,DONGIA) values (:MAHD, :MAMAU, :MASP, :SOLUONG, :DONGIA)";
		Query query = session.createSQLQuery(sql);
		query.setParameter("MAHD", cthd.getHd().getMAHD());
		query.setParameter("MAMAU", cthd.getMs().getMAMAU());
		query.setParameter("MASP", cthd.getSp().getMASP());
		query.setParameter("SOLUONG", cthd.getSOLUONG());
		query.setParameter("DONGIA", cthd.getDONGIA());
		int result = query.executeUpdate();
    }

}

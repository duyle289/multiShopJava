package multiShopJava.SpringMVC.dao.nhanvienDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.transaction.annotation.Transactional;

import multiShopJava.SpringMVC.model.nhanvien;
import multiShopJava.SpringMVC.model.nhasanxuat;
import multiShopJava.SpringMVC.model.sanpham;

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
   
    public void update2(int id,  String name, String email , String sdt , String cccd, String tk, String mk) {
		 Session session = sessionFactory.getCurrentSession();
		    nhanvien lsp =(nhanvien) session.get(nhanvien.class, id);
		    lsp.setTENNV(name);
		    lsp.setEMAIL(email);
		    lsp.setSDT(sdt);
		    lsp.setCCCD(cccd);
		    lsp.setUSERNAME(tk);
		    lsp.setPASSWORD(mk);
		    session.update(lsp);
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
	@Transactional
    @Override
	public List<nhanvien> list(){
		@SuppressWarnings("unchecked")
		List<nhanvien> listStaff = sessionFactory.getCurrentSession().createCriteria(nhanvien.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		return listStaff;
		
		
		
	}
	
	@Transactional
	public nhanvien getById(int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		nhanvien nv = (nhanvien) session.get(nhanvien.class, id);
		return nv;
	}
}

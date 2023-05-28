package org.simplilearn.app.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.app.config.HbConfig;
import org.simplilearn.app.entities.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public void insert(Emp e) {

		SessionFactory sessionFactory=HbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.save(e);
			tx.commit();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void delete(int eno) {
		SessionFactory sessionFactory=HbConfig.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			Emp e=session.get(Emp.class,eno);
			session.delete(e);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}

	@Override
	public Optional<Emp> get(int eno) {
        SessionFactory sessionFactory=HbConfig.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        Emp e=session.get(Emp.class,eno);
		return Optional.ofNullable(e);
	}

	@Override
	public List<Emp> getAll() {
        SessionFactory sessionFactory=HbConfig.getSessionFactory();
        Session session=sessionFactory.openSession();
        Query<Emp> query=session.createQuery("select e from org.simplilearn.app.entities.Emp e");
		return query.list();
	}

}

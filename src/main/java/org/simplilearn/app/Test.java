package org.simplilearn.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.app.config.HbConfig;
import org.simplilearn.app.dao.EmpDao;
import org.simplilearn.app.dao.EmpDaoImpl;
import org.simplilearn.app.entities.Emp;

public class Test {

	public static void main(String[] args) {

		EmpDao dao=new EmpDaoImpl();
		dao.getAll().forEach(Emp->{
			System.out.println(Emp.getEno()+"\t"+Emp.getName()+"\t"+Emp.getAddress());
		});
	}

}

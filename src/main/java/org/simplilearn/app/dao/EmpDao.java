package org.simplilearn.app.dao;

import java.util.List;
import java.util.Optional;

import org.simplilearn.app.entities.Emp;

public interface EmpDao {

	void insert(Emp e);
	void delete(int eno);
	Optional<Emp> get(int eno);
	List<Emp> getAll();
}

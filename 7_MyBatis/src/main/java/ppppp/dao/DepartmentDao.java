package ppppp.dao;

import ppppp.pojo.Department;

public interface DepartmentDao {
	Department getEmpsByIdStep(Integer id);
	Department getEmpsById(Integer id);
	Department getDepById(Integer id);
}

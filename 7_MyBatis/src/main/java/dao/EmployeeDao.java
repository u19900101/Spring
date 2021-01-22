package dao;

import pojo.Employee;

public interface EmployeeDao{

	Employee getEmpById(Integer id);
	int addEmp(Employee employee);
	int delEmp(Integer id);
	int updateEmp(Employee employee);
}

package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.Map;

public interface EmployeeDao{

	Employee getEmpById(Integer id);
	Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName")String lastName);
	Employee getEmpByMap(Map map);
	int addEmp(Employee employee);
	int delEmp(Integer id);
	int updateEmp(Employee employee);
}

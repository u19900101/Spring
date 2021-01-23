package dao;

import org.apache.ibatis.annotations.Select;
import pojo.Employee;

public interface EmployeeDaoAnno {

	@Select("select * from t_employee where id = #{id}")
	Employee getEmpById(Integer id);
	int addEmp(Employee employee);
	int delEmp(Integer id);
	int updateEmp(Employee employee);
}

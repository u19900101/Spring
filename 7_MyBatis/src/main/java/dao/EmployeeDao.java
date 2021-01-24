package dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao{
	List<Employee> getAllEmp();
	Employee getEmpById(Integer id);
	Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName")String lastName);
	Employee getEmpByMap(Map map);
	int addEmp(Employee employee);
	int delEmp(Integer id);
	int updateEmp(Employee employee);

	Map<String,Object> getEmpMapById(Integer i);


	@MapKey("id")// 指定结果集中为 主键的列名
	Map<Integer,Employee> getAllEmpReturnMap();

	// 动态sel
	List<Employee> getEmpByIdDynamic(Employee employee);
	List<Employee> getEmpByIdsDynamic(@Param("ids") Integer[] ids);
}

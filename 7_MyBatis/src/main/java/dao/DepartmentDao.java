package dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.Department;
import pojo.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {
	Department getEmpsByIdStep(Integer id);
	Department getEmpsById(Integer id);
	Department getDepById(Integer id);
}

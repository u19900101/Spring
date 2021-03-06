package ppppp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
// 为实现二级缓存 实现序列化接口
public class Employee  {
	// implements Serializable
	// private static final long serialVersionUID = -7390587151857533202L;
	private Integer id;
	// @NotNull(message = "不能为空")
	// @Length(max = 18,min = 3,message = "长度必须不正确")
	@Length(max = 18,min = 3)
	private String lastName;

	@Email
	@NotEmpty(message = "不能为空")
	private String email;
	//1 male, 0 female
	private Integer gender;

	//控制返回到页面的格式
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date birth;

	private String loginAccount;
	@JsonIgnore
	private Department department;


	public Employee(Integer id, String lastName, String email, Integer gender, Date birth) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
	}
	public Employee(String lastName, String email, Integer gender, Date birth) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", birth=" + birth +
				", loginAccount='" + loginAccount + '\'' +
				", department=" + department +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Date birth, String loginAccount, Department department) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.loginAccount = loginAccount;
		this.department = department;
	}

	public Employee() {
	}
}

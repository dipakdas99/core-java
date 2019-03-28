package com.bean;

import java.util.List;

public class Employee {
	//id name mgrid level, list<employee>
	private Integer id;
	private String name;
	private Integer mgrID;
	private Integer level;
	private List<Employee> empList;
	
	public Employee(Integer id, String name, Integer mgrID, List<Employee> empList) {
		super();
		this.id = id;
		this.name = name;
		this.mgrID = mgrID;
		this.empList = empList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMgrID() {
		return mgrID;
	}
	public void setMgrID(Integer mgrID) {
		this.mgrID = mgrID;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

package com.Design;

import java.util.List;

public class Employee {
	private Integer id;
	private String name;
	private Integer mgrID;
	Employee(){
		super();
	}

	public Employee(Integer id, String name, Integer mgrID) {
		super();
		this.id = id;
		this.name = name;
		this.mgrID = mgrID;
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

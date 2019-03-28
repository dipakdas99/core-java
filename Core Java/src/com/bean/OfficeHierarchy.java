package com.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OfficeHierarchy {
	private static int START_LEVEL = 1;
	
	public static void main(String[] args) {
		
		OfficeHierarchy obj = new OfficeHierarchy();
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Dipak", 10, new ArrayList<>()));
		list.add(new Employee(2, "Manohar", 11, new ArrayList<>()));
		list.add(new Employee(3, "Dipak", 11, new ArrayList<>()));
		list.add(new Employee(4, "Yokesh", 10, new ArrayList<>()));
		list.add(new Employee(5, "Suman", 3, new ArrayList<>()));
		list.add(new Employee(10, "Hari", 100, new ArrayList<>()));
		list.add(new Employee(11, "Pugazh", 100, new ArrayList<>()));
		list.add(new Employee(100, "Admin", 100, new ArrayList<>()));
		
		Employee root = obj.constructTree(list);
		System.out.println();
	}

	private Employee constructTree(List<Employee> list) {
		Employee root = null;
		Integer maxLevel = 0;
		Set<Employee> setObj = new HashSet<>();
		for (Employee emp : list) {
			if (emp.getId().equals(emp.getMgrID())) {
				emp.setLevel(START_LEVEL);
				setObj.add(emp);
				if (maxLevel < emp.getLevel()) {
					maxLevel = emp.getLevel();
					root = emp;
				}
				continue;
			}
			Employee managerObj = null;
			if (!setObj.contains(emp)) {
				emp.setLevel(START_LEVEL);
				setObj.add(emp);
			}
			managerObj = list.stream().filter(listObj -> emp.getMgrID().equals(listObj.getId())).findFirst().get();
			managerObj.setLevel(emp.getLevel() + 1);
			List<Employee> childList = managerObj.getEmpList();
			childList.add(emp);
			managerObj.setEmpList(childList);
			setObj.add(managerObj);
			if (maxLevel < managerObj.getLevel()) {
				maxLevel = managerObj.getLevel();
				root = managerObj;
			}
		}
		return root;
	}

}

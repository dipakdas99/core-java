package com.Design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OfficeHierarchy {

	public static void main(String[] args) {
		OfficeHierarchy obj = new OfficeHierarchy();

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(5, "Suman", 3));
		list.add(new Employee(1, "Dipak", 10));
		list.add(new Employee(2, "Manohar", 11));
		list.add(new Employee(3, "Dipak", 11));
		list.add(new Employee(4, "Yokesh", 10));
		list.add(new Employee(10, "Hari", 100));
		list.add(new Employee(11, "Pugazh", 100));
		list.add(new Employee(100, "Admin", 100));
		
		TreeNode<Employee> root = null;
		
		for (Employee employee : list) {
			if (employee.getId().equals(employee.getMgrID())) {
				root = new TreeNode<Employee>(employee);
				continue;
			}
			Employee child = list.stream().filter(listObj -> employee.getMgrID().equals(listObj.getId())).findFirst().get();
			TreeNode<Employee> childNode = new TreeNode<Employee>(child);
			
			root.addChild(child);
		}
		for(TreeNode node : root.getChildren()) {

		    System.out.println(node.getData());

		}
	}
}

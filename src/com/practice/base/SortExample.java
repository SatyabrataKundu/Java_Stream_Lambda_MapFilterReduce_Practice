package com.practice.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.practice.model.Employee;
/**
*
* @author Satyabrata Kundu
*/
public class SortExample {

	public static void main(String[] args) {
		
		List <Employee> employees = new ArrayList<Employee>(Arrays.asList(
				new Employee(3333,"Satyabrata","Kundu",32,80000),
				new Employee(3243,"Pradip","Wandhekar",35,90000),
				new Employee(1003,"Anjali","Srivastava",22,20000),
				new Employee(2946,"Subhadip","Jot",23,35000),
				new Employee(1005,"Sonia","Khatri",32,85000),
				new Employee(1005,"Ashish","Kumar",32,80000),
				new Employee(1005,"Pratik","Bangal",32,60000)
				));
		employees.forEach(System.out::println);
		
		employees.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getEmployeeId).thenComparing(Employee::getSalary).reversed());
		
		System.out.println("#######################################");
		employees.forEach(System.out::println);
		System.out.println("#######################################");
	}

}

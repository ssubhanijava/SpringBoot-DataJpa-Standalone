package com.subbu.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.subbu.Dao.EmployeeJpa;
import com.subbu.model.Employee;

/**
 * 
 * @author subhani
 *
 */
@Component
public class EmployeeCurdExample {

	@Autowired
	private EmployeeJpa employeeJpa;

	Scanner sc = new Scanner(System.in);

	/**
	 * saving Employee in Db
	 */
	public void saveEmployee() {

		System.out.println("--- Welcome To Saving  Employee----");
		System.out.println("Enter EmployeeName : ");
		String empName = sc.next();
		System.out.println("Enter EmployeeEmail : ");
		String empEmail = sc.next();

		System.out.println("Enter EmployeeEducation : ");
		String empEduc = sc.next();

		Employee emp = new Employee(empName, empEmail, empEduc);
		employeeJpa.save(emp);

	}

	/**
	 * 
	 * Update Employee Based On Id
	 * 
	 */
	public void updateEmployee() {

		System.out.println("--- Welcome To Upadte  Employee----");

		System.out.println("Enter Employee Id To Upadte...");
		int empUpdate = sc.nextInt();
		try {
			Employee employee = employeeJpa.findById(empUpdate).get();

			if (employee != null) {
				System.out.println("Before Emp in Db Details.. " + employee);

				System.out.println("Enter No.Based On Property..Update...");
				System.out.println("----------1->name ---2->Emai---- 3->Education-------");
				int updatePropNo = sc.nextInt();
				if (updatePropNo == 1) {
					System.out.println("Enter  New  EmployeeName : ");
					String empName = sc.next();
					employee.setName(empName);
				} else if (updatePropNo == 2) {

					System.out.println("Enter New EmployeeEmail : ");
					String empEmail = sc.next();
					employee.setEmail(empEmail);
				} else {
					System.out.println("Enter New EmployeeEducation : ");
					String empEduc = sc.next();
					employee.setEduation(empEduc);
				}
				employeeJpa.save(employee);
			}
		} catch (Exception e) {
			System.out.println("Employee Not Found....");
		}
	}

	/**
	 * Deleting Employee Based On Id
	 * 
	 */
	public void deleteEmployee() {

		System.out.println("--welcome To delete Employee--------");
		System.out.println("Enter Employee No.To delete...");
		int deleteEmp = sc.nextInt();
		try {

			Employee employee = employeeJpa.findById(deleteEmp).get();

			if (employee != null) {
				System.out.println("DeletIng  Emp in  Details.. " + employee);
				employeeJpa.delete(employee);
			}
		} catch (Exception e) {
			System.out.println("Employee Not Found....");
		}
	}

	/**
	 * 
	 * 
	 * Getting All Employee
	 * 
	 * @return
	 */
	public List<Employee> fetchAllEmployee() {
		List<Employee> findAll = employeeJpa.findAll();
		findAll.stream().iterator().forEachRemaining(System.out::println);
		return findAll;
	}

	/**
	 * This Method Will display Employee Based on Name And Email
	 * 
	 * 
	 * 
	 * @return
	 */
	public void getEmpolyeeByNameAndEmail() {

		System.out.println("Enter Name And Email To Find Employee.....");
		System.out.println("Enter Name Of The Employete..");
		String name = sc.nextLine();
		System.out.println("Enter Email To Find Employee..");
		String email = sc.nextLine();
		Employee emp = employeeJpa.findByNameAndEmail(name, email);
		if (emp != null) {
			System.out.println("Emp Details Based On Name And Email....");
			System.out.println(emp);

		} else {
			System.out.println("Employee Not Found Based On Name : " + name + " & Email : " + email);
		}

	}

}

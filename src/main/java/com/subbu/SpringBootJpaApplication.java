package com.subbu;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.subbu.test.EmployeeCurdExample;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootJpaApplication.class, args);

		EmployeeCurdExample employeeCurdExample = applicationContext.getBean(EmployeeCurdExample.class);

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"-----------Enter Options  1-Create,2-update,3-Delete,4-FetchhingAll,5-To retrive Emp Based On Name&Email---------");

		int input = sc.nextInt();

		if (input == 1) {
			employeeCurdExample.saveEmployee();

		} else if (input == 2) {
			employeeCurdExample.updateEmployee();
			System.out.println();
		} else if (input == 3) {
			employeeCurdExample.deleteEmployee();
		} else if (input == 4) {
			employeeCurdExample.fetchAllEmployee();
		} else if (input == 5) {
			employeeCurdExample.getEmpolyeeByNameAndEmail();
		}

		else {
			System.out.println("--You Enter Wrong Input--");

		}
		applicationContext.close();
	}

}

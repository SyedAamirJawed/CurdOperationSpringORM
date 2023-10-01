package com.springcurd.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcurd.dao.StudentDao;
import com.springcurd.entities.Student;

public class StudentRun {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		StudentDao studentDao = (StudentDao) context.getBean("studentDaoRef");

		Student student = new Student();
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n===================> Welcome To Student Mannagment App <===================\n\n");
		System.out.println("Enter 1 => For Insert New Student Details");
		System.out.println("Enter 2 => For Show Student Details");
		System.out.println("Enter 3 => For Update Student Details");
		System.out.println("Enter 4 => For Delete Student Details");
		System.out.println("Enter 5 => For Show All Student Details");
		System.out.println("Enter 6 => For Closed Application\n");

		try {
		while (true) {
			System.out.print("\nEnter Yous Choice : ");
			
			int action = scanner.nextInt();

			// Insert Operation
			if (action == 1) {
				System.out.println("\n====> Resigtration Form <====\n");
				System.out.print("Enter Student Id : ");
				int sId = scanner.nextInt();
				student.setStuId(sId);

				System.out.print("Enter Student Name : ");
				String sName = scanner.next();
				student.setStuName(sName);

				System.out.print("Enter Student City : ");
				String sCity = scanner.next();
				student.setStuCity(sCity);

				int newStudentId = studentDao.insertData(student);
				System.out.println("\nStudent Successfully Added RollNo = " +newStudentId);
			}

			// Select One Row
			else if (action == 2) {
				System.out.print("\nEnter Student Id : ");
				int rollNo = scanner.nextInt();
				Student studentDetails = studentDao.getOneStudent(rollNo);
				System.out.println("\nStudent Details => " + studentDetails.toString());
			}

			// Update Data
			else if (action == 3) {
				System.out.print("\nEnter Student Id Witch One You Want Update : ");
				int rollNo = scanner.nextInt();
				Student studentDetails = studentDao.getOneStudent(rollNo);
				System.out.println("\nSelected Student Details : " + studentDetails.toString());

				System.out.print("\nPress 1 => Change Name | Press 2 => Change City | Press 2 => Change Both \nEnter Your Chooes : ");

				int chooes = scanner.nextInt();

				if (chooes == 1) {
					System.out.print("Enter New Name : ");
					String sName = scanner.next();
					studentDetails.setStuName(sName);
					studentDao.updateStudent(studentDetails);
					System.out.println();
					System.out.println(studentDetails.getStuName() + " Name Has Been Updated Successfully\n");
				} else if (chooes == 2) {
					System.out.print("Enter New City : ");
					String sCity = scanner.next();
					studentDetails.setStuCity(sCity);
					studentDao.updateStudent(studentDetails);
					System.out.println();
                    System.out.println(studentDetails.getStuName() + " City Has Been Updated Successfully\n");
				} else if (chooes == 3) {
					System.out.print("Enter New Name : ");
					String sName = scanner.next();
					studentDetails.setStuName(sName);
                    System.out.print("Enter New City : ");
					String sCity = scanner.next();
					studentDetails.setStuCity(sCity);
					studentDao.updateStudent(studentDetails);
					System.out.println();
					System.out.println(studentDetails.getStuName() + " Name & City Has Been Updated Successfully\n");
				} else
					System.out.println("Enter Valid Input From 1-3 \n");
			}

			// Delete
			else if (action == 4) {
				System.out.print("\nEnter Student Id Which You Want To Delete : ");
				int rollNo = scanner.nextInt();
				Student selectedStudent = studentDao.getOneStudent(rollNo);
				System.out.print("\nSelected Student Details : " + selectedStudent.toString()
						+ "\n\nAre You Sure Delete This Student (Yes/No) : ");
				String action1 = scanner.next();

				if (action1.equalsIgnoreCase("yes")) {
					studentDao.deleteStudent(selectedStudent);
					System.out.println("\nDelete Succcessfully\n");
				}
			}

			// Select All
			else if (action == 5) {
				
				List<Student> students = studentDao.getAllStudent();
				System.out.print("\n===> All Student Details <===\n");
				for (Student oneStudent : students) {
					System.out.println(oneStudent.toString());
					System.out.println("____________________________________");
				}
			} else if (action == 6) {
				break;
			} else
				System.out.println("\nEnter Valid Input From 1-6\n");
		 }
		}
		catch (Exception e) {
			System.out.println("\nEnter Valid Input");
		}
		System.out.println("\nThanks For Using My Application. See You Soon..! ");
		
	}
}

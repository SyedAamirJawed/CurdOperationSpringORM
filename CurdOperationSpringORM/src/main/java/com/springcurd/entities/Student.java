
package com.springcurd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="springorm") 
public class Student 
{
	@Id
	@Column(name = "stu_id") 
	private int stuId;
	
	@Column(name = "stu_name")
	private String stuName;
	
	@Column(name = "stu_city")
	private String stuCity;

	
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuCity() {
		return stuCity;
	}

	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}

	@Override
	public String toString() {
		return "\nStudent Id = " + stuId + "\nStudent Name = " +stuName + "\nStudent City = " + stuCity;
	}
	
	
}



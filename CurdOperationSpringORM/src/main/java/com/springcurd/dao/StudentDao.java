package com.springcurd.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.springcurd.entities.Student;

public class StudentDao 
{
	private HibernateTemplate hibernateTemplate; 
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		this.hibernateTemplate = hibernateTemplate;
	}
   
	
    //INSERT Query 
	@Transactional   
	public int insertData(Student student){
	   Integer result = (Integer) hibernateTemplate.save(student); 
	   return result;
   }
   
   
   //SELECT Query(1 Row) 
	public Student getOneStudent(int studentId ){
	 Student oneRowData =  hibernateTemplate.get(Student.class,studentId);
	 return oneRowData;
   }
   
   
   //Delete Query
   @Transactional
   public void deleteStudent(Student student) {
	  hibernateTemplate.delete(student); 
   }
   
   
   //Update Query
   @Transactional
   public void updateStudent(Student student) {
	  hibernateTemplate.update(student); 
   }

   
   //SELECT Query(All Row) ==>
   public List<Student> getAllStudent(){
	  List<Student> studentList = hibernateTemplate.loadAll(Student.class); 
	  return studentList;
   }
   
}


package org.objectconnection.ExampleTwo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_data_01")
public class Student {
	private  int rollNo;
	private String name;
	private StudentAddress address;
	
	public Student() {
	}
	@Id
	@Column(name="roll_no")
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentAddress getAddress() {
		return address;
	}
	public void setAddress(StudentAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", address=" + address + "]";
	}
	
	
}

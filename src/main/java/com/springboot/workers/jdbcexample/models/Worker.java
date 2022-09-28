package com.springboot.workers.jdbcexample.models;

import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker {

	Integer workerID;
	String firstName;
	String lastName;
	Integer salary;
	Timestamp joiningDate;
	String department;
	
	public Worker() {
		super();
	}

	public Worker(Integer workerID, String firstName, String lastName, Integer salary, Timestamp joiningDate,
			String department) {
		super();
		this.workerID = workerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.department = department;
	}

	public Integer getWorkerID() {
		return workerID;
	}

	public void setWorkerID(Integer workerID) {
		this.workerID = workerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Timestamp getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Timestamp joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, firstName, joiningDate, lastName, salary, workerID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(department, other.department) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(joiningDate, other.joiningDate) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(salary, other.salary) && Objects.equals(workerID, other.workerID);
	}

	@Override
	public String toString() {
		return "Worker [workerID=" + workerID + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + ", joiningDate=" + joiningDate + ", department=" + department + "]";
	}
	
}

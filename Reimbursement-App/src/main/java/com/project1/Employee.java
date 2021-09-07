package com.project1;

public class Employee {
	private int emp_id;
	private String name;
	private String password;
	private String email;
	private boolean manager;

	public Employee(){}

	public Employee(int emp_id, String name, String password, String email, boolean manager) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.manager = manager;
	}


	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
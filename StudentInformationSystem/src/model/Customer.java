package model;

public class Customer {
	int customerId;
	String customerName;
	int age;
	public int setAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}

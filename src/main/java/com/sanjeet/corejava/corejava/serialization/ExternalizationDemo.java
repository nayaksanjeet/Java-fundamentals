package com.sanjeet.corejava.corejava.serialization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Employee implements Externalizable{
	private int empId;
	private double salary;
	private String name;
	private int deptId;
	
	
	public Employee() {
		
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Employee(int empId, double salary, String name, int deptId) {
		
		this.empId = empId;
		this.salary = salary;
		this.name = name;
		this.deptId = deptId;
	}
	@Override
	public void writeExternal(ObjectOutput obj) throws IOException{
		obj.writeUTF(name);
		obj.writeInt(empId);
		obj.writeDouble(salary);
	}
	@Override
	public void readExternal(ObjectInput obj) throws IOException, ClassNotFoundException{
		name=obj.readUTF();
		empId=obj.readInt();
		salary=obj.readDouble();
		
		
		
	}
	@Override
	public String toString(){
		return this.name+" "+this.salary+" "+this.deptId+" "+this.empId;
	}
}
public class ExternalizationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee e=new Employee(1,3456789.00,"sanjeet",56);
		File file=new File("E://externalization.ser");
		
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(e);
		System.out.println("Externalization is done >.....");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee e1=(Employee)ois.readObject();
		System.out.println(e1.toString());
		
	}
}

package com.sanjeet.corejava.corejava.datastructure;

class MyUser {

	private String name;
	private int age;
	private String company;
	
	
	
	public MyUser(String name, int age, String company) {
		super();
		this.name = name;
		this.age = age;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	//can be done using objects class
	//Objects.equals(o1,o2)
	@Override
	public boolean equals(Object o){
		
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o instanceof MyUser))
			return false;
		MyUser user=(MyUser) o;
		if((name.equals(user.name)) && (age==user.age) && (company.equals(user.company))){
			return true;
			
		}
		else return false;
	}
	//can be done using Objects.hashCode(...arr)
	@Override
	public int hashCode(){
		int result=17;
		result= 31*result+name.hashCode();
		result=31*result+age;
		result=31*result+company.hashCode();
		return result;
		
	}
	
}
public class MyCustomUser{
	
	public static void main(String[] args) {
		
		MyUser myuser=new MyUser("sanjeet",45,"TCS");
		MyUser myUser1=new MyUser("sanjeet",45,"TCS");
		System.out.println(myuser.equals(myUser1));
		System.out.println(myuser.hashCode());
		System.out.println(myUser1.hashCode());
		System.out.println(myuser==myUser1);
	}
}

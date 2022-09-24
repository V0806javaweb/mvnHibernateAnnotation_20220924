package model;

import javax.persistence.*;
@Entity
@Table(name="tb_employee")
public class MyEmployee {
	//此為tb_employee類資料格式，由hibernate cfg檔參考使用
	@Id
    int id;
    String firstName;
    String lastName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "MyEmployee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
    
}

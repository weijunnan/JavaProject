package com.atguigu.spring.boot.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

// 当前类存放读取yml配置文件的数据，要求当前类也在IOC容器中
@Component

// @ConfigurationProperties表示和yml配置文件对应，读取其中数据
// prefix属性表示和yml配置文件中以“student”开头的配置项对应
@ConfigurationProperties(prefix = "student")
public class Student {
	
	private Integer stuId;
	private String stuName;
	private Boolean graduated;
	private String[] subject;
	
	// 如果不使用@DateTimeFormat指定日期时间格式，那么必须使用默认格式“1990/10/12”
	// 如果不使用默认格式就必须使用@DateTimeFormat注解的pattern指定日期时间格式
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	private Map<String, String> teachers;
	private Address address;
	
	public Student() {
		
	}

	public Student(Integer stuId, String stuName, Boolean graduated, String[] subject, Date birthday,
			Map<String, String> teachers, Address address) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.graduated = graduated;
		this.subject = subject;
		this.birthday = birthday;
		this.teachers = teachers;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", graduated=" + graduated + ", subject="
				+ Arrays.toString(subject) + ", birthday=" + birthday + ", teachers=" + teachers + ", address="
				+ address + "]";
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Boolean getGraduated() {
		return graduated;
	}

	public void setGraduated(Boolean graduated) {
		this.graduated = graduated;
	}

	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Map<String, String> getTeachers() {
		return teachers;
	}

	public void setTeachers(Map<String, String> teachers) {
		this.teachers = teachers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}

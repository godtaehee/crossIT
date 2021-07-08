package com.crossit.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Project {
	
	private Long id;
	private String name;
	private int count;
	private String introduce;
	//DTO는 페이지별로 나누기 DB에 전송
	private Date limitdate;
	private int profile;
	private String hostorg;
	private String category;
	private String qualification;
	
	private String awards;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getLimitdate() {
		return limitdate;
	}
	public void setLimitdate(Date limitdate) {
		this.limitdate = limitdate;
	}
	public int getProfile() {
		return profile;
	}
	public void setProfile(int profile) {
		this.profile = profile;
	}
	public String getHostorg() {
		return hostorg;
	}
	public void setHostorg(String hostorg) {
		this.hostorg = hostorg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", count=" + count + ", introduce=" + introduce + ", limitdate="
				+ limitdate + ", profile=" + profile + ", hostorg=" + hostorg + ", category=" + category
				+ ", qualification=" + qualification + ", awards=" + awards + "]";
	}
	
	

}

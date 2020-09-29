package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "goals")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;
    @Column(name = "microsaving")
    private int microsaving;
    @Column(name = "targetamount")
    private int targetamount;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
    	
        this.phoneNo = phoneNo;
    }
    
    
    
	public int getTargetAmount() {
		return targetamount;
	}

	public void setTargetAmount(int targetAmount) {
		this.targetamount = targetAmount;
	}

	public int getMicroSaving() {
		return microsaving;
	}

	public void setMicroSaving(int microSaving) {
		this.microsaving = microSaving;
	}
}
//public class User {
//
//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	@Column(name = "name")
//	private String name;
//	@Column(name = "goal")
//	private String Goal;
//	@Column(name = "target_amount")
//	private int TargetAmount;
//	@Column(name = "micro_saving")
//	private int MicroSaving;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getGoal() {
//		return Goal;
//	}
//
//	public void setGoal(String goal) {
//		Goal = goal;
//	}
//
//	public int getTargetAmount() {
//		return TargetAmount;
//	}
//
//	public void setTargetAmount(int targetAmount) {
//		TargetAmount = targetAmount;
//	}
//
//	public int getMicroSaving() {
//		return MicroSaving;
//	}
//
//	public void setMicroSaving(int microSaving) {
//		MicroSaving = microSaving;
//	}
//
//}

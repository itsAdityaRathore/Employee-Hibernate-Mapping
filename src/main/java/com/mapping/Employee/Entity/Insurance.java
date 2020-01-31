package com.mapping.Employee.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "INSURANCE")
public class Insurance {

    @Id
    @Column(name = "INS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String ins_type;

    @Column
    private String ins_period;

    @Column
    private String ins_company;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public Insurance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIns_type() {
        return ins_type;
    }

    public void setIns_type(String ins_type) {
        this.ins_type = ins_type;
    }

    public String getIns_period() {
        return ins_period;
    }

    public void setIns_period(String ins_period) {
        this.ins_period = ins_period;
    }

    public String getIns_company() {
        return ins_company;
    }

    public void setIns_company(String ins_company) {
        this.ins_company = ins_company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

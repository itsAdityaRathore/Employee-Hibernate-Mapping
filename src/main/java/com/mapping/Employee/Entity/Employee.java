package com.mapping.Employee.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import javax.validation.GroupSequence;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", initialValue = 1001, allocationSize = 100, sequenceName = "user_seq")
    @Column(name = "EMP_ID")
    private int id;

    @Column
    private String name;

    @Column
    private String phone;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Bank bank;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Set<Insurance> insurances;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_domain",
            joinColumns = {@JoinColumn(referencedColumnName = "emp_id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Domain> domain;

    public Employee() {
    }

    public Employee(String name, String phone, Bank bank, Set<Insurance> insurances, Set<Domain> domain) {
        this.name = name;
        this.phone = phone;
        this.bank = bank;
        this.insurances = insurances;
        this.domain = domain;
    }

    public Set<Domain> getDomain() {
        return domain;
    }

    public void setDomain(Set<Domain> domain) {
        this.domain = domain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
//        if(bank == null){
//            if(this.bank != null){
//                this.bank.setEmployee(null);
//            }
//        } else {
//            bank.setEmployee(this);
//        }
        this.bank = bank;
        bank.setEmployee(this);
    }

    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }
}

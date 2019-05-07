package com.lambdaschool.orders.model;


/*
ORDNUM primary key, not null Long
ORDAMOUNT double
ADVANCEAMOUNT double
CUSTCODE Long foreign key (one customer to many orders) not null
AGENTCODE Long foreign key (one agent to many orders) not null
ORDDESCRIPTION String
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordernum;

    @Column(unique = true,
            nullable = false)
    private double ordamount;
    private double advanceamount;

    @OneToMany(mappedBy = "customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("customer")
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "agent",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("agent")
    private List<Agent> agents = new ArrayList<>();

    private String orddescription;

    public Order() {}

    public Order(double ordamount, double advanceamount, List<Customer> customers, List<Agent> agents, String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customers = customers;
        this.agents = agents;
        this.orddescription = orddescription;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }

}

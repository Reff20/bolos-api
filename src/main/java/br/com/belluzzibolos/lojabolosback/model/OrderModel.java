package br.com.belluzzibolos.lojabolosback.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_ORDER")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer id;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "ORDER_CUSTOMER")
    private String orderCustomer;

    @Column(name = "ORDER_ITEMS")
    private String orderItems;

    @Column(name = "ORDER_COST")
    private Float orderCost;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    public OrderModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(String orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String orderItems) {
        this.orderItems = orderItems;
    }

    public Float getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Float orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

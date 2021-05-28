package com.spring.files.excel.springbootuploadexcelfiles.madel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	@Id
	@Column(name = "Order_ID")
	private int id;

	@Column(name = "Order_Date")
	private String orderDate;

	@Column(name = "Order_Quantity")
	private double orderQuantity;

	@Column(name = "Sales")
	private double sales;

	@Column(name = "Ship_Mode")
	private String shipMode;

	@Column(name = "Profit")
	private double profit;

	@Column(name = "Unit_Price")
	private double unitPrice;

	@Column(name = "Customer")
	private String customer;

	@Column(name = "Customer_Segment")
	private String customerSegment;

	@Column(name = "Product_Category")
	private String productCategory;

	public Tutorial() {

	}

	public Tutorial(int id, String orderDate, double orderQuantity, double sales, String shipMode, double profit,
			double unitPrice, String customer, String customerSegment, String productCategory) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.sales = sales;
		this.shipMode = shipMode;
		this.profit = profit;
		this.unitPrice = unitPrice;
		this.customer = customer;
		this.customerSegment = customerSegment;
		this.productCategory = productCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public String getShipMode() {
		return shipMode;
	}

	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerSegment() {
		return customerSegment;
	}

	public void setCustomerSegment(String customerSegment) {
		this.customerSegment = customerSegment;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", orderDate=" + orderDate + ", orderQuantity=" + orderQuantity + ", sales="
				+ sales + ", shipMode=" + shipMode + ", profit=" + profit + ", unitPrice=" + unitPrice + ", customer="
				+ customer + ", customerSegment=" + customerSegment + ", productCategory=" + productCategory + "]";
	}
	
}

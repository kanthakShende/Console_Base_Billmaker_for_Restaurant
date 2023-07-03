package com.dac.org;

public class Menu {
	
private int srNo;
private String dishName;
private int price;

public Menu() {
}

public Menu(int srNo, String dishName, int price) {
	super();
	this.srNo = srNo;
	this.dishName = dishName;
	this.price = price;
}

public int getSrNo() {
	return srNo;
}

public void setSrNo(int srNo) {
	this.srNo = srNo;
}

public String getDishName() {
	return dishName;
}

public void setDishName(String dishName) {
	this.dishName = dishName;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

@Override
	public String toString() {
		return String.format("%-10d%-30s%-5d", this.srNo, this.dishName, this.price);
	}

}

package com.dac.org;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Table {
	
static float totalBill;
private Menu [] arr = new Menu[20];
List<String> list = new ArrayList<>(); 
private float bill;
static Scanner sc = new Scanner(System.in);

public Table() {
	arr[0] = new Menu(1, "Plain Rice", 50);
	arr[1] = new Menu(2, "Jeera Rice", 75);
	arr[2] = new Menu(3, "Chicken Curry", 300);
	arr[3] = new Menu(4, "Mutton Curry", 400);
	arr[4] = new Menu(5, "Masala Paneer", 200);
	arr[5] = new Menu(6, "Palak Paneer", 230);
	arr[6] = new Menu(7, "Chicken Biryani", 250);
	arr[7] = new Menu(8, "Mutton Biryani", 350);
	arr[8] = new Menu(9, "Roti", 10);
	arr[9] = new Menu(10, "Tandoori Chicken", 350);
	arr[10] = new Menu(11, "Hakka Noodles", 150);
	arr[11] = new Menu(12, "Veg Manchurian", 100);
	arr[12] = new Menu(13, "Mix Veg", 150);
	arr[13] = new Menu(14, "Egg Curry", 150);
	arr[14] = new Menu(15, "Plain Water", 20);
	arr[15] = new Menu(16, "Cold-drink", 50);
}

void printMenu() {
	Menu m = null;
	System.out.printf("%-10s%-30s%-5s\n", "Sr.No", "Dish Name", "Price");
	System.out.println("-----------------------------------------------------------------------------");
	for(int i = 0; i < arr.length; i++) {
		m = arr[i];
		if(m != null) {
			String str = m.toString();
			System.out.println(str);
		}
	}
	System.out.println("-----------------------------------------------------------------------------");
}

public void setDish() {
		boolean dishStatus = false;
		System.out.println("Enter your dish: ");
		String str = sc.nextLine();
		for(int i = 0; i < this.arr.length; i++) {
			if(this.arr[i] != null) {
				String str1 = this.arr[i].getDishName();
				if(str1.equalsIgnoreCase(str)) {
					try {
						list.add(str1);
					} catch (ConcurrentModificationException ex) {
						//ex.printStackTrace();
						System.out.println();
						sc.nextLine();
					}
					System.out.println("Dish added Sucessfully!!!");
					dishStatus = true;
					break;
				}
			}
		}
		if(dishStatus == false) {
			System.out.println("Enter valid dish!!!");
	 }
	}

public void removeDish(String str) {
	boolean dishStatus = false;
	for(int i = 0; i < this.arr.length; i++) {
		if(this.arr[i] != null) {
			String str1 = this.arr[i].getDishName();
			if(str1.equalsIgnoreCase(str)) {
				try {
					list.remove(str1);
				} catch (ConcurrentModificationException ex) {
					//ex.printStackTrace();
					System.out.println();
					sc.nextLine();
				}
				System.out.println("Dish removed Sucessfully!!!");
				dishStatus = true;
				break;
			}
		}
	}
	if(dishStatus == false) {
		System.out.println("Enter valid dish!!!");
 }
}
	
public void showYourOrder() {
	System.out.println("-------------------");
	System.out.println("Your orders are: ");
	System.out.println("-------------------");
	for(String str : list) {
		System.out.println(str);
	}
}

public List<String> getDishName() {
	return list;
}

public boolean printYourBill() {
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println("Your Bill is: ");
	System.out.println("-----------------------------------------------------------------------------");
	System.out.printf("%-30s%-7s\n", "Dish name", "Price");
	System.out.println("-----------------------------------------------------------------------------");
	for(String str : list) {
		if(str != null) {
			for(int i = 0; i < arr.length; i++) {
				Menu m = null;
				m = arr[i];
				if(m != null) {
					String str1 = m.getDishName();
					if(str.equals(str1)) {
						System.out.printf("%-30s%-7d\n", str, m.getPrice());
						this.bill = this.bill + m.getPrice();	
					}
				}
			}
		}
	}
	totalBill = totalBill + this.bill;
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println("Total:        "+this.bill);
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println("ThankYou vist again!!!!");
	return true;
	
}

public static void totalBillCounter() {
	System.out.println("-----------------------------------------");
	System.out.println("Total Collection : "+ totalBill);
	System.out.println("-----------------------------------------");
}
}




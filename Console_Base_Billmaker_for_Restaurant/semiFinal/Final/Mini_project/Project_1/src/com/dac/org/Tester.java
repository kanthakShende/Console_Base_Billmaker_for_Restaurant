package com.dac.org;

import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Tester {
public static Scanner sc = new Scanner(System.in);
private Table []table = new Table[20];
Table t2 = new Table();

void tableAvailablity() {
	System.out.println("Available tables are:");
	System.out.println("--------------------------------------------------------------------------------------------------------------");
	try {
		for(int i = 0; i < table.length; i++) {
			Table t1 = table[i];
			if(t1 == null) {
				System.out.print("| "+i+" |");
			}
		}
		System.out.println();
		throw new ArrayIndexOutOfBoundsException("There are 20 Tables in this Restaurant & the available Tables are: ");
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.println(e.getMessage());
	}	
	System.out.println();
	System.out.println("--------------------------------------------------------------------------------------------------------------");
}

void addTable(int index) {
	try {
		if(index<=19) {
	        if (table[index] == null) {
	        	table[index] = new Table();
	        	System.out.println("Table no. "+index+" is booked for you.." );
	        }else {
                throw new RuntimeException("Table no: " + index + " is already booked!!");
            }		
        }else {
        		throw ( new ArrayIndexOutOfBoundsException("Invalid Table no."));
        } 
    }catch (InputMismatchException ex) {
        System.out.println("Invalid input! Please enter a number.");
        sc.nextLine(); // consume the invalid input
    }catch (ArrayIndexOutOfBoundsException ex) {
        System.out.println(ex.getMessage());
    } catch (RuntimeException ex ) {
    	System.out.println(ex.getMessage());
	}
}

public void printMenu() {
	System.out.println("---------------------------------------------------------------");
	t2.printMenu();
}

public void addDish(int index) {
	if(index < table.length) {
        Table dish = table[index];
        if (dish != null) {
            try {
				dish.setDish();
			} catch (ConcurrentModificationException e) {
				//e.printStackTrace();
			}
        }
        else
        	System.out.println("Table no "+index+" is empty!!!");
	}
	else {
		System.out.println("Table no: " + index + " is invalid!!!!");
	}
 }

public String deleteDish(int index) {
	boolean b = false;
	if(index < table.length) {
        Table dish = table[index];
        if (dish != null) {
        	List <String> dish1 = dish.getDishName();
        	if(dish1 != null) {
        		System.out.println("Enter dish to be removed: ");
        		String str1 = sc.nextLine();
        	for(String str : dish1) {
        		if(str1.equalsIgnoreCase(str)) {
        		try {
					dish.removeDish(str);
				} catch (ConcurrentModificationException e) {
					//e.printStackTrace();
				}
        		b = true;
        		}
        	}
        	if(!b)
        		System.out.println("Invalid dish name");
        	}
        	else
        		System.out.println("Your order list is empty!!");
        	} 
        else
        	System.out.println("Table no "+index+" is empty!!!");
        }
	else 
		System.out.println("Table no: " + index + " is invalid!!!!");
	return null;
}
	

	
    
public void showOrder(int index) {
	if(index < table.length) {
		if(table[index] != null) {
	table[index].showYourOrder();
		}
		else
			System.out.println("Table no "+index+" is empty!!!");
	}
	else
		System.out.println("Table no: " + index + " is invalid!!!!");
}

public void printBill(int index) {
	if(index < table.length) {
	if(table[index] != null) {
    boolean b = table[index].printYourBill();	
    if(b == true) {
    	table[index] = null;
    }
	}
	else 
		System.out.println("Table no "+index+" is empty!!!");
}
	else
		System.out.println("Table no: " + index + " is invalid!!!!");
}

public void totalBill() {
	Table.totalBillCounter();
}
}

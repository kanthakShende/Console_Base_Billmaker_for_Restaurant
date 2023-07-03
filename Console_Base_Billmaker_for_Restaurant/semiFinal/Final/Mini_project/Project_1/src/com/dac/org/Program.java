package com.dac.org;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;

enum choice{
	EXIT, AVAILABLITY, BOOK, MENU, ADDDISH, REMOVEDISH, SHOW, BILL, TOTALBILL
}
public class Program {
static Scanner sc = new Scanner(System.in);

private static choice menuList() {
	try {
		System.out.println("-----------------------------------");
		System.out.println("0. EXIT");
		System.out.println("1. Check table Availablity");
		System.out.println("2. Book Table");
		System.out.println("3. Show Menu");
		System.out.println("4. Order Dish");
		System.out.println("5. Remove Dish");
		System.out.println("6. Show your order");
		System.out.println("7. Print Bill");
		System.out.println("8. Print Total Collection");
		System.out.println("-----------------------------------");
		System.out.print("Enter your Choice: ");
		int choice1 = sc.nextInt();
		return choice.values()[choice1];
	} catch (ArrayIndexOutOfBoundsException ex) {
	    System.out.println("Please Enter valid Input.");
	    sc.nextLine(); // consume the invalid input
	}
	catch(InputMismatchException ex) {
		System.out.println("Please Enter valid Input.");
		sc.nextLine();
	}
	return null;
}

public static void main(String[] args) {
	Tester t = new Tester();
	choice choice2;
	System.out.println("Welcome to Hotel Ashoka!!!!");
		while((choice2 = Program.menuList()) != choice.EXIT) {
			try {
				if(choice2.compareTo(choice2)<7) {
					switch(choice2) {
					case AVAILABLITY:
						t.tableAvailablity();
						break;
					
					case BOOK:
						System.out.println("Enter Table no. : ");
							t.addTable(sc.nextInt());
						break;
						
					case MENU:
						t.printMenu();
						break;
						
					case ADDDISH:
						System.out.println("Enter table no: ");
						try {
							t.addDish(sc.nextInt());
						} catch (ConcurrentModificationException e) {
							//e.printStackTrace();
						}
						break;
						
					case REMOVEDISH:
						System.out.println("Enter table no: ");
						try {
							t.deleteDish(sc.nextInt());
						} catch (ConcurrentModificationException e) {
							//e.printStackTrace();
						}
						break;
						
					case SHOW:
						System.out.println("Enter table no: ");
						t.showOrder(sc.nextInt());
						break;
						
					case BILL:
						System.out.println("Enter table no: ");
						t.printBill(sc.nextInt());
						break;
						
					case TOTALBILL:
						t.totalBill();
						break;
					}
				}
			}catch (NullPointerException ex) {
				
		     }catch (InputMismatchException ex) {
		        System.out.println("Please Enter valid Input.");
		        sc.nextLine(); // consume the invalid input
		     }catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}




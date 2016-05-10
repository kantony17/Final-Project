//customerDatabase.java
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CustomerDatabase implements java.io.Serializable{

	private int numCustomers;
	private Customer customerList;


	public CustomerDatabase(){
		customerList = null;

	}

	public boolean areNoCustomers(){
		return customerList == null;
	}
	
		public void printCustomers(){
		Customer temp = customerList;
		for (int j > 0; j < numCustomers; j++){
			System.out.print(temp.getEmail);
			temp=temp.getNext();
		}
	}

	public void addCustomer(){
		Customer newCustomer = makeCustomer();
		newCustomer.setNext(customerList);
		customerList = newCustomer;
		numCustomers++;
		System.out.println("*You have been added. Welcome to the Netflix family!*");
	}

	private Customer makeCustomer(){
		System.out.println("\n--------Customer Adding Portal--------");
		System.out.println("*Please enter your information*\n");




		Scanner scan = new Scanner(System.in);
		Scanner nums = new Scanner(System.in);


		System.out.print("Name: ");
		String name = scan.nextLine();

		System.out.print("Enter Password: ");
		String password1 = scan.nextLine();

		System.out.print("Confirm Password: ");
		String password2 = scan.nextLine();

		while (!(password1.equals(password2))){
			System.out.println("\nYour passwords did not match!");
			System.out.print("Enter Password: ");
			password1 = scan.nextLine();
			System.out.print("Confirm Password: ");
			password2 = scan.nextLine();
		}

		System.out.print("\nEmail: ");
		String email = scan.nextLine();


		System.out.println();
		System.out.print("Credit Card Number (16 digits): ");


		Long CCN = null;

		while(true){
			try{
				CCN = nums.nextLong();
				while ((CCN < 0000000000000000L) || (CCN > 9999999999999999L)){
					System.out.print("ERROR! Please enter your 16 digit card number as instructed: ");
					CCN = nums.nextLong();
				}
				break;
				
			}
			catch (InputMismatchException youFuckedUp){
				System.out.print("ERROR! Please enter your 16 digit card nubmer as instructed: ");
				nums.next();
				continue;
			}
		}

		Customer addingCustomer = new Customer(name, email, CCN, password2);

		System.out.println();

		return addingCustomer;
	}

	public Customer findCustomer(String email){
		if (areNoCustomers() == false){
			Customer temp = customerList;

			if (temp.getEmail() == email){
				return temp;
			}
			
			else{
				while (temp.getNext() != null){
					if (temp.getEmail() == email){
						return temp;
					}
					else{
						temp = temp.getNext();
					}
				}
			}
			return null;
		}
		else{
			return null;
		}
	}

	public boolean hasCustomer(String email0){
		thisCustomer = findCustomer(email0);
		if (thisCustomer != null){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean passwordMatch(String email0, String password0){
		thisCustomer = findCustomer(email0);
		if (hasCustomer(email0)){
			return (thisCustomer.getPassword() == password0);
		}
		else{
			return false; 
		}
	}

	/*public static void main(String[] args) {
		CustomerDatabase myCs = new CustomerDatabase();
		myCs.addCustomer();
		myCs.addCustomer();
		myCs.addCustomer();
		myCs.addCustomer();
	}*/



}

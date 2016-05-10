//customerDatabase.java
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CustomerDatabase implements java.io.Serializable{

	private int numCustomers;
	private Customer[] customerList;
	private int maxCustomers;


	public CustomerDatabase(){
		customerList = new Customer[97];
		maxCustomers = 97;

	}

	public boolean areNoCustomers(){
		return numCustomers == 0;
	}


	public int hash1(int IDNum){
		return (IDNum%97);
	}

	public int hash2(int value, int IDNum){
		return ((value + (IDNum%83) + 1)%97);


	}
	public Customer findCustomer(int IDNum){
		int counter = 0;
		int check = hash1(IDNum);

		while ((customerList[check] == null) || (customerList[check].getKey() != IDNum)){
			check = hash2(check,IDNum);
			counter++;
			if (counter > maxCustomers){
				return null;
			}
		}
		return customerList[check];
	}

	public void delete(int IDNum){
		int counter = 0;
		int check = hash1(IDNum);
		while ((customerList[check] == null) || (customerList[check].getKey() != IDNum)){
			check = hash2(check,IDNum);
		}

		customerList[check] = null;
		numCustomers--;

	}

	public void addCustomer(){
		Customer newCustomer = makeCustomer();

		int counter = 0;
		int place = hash1(newCustomer.getKey());
		while ((counter < maxCustomers) && (customerList[place] != null)){
			place = hash2(place,newCustomer.getKey());
			counter++;	
		}

		if (numCustomers == maxCustomers){
			System.out.println("Database is full; please make space in order to add " + newCustomer.getName());
		}

		else{
			customerList[place] = newCustomer;
			numCustomers++;
		}

	}




	/*
	public void addCustomer(){
		Customer newCustomer = makeCustomer();
		newCustomer.setNext(customerList);
		customerList = newCustomer;
		numCustomers++;
		System.out.println("*You have been added. Welcome to the Netflix family!*");
	}

	public void printCustomers(){
		Customer temp = customerList;
		for (int j = 0; j < numCustomers; j++){
			System.out.print(temp.getEmail());
			temp=temp.getNext();
		}
	}

	*/

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
		String ccnGo = "";

		while(true){
			try{
				CCN = nums.nextLong();
				while ((CCN < 0000000000000000L) || (CCN > 9999999999999999L)){
					System.out.print("ERROR! Please enter your 16 digit card number as instructed: ");
					CCN = nums.nextLong();

				}
				ccnGo = Long.toString(CCN);

				break;
				
			}
			catch (InputMismatchException youFuckedUp){
				System.out.print("ERROR! Please enter your 16 digit card nubmer as instructed: ");
				nums.next();
				continue;
			}
			
		}

		Customer addingCustomer = new Customer(name, email, ccnGo, password2);

		System.out.println();

		return addingCustomer;
	}

	/*public Customer findCustomer(String email){
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

	*/

	public boolean hasCustomer(int last4Digits){
		Customer thisCustomer = findCustomer(last4Digits);
		if (thisCustomer != null){
			return true;
		}
		else{
			return false;
		}
	}

	/*


	public boolean hasCustomer(String email0){
		Customer thisCustomer = findCustomer(email0);
		if (thisCustomer != null){
			return true;
		}
		else{
			return false;
		}
	}
	*/

	public boolean passwordMatch(int last4Digits, String password0){
		Customer thisCustomer = findCustomer(last4Digits);
		if (hasCustomer(last4Digits)){
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
	



	}
	*/

}




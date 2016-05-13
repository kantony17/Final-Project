//CustomerDatabase.java

//CustomerDatabase class is a hash table database for all customers in the system 
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CustomerDatabase implements java.io.Serializable{

	private int numCustomers; //number of customers in the system
	private Customer[] customerList; //array of custoers
	private int maxCustomers; //max customers or size of array


	//constructor takes no paramters, establishes an array of 97 customers
	public CustomerDatabase(){
		customerList = new Customer[97];
		maxCustomers = 97;

	}

	//returns true if no customers, false if 1 or more
	public boolean areNoCustomers(){
		return numCustomers == 0;
	}


	//hash 1 function returns index
	public int hash1(int IDNum){
		return (IDNum%97);
	}

	public int hash2(int value, int IDNum){
		return ((value + (IDNum%83) + 1)%97);


	}
	
	//returns Customer node after finding it by ID number
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

	//Returns A customers wishlist
	public WishList findCustomerWishList(int IDNum){
		int counter = 0;
		int check = hash1(IDNum);


		while ((customerList[check] == null) || (customerList[check].getKey() != IDNum)){
			check = hash2(check,IDNum);
			counter++;
			if (counter > maxCustomers){
				return null;
			}
		}
		return customerList[check].getWishList();

	}

	//returns the stack of recently watched movies
	public RecentlyWatchedStack findRecentlyWatchedStack(int IDNum){
		int counter = 0;
		int check = hash1(IDNum);

		while ((customerList[check] == null) || (customerList[check].getKey() != IDNum)){
			check = hash2(check,IDNum);
			counter++;
			if (counter > maxCustomers){
				return null;
			}
		}
		return customerList[check].getRecentlyWatchedStack();

	}


	//adds customer. Calls make customer to create this customer
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


	//make customer takes user input for name, email, ccn and password
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
				while ((CCN < 1000000000000000L) || (CCN > 9999999999999999L)){
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

			catch(StringIndexOutOfBoundsException again){
				System.out.print("ERROR! Please enter your 16 digit card nubmer as instructed: ");
				nums.next();
				continue;
			}
			
		}

		Customer addingCustomer = new Customer(name, email, ccnGo, password2);

		System.out.println();

		return addingCustomer;
	}


	//returns true if the customer with this key exists in the system, false if not
	public boolean hasCustomer(int last4Digits){
		Customer thisCustomer = findCustomer(last4Digits);
		if (thisCustomer != null){
			return true;
		}
		else{
			return false;
		}
	}

	//returns true if the paramter password matches with the password attached to the node with this key
	public boolean passwordMatch(int last4Digits, String password0){

		Customer thisCustomer = findCustomer(last4Digits);
		String checkPass = thisCustomer.getPassword();

		return password0.equals(checkPass);

	}



}


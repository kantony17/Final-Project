/*Customer.java

This is the class for a Customer node that holds:
	-Name
	-Email
	-Credit Card Number (CCN)
	-Key (last 4 digits of CCN)
	-Password
	-The customer's WishList

*/
public class Customer implements java.io.Serializable{ 

	private String name;
	private String email;
	private String CCN; //CCN is taken as a string because the max 16 digit number (9999999999999999) is larger than max int size
			//   We only use the last 4 digits of CCN in the program, so it was not necessary to make CCN a Long
	private int key;
	//private Customer next;
	private String password;
	private WishList wishList;
	//private //customer list of movies

	//Constructor takes Name, Email, CCN, and Password
	public Customer(String name0, String email0, String CCN0, String password0){
		name = name0;
		email = email0;
		CCN = CCN0;
		//key is taken by converting the last 4 characters of the CCN string to an integer
		key = Integer.parseInt(CCN.substring(12));
		password = password0;
		wishList = new WishList();
	}

	//Returns String Name of customer
	public String getName(){
		return name;
	}

	//returns String email of customer
	public String getEmail(){
		return email;
	}

	//returns STring CCN of customer
	public String getCCN(){
		return CCN;
	}

	//returns int key of customer
	public int getKey(){
		return key;
	}

	//Returns type WishList wishlist of customer
	public WishList getWishList(){
		return wishList;
	}

	/*
	public Customer getNext(){
		return next;
	}
	


	public void setNext(Customer x){
		next = x;
	}
	*/

	//Returns String password of customer
	public String getPassword(){
		return password;
	}
}

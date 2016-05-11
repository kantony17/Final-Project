//Cnode.java

public class Customer implements java.io.Serializable{ 

	private String name;
	private String email;
	private String CCN;
	private int key;
	private Customer next;
	private String password;
	private WishList wishList;
	//private //customer list of movies


	public Customer(String name0, String email0, String CCN0, String password0){
		name = name0;
		email = email0;
		CCN = CCN0;

		key = Integer.parseInt(CCN.substring(12));

		//key = key%1000;
		next = null;
		password = password0;
		wishList = new WishList();
	}

	public String getName(){
		return name;
	}

	public String getEmail(){
		return email;
	}

	public String getCCN(){
		return CCN;
	}

	public int getKey(){
		return key;
	}

	public WishList getWishList(){
		return wishList;
	}

	public Customer getNext(){
		return next;
	}


	public void setNext(Customer x){
		next = x;
	}

	public String getPassword(){
		return password;
	}
}

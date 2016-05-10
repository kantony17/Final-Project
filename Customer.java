//Cnode.java


public class Customer implements java.io.Serializable{ 

	private String name;
	private String email;
	private Long CCN;
	private Long key;
	private Customer next;
	private String password;
	//private //customer list of movies


	public Customer(String name0, String email0, Long CCN0, String password0){
		name = name0;
		email = email0;
		CCN = CCN0;
		key = CCN;
		next = null;
		password = password0;

	}

	public String getName(){
		return name;
	}

	public String getEmail(){
		return email;
	}

	public Long getCCN(){
		return CCN;
	}

	public Long getKey(){
		return key;
	}

	public Customer getNext(){
		return next;
	}


	public void setNext(Customer x){
		next = x;
	}

}




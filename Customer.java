//Cnode.java


public class Customer{ 

	private String name;
	private String email;
	private int CCN;
	private int key;
	private Customer nextC;
	private //customer list of movies


	public Cnode(String name0, String email0, int CCN0){
		name = name0;
		email = email0;
		CCN = CCN0;
		key = CCN;
		nextC = null;

	}

	public String getName(){
		return name;
	}

	public String getEmail(){
		return email;
	}

	public int getCCN(){
		return CCN;
	}

	public int getKey(){
		return key;
	}

	public Customer getNextC(){
		return nextC;
	}


	public void setNextC(Customer x){
		nextC = x;
	}

}




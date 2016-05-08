//Wish List for Customers


import java.util.Scanner;

public class WishList{

	//instance variables
	private int length;
	private Movie head;
	private Movie end;
	private Movie temp;
	private Movie temp2;
	
	//constructor
	public WishList(){
		length = 0;
	}

	//add new movie in any location, O(n) runtime
	public void addNewMovie(Movie movie){
		if (length < 20){
			try{
				Scanner s = new Scanner(System.in);
				System.out.println("Where would you like this movie to be added? \n A. Front \n B. End \n C. Other");
				String userInput = s.next();
				if (userInput.equals("A")){
					if (length == 0){
						head = end = movie;
						System.out.println("The movie you have added is the first movie of your wish list\n");
					}
					else if(length ==1){
						Movie temp = head;
						head = movie;
						head.setNextM(temp);
						end = temp;
						System.out.println("The movie has been added to the front, but there are " + length + " other movies in your list \n");

					}
					else{//lengths greater than 1
						Movie temp = head.getNextM();
						Movie temp2 = head;
						head = movie;
						movie.setNextM(temp2);
						System.out.println("The movie has been added to the front, but there are " + length + " other movies in your list \n");
					}
					length++;
				}
				else if (userInput.equals("B")){
					Movie temp = end;
					end = movie;
					temp.setNextM(movie);
					length++;
					System.out.println("The movie has been added to the end of your list \n");
				}
				else if (userInput.equals("C")){
					Scanner x = new Scanner(System.in);
					System.out.println("Enter a number 1-"+ length+1+ " where you'd like this movie to be played:  ");
					int userInput2 = x.nextInt();
					Movie temp = head;
					for (int i = 0; i < userInput2; i++){
						temp = temp.getNextM();
					}
					Movie temp2 = temp;
					temp.setNextM(movie);
					movie.setNextM(temp2.getNextM());
					length++;
					System.out.println("The movie is in position "+ userInput + " of your list\n");
				}
			}
			catch(IllegalArgumentException i){
				System.out.println("You did not enter one of the choices. Choose Again");
				i.printStackTrace();
			}
		}
		else{
			System.out.println("Sorry, you're wish list is full\n");
		}
	}

	//searches for a movie in the list, returns the movie, O(n) runtime 
	//id is the five digit long number for each movie 
	public Movie search(int id){
		while (head.getNextM() != null && head.getNextM().getID() != id){
			head = head.getNextM();
		}
		return head;//returning the node before the one we're searching for
	}

	//deletes the node in the list and reorganizes the list, O(n) runtime 
	public void delete(int id){
		temp = search(id);
		temp.setNextM(temp.getNextM().getNextM());
		temp.getNextM().setNextM(null); 
	}

	//returns the first movie in the list
	public Movie firstMovie(){
		return head;
	}

	//prints the title and id of each of the movies in the list in the order they are in the list 
	public void printList(){
		Movie temp = head;
		for (int i = 0; i < length; i++){
			System.out.println(temp.getTitle() + "," + temp.getID());
			temp = temp.getNextM();
		}
	}
}


//Wish List for Customers


import java.util.Scanner;

public class WishList{

	//instance variables
	private int length;
	private Movie head;
	private Movie end;
	private Movie temp;
	private Movie temp2;
	private Movie prevEnd; 

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
				if (userInput.equals("A")){ //insert to the front of wishlist
					if (length == 0){
						head = end = movie;
						System.out.println("The movie you have added is the first movie of your wish list\n");
					}
					else if(length == 1){
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
				else if (userInput.equals("B")){ //insert a movie to the end of the wishlist
					if (length == 0){
						head = end = movie;
						length++;
						System.out.println("The movie has been added to the end of your list.");
					}
					else{
						temp = head;
						for (int i = 0; i < length - 1; i++){
							temp = temp.getNextM();
						}
						end = temp;
						temp.setNextM(movie);
						end = movie;
						length++;
					}
				}
				else if (userInput.equals("C")){ //option C- insert to a specified (integer) spot
					Scanner x = new Scanner(System.in);
					System.out.println("Enter a number 1 - " + (length+1) + " where you'd like this movie to be played:  ");
					int userInput2 = x.nextInt();
					if (length == 0){ //to insert at the beginning when the list is empty
						head = end = movie;
						length++;
						System.out.println("The movie has been added to your list.");
					}
					else if (userInput2 == 1){ //insert into the front with other movies already in the list
						Movie temp = head.getNextM();
						Movie temp2 = head;
						head = movie;
						movie.setNextM(temp2);
						length++;
						System.out.println("The movie has been added to the front, but there are " + length + " other movies in your list \n");
					}
					else if (userInput2 == (length + 1)){ //if they want to insert at the end
						if (length == 1){
							head.setNextM(movie);
							movie = end;
							length++;
						}
						else if (length == 2){
							for (int i = 0; i < length - 1; i++){
								end = head.getNextM();
							}
							Movie temp = end;
							end = movie;
							temp.setNextM(movie);
							length++;
						}
						else{
							for (int i = 0; i < length - 2; i++){
								prevEnd = head.getNextM();
								end = prevEnd.getNextM();
							}
							Movie temp = end;
							end = movie;
							prevEnd.setNextM(temp);
							temp.setNextM(movie);
						
							length++;
						}
						System.out.println("The movie has been added to the end of your list \n");
						
					}
					else{ //anywhere else in the middle
						Movie temp = head;
						for (int i = 0; i < (userInput2 - 2); i++){
							temp = temp.getNextM();
							System.out.println("1");
						}
						movie.setNextM(temp.getNextM());
						temp.setNextM(movie);
						length++;
						System.out.println("The movie is in position " + userInput2 + " of your list\n");
					}
				}
				
			}
			catch(IllegalArgumentException i){
				System.out.println("You did not enter one of the choices. Choose Again");
				i.printStackTrace();
			}
		}
		else{
			System.out.println("Sorry, your wish list is full");
		}
	}

	//searches for a movie in the list, returns the movie, O(n) runtime 
	//id is the five digit long number for each movie 
	public Movie search(int id){
		Movie temp = head;
		while (temp != null){
			if (temp.getID() == id){
				return temp;
			}
			temp = temp.getNextM();
		}
		System.out.println("Sorry your movie is not in the wishlist");
		return null;
	}

	//deletes the movie from the list
	public Movie delete(int id){
		Movie temp1 = head;
		Movie temp2 = head;
		if (head.getID() == id){
			head = head.getNextM();
			length--;
			return temp1;
		}
		while (temp2 != null){
			temp2 = temp2.getNextM();
			if (temp2.getID() == id){
				temp1.setNextM(temp2.getNextM());
				length--;
				return temp2;
			}
			else{
				temp1 = temp1.getNextM();
			}
		}
		return null;
	}
	
	//returns the first movie in the list
	public Movie firstMovie(){
		return head;
	}

	//prints the title and id of each of the movies in the list in the order they are in the list 
	public void printList(){
		if (length == 0){
			System.out.println("There are no movies in your wish list.");
		}
		else{
			Movie temp = head;
			while (temp != null){
				for (int i = 0; i < length; i++){
					System.out.println("Title: " + temp.getTitle() + ", " + "ID: " + temp.getID());
					temp = temp.getNextM();
				}
			}
		}
	}
}

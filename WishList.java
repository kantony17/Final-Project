//Wish List for Customers


import java.util.*;
import java.io.*;

public class WishList implements java.io.Serializable{

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
		//wishlist can only hold up to 20 movies at a time
		if (length < 20){
			String userInput = "";
			while (!(userInput.equals("A") || userInput.equals("B") || userInput.equals("C"))){
				Scanner s = new Scanner(System.in);
				System.out.println("Where would you like this movie to be added? \n A. Front \n B. End \n C. Other");
				userInput = s.next();
				if (!(userInput.equals("A") || userInput.equals("B") || userInput.equals("C"))){
					System.out.println("Sorry that is not one of the options. Try again. ");
				}
			}
			//inserts the movie to the front of the wishlist 
			if (userInput.equals("A")){ 
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
				//lengths greater that 1
				else{
					Movie temp = head.getNextM();
					Movie temp2 = head;
					head = movie;
					movie.setNextM(temp2);
					System.out.println("The movie has been added to the front, but there are " + length + " other movies in your list \n");
				}
				length++;
			}
			//inserts the movie to the end of the wishlist 
			else if (userInput.equals("B")){ 
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
			//inserts the movie to a specified (integer) position 
			else if (userInput.equals("C")){ 
				Scanner x = new Scanner(System.in);
				System.out.println("Enter a number 1 - " + (length+1) + " where you'd like this movie to be played:  ");
				int userInput2 = x.nextInt();
				//insert at the beginning when the list is empty
				if (length == 0){ 
					head = end = movie;
					length++;
					System.out.println("The movie has been added to your list.");
				}
				//inserts at the beginning with other movies in the list 
				else if (userInput2 == 1){ 
					Movie temp = head.getNextM();
					Movie temp2 = head;
					head = movie;
					movie.setNextM(temp2);
					length++;
					System.out.println("The movie has been added to the front, but there are " + length + " other movies in your list \n");
				}
				//inserts at the end of the list 
				else if (userInput2 == (length + 1)){ 
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
				//inserts anywhere else in the middle
				else{ 
					Movie temp = head;
					for (int i = 0; i < (userInput2 - 2); i++){
						temp = temp.getNextM();
					}
					movie.setNextM(temp.getNextM());
					temp.setNextM(movie);
					length++;
					System.out.println("The movie is in position " + userInput2 + " of your list\n");
				}
			}
		}
		//if they try to enter more than 20 movies
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
		System.out.println("Sorry that movie is not in your wishlist.");
		return null;
	}

	//deletes the movie from the list, O(n) runtime 
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

	//prints the title and ID of each of the movies in the list in the order they are in the list 
	public void printList(){
		//if the list is empty
		if (length == 0){
			System.out.println("There are no movies in your wish list.");
		}
		else{
			Movie temp = head;
			for (int i = 0; i < length; i++){
				System.out.println("Title: " + temp.getTitle() + ", " + "ID: " + temp.getID());
				temp = temp.getNextM();
			}

		}
	}
}

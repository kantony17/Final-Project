//WISHLIST CODED WITH AN ARRAY

//Wish List for Customers


import java.util.*;
import java.io.*;

public class WishList implements java.io.Serializable{

	//instance variables
	private int length;
	private int head;
	private int end;
	private int i;
	private Movie[] wishlist;

	public WishList(){
		head = 0;
		length = 0;
		wishlist = new Movie[20];
	}

	//returns boolean, whether the array is empty or not
	public boolean isEmpty(){
		return length == 0;
	}

	//add new movie in any location, O(n) runtime
	public void addNewMovie(Movie movie){
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
			if (userInput.equals("A")){ 
				if (length == 0){
					wishlist[0] = movie;
					length++;
					end = length;
					System.out.println("The movie you have added is the first movie of your wish list\n");
				}
				else{
					for (int i = length; i > 0; i--){
						wishlist[i] = wishlist[i - 1];
					}
					wishlist[0] = movie;
					System.out.println("The movie has been added to the front, but there are " + length + " other movies in your list \n");
					length++;
				}
			}

			//inserts the movie to the end of the wishlist 
			else if (userInput.equals("B")){ 
				if (length == 0){
					length++;
					wishlist[0] = movie;
					end = length;
					System.out.println("The movie has been added to the end of your list.");
				}
				else{
					wishlist[length] = movie;
					length++;
					end = length;
				}
			}
			else if (userInput.equals("C")){ 
				Scanner x = new Scanner(System.in);
				System.out.println("Enter a number 1 - " + (length + 1) + " where you'd like this movie to be played:  ");
				int userInput2 = x.nextInt();
				//insert at the beginning when the list is empty
				if (length == 0){ 
					wishlist[0] = movie;
					length++;
					end = length;
					System.out.println("The movie has been added to your list.");
				}
				//inserts at the end of the list 
				else if (userInput2 == (length + 1)){ 
					wishlist[length] = movie;
					length++;
					end = length;
					System.out.println("The movie has been added to the end of your list \n");
				}
				//inserts anywhere else in the middle
				else{
					for (int i = length; i > userInput2-1; i--){
						wishlist[i] = wishlist[i - 1];
					}
					wishlist[userInput2-1] = movie;
					length++;
					System.out.println("The movie is in position " + userInput2 + " of your list\n");
				}
			}
		}
		else{
			System.out.println("Sorry, your wishlist is full.");
		}
	}

	//deletes the movie from the list, O(n) runtime 
	public Movie delete(int id){
		length--;
		wishlist[i] = wishlist[length];
		return wishlist[i];
	}

	//returns the first movie in the list
	public Movie firstMovie(){
		if (isEmpty()){
			return null;
		}
		else{
			return wishlist[0];
		}
	}

	//prints the title and ID of each of the movies in the list in the order they are in the list 
    public void printList(){
    	if (length == 0){
    		System.out.println("There are no movies in your wishlist.");
    	}
    	else{
    		for (int i = 0; i < length; i++){
    			if (wishlist[i] != null){
    				System.out.println(wishlist[i].getTitle());
    			}
    			else{
    				System.out.println("empty");
    			}
    		}
    	}
    }
}

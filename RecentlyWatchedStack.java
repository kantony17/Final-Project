/*
Andrew Stutzman
5-4-16
RecentlyWatchStack

This program creates a Stack in an array that allows a user to use the following functions:
-Create an empty stack
-Check if the stack is empty
-Return the most recently watched movie (top)
-Remove the most recently watched movie from the stack and return it (pop)
-Add a movie after having just finished watching it (push)
-Print out the RecentlyWatchedStack
*/

//Create class RecentlyWatchedStack
import java.io.*;

public class RecentlyWatchedStack implements java.io.Serializable{

	//create n to keep track of # of items in stack and head to keep track of top item in stack
	private int k;
	private Movie [] s;

	//create an empty stack
	//with array of size 100
	public RecentlyWatchedStack(){
		k = 0;
		s = new Movie[100];
	}

	//return if the stack is empty
	public boolean isEmpty(){
		return k == 0;
	}

	//return the most recently watched movie
	public Movie top(){
		return s[k-1];
	}

	//remove the most recently watched movie with it removed from the stack
	public Movie pop(){
		k--;
		return s[k];
	}

	//add a movie that you just finished watching
	public void push(Movie x){
		s[k] = x;
		k++;
	}

	//printRecentlyWatchedStack method for RecentlyWatchedStack
    public void printRecentlyWatchedStack() {
    	if (k != 0){
			for(int i = k-1; i >= 0; i--) {
			System.out.println(s[i].getTitle());
			}
		}
		else{
			System.out.println("You haven't watched any movies recently.\n");
		}
    }
}


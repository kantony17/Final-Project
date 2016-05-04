/*
Andrew Stutzman
5-4-16
RecentlyWatchStack

This program creates a Stack in a Linked List that allows a user to use the following functions:
-Create an empty stack
-Check if the stack is empty
-Return the most recently watched movie (top)
-Remove the most recently watched movie from the stack and return it (pop)
-Add a movie after having just finished watching it (push)
-Print out the RecentlyWatchedStack
*/

//Create class RecentlyWatchedStack

public class RecentlyWatchedStack{

	//create n to keep track of # of items in stack and head to keep track of top item in stack
	private int k;
	private Movie justWatched;

	//create an empty stack
	public RecentlyWatchedStack(){
		justWatched = null;
		k = 0;
	}

	//return if the stack is empty
	public boolean isEmpty(){
		return justWatched == null;
	}

	//return the most recently watched movie
	public Movie top(){
		return justWatched;
	}

	//remove the most recently watched movie with it removed from the stack
	public Movie pop(){
		Movie tempWatched = justWatched;
		//set justWatched to the next item in the list
		justWatched = justWatched.getNextS();
		//set the temp to null
		tempWatched.setNextS(null);
		k--;
		return tempWatched;
	}

	//add a movie that you just finished watching
	public void push(Movie x){
		//set justWatched pointer to be the newly added movie
		x.setNextS(justWatched);
		//set added movie to be the top item of the stack
		justWatched = x;
		k++;
	}

	//printRecentlyWatchedStack method for RecentlyWatchedStack
    public void printRecentlyWatchedStack() {
        System.out.println(k);
        Movie tempWatched = justWatched;
        while (tempWatched != null) {
            System.out.println(tempWatched.getTitle());
            tempWatched = tempWatched.getNextS();
        }
    }
}


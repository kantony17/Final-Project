/*MovieDatabase.java
Class MovieDatabase maintains all movies in 3 data structures (Hash table, BST, heap)
*/



import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MovieDatabase implements java.io.Serializable{

	//create hash table to access by ID number
	private MovieHashTable_ID moviesHash;

	//create BST to access by release date
	private MovieReleaseDateBST moviesBST;

	//create Heap to access by score
	private MovieTomatoScoreHeap moviesHeap;

	private int numMovies;

	private int idCounter;


	//Constuctor takes variables for a hash table, BST, and heap created elsewhere
	public MovieDatabase(MovieHashTable_ID moviesHash0, MovieReleaseDateBST moviesBST0, MovieTomatoScoreHeap moviesHeap0){

		moviesHash = moviesHash0;
		moviesBST = moviesBST0;
		moviesHeap = moviesHeap0;

		numMovies = 0; 

		idCounter = 10000;
	}

	//Adds movie to hash table, BST, and Heap
	public void centralAdd(){

		//calls makeMovie to get Admin input that creates a Movie
		Movie inMovie = makeMovie();
		//Hash table insertion
		moviesHash.insert(inMovie);
		//BST insertion
		moviesBST.insertMovie(inMovie);
		//Heap insertion
		moviesHeap.insertMHeap(inMovie);
		numMovies++;

		System.out.println(inMovie.getTitle() + " has been added to the database");
		if (numMovies > 1){
			System.out.println("The database now has " + numMovies + " movies.\n"); 
		}
		else{
			System.out.println("The database now has 1 movie.\n");
		}

	}

	//Returns Movie after taking user input to create movie
	private Movie makeMovie(){

		System.out.println("\n--------Movie input module--------");
		System.out.println("*Please enter the following items*\n");

		//Scanners to take in strings and integers
		Scanner scan = new Scanner(System.in);
		Scanner nums = new Scanner(System.in);
		
		System.out.print("Title: ");
		String title = scan.nextLine();

		System.out.println();
		System.out.print("Release Date (yearmonthday i.e. 19970322): ");

		int releaseDate = 0;

		//try catch block runs until user has entered a data integer in an appropriate range
		while(true){
			try{
				releaseDate = nums.nextInt();
				while ((releaseDate < 19000101) || (releaseDate > 20191231)){
					System.out.print("ERROR! Please enter release date as instructed by yearmonthday: ");
					releaseDate = nums.nextInt();
				}
				break;
				
			}
			catch (InputMismatchException youFuckedUp){
				System.out.print("ERROR! Please enter release date as instructed by yearmonthday: ");
				nums.next();
				continue;
			}
		}

		System.out.println();
		//movie id is created by increasing a general idCounter by 1
		int id = idCounter++;
		System.out.print("Rotten Tomato's Score (0-100): ");
		int tomatoScore = 0;

		//try catch block runs in a while loop until user enters an integer between 0 and 100 for tomato score
		while (true){
			try{
				tomatoScore = nums.nextInt();
				while ((tomatoScore < 0) || (tomatoScore > 100)){
					System.out.print("You must enter a number from 0-100. Try again: ");
					tomatoScore = nums.nextInt();
				}
				break;
			}
			catch (InputMismatchException dammit){
				System.out.print("You must enter a number from 0-100. Try again: ");
				nums.next();
				continue;
			}
		}

		System.out.println("\n----------------------------------");
		//creates instance of this movie, then returns the movie
		Movie myMovie = new Movie(title, releaseDate, tomatoScore, id);
		return myMovie;
	}

	//Method to delete movie from all databases. The only time that movies are deleted from all databases is 
	public void centralDelete(){
		Movie outMovie = moviesHeap.findLeastRatedMovie(); 
		outMovie.setLibraryStatus(false); //sets boolean flag in movie node to indicate that it is not in the databse

		//deletes in all three main databases
		moviesHash.delete(outMovie.getID());
		moviesBST.deleteMovie(outMovie);
		moviesHeap.deleteLeastRatedMovie();
		numMovies--;

		System.out.println(outMovie.getTitle() + " has been removed from the database");
		
		if (numMovies > 1){
			System.out.println("The database now has " + numMovies + " movies."); 
		}
		else{
			System.out.println("The database now has 1 movie.\n");
		}
	}
}
//movieDatabase.java



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

	public MovieDatabase(MovieHashTable_ID moviesHash0, MovieReleaseDateBST moviesBST0, MovieTomatoScoreHeap moviesHeap0){

		moviesHash = moviesHash0;
		moviesBST = moviesBST0;
		moviesHeap = moviesHeap0;

		numMovies = 0; 
	}

	//Adds movie to hash table, BST, and Heap
	public void centralAdd(){

		Movie inMovie = makeMovie();


		//Hash table
		moviesHash.insert(inMovie);

		//BST
		moviesBST.insertMovie(inMovie);

		//Heap

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

	private Movie makeMovie(){

		System.out.println("\n--------Movie input module--------");
		System.out.println("*Please enter the following items*\n");





		Scanner scan = new Scanner(System.in);
		Scanner nums = new Scanner(System.in);


		System.out.print("Title: ");
		String title = scan.nextLine();

		System.out.println();
		System.out.print("Release Date (yearmonthday i.e. 19970322): ");

		int releaseDate = 0;

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


		int id = numMovies + 10000;

		System.out.print("Rotten Tomato's Score (0-100): ");
		int tomatoScore = 0;


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

		Movie myMovie = new Movie(title, releaseDate, id, tomatoScore);

		return myMovie;

	}

	public void centralDelete(){
		Movie outMovie = moviesHeap.findLeastRatedMovie();
		moviesHash.delete(outMovie.getID());
		moviesBST.deleteMovie(outMovie);
		moviesHeap.deleteLeastRatedMovie();
		numMovies--;
		System.out.println("\n" + outMovie.getTitle() + " has been removed from the database");

		if (numMovies > 1){
			System.out.println("The database now has " + numMovies + " movies.\n"); 
		}
		else if (numMovies <= 0){
			System.out.println("The database now has 0 movies.\n");
		}
		else if (numMovies == 1){
			System.out.println("The database now has 1 movie.\n");
		}

	}
	

	/*public static void main(String[] args){
		movieDatabase myMovies = new movieDatabase();
		myMovies.centralAdd();
		myMovies.centralAdd();
		myMovies.centralDelete();
	}*/


}
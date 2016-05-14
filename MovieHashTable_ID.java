/*
MovieHashTable_ID.java

Uses a hash table to look up, insert, or delete movies by ID number

*/


public class MovieHashTable_ID implements java.io.Serializable{
	private Movie[] movies;
	private int maxMovies;
	private int numMovies;

	//constructor
	public MovieHashTable_ID(){
		maxMovies = 251; //max number of movies
		movies = new Movie[maxMovies]; //create the array for the hash table
		numMovies = 0; //initialize the nummovies at 0

	}
	//check if empty
	public boolean isEmpty(){
		return numMovies == 0;
	}

	//check if full
	public boolean isFull(){
		return numMovies == maxMovies;
	}

	//hash function 1
	public int hash1(int IDNum){
		return (IDNum%maxMovies);
	}

	//hash function 2
	public int hash2(int value, int IDNum){
		return ((value + (IDNum%239) + 1)%251);

	}
	
	//search
	public Movie lookUp(int IDNum){
		int counter = 0;
		int check = hash1(IDNum); //run through hash 1

		while ((movies[check] == null) || (movies[check].getID() != IDNum)){
			check = hash2(check,IDNum);
			counter++;
			if (counter > maxMovies){
				return null;
			}
		}
		return movies[check];
	}

	//delete using the ID number 
	public void delete(int IDNum){
		int counter = 0;
		int check = hash1(IDNum);
		while ((movies[check] == null) || (movies[check].getID() != IDNum)){
			check = hash2(check,IDNum);
		}

		movies[check] = null;
		numMovies--; //increment number of movies

	}


	public void insert(Movie inMovie){
		int counter = 0;
		int place = hash1(inMovie.getID());
		while ((counter < maxMovies) && (movies[place] != null)){
			place = hash2(place,inMovie.getID());
			counter++;	
		}

		//check to see if the hash is full
		if (isFull()){ //call isFull function
			System.out.println("Database is full; please make space in order to add " + inMovie.getTitle());
		}

		else{ //else, isnt full
			movies[place] = inMovie; //insert into hash
			numMovies++;//increase movie
		}

	}

}


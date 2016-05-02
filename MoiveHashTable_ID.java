/*
MovieHashTable_ID.java

Uses a hash table to look up, insert, or delete movies by ID number

*/


public class MovieHashTable_ID implements java.io.Serializable{
	private Movie[] movies;
	private int maxMovies;
	private int numMovies;

	public MovieHashTable_ID(){
		maxMovies = 251;
		movies = new Movie[maxMovies];
		numMovies = 0;

	}

	public boolean isEmpty(){
		return numMovies == 0;
	}


	public boolean isFull(){
		return numMovies == maxMovies;
	}

	public int hash1(int IDNum){
		return (IDNum%maxMovie);
	}

	public int hash2(int value, int IDNum){
		return ((value + (IDNum%239) + 1)%251);

	}
	
	public Moive lookUp(int IDNum){
		int counter = 0;
		int check = hash1(key);

		while ((movies[check] == null) || (movies[check].getKey() != key)){
			check = hash2(check,key);
			counter++;
			if (counter > maxMovies){
				return null;
			}
		}
		return movies[check];
	}

	public void delete(int IDNum){
		int counter = 0;
		int check = hash1(key);
		while ((movies[check] == null) || (movies[check].getKey() != key)){
			check = hash2(check,key);
		}

		movies[check] = null;
		numMovies--;

	}


	public void insert(Movie inMovie){
		int counter = 0;
		int place = hash1(inMovie.getKey());
		while ((counter < maxMovies) && (movies[place] != null)){
			place = hash2(place,inMovie.getKey());
			counter++;	
		}

		if (isFull()){
			System.out.println("Database is full; please make space in order to add " + inMovie.getName());
		}

		else{
			(counter < maxMovies)
			movies[place] = inMovie;
			numMovies++;
		}

	}

}

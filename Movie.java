/*
Andrew Stutzman
4-25-16
Movie class

This class creates a Movie node that holds the following information:
- Title of the movie (title)
- Release Date (date) [make sure to enter release date in yyyymmdd format]
- ID code (id)
- Whether or not the movie is in the library
- Pointer called next to link movies together
*/

public class Movie{

	//instance variables
	private String title;
	private int releaseDate;
	private int id;
	private int tomatoScore;
	private boolean haveMovie;
	private Movie next;

	//incoming variables can't have the same names as instance variables
	public Movie(String title0, int releaseDate0, int id0, int tomatoScore0, boolean haveMovie0, Movie next0){
		title = title0;
		releaseDate = releaseDate0;
		id = id0;
		tomatoScore = tomatoScore0;
		haveMovie = haveMovie0;
		next = next0;
	}

	//assume movie is in the library unless otherwise specified, set pointer to null
	public Movie(String title, int releaseDate, int id, int tomatoScore){
		this.title = title;
		this.releaseDate = releaseDate;
		this.id = id;
		this.tomatoScore = tomatoScore;
		haveMovie = true;
		next = null;
	}

	//returns the movie's title
	public String getTitle(){
		return title;
	}

	//sets the movie's title
	public void setTitle(String title0){
		title = title0;
	}

	//returns the movie's release date
	public int getRelease(){
		return releaseDate;
	}

	//sets the movie's release date
	public void setRelease(int releaseDate0){
		releaseDate = releaseDate0;
	}
	
	//returns the movie's ID number
	public int getID(){
		return id;
	}

	//sets the movie's ID number
	public void setID(int id0){
		id = id0;
	}

	//returns the movie's rotten tomato score
	public int getTomatoScore(){
		return tomatoScore;
	}

	//sets the movie's rotten tomato score
	public void setTomatoScore(int tomatoScore0){
		tomatoScore = tomatoScore0;
	}

	//returns true if the movie is in the library, false otherwise
	public boolean haveMovie(){
		return haveMovie;
	}

	//determine whether or not the movie is in the library
	public void setLibraryStatus(boolean haveMovie0){
		haveMovie = haveMovie0;
	}

	//returns the movie's pointer
	public Movie getNext(){
		return next;
	}
	
	//sets the movie's pointer
	public void setNext(Movie nextItem){
		next = nextItem;
	}

}
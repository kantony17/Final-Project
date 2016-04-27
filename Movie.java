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
- Right, Left, and Root pointers to use move Node in a BST
*/

public class Movie implements java.io.Serializable{

	//instance variables
	private String title;
	private int releaseDate;
	private int id;
	private int tomatoScore;
	private boolean haveMovie;
	private Movie nextM;
	private Movie rightM;
	private Movie leftM;
	private Movie rootM;

	//incoming variables can't have the same names as instance variables
	public Movie(String title0, int releaseDate0, int id0, int tomatoScore0, boolean haveMovie0, Movie nextM0, Movie rightM0, Movie leftM0, Movie rootM0){
		title = title0;
		releaseDate = releaseDate0;
		id = id0;
		tomatoScore = tomatoScore0;
		haveMovie = haveMovie0;
		nextM = nextM0;
		rightM = rightM0;
		leftM = leftM0;
		rootM = rootM0;
	}

	//assume movie is in the library unless otherwise specified, set pointer to null
	public Movie(String title, int releaseDate, int id, int tomatoScore){
		this.title = title;
		this.releaseDate = releaseDate;
		this.id = id;
		this.tomatoScore = tomatoScore;
		haveMovie = true;
		nextM = null;
		rightM = null;
		leftM = null;
		rootM = null;
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

	//returns the movie's next pointer
	public Movie getNextM(){
		return nextM;
	}
	
	//sets the movie's next pointer
	public void setNextM(Movie nextMItem){
		nextM = nextMItem;
	}

	//returns the movie's right pointer
	public Movie getRightM(){
		return rightM;
	}
	
	//sets the movie's right pointer
	public void setRightM(Movie rightMItem){
		rightM = rightMItem;
	}

	//returns the movie's left pointer
	public Movie getLeftM(){
		return leftM;
	}
	
	//sets the movie's left pointer
	public void setLeftM(Movie leftMItem){
		leftM = leftMItem;
	}

	//returns the movie's root pointer
	public Movie getRootM(){
		return rootM;
	}
	
	//sets the movie's root pointer
	public void setRootM(Movie rootMItem){
		rootM = rootMItem;
	}

}
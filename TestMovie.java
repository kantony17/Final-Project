public class TestMovie {
    public static void main(String[] args){
    	System.out.println();
    	System.out.println("This is code that will test the Movie Node.");
		System.out.println();
		Movie aMovie = new Movie("Captain America: Civil War", 20160506, 1, 97);
		Movie bMovie = new Movie("Deadpool", 20160212, 2, 83);
		System.out.println("The first movie is " + aMovie.getTitle());
		System.out.println("It was released: " + aMovie.getRelease());
		System.out.println("Its movie ID is " + aMovie.getID());
		System.out.println("Rotten Tomatos gives it a " + aMovie.getTomatoScore() + "%");
		System.out.println("In our movie library? " + aMovie.haveMovie());
		System.out.println();
		System.out.println("The first movie is " + bMovie.getTitle());
		System.out.println("It was released: " + bMovie.getRelease());
		System.out.println("Its movie ID is " + bMovie.getID());
		System.out.println("Rotten Tomatos gives it a " + bMovie.getTomatoScore() + "%");
		System.out.println("In our movie library? " + bMovie.haveMovie());
	}
}
public class TestMovieTomatoScoreHeap {
    public static void main(String[] args){
    	MovieTomatoScoreHeap a = new MovieTomatoScoreHeap();
    	System.out.println();
    	System.out.println("This is code that will test the MovieTomatoScoreHeap.");
		System.out.println();
		Movie aMovie = new Movie("Captain America: Civil War", 20160506, 10001, 97);
		Movie bMovie = new Movie("Deadpool", 20160212, 10002, 83);
		Movie cMovie = new Movie("Iron Man", 20080502, 10003, 94);
		Movie dMovie = new Movie("X-Men: Apocalypse", 20160527, 10004, 99);
		Movie eMovie = new Movie("Test 1", 20160214, 10005, 85);
		Movie fMovie = new Movie("Test 2", 20160213, 10006, 59);
		Movie gMovie = new Movie("Test 3", 20160215, 10007, 89);
		Movie hMovie = new Movie("Test 4", 20161010, 10008, 90);
		Movie iMovie = new Movie("Test 5", 20001010, 10009, 49);
		Movie jMovie = new Movie("Test 6", 20101010, 10010, 59);
		Movie kMovie = new Movie("Test 7", 20091010, 10011, 69);
		a.insertMHeap(aMovie);
		a.insertMHeap(bMovie);
		a.insertMHeap(cMovie);
		a.insertMHeap(dMovie);
		a.insertMHeap(eMovie);
		a.insertMHeap(fMovie);
		a.insertMHeap(gMovie);
		a.insertMHeap(hMovie);
		a.insertMHeap(iMovie);
		a.insertMHeap(jMovie);
		a.insertMHeap(kMovie);
		System.out.println("The least rated movie is "+ a.findLeastRatedMovie().getTitle() + " with a score of " +a.findLeastRatedMovie().getTomatoScore());
		a.printMHeap();
		a.deleteLeastRatedMovie();
		System.out.println();
		System.out.println("The least rated movie is "+ a.findLeastRatedMovie().getTitle() + " with a score of " +a.findLeastRatedMovie().getTomatoScore());
		a.printMHeap();
		a.deleteLeastRatedMovie();
		System.out.println();
		System.out.println("The least rated movie is "+ a.findLeastRatedMovie().getTitle() + " with a score of " +a.findLeastRatedMovie().getTomatoScore());
		a.printMHeap();
		a.deleteLeastRatedMovie();
		System.out.println();
		System.out.println("The least rated movie is "+ a.findLeastRatedMovie().getTitle() + " with a score of " +a.findLeastRatedMovie().getTomatoScore());
		a.printMHeap();
		a.deleteLeastRatedMovie();
		System.out.println();
	}
}
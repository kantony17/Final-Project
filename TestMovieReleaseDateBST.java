public class TestMovieReleaseDateBST {
    public static void main(String[] args){
    	MovieReleaseDateBST a = new MovieReleaseDateBST();
    	System.out.println();
    	System.out.println("This is code that will test the MovieReleaseDate BST.");
		System.out.println();
		Movie aMovie = new Movie("Captain America: Civil War", 20160506, 10001, 97);
		Movie bMovie = new Movie("Deadpool", 20160212, 10002, 83);
		Movie cMovie = new Movie("Iron Man", 20080502, 10003, 94);
		Movie dMovie = new Movie("X-Men: Apocalypse", 20160527, 10004, 99);
		Movie eMovie = new Movie("Test 1", 20160214, 10005, 85);
		Movie fMovie = new Movie("Test 2", 20160213, 10006, 88);
		Movie gMovie = new Movie("Test 3", 20160215, 10007, 89);
		Movie hMovie = new Movie("Test 4", 20161010, 10008, 90);
		Movie iMovie = new Movie("Test 5", 20001010, 10009, 49);
		Movie jMovie = new Movie("Test 6", 20101010, 10010, 59);
		Movie kMovie = new Movie("Test 7", 20091010, 10011, 69);
		a.insertMovie(aMovie);
		a.insertMovie(bMovie);
		a.insertMovie(cMovie);
		a.traverseMovieTree();
		a.printMovieTree();
		System.out.println();
		a.insertMovie(dMovie);
		a.insertMovie(eMovie);
		a.insertMovie(fMovie);
		a.insertMovie(gMovie);
		a.insertMovie(hMovie);
		a.insertMovie(iMovie);
		a.insertMovie(jMovie);
		a.insertMovie(kMovie);
		a.traverseMovieTree();
		a.printMovieTree();
		//Now need to test delete method
		
		//this tests deleting the root
		/*
		a.deleteMovie(aMovie);
		a.traverseMovieTree();
		a.printMovieTree();
		*/

		//test deleting movie with no children
		/*
		a.deleteMovie(hMovie);
		a.traverseMovieTree();
		a.printMovieTree();
		*/

		//test deleting movie with 1 child
		/*
		a.deleteMovie(cMovie);
		a.traverseMovieTree();
		a.printMovieTree();
		*/

		//test deleting movie in the tree with two children
		a.deleteMovie(bMovie);
		a.traverseMovieTree();
		a.printMovieTree();	
	}
}
public class TestWishList {
	public static void main(String[] args) {
		WishList w = new WishList();
		Movie aMovie = new Movie("Captain America: Civil War", 20160506, 10001, 97);
		Movie bMovie = new Movie("Deadpool", 20160212, 10002, 83);
		Movie cMovie = new Movie("The Jungle Book", 20160403, 10003, 94);
		Movie dMovie = new Movie("The Boss", 20160780, 10004, 19);
		Movie eMovie = new Movie("Iron Man", 20160920, 10005, 95);

		w.addNewMovie(aMovie);
		w.addNewMovie(bMovie);
		w.addNewMovie(cMovie);
		//w.addNewMovie(dMovie);
		//w.addNewMovie(eMovie);

		//System.out.println("This is the movie you are searching for:");
		//System.out.println(w.search(19));

		System.out.println("The following movies are in your list:");
		w.printList();

		//w.delete(83); //delete a movie

		//System.out.println("The following movies are in your list:");
		//w.printList();
	}
	
}

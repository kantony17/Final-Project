public class TestWishList {
	public static void main(String[] args) {
		WishList w = new WishList();
		Movie aMovie = new Movie("Captain America: Civil War", 20160506, 10001, 97);
		Movie bMovie = new Movie("Deadpool", 20160212, 10002, 83);
		Movie cMovie = new Movie("The Jungle Book", 20160403, 10003, 94);
		Movie dMovie = new Movie("The Boss", 20160780, 10004, 19);
		Movie eMovie = new Movie("Iron Man", 20160920, 10005, 95);
		Movie fMovie = new Movie("Aladdin", 19921125, 10050, 92);
		Movie gMovie = new Movie("Accepted", 20060818, 10059, 37);
		Movie hMovie = new Movie("Princess Bride", 19870925, 10049, 97);
		Movie iMovie = new Movie("21 Jump Street", 20120316, 10098, 85);
		Movie jMovie = new Movie("Love Actually", 20031106, 12390, 63);
		Movie kMovie = new Movie("Goon", 20110330, 50098, 82);
		Movie lMovie = new Movie("Without a Paddle", 20040820, 34859, 14);
		Movie mMovie = new Movie("Lord of the Rings: The Fellowship of the Ring", 20011219, 34859, 97);
		Movie nMovie = new Movie("The Hitchhiker's Guide to the Galaxy", 20050429, 24758, 60);
		Movie oMovie = new Movie("In Your Eyes", 20140420, 23984, 63);
		Movie pMovie = new Movie("Fight Club", 19990921, 93480, 79);
		Movie qMovie = new Movie("Pulp Fiction", 19941014, 39532, 94);
		Movie rMovie = new Movie("Memento", 20010316, 94573, 92);
		Movie sMovie = new Movie("Star Wars: A New Hope", 19970525, 19283, 94);
		Movie tMovie = new Movie("The Lost Boys", 19870731, 93457, 72);
		Movie uMovie = new Movie("Monty Python and the Holy Grail", 19750101, 93457, 97);

		//adds movies to the wishlist
		w.addNewMovie(aMovie);
		w.addNewMovie(bMovie);
		w.addNewMovie(cMovie);

		System.out.println("The following movies are in your list:");
		w.printList();

		w.addNewMovie(dMovie);
		w.addNewMovie(eMovie);
		w.addNewMovie(fMovie);

		//returns the first movie of wishlist 
		System.out.println("This is the first movie in your wish list: " + w.firstMovie().getTitle());

		System.out.println("The following movies are in your list: ");
		w.printList();

		//test prints for movies that are in the list
		System.out.println("This is the title of the movie you are searching for: " + w.search(10001).getTitle());
		System.out.println("This is the title of the movie you are searching for: " + w.search(10002).getTitle());
		System.out.println("This is the title of the movie you are searching for: " + w.search(10003).getTitle());
		System.out.println("This is the title of the movie you are searching for: " + w.search(10004).getTitle());
		System.out.println("This is the title of the movie you are searching for: " + w.search(10005).getTitle());


		//test print for movies that are not in the list
		System.out.println("This is the title of the movie you are searching for: " + w.search(10006));
		System.out.println("This is the title of the movie you are searching for: " + w.search(10089));

		w.delete(10003); 
		w.delete(10004);

		System.out.println("The following movies are in your list:");
		w.printList();

		w.delete(10002);
		w.delete(10001);

		System.out.println("The following movies are in your list:");
		w.printList();

		w.addNewMovie(gMovie);
		w.addNewMovie(hMovie);
		w.addNewMovie(iMovie);
		w.addNewMovie(jMovie);

		System.out.println("The following movies are in your list:");
		w.printList();

		/*w.addNewMovie(kMovie);
		w.addNewMovie(lMovie);
		w.addNewMovie(mMovie);
		w.addNewMovie(nMovie);
		w.addNewMovie(oMovie);
		w.addNewMovie(pMovie);
		w.addNewMovie(qMovie);
		w.addNewMovie(rMovie);
		w.addNewMovie(sMovie);
		w.addNewMovie(tMovie);
		w.addNewMovie(uMovie);
		w.addNewMovie(dMovie);
		w.addNewMovie(eMovie);
		w.addNewMovie(fMovie);
		w.addNewMovie(cMovie);


		System.out.println("The following movies are in your list:");
		w.printList(); */

		System.out.println("FINISH");
	}
	
}

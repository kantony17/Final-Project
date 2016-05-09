/*Main Menu
-the main menu implements scanners in order to distinguish between admins and customers
-customers have acess to edit their wishlists
-admins have options to acess and edit the movie database
*/


import java.util.Scanner;

public class MainMenu{

	//instance variables
	private String passwordA = "netflixAdmin";
	private String passwordC = "netflixCust";
	WishList wishlist = new WishList();
	MovieHashTable_ID movieHash = new MovieHashTable_ID();
	MovieTomatoScoreHeap movieHeap = new MovieTomatoScoreHeap();
	MovieReleaseDateBST movieBST = new MovieReleaseDateBST();
	//RecentlyWatchedStack movieStack = new RecentlyWatchedStack();

	//constructor 
	public MainMenu(){
		try{
			Scanner f = new Scanner(System.in);
			System.out.println("Please enter your username:  ");
			String username = f.next();
			if (username.equals("admin")){
				try{
					Scanner p = new Scanner(System.in);
					System.out.println("Please input your admin password:  ");
					String password = p.next();
					if (password == passwordA){
						try{
							Scanner t = new Scanner(System.in);
							System.out.println("1. Add a movie to the database. \n 2. View least-rated movie in the database. \n 3. View all movies in database(by order of release date). ");
							int adminInput = t.nextInt();
							if (adminInput == 1){
								//movieHeap.centralAdd();
							}
							
							else if (adminInput == 2){
								Movie temp = movieHeap.findLeastRatedMovie();
								try{
									Scanner l = new Scanner(System.in);
									System.out.println("Would you like to delete this movie from the database? Yes or No. ");
									String answer = l.next();
									if (answer.equals("Yes")){
										//movieHeap.centralDelete();
									}
									else if (answer.equals("No")){
										System.out.println("This movie will remain in the database.");
									}
								}
								catch(IllegalArgumentException l){
										System.out.println("You did not enter one of the choices. Choose Again");
										l.printStackTrace();
								}

							}
						
							else if (adminInput == 3){
								movieBST.printMovieTree();
							}
						}
						catch(IllegalArgumentException z){
							System.out.println("You did not enter one of the choices. Choose Again");
							z.printStackTrace(); 
						}
					}
				}
				catch(IllegalArgumentException a){
						System.out.println("You did not enter one of the choices. Choose Again");
						a.printStackTrace();
				}
			}
			else if (username.equals("customer")){
				try{
					Scanner o = new Scanner(System.in);
					System.out.println("Please input your customer password:  ");
					String password = o.next();
					if (password == passwordC){
						try{
							Scanner s = new Scanner(System.in);
							System.out.println("What would you like to do today? \n 1. Play a Movie \n 2. See movies in your wish list \n 3. Add a new movie to your wish list \n 4. Delete a movie from your wishlist \n 5. View your recently watched movies ");
							int userInput = s.nextInt();
							if (userInput == 1){
								wishlist.firstMovie();
								try{
									Scanner e = new Scanner(System.in);
									System.out.println("Would you like to delete this movie from the wishlist after you've seen it? Yes or No");
									String userInput5 = e.next();
									if (userInput5.equals("Yes")){
										wishlist.delete(wishlist.firstMovie().getID());
									}
									else if (userInput5.equals("No")){
										System.out.println("This movie will remain in your wish list.");;
									}
								}
								catch(IllegalArgumentException k){
									System.out.println("You did not enter one of the choices. Choose Again");
									k.printStackTrace();
								}
							}
							else if (userInput == 2){
								wishlist.printList();
							}
							else if (userInput == 3){
								Scanner n = new Scanner(System.in);
								System.out.println("Enter the ID of the movie you would like to add:   ");
								int userInput2 = n.nextInt();
								Movie movie = movieHash.lookUp(userInput2);
								wishlist.addNewMovie(movie);
							}
							else if (userInput == 4){
								Scanner d = new Scanner(System.in);
								System.out.println("Enter the ID of the movie you would like to delete:    ");
								int userInput3 = d.nextInt();
								wishlist.delete(userInput3);
							}
							else if (userInput ==5){
								//movieStack.printRecentlyWatchedStack();
							}
						}
						catch(IllegalArgumentException j){
							System.out.println("You did not enter one of the choices. Choose Again");
							j.printStackTrace(); 
						}
					}
				}
				catch(IllegalArgumentException u){
					System.out.println("You did not enter one of the choices. Choose Again");
					u.printStackTrace(); 
				}
			}
		}
		catch(IllegalArgumentException i){
			System.out.println("You did not enter one of the choices. Choose Again");
			i.printStackTrace(); 
		}
	}
}

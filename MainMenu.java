/*Main Menu
-the main menu implements scanners in order to distinguish between admins and customers
-customers have acess to edit their wishlists
-admins have options to acess and edit the movie database
*/

import java.io.*;
import java.util.Scanner;

public class MainMenu implements java.io.Serializable{

	//instance variables
	private String passwordA = "netflixAdmin";
	private String passwordC = "netflixCust";
	private String username;
	private String password;
	WishList wishlist = new WishList();
	MovieHashTable_ID moviesHash = new MovieHashTable_ID();
	MovieTomatoScoreHeap moviesHeap = new MovieTomatoScoreHeap();
	MovieReleaseDateBST moviesBST = new MovieReleaseDateBST();
	RecentlyWatchedStack moviesStack = new RecentlyWatchedStack();
	MovieDatabase moviesDatabase = new MovieDatabase(moviesHash, moviesBST, moviesHeap);
	CustomerDatabase customerDatabase = new CustomerDatabase();

	//constructor 
	public MainMenu(){
		/*
		//
		try{

		}
		//else serialize it
		else{

		}
			*/
		username = "";
		Boolean returningCust = false;
		//System.out.println("Test before while loop");
		while ((!(username.equals("admin"))) && (!(username.equals("1"))) && ((returningCust == false))){
			//System.out.println("test begining of while loop");
			Scanner f = new Scanner(System.in);
			System.out.println("\n-----------Welcome to NetFlix!-----------\nPlease Login Below\nAdmins and Returning Customers enter approriate username, or new Customers please press 1.");
			System.out.print("Username: ");
			username = f.next();
			username = username.replaceAll("\\s+",""); //removes white space and characters
			returningCust = customerDatabase.hasCustomer(username);
		}
		if (username.equals("admin")){
			password = "";
			while (!(password.equals(passwordA))){
				Scanner p = new Scanner(System.in);
				System.out.print("Password:  ");
				password = p.next();
			}
			if (password.equals(passwordA)){
				System.out.println("\nWelcome Admin!\n");
				int adminInput = 0;
				while (adminInput != 4){
					try{
						Scanner t = new Scanner(System.in);
						System.out.println("Please select an option from the list below (1-4) then press enter:\n1. Add a movie to the database.\n2. View least-rated movie in the database.\n3. View all movies in database(by order of release date).\n4. Pick this option to quit.\n");
						System.out.print("Option: ");
						adminInput = t.nextInt();

						if (adminInput == 1){ //add movie to the database
							moviesDatabase.centralAdd(); //central add makes sure it changes in all of the data structures 
						}
						else if (adminInput == 2){ //view least rated movie in the database
							Movie temp = moviesHeap.findLeastRatedMovie();
							if (temp == null){
								System.out.println("Sorry there are no movies in the database\n");
							}
							else{
								System.out.println("The least rated movie is:   ");
								System.out.println(temp.getTitle());

								String answer = "";
								while (!(answer.equals("yes")) && !(answer.equals("no"))){
									Scanner l = new Scanner(System.in); //give option to delete the least rated move
									System.out.println("Would you like to delete this movie from the database? Yes or No. ");
									answer = l.next().toLowerCase();
								}
								if (answer.equals("yes")){
									moviesDatabase.centralDelete();
								}
								else if (answer.equals("no")){
									System.out.println("This movie will remain in the database.\n");
								}
							}
						}
						else if (adminInput == 3){ //view all movies in the database
							System.out.println("The folowing movies are available for viewing in the database:\n");
							moviesBST.traverseMovieTree();
						}
					}
					catch(IllegalArgumentException z){
						System.out.println("You did not enter one of the choices. Choose Again");
						z.printStackTrace(); 
					}
				}	
			}
		}
		else if ((returningCust == true) || username.equals("1")){
			Scanner o = new Scanner(System.in);
			if (username.equals("1")){
				customerDatabase.addCustomer();
				System.out.println("Enter your new Username (email) to begin!   ");
				username = o.next();
			}

			System.out.print("Password:  ");
			password = o.next();
			System.out.println("password printed" + password);

			customerDatabase.printCustomers(); // TEST check to see if they exist in the database

			while ((customerDatabase.passwordMatch(username, password)) == false){
				if (customerDatabase.hasCustomer(username) == false);{
					System.out.println("doesnt exist :( ");	
				}

				System.out.println("Nice try... You're password is wrong. Why don't you enter a different password.");
				System.out.print("Password:  ");
				password = o.next();
				password = password.replaceAll("\\s+",""); //removes white space and characters
			}
			if (password.equals(passwordC)){
				System.out.println("\nWelcome Customer!\n");
				int userInput9 = 0;
				while (userInput9 != 6){

					Scanner s = new Scanner(System.in);
					System.out.println("What would you like to do today? Choose and option (1-6) and press enter.\n1. Play a Movie\n2. See movies in your wish list\n3. Add a new movie to your wish list\n4. Delete a movie from your wishlist\n5. View your recently watched movies\n6. Quit\n");
					System.out.print("Option: ");
					userInput9 = s.nextInt();

					if (userInput9 == 1){ //play first movie of wishlist
						Movie play = wishlist.firstMovie();
						System.out.println("You are now about to 'watch': " + play.getTitle());
						try{
							Scanner e = new Scanner(System.in); //give them the option to delete after watching
							System.out.println("Would you like to delete this movie from the wishlist after you've seen it? Yes or No");
							String userInput5 = e.next().toLowerCase();
							if (userInput5.equals("yes")){
								wishlist.delete(wishlist.firstMovie().getID());
							}
							else if (userInput5.equals("no")){
								System.out.println("This movie will remain in your wish list.");;
							}
						}
						catch(IllegalArgumentException k){
							System.out.println("You did not enter one of the choices. Choose Again");
							k.printStackTrace();
						}
					}
					else if (userInput9 == 2){ //print wishlist
						wishlist.printList();
					}
					else if (userInput9 == 3){ //add movie to wishlist
						Scanner n = new Scanner(System.in);
						System.out.println("Enter the ID of the movie you would like to add:   ");
						int userInput2 = n.nextInt();
						Movie movie = moviesHash.lookUp(userInput2);
						wishlist.addNewMovie(movie);
					}
					else if (userInput9 == 4){ //delete movie from wishlist
						Scanner d = new Scanner(System.in);
						System.out.println("Enter the ID of the movie you would like to delete:    ");
						int userInput3 = d.nextInt();
						wishlist.delete(userInput3);
					}
					else if (userInput9 == 5){ //print recently watched movies
						moviesStack.printRecentlyWatchedStack();
					}
					//6 quits the program, anything else prompts within options while loop
				}
			}
		}
	}	
}






/*Main Menu
-the main menu implements scanners in order to distinguish between admins and customers
-customers have acess to edit their wishlists
-admins have options to acess and edit the movie database
*/

//imports
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MainMenu implements java.io.Serializable{

	//instance variables
	private String passwordA = "netflixAdmin"; //hard code the admin password, but each customer will have their own
	private int username;
	private String password;
	//data structures, serialized below
	MovieHashTable_ID moviesHash;
	MovieTomatoScoreHeap moviesHeap;
	MovieReleaseDateBST moviesBST;
	RecentlyWatchedStack moviesStack;
	MovieDatabase moviesDatabase;
	CustomerDatabase customerDatabase; 

	//constructor 
	public MainMenu(){
	MainMenu aa = null;
		//begining of serealization
		moviesHash = new MovieHashTable_ID();
		moviesHeap = new MovieTomatoScoreHeap();
		moviesBST = new MovieReleaseDateBST();
		moviesDatabase = new MovieDatabase(moviesHash, moviesBST, moviesHeap);
		customerDatabase = new CustomerDatabase();

		File bigFile = new File("Data.ser"); //data file where information will be serialized
		if ((bigFile.exists()) && (!(bigFile.isDirectory()))){//check to see if file already exists
			try{
	        	FileInputStream fileIn1 = new FileInputStream("Data.ser");
	        	ObjectInputStream in = new ObjectInputStream(fileIn1);
	        	//wishlist = (WishList) in.readObject();
	        	moviesHash = (MovieHashTable_ID) in.readObject();
	        	moviesHeap = (MovieTomatoScoreHeap) in.readObject();
	        	moviesBST = (MovieReleaseDateBST) in.readObject();
	        	moviesDatabase = (MovieDatabase) in.readObject();
	        	customerDatabase = (CustomerDatabase) in.readObject();
	        	in.close();
	        	fileIn1.close();
	      	}
	      	catch(IOException i){
	        	i.printStackTrace();
	        	return;
	        }
	      	catch(ClassNotFoundException c){
	        	System.out.println("MainMenu class not found");
	        	c.printStackTrace();
	       		return;
	        }
	    }

        /* ------------------------------------------------------- */

		username = 0;
		Boolean returningCust = false; //start returning customer as false, so will enter while loop
		Scanner f = new Scanner(System.in); // scanner for main menu
		while(true){//to keep everything running on a loop
			try{
				while ((username != 1) && (username != 2) && ((returningCust == false))){ //while loop for
					System.out.println("\n-----------Welcome to NetFlix!-----------\nPlease Choose an option below\n1. Admins\n2. New Customers\nReturning Customers Enter your Username");
					System.out.print("Login: "); //propt for one of the above login options 
					username = f.nextInt();//get the user input
					returningCust = customerDatabase.hasCustomer(username);//check to see if they are a returning customer (if true will exit while loop)
					if ((username != 1) && (username != 2) && ((returningCust == false))){ //if none of the options
						System.out.println("\nPlease try again, that wasn't an option!\n"); //tell them they were wrong...try again
					}
				}
				break;
			}
			catch (InputMismatchException really){
				System.out.print("Your choice is not valid. Please input your login as instructed: ");
				f.next();
				continue;
			}
		}
		if (username == 1){ //option for if user is an admin
			password = "";//set the password to empty string so program will enter while loop
			while (!(password.equals(passwordA))){ //until the user input is the same as hard coded password 
				Scanner p = new Scanner(System.in);//scanner
				System.out.print("Password:  ");
				password = p.next();//get user input
				if(!(password.equals(passwordA))){ //if they arent right, prompt again (will print then stay in while loop)
					System.out.println("\nPlease try again, that wasn't right...\n");
				}
			}
			if (password.equals(passwordA)){ //after exits while loop-they are an admin
				System.out.println("\nWelcome Admin!\n");
				int adminInput = 0;
				Scanner t = new Scanner(System.in);
				while(true){
					try{
						while (adminInput != 4){ //while not quit
								System.out.println("Please select an option from the list below (1-4) then press enter:\n1. Add a movie to the database.\n2. View least-rated movie in the database.\n3. View all movies in database(by order of release date).\n4. Pick this option to quit.\n");
								System.out.print("Option: ");
								adminInput = t.nextInt(); //get user input

								if (adminInput == 1){ //add movie to the database
									moviesDatabase.centralAdd(); //central add makes sure it changes in all of the data structures 
								}
								else if (adminInput == 2){ //view least rated movie in the database
									Movie temp = moviesHeap.findLeastRatedMovie(); //data structure (heap) root is least rated
									if (temp == null){ //no movies available 
										System.out.println("\nSorry there are no movies in the database\n");
									}
									else{
										System.out.println("The least rated movie is:   ");
										System.out.println(temp.getTitle()); //get the title from temp which holds the current least rated movie

										String answer = "";
										while (!(answer.equals("yes")) && !(answer.equals("no"))){
											Scanner l = new Scanner(System.in); //give option to delete the least rated move
											System.out.println("Would you like to delete this movie from the database? Yes or No. ");
											answer = l.next().toLowerCase(); //always put the input to lowercase to check
											if (!(answer.equals("yes")) && !(answer.equals("no"))){
												System.out.println("That was neither 'yes' or 'no', why dont you try again...\n");
											}
										}
										if (answer.equals("yes")){
											moviesDatabase.centralDelete(); //delete the movie, central delete then deletes from all data structures
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
							break;
						}
					catch(InputMismatchException z){
						System.out.println("\nYou did not enter one of the choices. Choose Again\n");
						t.next(); 
						continue;
					}	
				}	
			}
		}
		else if ((returningCust == true) || (username == 2)){
			Scanner o = new Scanner(System.in);
			if (username == 2){
				customerDatabase.addCustomer();
				System.out.println("\nHello! Enter the  last four digits of your CCN to begin!   ");
				username = o.nextInt();
				while (!customerDatabase.hasCustomer(username)){
					System.out.println("Sorry! We dont have that CCN in our system, please try again:\n");
					username = o.nextInt();
				}
			}

			Scanner a = new Scanner(System.in);
			System.out.print("Password:  ");
			password = a.next();
			System.out.println("password printed: " + password); //TEST PRINT

			while ((customerDatabase.passwordMatch(username, password)) != true){
				System.out.println("Nice try... You're password is wrong. Why don't you enter a different password.");
				System.out.print("Password:  ");
				password = o.next();
				if ((customerDatabase.passwordMatch(username, password)) == false){
					System.out.println("\n Sorry that password doesnt match the CCN you entered, please try again\n");
				}
			}

			System.out.println("\nWelcome Customer!\n");
			
			int userInput9 = 0;
			while (userInput9 != 7){
				Scanner s = new Scanner(System.in);
				System.out.println("What would you like to do today? Choose and option (1-6) and press enter.\n1. Play a Movie\n2. See movies in your wish list\n3. Add a new movie to your wish list\n4. Delete a movie from your wishlist\n5. View your recently watched movies\n6. View all available movies\n7. Quit\n");
				System.out.print("Option: ");
				userInput9 = s.nextInt();

				if (userInput9 == 1){ //play first movie of wishlist
					
					if (! customerDatabase.findCustomerWishList(username).wishListEmpty()){
						Movie play = customerDatabase.findCustomerWishList(username).firstMovie();
						System.out.println("You are now about to 'watch': " + play.getTitle());
					
						try{
							Scanner e = new Scanner(System.in); //give them the option to delete after watching
							System.out.println("\nWould you like to delete this movie from the wishlist after you've seen it? Yes or No");
							String userInput5 = e.next().toLowerCase();
							if (userInput5.equals("yes")){ //user customer database to find the user with the given username, then delete from that wishlist
								customerDatabase.findCustomerWishList(username).delete(customerDatabase.findCustomerWishList(username).firstMovie().getID());
							}
							else if (userInput5.equals("no")){
								System.out.println("This movie will remain in your wish list.");;
							}
						}
						catch(IllegalArgumentException k){
							System.out.println("\nYou did not enter one of the choices. Choose Again\n");
							k.printStackTrace();
						}
					}
					else{
						System.out.println("\nSorry you have no movies in your wish list-try adding some!\n");
					}
				}
				else if (userInput9 == 2){ //print wishlist
					customerDatabase.findCustomerWishList(username).printList(); //use cusotmer databse to find the customer then print that specific wishlist
				}
				else if (userInput9 == 3){ //add movie to wishlist
					Scanner n = new Scanner(System.in);
					System.out.println("Enter the ID of the movie you would like to add:   ");
					int userInput2 = n.nextInt();
					Movie movie = moviesHash.lookUp(userInput2); //returns movie node to be added
					if (movie == null){
						System.out.println("\nSorry this movie isn't in our database.\n");
					}
					else{
						customerDatabase.findCustomerWishList(username).addNewMovie(movie);
					}
				}
				else if (userInput9 == 4){ //delete movie from wishlist
					Scanner d = new Scanner(System.in);
					System.out.println("Enter the ID of the movie you would like to delete:    ");
					int userInput3 = d.nextInt();
					Movie movieDeleter = customerDatabase.findCustomerWishList(username).search(userInput3); //returns movie node to be added
					if (movieDeleter == null){
						System.out.println("\nSorry this movie isn't in your wish list.\n");
					}
					else{
						customerDatabase.findCustomerWishList(username).delete(userInput3);
					}
				}
				else if (userInput9 == 5){ //print recently watched movies
					moviesStack.printRecentlyWatchedStack();
				}
				else if (userInput9 == 6){ //prints all avaliable movies
					System.out.println("The folowing movies are available for viewing in the database:\n");
					moviesBST.traverseMovieTree();
				}
				//7 quits the program, anything else prompts within options while loop
			}
		}
		//finish serialization
		try{
			FileOutputStream fileOut1 = 
			new FileOutputStream("Data.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut1);
			//out.writeObject(wishlist);
			out.writeObject(moviesHash);
			out.writeObject(moviesHeap);
			out.writeObject(moviesBST);
			out.writeObject(moviesDatabase);
			out.writeObject(customerDatabase);
			out.close();
			fileOut1.close();
			System.out.println("Serialized object successfully in Data.ser");
		}
		
		catch(IOException i){
			i.printStackTrace();
		}
	}	
}


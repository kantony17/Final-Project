/*Main Menu
-the main menu implements scanners in order to distinguish between admins and customers
-customers have acess to edit their wishlists
-admins have options to acess and edit the movie database
-THIS VERSION IS SERIALIZABLE...BUT NOT ACTUALLY THE FINAL CODE...
*/

import java.io.*;
import java.util.Scanner;

public class MainMenu implements java.io.Serializable{

	//instance variables
	private String passwordA = "netflixAdmin";
	private String passwordC = "netflixCust";
	private int username;
	private String password;
	private WishList wishlist;
	private MovieHashTable_ID moviesHash;
	private MovieTomatoScoreHeap moviesHeap;
	private MovieReleaseDateBST moviesBST;
	private RecentlyWatchedStack moviesStack;
	private MovieDatabase moviesDatabase;
	private CustomerDatabase customerDatabase;

	//constructor 
	public MainMenu(){
		MainMenu aa = null;
		
		wishlist = new WishList();
		moviesHash = new MovieHashTable_ID();
		moviesHeap = new MovieTomatoScoreHeap();
		moviesBST = new MovieReleaseDateBST();
		moviesStack = new RecentlyWatchedStack();
		moviesDatabase = new MovieDatabase(moviesHash, moviesBST, moviesHeap);
		customerDatabase = new CustomerDatabase();
		
		try{
        	FileInputStream fileIn1 = new FileInputStream("WishList.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn1);
        	wishlist = (WishList) in.readObject();
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

       	try{
        	FileInputStream fileIn2 = new FileInputStream("MovieHashTable_ID.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn2);
        	moviesHash = (MovieHashTable_ID) in.readObject();
        	in.close();
        	fileIn2.close();
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

        try{
        	FileInputStream fileIn3 = new FileInputStream("MovieTomatoScoreHeap.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn3);
        	moviesHeap = (MovieTomatoScoreHeap) in.readObject();
        	in.close();
        	fileIn3.close();
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

        try{
        	FileInputStream fileIn4 = new FileInputStream("MovieReleaseDateBST.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn4);
        	moviesBST = (MovieReleaseDateBST) in.readObject();
        	in.close();
        	fileIn4.close();
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
		
		try{
        	FileInputStream fileIn4 = new FileInputStream("MovieReleaseDateBST.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn4);
        	moviesBST = (MovieReleaseDateBST) in.readObject();
        	in.close();
        	fileIn4.close();
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

        try{
        	FileInputStream fileIn5 = new FileInputStream("RecentlyWatchedStack.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn5);
        	moviesStack = (RecentlyWatchedStack) in.readObject();
        	in.close();
        	fileIn5.close();
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
		
		try{
        	FileInputStream fileIn6 = new FileInputStream("MovieDatabase.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn6);
        	moviesDatabase = (MovieDatabase) in.readObject();
        	in.close();
        	fileIn6.close();
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

        try{
        	FileInputStream fileIn7 = new FileInputStream("CustomerDatabase.ser");
        	ObjectInputStream in = new ObjectInputStream(fileIn7);
        	customerDatabase = (CustomerDatabase) in.readObject();
        	in.close();
        	fileIn7.close();
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

		username = 0;
		Boolean returningCust = false;
		//System.out.println("Test before while loop");
		while ((username != 1) && (username != 2) && ((returningCust == false))){
			Scanner f = new Scanner(System.in);
			System.out.println("\n-----------Welcome to NetFlix!-----------\nPlease Login Below\nAdmins press 1 and Returning Customers enter last 4-digits of your CCN, and new Customers please press 2.");
			System.out.print("Login: ");
			username = f.nextInt();
			returningCust = customerDatabase.hasCustomer(username);
			if ((username != 1) && (username != 2) && ((returningCust == false))){
				System.out.println("\nPlease try again, that wasn't an option!\n");
			}
		}
		if (username == 1){
			password = "";
			while (!(password.equals(passwordA))){
				Scanner p = new Scanner(System.in);
				System.out.print("Password:  ");
				password = p.next();
				if(!(password.equals(passwordA))){
					System.out.println("\nPlease try again, that wasn't right...\n");
				}
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
								System.out.println("\nSorry there are no movies in the database\n");
							}
							else{
								System.out.println("The least rated movie is:   ");
								System.out.println(temp.getTitle());

								String answer = "";
								while (!(answer.equals("yes")) && !(answer.equals("no"))){
									Scanner l = new Scanner(System.in); //give option to delete the least rated move
									System.out.println("Would you like to delete this movie from the database? Yes or No. ");
									answer = l.next().toLowerCase();
									if (!(answer.equals("yes")) && !(answer.equals("no"))){
										System.out.println("That was neither 'yes' or 'no', why dont you try again...\n");
									}
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
		else if ((returningCust == true) || (username == 2)){
			Scanner o = new Scanner(System.in);
			if (username == 2){
				customerDatabase.addCustomer();
				System.out.println("Enter the  last four digits of your CCN to begin!   ");
				username = o.nextInt();
			}
			Scanner a = new Scanner(System.in);
			System.out.print("Password:  ");
			password = a.next();
			System.out.println("password printed" + password);

			while ((customerDatabase.passwordMatch(username, password)) == false){
				System.out.println("Nice try... You're password is wrong. Why don't you enter a different password.");
				System.out.print("Password:  ");
				password = o.next();
				if ((customerDatabase.passwordMatch(username, password)) == false){
					System.out.println("\n Sorry that password doesnt match the CCN you entered, please try again\n");
				}
			}

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

		try{
			FileOutputStream fileOut1 = 
			new FileOutputStream("WishList.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut1);
			out.writeObject(wishlist);
			out.close();
			fileOut1.close();
			System.out.println("Serialized object successfully in wishlist.ser");

		}
		catch(IOException i){
			i.printStackTrace();
		}
		
		try{
			FileOutputStream fileOut2 = 
			new FileOutputStream("MovieHashTable_ID.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut2);
			out.writeObject(moviesHash);
			out.close();
			fileOut2.close();
			System.out.println("Serialized object successfully in MoviesHashTable_ID.ser");

		}
		catch(IOException i){
			i.printStackTrace();
		}

		try{
			FileOutputStream fileOut3 = 
			new FileOutputStream("MovieTomatoScoreHeap.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut3);
			out.writeObject(moviesHeap);
			out.close();
			fileOut3.close();
			System.out.println("Serialized object successfully in MovieTomatoScoreHeap.ser");

		}
		catch(IOException i){
			i.printStackTrace();
		}

		try{
			FileOutputStream fileOut4 = 
			new FileOutputStream("MovieReleaseDateBST.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut4);
			out.writeObject(moviesBST);
			out.close();
			fileOut4.close();
			System.out.println("Serialized object successfully in MovieReleaseDateBST.ser");

		}
		catch(IOException i){
			i.printStackTrace();
		}

		try{
			FileOutputStream fileOut5 = 
			new FileOutputStream("RecentlyWatchedStack.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut5);
			out.writeObject(moviesStack);
			out.close();
			fileOut5.close();
			System.out.println("Serialized object successfully in RecentlyWatchedStack.ser");

		}
		catch(IOException i){
			i.printStackTrace();
		}

		try{
			FileOutputStream fileOut6 = 
			new FileOutputStream("MovieDatabase.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut6);
			out.writeObject(moviesDatabase);
			out.close();
			fileOut6.close();
			System.out.println("Serialized object successfully in MovieDatabase.ser");

		}
		catch(IOException i){
			i.printStackTrace();
		}

		try{
			FileOutputStream fileOut7 = 
			new FileOutputStream("customerDatabase.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut7);
			out.writeObject(customerDatabase);
			out.close();
			fileOut7.close();
			System.out.println("Serialized object successfully in customerDatabase.ser");

		}
		catch(IOException i){
			i.printStackTrace();
		}
	}	
}


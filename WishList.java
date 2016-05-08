//Wish List for Customers


import java.util.Scanner;

public class WishList{

	//instance variables
	private int length;
	private Movie head;
	private Movie end;
	private Movie temp;
	private Movie temp2;
	
	//constructor
	public WishList(){
		length = 0;
	}

	//add new movie in any location, O(n) runtime
	public void addNewMovie(Movie movie){
		Scanner u = new Scanner(System.in);
		System.out.println("How many movies would you like to add?");
		int number = u.nextInt();
		while (length < 20 && (length + number) < 20){
			try{
				for (int j = 0; j < number; j++) {
					Scanner s = new Scanner(System.in);
					System.out.println("Where would you like this movie to be added? \n A. Front \n B. End \n C. Other");
					String userInput = s.next();
					if (userInput.equals("A")){
						if (length == 0){
							head = movie;
							System.out.println("The movie you have added is the first movie of your wish list");
						}
						else{
							Movie temp = head.getNextM();
							head = movie;
							movie.setNextM(temp);
							System.out.println("The movie has been added to the front, but there are also other movies in your list");

						}
						length++;
					}
					else if (userInput == "B"){
						Movie temp = end;
						end = movie;
						temp.setNextM(movie);
						length++;
					}
					else if (userInput == "C"){
						Scanner x = new Scanner(System.in);
						System.out.println("Enter a number 1-20 where you'd like this movie to be played:  ");
						int userInput2 = x.nextInt();
						Movie temp = head;
						for (int i = 0; i < userInput2; i++){
							temp = temp.getNextM();
						}
						Movie temp2 = temp;
						temp.setNextM(movie);
						movie.setNextM(temp2.getNextM());
						length++;
					}
				}
			}
			catch(IllegalArgumentException i){
				System.out.println("You did not enter one of the choices. Choose Again");
				i.printStackTrace();
			}
		}
	}

	//searches for a movie in the list, returns the movie, O(n) runtime 
	//id is the five digit long number for each movie 
	public Movie search(int id){
		while (head.getNextM() != null && head.getNextM().getID() != id){
			head = head.getNextM();
		}
		return head;//returning the node before the one we're searching for
	}

	//deletes the node in the list and reorganizes the list, O(n) runtime 
	public void delete(int id){
		temp = search(id);
		temp.setNextM(temp.getNextM().getNextM());
		temp.getNextM().setNextM(null); 
	}

	//returns the first movie in the list
	public Movie firstMovie(){
		return head;
	}

	//prints the title and id of each of the movies in the list in the order they are in the list 
	public void printList(){
		Movie temp = head;
		System.out.println();
		for (int i = 0; i < length; i++){
			System.out.println(temp.getTitle() + "," + temp.getID());
			temp = temp.getNextM();
		}
	}

}

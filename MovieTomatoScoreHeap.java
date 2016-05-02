/*
Andrew Stutzman
5/2/16

This is a Heap class to store the movies in the data base in order of the lowest rated tomato score

Functions Include:
-Create an empty heap
-Check if the heap is empty (isEmptyMovieHeap)
-Check the number of movies in the heap (lengthMovieHeap)
-Insert an item into the heap(insertMHeap)
-Find the element with the lowest tomato score (findLeastRatedMovie)
-Delete the element with the lowest tomato sore (deleteLeastRatedMovie)
-Print out the heap in order (printMHeap)

Assume max size of 251.
*/

//Create class MovieTomatoScoreHeap

public class MovieTomatoScoreHeap implements java.io.Serializable{

	//variable n to keep track of the number of movies in the heap
	private int nMH;
	private Movie[] pq;

	//create an empty heap w/ array of size 251
	public MovieTomatoScoreHeap(){
		nMH = 0;
		pq = new Movie[251];		
	}

	//return if the heap is empty
	public boolean isEmptyMovieHeap(){
		return nMH == 0;
	}

	//return the number of movies in the heap
	public int lengthMovieHeap(){
		return nMH;
	}

	//insert a movie into the heap
	public void insertMHeap(Movie x){
		pq[nMH] = x;
		//check the newly added movies priority again its parent and adjust order if required
		nMH++;
		checkPriorityUp(nMH-1);
	}

	//check a child's priority against its parent. Swap the two if necessary
	private void checkPriorityUp(int x){
		if (pq[x].getTomatoScore() < pq[x/2].getTomatoScore()){
			swap(x,x/2);
			checkPriorityUp(x/2);
		}
	}

	//function to swap two elements
	private void swap(int x, int y){
		Movie temp = pq[x];
		pq[x] = pq[y];
		pq[y] = temp;
	}

	//returns the lowest rated movie in the database
	public Movie findLeastRatedMovie(){
		return pq[0];
	}

	//check a parent's priority against its child, swap the two if necessary
	private void checkPriorityDown(int x){
		//swap with left or right child if the child has higher priority than the parent
		int i = 0;
		while (2*i+1 < nMH-1 && 2*i+2 < nMH-1){
			//if the movie is ever at a lower tomato score than both its children, break the while loop
			if ((pq[x].getTomatoScore() < pq[2*i+1].getTomatoScore()) && (pq[x].getTomatoScore() < pq[2*i+2].getTomatoScore())){
				break;
			}
			//if current movie has a higher tomato score than left child and left child is small then right child, swap the two
			else if ((pq[x].getTomatoScore() > pq[2*i+1].getTomatoScore()) && (pq[2*i+1].getTomatoScore() < pq[2*i+2].getTomatoScore())){
				swap(x,2*i+1);
				x = 2*i+1;
			}
			//if currentmovie has a higher tomato score than right child and right child is smaller than left child, swap the two
			else if ((pq[x].getTomatoScore() > pq[2*i+2].getTomatoScore()) && (pq[2*i+1].getTomatoScore() > pq[2*i+2].getTomatoScore())){
				swap(x,2*i+2);
				x = 2*i+2;
			}
			//if doesn't fit any of these condictions break the loop
			else{
				break;
			}
			i++;
		}
	}

	//delete the lowest rated movie from the heap and update the new minimum
	public Movie deleteLeastRatedMovie(){
		if (nMH != 0){
			//call swap function to swap first and last item in the priority queue
			swap(0,nMH-1);
			checkPriorityDown(0);
			nMH--;
			//if n = 2 check the two elements and make sure the lowest priority item is first
			if (nMH == 2){
				if (pq[0].getTomatoScore() > pq[1].getTomatoScore()) {
					swap(0,1);
				}
			}
			return pq[nMH];
		}
		else{
			System.out.println("Sorry, there are no items left in the priority queue to delete.");
		}
		return null;
	}

	//print out the whole movie heap
	public void printMHeap(){
		int i = 0;
		//go through n indices
		while(i <= (nMH-1)){
			System.out.println(pq[i].getTomatoScore() + " " + pq[i].getTitle());
			i++;
		}
	}
}


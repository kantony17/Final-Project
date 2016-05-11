/*
Andrew Stutzman 
4/27/16

This is a BST class to store the movies in the data base ordered by their respective
release dates.

Functions Include:
-Create the tree ordering movies by release date
-Check if the tree is empty
-Insert a movie into the tree
-Search for a movie given the movie's release date
-Delete a movie from the tree
-Use the traverse function to print out the tree in order of release date
*/

public class MovieReleaseDateBST implements java.io.Serializable{

	//create a pointer to use to navigate the BST
	//also a variable n to keep track of the number of items in the tree (max of 255)
	private Movie rightM;
	private Movie leftM;
	private Movie rootM;
	private int nM;

	public MovieReleaseDateBST(){
		rightM = null;
		leftM = null;
		rootM = null;
		nM = 0;
	}

	//return if Movie BST is empty
	public boolean isEmptyMovieTree(){
		return rootM == null;
	}

	// insert a movie into the BST
	public void insertMovie(Movie x){
		//if empty movie tree, add the first movie to the root of the tree
		if (rootM == null){
			rootM = x;
		}
		//if more than 1 item in the movie tree, use insert2 function
		else{
			insertMovie2(x,rootM);
		}
	}

	//insert a node into movie BST of 1 or more items
	private void insertMovie2(Movie x, Movie p){
		//if added movie has a most recent release date than the root, either compare to left child or set as left child
		if (x.getRelease() > p.getRelease()){
			//if left movie child is empty, set Movie x to be the child
			if(p.getLeftM() == null){
				p.setLeftM(x);
			}
			//if left movie child is full, run insert2 again on that child
			else{
				insertMovie2(x,p.getLeftM());
			}
		}
		//if added movie has an older release date than the root, either compare to right child or set as right child
		else{
			//if right movie child is empty, set Movie x to be the child
			if (p.getRightM() == null){
				p.setRightM(x);
			}
			//if right movie child is full, run insert2 again on that child
			else{
				insertMovie2(x,p.getRightM());
			}
		}			

	}

	//call search2
	public Movie search(int releaseDate){
		return search2(rootM,releaseDate);
	}

	//searches through movie BST and returns the movie if it is found in the tree
	private Movie search2(Movie x, int releaseDate){
		//if the movie is not in the tree, return null
		if (x == null){
			return null;
		}
		//if the currently compared movie's release date is the same as the called release date then return the Movie
		else if (releaseDate == x.getRelease()){
			return x;
		}
		//if the currently compared movie's release date is less than called release date, then search the left branch
		else if (releaseDate < x.getRelease()){		
			return search2(x.getLeftM(),releaseDate);
		}
		//if the currently compared movie's release date is greater than called release date, then search the right branch
		else{
			return search2(x.getRightM(),releaseDate);
		}
	}

	//delete a movie from the tree and update the tree
	public void deleteMovie(Movie x){
		//parent of the node to be deleted initially set to null
		Movie parent = null;
		//initially check to see if the root is the movie that needs to be deleted
		if(x == rootM){
			deleteMovieRoot(x);
		}
		else{
			//if item to be deleted is not the root, find the parent of the movie to be deleted
			parent = findParent(x);
			deleteMovie2(x,parent);
		}
	}

	//delete the root of tree
	private void deleteMovieRoot(Movie x){
		Movie temp = rootM;
		//if root has no children, set the root of the tree to be null
		if(temp.getLeftM() == null && temp.getRightM() == null){
			rootM = null;
		}
		//if root has 1 child
		else if(temp.getLeftM() == null || temp.getRightM() == null){
			//check to see if the child of the root is the left or right
			if(rootM.getRightM() == null){
				rootM = rootM.getLeftM();
			}
			//if child is right set it to be the new root
			else{
				rootM = rootM.getRightM();
			}
		}
		//if root has 2 children
		else{
			//right once, and left most movie
			temp = temp.getRightM();
			//left most movie
			while(temp.getLeftM() != null){
				temp = temp.getLeftM();
			}
			//set variable of find temps parent
			Movie tempParent = findParent(temp);
			//check if there's stuff on the right of left most movie
			//find the parent of temp and set the parents left movie to temps right stuff
			if (temp.getRightM() != null){
				//if parent is not the root then set left
				if (rootM != tempParent){
					tempParent.setLeftM(temp.getRightM());
				}
				//otherwise the parent is the root, so set it be the right
				else {
					tempParent.setRightM(temp.getRightM());
				}
			}
			//set stuff on left and right of root to be the left and right of temp
			tempParent.setLeftM(null);
			temp.setLeftM(rootM.getLeftM());
			temp.setRightM(rootM.getRightM());
			//set the temp to be the new root
			rootM = temp;
		}
	}

	//function to find the parent of a movie that we want to delete
	//we already know that the movie has a parent
	private Movie findParent(Movie x){
		//Movie parent = null;
		Movie temp = rootM;
		//while temp left and temp right not what im looking for, keep going through the loop
		// to find the parent of the movie
		while(temp.getLeftM() != x && temp.getRightM() != x){
			//check to the right
			if(temp.getRelease() > x.getRelease()){
				temp = temp.getRightM();
			}
			//check to the left
			else{
				temp = temp.getLeftM();
			}
		}
		return temp;
	}

	//function to determine if the child of a parent is either the left or right
	//boolean of True means left, boolean of False means right.
	private boolean isLeft(Movie x){
		//initially say that the child is the left child, and check to see if it is or not
		boolean childLeft = true;
		//if the parent of the child has left child, set childPosition to true
		if (findParent(x).getLeftM() == x){
			childLeft = true;
		}
		//otherwise the parent of the child must have a right child
		else{
			childLeft = false;
		}
		return childLeft;
	}

	//deletes a movie from the tree and updates the tree
	private void deleteMovie2(Movie x, Movie parent){
		//need to search through tree and keep track of current parent and the child
		//like search function
		Movie temp = x;
		//3 cases, 0 children, 1 child, 2 children

		//0 children, set the parent to point to null
		if (temp.getLeftM() == null && temp.getRightM() == null){
			if (parent.getLeftM() == temp){
				parent.setLeftM(null);
			}
			else{
				parent.setRightM(null);
			}
		}

		//1 child, set the child of x to be the left or right child of the parent of x
		else if (temp.getLeftM() == null || temp.getRightM() == null){
			//if the parents left child is the movie being deleted, have the parent
			// point to its grandchild
			if (parent.getLeftM() == temp){
				if (temp.getRightM() == null){
					//set left of parent = left child of temp
					parent.setLeftM(temp.getLeftM());
				}
				//else the child is on the right side of temp
				else{
					//set right child of temp to parent.getLeft
					parent.setLeftM(temp.getRightM());
				}
			}
			//if the parents right child is the movie being delted, have the parent
			// point to its grandchild
			else{
				//if the parents right child is the movie being deleted, have the parent
				// point to its grandchild
				if (temp.getRightM() == null){
					//set left parent = left child of temp
					parent.setRightM(temp.getLeftM());
				}
				//else the child is on the right side of temp
				else{
					//set right child of temp to parent.getRight
					parent.setRightM(temp.getRightM());
				}
			}
			//set the deleted movie to point to null
			temp = null;
		}

		//2 children
		else{
			//go right one and left as possbile, 
			//that left most movie now replaces the movie being deleted
			//update all the pointers
			//determine if the temp that's being deleted is the left or right child of its parent
			//temp is the left child of the parent
			if(parent.getLeftM() == temp){
				//go to the movie to be deleted's right child
				Movie rightOnce = temp.getRightM();
				//now go to the left most movie from that right child
				Movie leftUntilNull = rightOnce;
				while(leftUntilNull.getLeftM() != null){
					leftUntilNull = leftUntilNull.getLeftM();
				}
				//most left movie has been found, set it to be the left child of parent
				if (leftUntilNull.getRightM() == null){
					parent.setLeftM(leftUntilNull);
					leftUntilNull.setLeftM(temp.getLeftM());
					//set temp to null
				}
				//otherwise there is something hanging off of it
				else{
					Movie moviesToTheRight = findParent(leftUntilNull);
					moviesToTheRight.setRightM(leftUntilNull.getRightM());
					parent.setRightM(leftUntilNull);
					leftUntilNull.setLeftM(temp.getLeftM());
					leftUntilNull.setRightM(rightOnce);
				}
				temp = null;
			}

			//otherwise temp must be the right child of the parent
			//go left one and right as possible,
			//that right most movie now replaces the movie being deleted
			//update all the pointers
			else{
				//go to the movie to be deleted's right child
				Movie rightOnce = temp.getRightM();
				//now go to the left most movie from that right child
				Movie leftUntilNull = rightOnce;
				while(leftUntilNull.getLeftM() != null){
					leftUntilNull = leftUntilNull.getLeftM();
				}
				//most left movie has been found, set it to be the left child of parent
				if (leftUntilNull.getRightM() == null){
					parent.setRightM(leftUntilNull);
					leftUntilNull.setLeftM(temp.getLeftM());
					//set temp to null
				}
				//otherwise there is something hanging off of it
				else{
					Movie moviesToTheRight = findParent(leftUntilNull);
					moviesToTheRight.setLeftM(leftUntilNull.getRightM());
					parent.setRightM(leftUntilNull);
					leftUntilNull.setLeftM(temp.getLeftM());
					leftUntilNull.setRightM(rightOnce);
				}
				temp = null;
			}
		}
	}

	//call traverse2 with root
	public void traverseMovieTree(){
		System.out.println("ID Number   Release Date    Title");
		traverseMovieTree2(rootM);
		System.out.println();
	}

	//print out all of the movies in the tree in order of release date
	private void traverseMovieTree2(Movie x){
		if (x != null){
			traverseMovieTree2(x.getLeftM());
			System.out.println(x.getID() + "\t\t" + x.getRelease() + "\t" + x.getTitle());
			traverseMovieTree2(x.getRightM());
		}
	}


	//_________________________________________________________________________________
	//this part helps with making sure the tree is ordering correctly

	//printMovieTree method for movie BST
    public void printMovieTree() {
		printMovieTree2(rootM);
		System.out.println();
    }

    private void printMovieTree2(Movie mTree) {
		if (mTree != null) {
	    	System.out.print(mTree.getRelease() + " ");
            	if (mTree.getLeftM() != null)
	        		System.out.print("Left: " + mTree.getLeftM().getRelease() + " ");
            	else
                	System.out.print("Left: null ");
            	if (mTree.getRightM() != null)
	        		System.out.println("Right: " + mTree.getRightM().getRelease() + " ");
            	else
                	System.out.println("Right: null ");
	    	printMovieTree2(mTree.getLeftM());
	    	printMovieTree2(mTree.getRightM());
	    }
    }

}
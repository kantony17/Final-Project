# Final-Project
######*Presentation on: May 12th, 2016.*
######*Due on: May 16th, 2016 by 5pm.*

## Synopsis:
This program was designed for Connecticut College’s Computer Science 212: Data Structures. 
The ultimate goal of the program is to create a database of movies that registered users could manipulate in their wish lists, 
adding in different orders, deleting and ‘watching’.  When running the program, users can either login as 
‘administrators’ who can edit the entire movie database, ‘customers’ who can edit their own personal wishlist (up to twenty movies) 
but also view all movies from the main database, or ‘new customers’ who can register in the customer database with their name, email, 
credit card number, and create a password to login in the future. 

## Test:
Test this code by running the main function, NetFlix.java. 
This file calls on MainMenu.java which depending on user input accesses the other data structures in the file. 

## Files and Data Structures:
The following are the files and subsequent data strucutres used in order to run the main method NetFlix.java. All classes are serializable. 
#####Customer.java
This file is the specific customer node. It can set and return a customers name, credit card number and the password that they create. Each customer is created as their own node.  
#####Movie.java
This file is the specific movie node. It can set and return a movies title, ID number, rotten tomato rating score and whether or not is is available. Each movie is create as its own node, which is then stored in a variety of different data structures. 
#####WishList.java
This file contains the methods specific to the functions a cusotmer can perform on their wish lists. The wish lists are created in an array so customers can access ('play') the next movie in O(1) run time, as well as add, delete and view all the movies in O(n) runtime. 
#####CustomerDatabase.java
This file is a database made from a hash table which implements double hashing in order to store all of the customer nodes. The database is called on from the main menu when returning customers are trying to login, in order to check if the usermane they enter matches with the password they created. 
#####MovieDatabase.java
This file is the main hash data structure that is called to add and delete movie nodes. It subsequently does a 'central' add and delete, which ensures that the movie nodes are deleted not only from this particular data structure but also from the ID hash table, release date BST, and rating score heap (see below). 
#####MovieHashTable_ID.java
Each movie node is given an ID number in order to place it in the hash table present in this file which can be used to lookup, add and delete movie nodes by their given ID's. 
#####MovieReleaseDateBST.java
This file contains a binary search tree data structure that is used to store the movie nodes from the database in order of their release dates. Release dates are inputted in as 8 digit numbers representing the year month and day (YYYYMMDD). The binary search tree is able to see if the database is empty, insert any new movies that were added to the main database into the tree, search for a given release date and delete a movie from the tree when called from the central delete function. There is also a print function that both administrators and customers call in order to view all available movies, in order of release date. 
#####MovieTomatoScoreHeap.java
Each movie is given a rotten tomato rating score, and in this file and heap data structure orders the movie nodes from the main movie database in order of the lowest rated movie. When the admin views the least rated movie, they are given the option to delete it, which deletes the root of the head and then rebalances the tree. This is the only way that movies can be deleted from the movie database. 
#####RecentlyWatchedStack.java
This file keeps track of customers most recently watched movies, by using a stack in an array. Each time a user acesses ('plays') their first movie it is pushed onto this stack. That way the most recently watched movie is at the top. Even if a user doesn't delete the movie from their wish list it will still be added to the stack. 
#####UserManual.pdf
This is just a pdf file that contains instructions for a user, it walks through the interface but leaves out the code behind the process. 
## Contributors:
Sarah Carley '18, Kaavya Antony '19, Alex Klavans '19, and Andrew Stutzman '17 of Connecticut College

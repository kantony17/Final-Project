public class TestRecentlyWatchedStack {
    public static void main(String[] args){
	RecentlyWatchedStack a = new RecentlyWatchedStack();
	Movie aMovie = new Movie("Captain America: Civil War", 20160506, 10001, 97);
	Movie bMovie = new Movie("Deadpool", 20160212, 10002, 83);
	Movie cMovie = new Movie("Iron Man", 20080502, 10003, 94);
	Movie dMovie = new Movie("X-Men: Apocalypse", 20160527, 10004, 99);
	a.push(aMovie);
	a.push(bMovie);
	a.push(cMovie);
	a.push(dMovie);
	a.printRecentlyWatchedStack();
	System.out.println();
	System.out.println(a.top().getTitle());
	System.out.println();
	a.printRecentlyWatchedStack();
	System.out.println();
	System.out.println(a.pop().getTitle());
	System.out.println();
	a.printRecentlyWatchedStack();
	System.out.println();
	while(!a.isEmpty()) {
	    System.out.println(a.pop().getTitle());
	    System.out.println();
	}
    	a.printRecentlyWatchedStack();
	System.out.println();
    }
}

import java.util.Scanner;

public class MediaLib {
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in); 
        
        Song song2 = new Song("Title2", 7, 0.99, false);
        Song song3 = new Song("Title3", 9, 1.29, true);
        Song song4 = new Song("Title4", 6, 1.19, false);
        Song song5 = new Song("Title5", 10, 0.99, true);
        Song song6 = new Song("Title6", 8, 1.09, false);
        
        //testing
        System.out.print("Enter song name: "); 
        String title = input.next();
        System.out.print("Enter rating (1-10): "); 
        int rating = input.nextInt(); 
        System.out.print("Enter price (.99 - 1.29): "); 
        double price = input.nextInt(); 
        System.out.print("Favorite? "); 
        String ans = input.next(); 
        boolean favorite;
        if (ans.equalsIgnoreCase("Y")){
             favorite = true; 
        }else{
             favorite = false; 
        }
        Song song1 = new Song(title, rating, price, favorite);
        //
        
        Movie movie1 = new Movie("Inception", 9, 148);
        Movie movie2 = new Movie("Matrix", 10, 120);
        Book book1 = new Book("Book 1", 8);
        Book book2 = new Book("Book 2", 9);
        double totalCost; 
        int numSongs = 6, totalRatings; 
        totalCost = song1.getPrice()+song2.getPrice()+song3.getPrice()+song4.getPrice()+ 
                    song5.getPrice()+song6.getPrice();
        totalRatings = (song1.getRating() + song2.getRating() + song3.getRating() +
                       song4.getRating() + song5.getRating() + song6.getRating());
        System.out.println(song1.toString());
        System.out.println();
        System.out.println(song2.toString());
        System.out.println();
        System.out.println(song3.toString());
        System.out.println();
        System.out.println(song4.toString());
        System.out.println();
        System.out.println(song5.toString());
        System.out.println();
        System.out.println(song6.toString());
        System.out.println();
        System.out.println("Number of songs: " + numSongs); 
        System.out.println("Total Cost of Songs: $" + totalCost);
        System.out.println("Average Cost of Songs: " + totalCost/numSongs); 
        System.out.println("Total Ratings: " + totalRatings);
        System.out.println("Average Ratings: " + totalRatings/numSongs);
        System.out.println();
        System.out.println(movie1.toString());
        System.out.println();
        System.out.println(movie2.toString());
        System.out.println();
        System.out.println(book1.toString());
        System.out.println();
        System.out.println(book2.toString());         
        System.out.println();
        
        input.close();
    }   
}



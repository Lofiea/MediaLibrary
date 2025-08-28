// MediaLib.java
import java.util.*;

public class MediaLib {
    // Collections
    private static final List<Song> songs = new ArrayList<>();
    private static final List<Movie> movies = new ArrayList<>();
    private static final List<Book> books = new ArrayList<>();

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        seedDemoData();
        System.out.println("Welcome to MediaLibrary!");
        boolean running = true;
        while (running) {
            switch (mainMenu()) {
                case 1 -> songMenu();
                case 2 -> movieMenu();
                case 3 -> bookMenu();
                case 0 -> { running = false; System.out.println("Goodbye!"); }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // MAIN MENU 
    private static int mainMenu() {
        System.out.println("""
                
                =========== MAIN ===========
                1) Songs
                2) Movies
                3) Books
                0) Exit
                ============================
                """);

        return promptInt("Choose an option: ", 0, 3);
    }

    //  SONGS 
    private static void songMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    
                    --- SONGS ---
                    1) Add a Song
                    2) List Songs
                    3) Search Songs by Title
                    4) Delete a Song
                    5) Sort Songs (Title/Rating/Price)
                    6) Song Stats
                    0) Back
                    """);

            switch (promptInt("Choose: ", 0, 6)) {
                case 1 -> addSong();
                case 2 -> listSongs();
                case 3 -> searchSongs();
                case 4 -> deleteSong();
                case 5 -> sortSongs();
                case 6 -> showSongStats();
                case 0 -> back = true;
            }
        }
    }

    private static void addSong() {
        System.out.println("\nAdd a new song:");
        String title = promptString("Title: ");
        int rating = promptInt("Rating (1-10): ", 1, 10);
        double price = promptDouble("Price (0.99 - 1.29): ", 0.99, 1.29);
        boolean favorite = promptYesNo("Favorite (Y/N): ");
        songs.add(new Song(title, rating, price, favorite));
        System.out.println(" Added: " + title);
    }

    private static void listSongs() {
        if (songs.isEmpty()) { System.out.println("\nNo songs yet. Add one!"); return; }
        System.out.println("\nAll songs:");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println("[" + i + "]\n" + songs.get(i) + "\n");
        }
    }

    private static void searchSongs() {
        if (songs.isEmpty()) { System.out.println("\nNo songs to search."); return; }
        String q = promptString("\nSearch title contains: ").toLowerCase();
        boolean any = false;
        for (Song s : songs) {
            if (s.getTitle().toLowerCase().contains(q)) {
                System.out.println(s + "\n");
                any = true;
            }
        }
        if (!any) System.out.println("No matches.");
    }

    private static void deleteSong() {
        if (songs.isEmpty()) { System.out.println("\nNo songs to delete."); return; }
        listSongs();
        int idx = promptInt("Enter index to delete: ", 0, songs.size() - 1);
        Song removed = songs.remove(idx);
        System.out.println("Removed: " + removed.getTitle());
    }

    private static void sortSongs() {
        if (songs.isEmpty()) { System.out.println("\nNo songs to sort."); return; }
        System.out.println("""
                
                Sort by:
                1) Title (A→Z)
                2) Rating (High→Low)
                3) Price (Low→High)
                """);
        int choice = promptInt("Choose: ", 1, 3);
        switch (choice) {
            case 1 -> songs.sort(Comparator.comparing(Song::getTitle, String.CASE_INSENSITIVE_ORDER));
            case 2 -> songs.sort(Comparator.comparingInt(Song::getRating).reversed());
            case 3 -> songs.sort(Comparator.comparingDouble(Song::getPrice));
        }
        System.out.println("Sorted.");
        listSongs();
    }

    private static void showSongStats() {
        if (songs.isEmpty()) { System.out.println("\nNo songs for stats."); return; }
        int count = songs.size();
        int totalRating = 0;
        double totalPrice = 0.0;
        Song top = songs.get(0);
        long favorites = 0;

        for (Song s : songs) {
            totalRating += s.getRating();
            totalPrice += s.getPrice();
            if (s.getRating() > top.getRating()) top = s;
            if (s.getFavorite()) favorites++;
        }
        double avgRating = (double) totalRating / count;
        double avgPrice = totalPrice / count;

        System.out.printf("""
                
                --- Song Stats ---
                Count: %d
                Total Price: $%.2f
                Avg Price: $%.2f
                Avg Rating: %.2f
                Favorites: %d
                Top Rated: %s (%d/10)
                
                """, count, totalPrice, avgPrice, avgRating, favorites, top.getTitle(), top.getRating());
    }

    // MOVIES 
    private static void movieMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    
                    --- MOVIES ---
                    1) Add a Movie
                    2) List Movies
                    3) Search Movies by Title
                    4) Delete a Movie
                    5) Sort Movies (Title/Rating/Duration)
                    6) Movie Stats
                    0) Back
                    """);

            switch (promptInt("Choose: ", 0, 6)) {
                case 1 -> addMovie();
                case 2 -> listMovies();
                case 3 -> searchMovies();
                case 4 -> deleteMovie();
                case 5 -> sortMovies();
                case 6 -> showMovieStats();
                case 0 -> back = true;
            }
        }
    }

    private static void addMovie() {
        System.out.println("\nAdd a new movie:");
        String title = promptString("Title: ");
        int rating = promptInt("Rating (1-10): ", 1, 10);
        int duration = promptInt("Duration in minutes (e.g., 120): ", 1, 10000);
        movies.add(new Movie(title, rating, duration));
        System.out.println("Added: " + title);
    }

    private static void listMovies() {
        if (movies.isEmpty()) { System.out.println("\nNo movies yet. Add one!"); return; }
        System.out.println("\nAll movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("[" + i + "]\n" + movies.get(i) + "\n");
        }
    }

    private static void searchMovies() {
        if (movies.isEmpty()) { System.out.println("\nNo movies to search."); return; }
        String q = promptString("\nSearch title contains: ").toLowerCase();
        boolean any = false;
        for (Movie m : movies) {
            if (m.getTitle().toLowerCase().contains(q)) {
                System.out.println(m + "\n");
                any = true;
            }
        }
        if (!any) System.out.println("No matches.");
    }

    private static void deleteMovie() {
        if (movies.isEmpty()) { System.out.println("\nNo movies to delete."); return; }
        listMovies();
        int idx = promptInt("Enter index to delete: ", 0, movies.size() - 1);
        Movie removed = movies.remove(idx);
        System.out.println("Removed: " + removed.getTitle());
    }

    private static void sortMovies() {
        if (movies.isEmpty()) { System.out.println("\nNo movies to sort."); return; }
        System.out.println("""
                
                Sort by:
                1) Title (A→Z)
                2) Rating (High→Low)
                3) Duration (Short→Long)
                """);

        int choice = promptInt("Choose: ", 1, 3);
        switch (choice) {
            case 1 -> movies.sort(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER));
            case 2 -> movies.sort(Comparator.comparingInt(Movie::getRating).reversed());
            case 3 -> movies.sort(Comparator.comparingInt(MediaLib::getDurationMinutesOf)); // requires getter
        }
        System.out.println("Sorted.");
        listMovies();
    }

    private static void showMovieStats() {
        if (movies.isEmpty()) { System.out.println("\nNo movies for stats."); return; }
        int count = movies.size();
        int totalRating = 0;
        int totalMinutes = 0;
        Movie top = movies.get(0);
        Movie longest = movies.get(0);

        for (Movie m : movies) {
            totalRating += m.getRating();
            int mins = getDurationMinutesOf(m);
            totalMinutes += mins;
            if (m.getRating() > top.getRating()) top = m;
            if (mins > getDurationMinutesOf(longest)) longest = m;
        }
        double avgRating = (double) totalRating / count;
        double avgMinutes = (double) totalMinutes / count;

        System.out.printf("""
                
                --- Movie Stats ---
                Count: %d
                Avg Rating: %.2f
                Avg Duration: %s
                Top Rated: %s (%d/10)
                Longest: %s (%s)
                
                """, count, avgRating, formatDuration((int)Math.round(avgMinutes)),
                top.getTitle(), top.getRating(),
                longest.getTitle(), formatDuration(getDurationMinutesOf(longest)));
    }

    // helper to access minutes
    private static int getDurationMinutesOf(Movie m) {
        return Integer.parseInt(m.getDuration());
    }

    private static String formatDuration(int minutes) {
        int h = minutes / 60;
        int min = minutes % 60;
        return h + " hours " + min + " minutes";
    }

    // BOOKS 
    private static void bookMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    
                    --- BOOKS ---
                    1) Add a Book
                    2) List Books
                    3) Search Books by Title
                    4) Delete a Book
                    5) Sort Books (Title/Rating)
                    6) Book Stats
                    0) Back
                    """);
            switch (promptInt("Choose: ", 0, 6)) {
                case 1 -> addBook();
                case 2 -> listBooks();
                case 3 -> searchBooks();
                case 4 -> deleteBook();
                case 5 -> sortBooks();
                case 6 -> showBookStats();
                case 0 -> back = true;
            }
        }
    }

    private static void addBook() {
        System.out.println("\nAdd a new book:");
        String title = promptString("Title: ");
        int rating = promptInt("Rating (1-10): ", 1, 10);
        books.add(new Book(title, rating));
        System.out.println("Added: " + title);
    }

    private static void listBooks() {
        if (books.isEmpty()) { System.out.println("\nNo books yet. Add one!"); return; }
        System.out.println("\nAll books:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("[" + i + "]\n" + books.get(i) + "\n");
        }
    }

    private static void searchBooks() {
        if (books.isEmpty()) { System.out.println("\nNo books to search."); return; }
        String q = promptString("\nSearch title contains: ").toLowerCase();
        boolean any = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(q)) {
                System.out.println(b + "\n");
                any = true;
            }
        }
        if (!any) System.out.println("No matches.");
    }

    private static void deleteBook() {
        if (books.isEmpty()) { System.out.println("\nNo books to delete."); return; }
        listBooks();
        int idx = promptInt("Enter index to delete: ", 0, books.size() - 1);
        Book removed = books.remove(idx);
        System.out.println("Removed: " + removed.getTitle());
    }

    private static void sortBooks() {
        if (books.isEmpty()) { System.out.println("\nNo books to sort."); return; }
        System.out.println("""
                
                Sort by:
                1) Title (A→Z)
                2) Rating (High→Low)
                """);
        int choice = promptInt("Choose: ", 1, 2);
        switch (choice) {
            case 1 -> books.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
            case 2 -> books.sort(Comparator.comparingInt(Book::getRating).reversed());
        }
        System.out.println("Sorted.");
        listBooks();
    }

    private static void showBookStats() {
        if (books.isEmpty()) { System.out.println("\nNo books for stats."); return; }
        int count = books.size();
        int totalRating = 0;
        Book top = books.get(0);

        for (Book b : books) {
            totalRating += b.getRating();
            if (b.getRating() > top.getRating()) top = b;
        }
        double avgRating = (double) totalRating / count;

        System.out.printf("""
                
                --- Book Stats ---
                Count: %d
                Avg Rating: %.2f
                Top Rated: %s (%d/10)
                
                """, count, avgRating, top.getTitle(), top.getRating());
    }

    // INPUT HELPERS 
    private static String promptString(String msg) {
        System.out.print(msg);
        String line = in.nextLine().trim();
        while (line.isEmpty()) {
            System.out.print("Please enter a non-empty value: ");
            line = in.nextLine().trim();
        }
        return line;
    }

    private static int promptInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String s = in.nextLine().trim();
            try {
                int val = Integer.parseInt(s);
                if (val < min || val > max) {
                    System.out.printf("Enter a value between %d and %d.%n", min, max);
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double promptDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            String s = in.nextLine().trim();
            try {
                double val = Double.parseDouble(s);
                if (val < min || val > max) {
                    System.out.printf("Enter a value between %.2f and %.2f.%n", min, max);
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number (e.g., 1.09).");
            }
        }
    }

    private static boolean promptYesNo(String msg) {
        while (true) {
            System.out.print(msg);
            String s = in.nextLine().trim();
            if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("Yes")) return true;
            if (s.equalsIgnoreCase("N") || s.equalsIgnoreCase("No")) return false;
            System.out.println("Please enter Y or N.");
        }
    }

    // SEED DATA 
    private static void seedDemoData() {
        // Songs
        songs.add(new Song("Title2", 7, 0.99, false));
        songs.add(new Song("Title3", 9, 1.29, true));
        songs.add(new Song("Title4", 6, 1.19, false));
        
        // Movies
        movies.add(new Movie("Inception", 9, 148));
        movies.add(new Movie("The Matrix", 10, 120));
        movies.add(new Movie("Spirited Away", 9, 125));
        
        // Books
        books.add(new Book("Clean Code", 9));
        books.add(new Book("The Pragmatic Programmer", 10));
        books.add(new Book("Effective Java", 9));
    }
}

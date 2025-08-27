public class Book {
    private String title;
    private int rating;
    
    public Book()
    {
        title = "";
        rating = 0;
    }
    public Book(String t, int r)
    {
        title = t;
        rating = r;
    }
    public Book(Book b)
    {
        title = b.title;
        rating = b.rating;
    }    
    public void setTitle(String t)
    {
        title = t;
    }
    public void setRating(int r)
    {
        rating = r;
    }
    public String getTitle()
    {
        return title;
    }
    public int getRating()
    {
        return rating;
    } 
    public String toString() {
        String str;
        str = "Title:    " + title  + "\n" +
              "Rating:  " + rating;
              return str;
    }
}

public class Song {
    private String title;
    private int rating;
    private double price;
    private boolean favorite;
    
    public Song()
    {
        title = "";
        rating = 0;
        price = 0;
        favorite = true; 
    }
    public Song(String t, int r, double p, boolean fav)
    {
        title = t;
        rating = r;
        price = p;
        favorite = fav;
    }
    public Song(Song s)
    {
        title = s.title;
        rating = s.rating;
        price = s.price;
        favorite = s.favorite;
    }    
    public void setTitle(String t)
    {
        title = t;
    }
    public void setRating(int r)
    {
        rating = r;
    }
    public void setPrice(double p)
    {
        price = p;
    }
    public void setFavorite(boolean f)
    {
        favorite = f;
    }
    public String getTitle()
    {
        return title;
    }
    public int getRating()
    {
        return rating;
    }
    public double getPrice()
    {
        return price;
    }
    public boolean getFavorite()
    {
        return favorite;
    }    
    public String toString() {
        String str;
        str = "Title:    " + title  + "\n" +
              "Rating:  " + rating + "\n" +
              "Price: $ " + price + "\n" +
              "Favorite:  " + favorite;
              return str;
    }
}

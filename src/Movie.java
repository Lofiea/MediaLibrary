public class Movie {
    private String title;
    private int rating;
    private int duration;
    
    public Movie()
    {
        title = "";
        rating = 0;
        duration = 0;
    }
    public Movie(String t, int r, int d)
    {
        title = t;
        rating = r;
        duration = d;
    }
    public Movie(Movie m)
    {
        title = m.title;
        rating = m.rating;
        duration = m.duration;
    }    
    public void setTitle(String t)
    {
        title = t;
    }
    public void setRating(int r)
    {
        rating = r;
    }
    public void setDuration(int d)
    {
        duration = d;
    }
    public String getTitle()
    {
        return title;
    }
    public int getRating()
    {
        return rating;
    }
    public String getDuration()
    {
        int hours = duration/60; 
        int mins = duration % 60; 
        return hours + " hours " + mins + " minutes ";
    } 
    public String toString() {
        String str;
        str = "Title:    " + title  + "\n" +
              "Rating:  " + rating + "\n" +
              "Duration: " + getDuration();
              return str;
    }
}


/**
 * This is just the song class with the song names and its duration
 */
public class Song {
    private String song_title;
    private double song_duration;
    public Song(String song_title,double song_duration){
        this.song_duration=song_duration;
        this.song_title=song_title;
    }
    public String getSong_title(){
        return this.song_title;
    }

    @Override
    public String toString() {
        return ("The song " +song_title +" is of duration "+ song_duration);

    }
}



import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is the album class which has some of the feature like the regular album
 * I am adding songs, finding if the songs is in the album, creating the playlists and adding the songs
 * This all power is used in the main method as you can see.
 */
public class Album {
    private String artist_name;
    private String album_title;
    private ArrayList<Song> songs;
    public Album(String artist_name, String album_title){
        this.artist_name=artist_name;
        this.album_title=album_title;
        this.songs= new ArrayList<Song>();
    }
    public boolean addsongs(String name, double duration){
        Song add_song = new Song(name,duration);
        if(findsong(add_song)== false){
            this.songs.add(add_song);
            return true;
        }
        return false;
    }
    public boolean findsong(Song song){
        for(int i=0;i<this.songs.size();i++){
            if(this.songs.get(i) ==song){
                return true;
            }
        }
        return false;
    }


    public boolean addtoplaylist(String name, LinkedList<Song> playlist){
        for (int i=0;i<this.songs.size();i++){
            if(this.songs.get(i).getSong_title()==name){
                playlist.add(this.songs.get(i));
                return true;
            }
        }
        System.out.println("The song is not in the album");
        return false;
    }


}

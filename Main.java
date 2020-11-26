
import java.util.*;
/**
// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()
*/


public class Main {

    public static void main(String[] args) {
        ArrayList<Album> albums= new ArrayList<>();
        /**
        First, I am creating bunch of albums inside an arraylists with the songs and their durations.
         */

        Album album= new Album("Ajal","Its me");
        album.addsongs("Hello World",4.5);
        album.addsongs("Hello Earth",4.8);
        album.addsongs("Hello Moon",2.65);
        album.addsongs("Hello Jupiter",6.8);
        album.addsongs("Hello Neptune",5.8);
        album.addsongs("Hello Pluto",4.1);
        album.addsongs("Hello Venus",4.0);
        album.addsongs("Hello Mercury",1.8);
        albums.add(album);

        album= new Album("You","Its you");
        album.addsongs("Hello you World",4.5);
        album.addsongs("Hello you Earth",4.8);
        album.addsongs("Hello you Moon",4.8);
        album.addsongs("Hello you Jupiter",4.8);
        album.addsongs("Hello you Neptune",4.8);
        album.addsongs("Hello you Pluto",4.8);
        album.addsongs("Hello you Venus",4.8);
        album.addsongs("Hello you Mercury",4.8);
        albums.add(album);

        /**
         * Here I am working with one of the albums and creating a playlist based on the songs on that album
         */
        LinkedList<Song> playList= new LinkedList<Song>();
        albums.get(0).addtoplaylist("Hello World",playList);
        albums.get(0).addtoplaylist("Hello Moon",playList);
        albums.get(0).addtoplaylist("Hello Venus",playList);

        /**
         * Here I am giving some of the feature to my playlists like playing the song, going to the next song, going to the previos song,
         * removing the song, listing the playlist and quitting the playlist.
         */
        boolean quit=true;
        ListIterator<Song> listIterator= playList.listIterator();
        while(true){
            System.out.println("Select from the options 1.playlist,2.play_next,3.play_previous,4.print all songs in playlists, 5.remove that song,6. quit");
            Scanner scanner= new Scanner(System.in);
            int scan=scanner.nextInt();
            if (scan==1){
                if(playList.size()==0){
                    System.out.println("No songs in the playlist");
                    return;
                } else {
                    System.out.println("Now playing " + listIterator.next().toString());
                    if(scan ==1){
                        listIterator.previous();
                    }
                }
            }
            else if (scan==2){
                if(listIterator.hasNext()){

                    System.out.println("Next playing " + listIterator.next().toString());

                }
                else{
                    System.out.println("End of the list.");
                    break;
                }
            }
            else if(scan==3){
                if(listIterator.hasPrevious()){
                    listIterator.previous();
                    System.out.println("Previous playing " + listIterator.previous().toString());
                }
                else{
                    System.out.println("Starting of the list");
                }
            }
            else if(scan==4){
                ListIterator<Song> listIterator1= playList.listIterator();
                while(listIterator1.hasNext()){
                    System.out.println(listIterator1.next());
                }
            }
            else if(scan==5){
                listIterator.remove();
                System.out.println("The recent song has been removed");
                if(listIterator.hasNext()){
                    System.out.println("Now playing "+listIterator.next());
                }else if(listIterator.hasPrevious()){
                    System.out.println("Now playing "+ listIterator.previous());
                }else{
                    System.out.println("Nothing is left in the playlist. Everything is deleted");
                    break;
                }
            }
            else{
                System.exit(0);
            }
        }

    }

}

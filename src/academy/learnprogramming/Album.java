package academy.learnprogramming;



import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private final String nameOfAlbum;
    private final String artist;
    private ArrayList<Song> songsOnAlbum;

    public Album (String artist, String nameOfAlbum){
        this.artist = artist;
        this.nameOfAlbum = nameOfAlbum;
        songsOnAlbum = new ArrayList<>();
    }

    public void printSongs (){
        System.out.println("\n");
        for (int i = 0; i < songsOnAlbum.size(); i++){
            System.out.println(songsOnAlbum.get(i).getTitleOfSong());
        }
    }

    public void addSongToAlbum (String titleOfSong, double durationOfSong){
        if(findSong(titleOfSong) == null){
            songsOnAlbum.add(Song.createSong(titleOfSong, durationOfSong));
        }
    }
    public Song findSong (String titleOfSong){
        for (Song toBeChecked: this.songsOnAlbum){
            if(toBeChecked.getTitleOfSong().equals(titleOfSong)){
                return toBeChecked;
            }
        }
        return null;
    }
    public void addToPlaylist (int trackNumber, LinkedList<Song> playlist){
        int indexOfSong = trackNumber-1;
        if((indexOfSong >= 0) && (indexOfSong <= this.songsOnAlbum.size())){
            playlist.add(this.songsOnAlbum.get(indexOfSong));
        } else {
            System.out.println("No such track");
        }
    }
    public void addToPlaylist (String nameOfSong, LinkedList<Song> playlist){
        Song checkedSong = findSong(nameOfSong);
        if (checkedSong != null){
            playlist.add(checkedSong);
        } else {
            System.out.println("No such track");
        }
    }

}

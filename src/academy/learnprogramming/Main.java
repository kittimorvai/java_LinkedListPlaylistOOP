package academy.learnprogramming;

import java.util.*;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album1 = new Album("Artist1", "Album1");
        Album album2 = new Album("Artist2", "Album2");

        album1.addSongToAlbum("Song1", 3.21);
        album1.addSongToAlbum("Song2", 2.45);
        album1.addSongToAlbum("Song3", 2.65);
        album1.addSongToAlbum("Song4", 3.10);
        albums.add(album1);

        album2.addSongToAlbum("Song5", 3.50);
        album2.addSongToAlbum("Song6", 2.67);
        album2.addSongToAlbum("Song7", 3.50);
        albums.add(album2);

//        album1.printSongs();
//        album2.printSongs();

        LinkedList<Song> playlist = new LinkedList<>();
        album2.addToPlaylist("Song6", playlist);
        album2.addToPlaylist("Song7", playlist);
        album1.addToPlaylist("Song3", playlist);

        listeningToPlaylist(playlist);


    }
    public static void listeningToPlaylist (LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.isEmpty()){
            System.out.println("No tracks in the playlist");
            return;
        } else {
            printMenu();
        }

        while (!quit){
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 0:
                    System.out.println("Quitting playlist.");
                    quit = true;
                    goingForward = false;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now listening to " + listIterator.next().toString());
                    } else {
                        System.out.println("You have reached the end of the playlist.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now listening to " + listIterator.previous().toString());
                    } else {
                        System.out.println("You are at the first track.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                case 4:
                    printPlaylist(playlist);
                    break;
                case 5:
                    //replay
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            goingForward = true;
                        }
                    } else {
                        if(goingForward){
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing " + listIterator.previous().toString());
                                goingForward = false;
                            }
                        }
                    }
                    break;
                case 6:
                    //remove current song
                    if(playlist.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
    public static void printMenu (){
        System.out.println("Available actions:\n");
        System.out.println("0 - quit playlist\n" +
                "1 - next track\n" +
                "2 - previous track\n" +
                "3 - print menu\n" +
                "4 - print playlist\n" +
                "5 - replay\n" +
                "6 - remove current song from playlist");
    }
    public static void printPlaylist(LinkedList<Song> playlist){

        for (Song song : playlist) {
            System.out.println(song);
        }
    }



}

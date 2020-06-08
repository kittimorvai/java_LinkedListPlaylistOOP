package academy.learnprogramming;

public class Song {
    private final String titleOfSong;
    private final double durationOfSong;

    public Song(String titleOfSong, double durationOfSong){
        this.titleOfSong = titleOfSong;
        this.durationOfSong = durationOfSong;
    }

    public String getTitleOfSong() {
        return titleOfSong;
    }

    public static Song createSong (String titleOfSong, double durationOfSong){
        return new Song (titleOfSong, durationOfSong);
    }

    @Override
    public String toString() {
        return this.titleOfSong + " - " + this.durationOfSong;
    }
}

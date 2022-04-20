package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    @Autowired
    private SongMapper songMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData() {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(song1.getId());
            System.out.println(song3.toString());

            // my stuff
            myMyBatis();

        };
    }

    private void myMyBatis() {
        Song song3 = createSong("Le Onde", "Islands",
                        "Ludovicio Enaudi", 250);
        Song song4 = createSong("We don't talk about Bruni", "Encanto soundtrack",
                "Disney", 312);
        Song song5 = createSong("Let it go", "Frozen",
                "Disney", 274);

        // Create
        songMapper.insertNewSong(song3);
        songMapper.insertNewSong(song4);
        songMapper.insertNewSong(song5);

        // Read
        print(songMapper.getSongsByName("Le Onde"));
        print(songMapper.getSongsByAlbumAndArtist("Ludovicio Enaudi", "Islands"));
        print(songMapper.getSongsByArtist("Disney"));
        print(songMapper.getSongsBySongLength(274));

        // Update
        song3.setAlbum_name("Essential Ennaudi");
        songMapper.updateSong(song3);
        print(songMapper.getSongById(song3.getId()));

        // Delete
        songMapper.deleteSongById(song3.getId());
        songMapper.deleteSongsByAlbumAndArtist("Disney", "Encanto soundtrack");
        songMapper.deleteSongsBySongLength(274);
        songMapper.deleteSongs();
    }

    private void print(ArrayList<Song> songs) {
        System.out.println();
        System.out.println("******************");
        songs.forEach(System.out::println);
    }

    private void print(Song song) {
        System.out.println();
        System.out.println("******************");
        System.out.println(song);
    }

    private Song createSong(String name, String albumName, String artistName, int songLength) {
        Song song = new Song();
        song.setName(name);
        song.setAlbum_name(albumName);
        song.setArtist_name(artistName);
        song.setSong_length(songLength);
        return song;
    }
}

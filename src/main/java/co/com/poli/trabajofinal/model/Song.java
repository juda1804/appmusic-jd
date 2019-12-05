package co.com.poli.trabajofinal.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="song")
public class Song implements Serializable {


    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long song_id;

    @Getter
    @Setter
    private String title;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="playlist_id")
    private PlayList playList;

    @Getter
    @Setter
    private String artist;

    @Getter
    @Setter
    private String albun;

    @Getter
    @Setter
    private String year;

    public Song() {
    }

    public Song(String title, PlayList playList, String artist, String albun, String year) {
        this.title = title;
        this.playList = playList;
        this.artist = artist;
        this.albun = albun;
        this.year = year;
    }
}

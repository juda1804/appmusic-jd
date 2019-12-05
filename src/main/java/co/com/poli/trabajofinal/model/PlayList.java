package co.com.poli.trabajofinal.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "play_list")
public class PlayList extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="playlist_id")
    @Id
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @OneToMany( mappedBy="playList", cascade=CascadeType.ALL)
    private List<Song> songs;

    public PlayList() {
    }

    public PlayList(String name, String description, List<Song> songs) {
        this.name = name;
        this.description = description;
        this.songs = songs;
    }
}

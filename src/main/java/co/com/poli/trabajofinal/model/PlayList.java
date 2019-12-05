package co.com.poli.trabajofinal.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "play_list")
public class PlayList implements Serializable {

    @Getter
    @Setter
    @Column(name="name_id")
    @Id
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @OneToMany( mappedBy ="playList", cascade = CascadeType.ALL)
    private Set<Song> songs;

    public PlayList() {
    }
}

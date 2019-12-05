package co.com.poli.trabajofinal.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@EqualsAndHashCode(exclude = "playList")
@Table(name="song")
public class Song implements Serializable {


    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="name_id")
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
}

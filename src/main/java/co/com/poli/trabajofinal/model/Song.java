package co.com.poli.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Song implements Serializable {


    private static final long serialVersionUID = 1L;

    private String title;
    private String artist;
    private String album;
    private String year;
}

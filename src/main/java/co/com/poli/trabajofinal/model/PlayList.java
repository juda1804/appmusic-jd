package co.com.poli.trabajofinal.model;


import lombok.Data;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name ="play_list")
public class PlayList extends Auditable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    private String name;

    private String description;

    @Lob
    @Type(type ="serializable")
    private List<Song> songs;

}

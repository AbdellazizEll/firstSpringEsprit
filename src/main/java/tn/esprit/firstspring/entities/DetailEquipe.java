package tn.esprit.firstspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailEquipe;
    private int salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="idEquipe",referencedColumnName = "idEquipe" )
    @JsonIgnore
    private  Equipe equipe;
}

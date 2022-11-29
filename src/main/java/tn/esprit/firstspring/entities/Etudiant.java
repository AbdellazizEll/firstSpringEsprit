package tn.esprit.firstspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String nomE;
    private String prenomE;
    @Enumerated(EnumType.STRING)
    private Option opt;
    @ManyToOne
    private Departement departement;

    @OneToMany(mappedBy = "etudiant" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Contrat> contrat;
    @ManyToMany( mappedBy = "etudiant" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Equipe> equipe;

}

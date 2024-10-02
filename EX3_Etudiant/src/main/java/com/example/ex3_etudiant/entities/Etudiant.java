package com.example.ex3_etudiant.entities;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @Column(name = "cne", length = 20)
    private String cne;

    // Champ qui référence l'ID de la filière
    @Column(name = "filiereId")
    private int filiereId;
}
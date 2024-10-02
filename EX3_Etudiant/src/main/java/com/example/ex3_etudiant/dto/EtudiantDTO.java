package com.example.ex3_etudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDTO {
    private int idEtudiant;
    private String nom;
    private String prenom;
    private String cne;
    private FiliereDTO filiere;
}

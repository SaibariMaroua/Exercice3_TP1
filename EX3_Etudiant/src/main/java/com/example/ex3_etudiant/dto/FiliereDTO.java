package com.example.ex3_etudiant.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDTO {
    private Long idFiliere;
    private String code;
    private String libelle;
}
package com.example.ex3_filiere.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFiliere;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "libelle", length = 100)
    private String libelle;
}


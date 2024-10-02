package com.example.ex3_etudiant.Repository;


import com.example.ex3_etudiant.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
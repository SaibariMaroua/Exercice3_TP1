package com.example.ex3_etudiant.Service;

import com.example.ex3_etudiant.Repository.EtudiantRepository;
import com.example.ex3_etudiant.dto.EtudiantDTO;
import com.example.ex3_etudiant.dto.FiliereDTO;
import com.example.ex3_etudiant.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private RestTemplate restTemplate;


    public List<EtudiantDTO> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return etudiants.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public EtudiantDTO getEtudiantById(int id) {
        Optional<Etudiant> etudiantOpt = etudiantRepository.findById(id);

        if (etudiantOpt.isPresent()) {
            Etudiant etudiant = etudiantOpt.get();
            return convertToDto(etudiant);
        }
        return null;
    }

    private EtudiantDTO convertToDto(Etudiant etudiant) {
        String filiereApiUrl = "http://localhost:8080/api/filieres/" + etudiant.getFiliereId();
        FiliereDTO filiere = restTemplate.getForObject(filiereApiUrl, FiliereDTO.class);

        return new EtudiantDTO(
                etudiant.getIdEtudiant(),
                etudiant.getNom(),
                etudiant.getPrenom(),
                etudiant.getCne(),
                filiere
        );
    }

    public Etudiant createEtudiant(Etudiant etudiant) {
        FiliereDTO filiere = getFiliereById(etudiant.getFiliereId());

        if (filiere == null) {
            throw new RuntimeException("La filière avec l'ID " + etudiant.getFiliereId() + " n'existe pas.");
        }

        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(int id, Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant != null) {

            FiliereDTO filiere = getFiliereById(etudiantDetails.getFiliereId());
            if (filiere == null) {
                throw new IllegalArgumentException("Impossible de mettre à jour l'étudiant car la filière n'existe pas.");
            }

            etudiant.setNom(etudiantDetails.getNom());
            etudiant.setPrenom(etudiantDetails.getPrenom());
            etudiant.setCne(etudiantDetails.getCne());
            etudiant.setFiliereId(etudiantDetails.getFiliereId());

            return etudiantRepository.save(etudiant);
        }
        return null;
    }

    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }

    private FiliereDTO getFiliereById(int filiereId) {
        String filiereApiUrl = "http://localhost:8080/api/filieres/" + filiereId;
        return restTemplate.getForObject(filiereApiUrl, FiliereDTO.class);
    }
}

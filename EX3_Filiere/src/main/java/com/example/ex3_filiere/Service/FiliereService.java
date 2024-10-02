package com.example.ex3_filiere.Service;

import com.example.ex3_filiere.Repository.FiliereRepository;
import com.example.ex3_filiere.entities.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    public Filiere getFiliereById(int idFiliere) {
        return filiereRepository.findById(idFiliere).orElse(null);
    }

    public Filiere createFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public Filiere updateFiliere(int idFiliere, Filiere filiereDetails) {
        Filiere filiere = filiereRepository.findById(idFiliere).orElse(null);
        if (filiere != null) {
            filiere.setCode(filiereDetails.getCode());
            filiere.setLibelle(filiereDetails.getLibelle());
            return filiereRepository.save(filiere);
        }
        return null;
    }

    public void deleteFiliere(int idFiliere) {
        filiereRepository.deleteById(idFiliere);
    }
}
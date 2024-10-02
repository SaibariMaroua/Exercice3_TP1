package com.example.ex3_filiere.Controller;

import com.example.ex3_filiere.Service.FiliereService;
import com.example.ex3_filiere.entities.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    // Récupérer toutes les filières
    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    // Récupérer une filière par son ID
    @GetMapping("/{idFiliere}")
    public Filiere getFiliereById(@PathVariable int idFiliere) {
        return filiereService.getFiliereById(idFiliere);
    }

    // Créer une nouvelle filière
    @PostMapping
    public Filiere createFiliere(@RequestBody Filiere filiere) {
        return filiereService.createFiliere(filiere);
    }

    // Mettre à jour une filière existante
    @PutMapping("/{idFiliere}")
    public Filiere updateFiliere(@PathVariable int idFiliere, @RequestBody Filiere filiereDetails) {
        return filiereService.updateFiliere(idFiliere, filiereDetails);
    }

    // Supprimer une filière par son ID
    @DeleteMapping("/{idFiliere}")
    public void deleteFiliere(@PathVariable int idFiliere) {
        filiereService.deleteFiliere(idFiliere);
    }
}

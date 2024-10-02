package com.example.ex3_etudiant.Controller;

import com.example.ex3_etudiant.Service.EtudiantService;
import com.example.ex3_etudiant.dto.EtudiantDTO;
import com.example.ex3_etudiant.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;


    @GetMapping
    public List<EtudiantDTO> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiantById(@PathVariable int id) {
        EtudiantDTO etudiantDTO = etudiantService.getEtudiantById(id);
        if (etudiantDTO != null) {
            return ResponseEntity.ok(etudiantDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant) {
        try {
            Etudiant createdEtudiant = etudiantService.createEtudiant(etudiant);
            return ResponseEntity.ok(createdEtudiant);
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable int id, @RequestBody Etudiant etudiantDetails) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(id, etudiantDetails);
        if (updatedEtudiant != null) {
            return ResponseEntity.ok(updatedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable int id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }
}

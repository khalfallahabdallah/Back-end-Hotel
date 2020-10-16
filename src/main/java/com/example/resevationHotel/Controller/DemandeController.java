package com.example.resevationHotel.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resevationHotel.Exception.ResourceNotFoundException;
import com.example.resevationHotel.Model.Demande;
import com.example.resevationHotel.Repository.DemandeRepository;
@CrossOrigin ("*")
@RestController
@RequestMapping("/api/v1")
public class DemandeController {
	@Autowired
	private DemandeRepository demandeRepository;
	@GetMapping("/demandes")
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }
	@GetMapping("/demandes/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable(value = "id") Long demandeId)
        throws ResourceNotFoundException {
       Demande demande = demandeRepository.findById(demandeId)
          .orElseThrow(() -> new ResourceNotFoundException("Demande not found for this id :: " + demandeId));
        return ResponseEntity.ok().body(demande);
    }
	@PostMapping("/demandes")
    public Demande createDemande(@Valid @RequestBody  Demande demande) {
        return demandeRepository.save(demande);
    }
	@PutMapping("/demandes/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable(value = "id") Long demandeId,
         @Valid @RequestBody Demande demandeDetails) throws ResourceNotFoundException {
         Demande demande = demandeRepository.findById(demandeId)
        .orElseThrow(() -> new ResourceNotFoundException("Demande not found for this id :: " + demandeId));

        demande.setNubpersonne( demandeDetails.getNubpersonne());
        demande.setDate( demandeDetails.getDate());
        demande.setDelai( demandeDetails.getDelai());
        demande.setPrix( demandeDetails.getPrix());
        final Demande updatedDemande = demandeRepository.save(demande);
        return ResponseEntity.ok(updatedDemande);
    }

    @DeleteMapping("/demandes/{id}")
    public Map<String, Boolean> deleteDemande(@PathVariable(value = "id") Long demandeId)
         throws ResourceNotFoundException {
    	 Demande demande = demandeRepository.findById(demandeId)
       .orElseThrow(() -> new ResourceNotFoundException(" Deammnde not found for this id :: " + demandeId));

        demandeRepository.delete(demande);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

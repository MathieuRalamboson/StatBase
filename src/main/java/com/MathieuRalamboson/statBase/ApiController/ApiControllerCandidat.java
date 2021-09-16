package com.MathieuRalamboson.statBase.ApiController;

import com.MathieuRalamboson.statBase.Exception.ApplicationException;
import com.MathieuRalamboson.statBase.Gestionnaire.GestionnaireCandidat;
import com.MathieuRalamboson.statBase.Model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.rmi.transport.ObjectTable;

import java.util.List;
import java.util.Optional;

@Controller
public class ApiControllerCandidat {

    @Autowired
    public GestionnaireCandidat gestionnaireCandidat;

    /**
     * Effectue la creation d'un candidat
     * @param candidat
     * @return
     */
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<Object> handleCreate(Candidat candidat) {
        gestionnaireCandidat.addCandidat(candidat);
        return new ResponseEntity(candidat, HttpStatus.OK);
    }

    /**
     * Effectue la modification d'un candidat
     * @param candidat
     * @return
     */
    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> handleUpdate(
            @PathVariable Integer id,
            @RequestBody Candidat candidat) {
        if(gestionnaireCandidat.findCandidatById(id) != null) {
            gestionnaireCandidat.updateCandidat(candidat);
            return new ResponseEntity<>(candidat, HttpStatus.OK);
        } else {
            throw new ApplicationException("Le candidat avec l'id : " + id + " n'a pas été trouvé en base.");
        }
    }

    /**
     * Effectue la suppression d'un candidat
     * @param id
     * @return
     */
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> handleDelete(@PathVariable Integer id){
        gestionnaireCandidat.deleteCandidat(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Effectue la récupération de la liste de tous les candidats en BDD
     * @return
     */
    @RequestMapping(path = "/getAllCandidat",method = RequestMethod.GET)
    public ResponseEntity<List<Candidat>> handleGetAllCandidat() {
        List<Candidat> list = gestionnaireCandidat.findAllCandidat();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    /**
     * Effectue la récuperttion d'un candidat rechercher
     * @param id
     * @return
     */
    @RequestMapping(path = "/findCandidateById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> handleFindCandidateById(@PathVariable Integer id) {
        if (gestionnaireCandidat.findCandidatById(id) != null) {
            Optional<Candidat> candidat = gestionnaireCandidat.findCandidatById(id);
            return new ResponseEntity<>(candidat,HttpStatus.OK);
        } else {
            throw new ApplicationException("Le candidat rechercher n'a pas été trouver.");
        }
    }



}

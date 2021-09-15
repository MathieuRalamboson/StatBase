package com.MathieuRalamboson.statBase.Gestionnaire;

import com.MathieuRalamboson.statBase.Exception.ApplicationException;
import com.MathieuRalamboson.statBase.Interface.InterfacePersistanceCandidat;
import com.MathieuRalamboson.statBase.Model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GestionnaireCandidat {

    @Autowired
    public InterfacePersistanceCandidat interfacePersistanceCandidat;

    /**
     * Fonction ajout d'un candidat
     * @param candidat
     * @return
     */
    public Candidat addCandidat(Candidat candidat) {
        candidat.setCode(UUID.randomUUID().toString());
        return interfacePersistanceCandidat.save(candidat);
    }

    /**
     * Fonction récupération d'un liste de tous les candidats en BDD
     * @return
     */
    public List<Candidat> findAllCandidat() {
        return interfacePersistanceCandidat.findAll();
    }

    /**
     * Fonction modification d'un candidat en BDD
     * @param candidat
     * @return
     */
    public Candidat updateCandidat(Candidat candidat) {
        return interfacePersistanceCandidat.save(candidat);
    }


    /**
     * Fonction suppression d'un candidat en BDD
     * @param id
     */
    public void deleteCandidat(Integer id) {
        interfacePersistanceCandidat.deleteCandidatById(id);
    }

    public Optional<Candidat> findCandidatById(Integer id) {
        if(interfacePersistanceCandidat.findById(id) == null) {
            throw new ApplicationException("L'alumni avec l'identifiant " + id + " n'existe pas en base !");
        } else {
            return interfacePersistanceCandidat.findById(id);
        }
    }
}

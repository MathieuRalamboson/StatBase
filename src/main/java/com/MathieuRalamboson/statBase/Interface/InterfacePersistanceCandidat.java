package com.MathieuRalamboson.statBase.Interface;

import com.MathieuRalamboson.statBase.Model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository gère les requetes sql automatiquement
 * en se basant sur les mots clef écrit dans le nom de la méthode
 * find = SELECT* ,
 * delete = DROP,
 * Candidat = <Objet>
 * ById = Where id = id
 */
public interface InterfacePersistanceCandidat extends JpaRepository<Candidat,Integer> {

    void deleteCandidatById(Integer id);

    Candidat findCandidatById(Integer id);
}

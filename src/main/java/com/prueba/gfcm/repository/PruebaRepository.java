package com.prueba.gfcm.repository;

import com.prueba.gfcm.model.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase contiene clase de Repositorio para acceso a Persistencia
 * @author German Francisco Cuellar
 * @version 1.0
 * 
 * 
 */

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {

}

package api.rest.indra.DAOModel;


import org.springframework.data.jpa.repository.JpaRepository;

import api.rest.indra.model.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Long>{

}

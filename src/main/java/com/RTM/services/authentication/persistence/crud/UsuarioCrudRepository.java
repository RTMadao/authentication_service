package com.RTM.services.authentication.persistence.crud;

import com.RTM.services.authentication.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByUsername(String username);

}

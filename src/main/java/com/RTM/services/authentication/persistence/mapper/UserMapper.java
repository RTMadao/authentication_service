package com.RTM.services.authentication.persistence.mapper;

import com.RTM.services.authentication.domain.model.User;
import com.RTM.services.authentication.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration()
    Usuario toUsuario(User user);

}

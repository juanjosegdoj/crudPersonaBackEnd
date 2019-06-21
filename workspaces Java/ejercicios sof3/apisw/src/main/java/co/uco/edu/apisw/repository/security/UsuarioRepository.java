package co.uco.edu.apisw.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uco.edu.apisw.entity.security.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByUsername(String username);

}

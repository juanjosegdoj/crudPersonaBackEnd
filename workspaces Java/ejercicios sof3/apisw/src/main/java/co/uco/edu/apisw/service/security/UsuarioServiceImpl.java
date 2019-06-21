package co.uco.edu.apisw.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.uco.edu.apisw.entity.security.Rol;
import co.uco.edu.apisw.entity.security.Usuario;
import co.uco.edu.apisw.repository.security.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRpository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRpository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthotities(usuario.getRoles());
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}
	


	private List<GrantedAuthority> buildAuthotities(List<Rol> listUserRole) {
		List<GrantedAuthority> auths = new ArrayList<>();
		for (Rol userRole : listUserRole) {
			auths.add(new SimpleGrantedAuthority(userRole.getNombre()));
		}
		return auths;
	}
	
	

}
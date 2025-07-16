package mx.com.bimbo.data.persistence.service;

import mx.com.bimbo.dto.usuarioDTO;

public interface IUsuarioService {

	public Integer altaUsuario(usuarioDTO _usuarioDTO);
	
	public Integer ConsultaSaldo (Long idUsuario) ;
}

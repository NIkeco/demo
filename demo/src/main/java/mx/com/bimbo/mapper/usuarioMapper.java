package mx.com.bimbo.mapper;

import mx.com.bimbo.data.persistence.model.usuarioEntity;
import mx.com.bimbo.dto.usuarioDTO;
import mx.com.bimbo.security.Sha256;

public class usuarioMapper {

	public static usuarioEntity mapToUsuario (usuarioDTO usuario)	{
		return new usuarioEntity(null, usuario.getUsuario().toUpperCase(), Sha256.getSHA256(usuario.getContraseña()), usuario.getFechaIngreso(), 0);		
	
	}
	
}

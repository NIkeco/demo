package mx.com.bimbo.data.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mx.com.bimbo.controllers.lealtadController;
import mx.com.bimbo.data.persistence.dao.IUsuarioDAO;
import mx.com.bimbo.data.persistence.model.usuarioEntity;
import mx.com.bimbo.dto.usuarioDTO;
import mx.com.bimbo.mapper.usuarioMapper;

@Transactional
@Service
@Slf4j
public class UsuarioServiceImp implements IUsuarioService {

	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private IUsuarioDAO usuarioDAO;	
	
	public Integer altaUsuario(usuarioDTO _usuarioDTO) {
		try {
			usuarioEntity usuario = usuarioMapper.mapToUsuario(_usuarioDTO);
			usuarioDAO.save(usuario);			
			
		} catch (Exception e) {
			log.error("Error al tratar de guardar el usuario");
			return -1;
		}
		
		return 0;
		
	}
	
	public Integer ConsultaSaldo (Long idUsuario) {
		try {
			usuarioEntity usuario =  usuarioDAO.findSaldoUsuarioById(idUsuario);
			
			return usuario.getSaldo();
		}
		catch (Exception e) {
			log.error("Error al consultar el Saldo");
			return -1; 
		}
		
	}
	
	
}

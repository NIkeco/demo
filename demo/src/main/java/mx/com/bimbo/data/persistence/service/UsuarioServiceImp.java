package mx.com.bimbo.data.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mx.com.bimbo.data.persistence.dao.IUsuarioDAO;
import mx.com.bimbo.data.persistence.model.usuarioEntity;
import mx.com.bimbo.dto.usuarioDTO;
import mx.com.bimbo.mapper.usuarioMapper;

@Transactional
@Service
public class UsuarioServiceImp implements IUsuarioService {

	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private IUsuarioDAO usuarioDAO;	
	
	public Integer altaUsuario(usuarioDTO _usuarioDTO) {
		try {
			usuarioEntity usuario = usuarioMapper.mapToUsuario(_usuarioDTO);
			usuarioDAO.save(usuario);
			
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public Integer ConsultaSaldo (Long idUsuario) {
		try {
			usuarioEntity usuario =  usuarioDAO.findSaldoUsuarioById(idUsuario);
			
			return usuario.getSaldo();
		}
		catch (Exception e) {
		// 	TODO Auto-generated catch block
			e.printStackTrace();
			return -1; 
		}
		
	}
	
	
}

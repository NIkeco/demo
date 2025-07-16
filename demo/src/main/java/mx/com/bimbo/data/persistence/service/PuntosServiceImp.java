package mx.com.bimbo.data.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mx.com.bimbo.data.persistence.dao.IPuntosDAO;
import mx.com.bimbo.data.persistence.model.puntosEntity;
import mx.com.bimbo.dto.puntosDTO;
import mx.com.bimbo.mapper.puntosMapper;


@Transactional
@Service
public class PuntosServiceImp implements IPuntosService {

	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private IPuntosDAO puntosDAO;	
	
	public Integer RegistraPuntos (puntosDTO puntosDto) 
	{
		return puntosDAO.RegistraTransacion(puntosMapper.mapToPuntos(puntosDto)); 
	}
	
	public Integer RegistraPuntos (puntosEntity puntosEnn) 
	{
		return puntosDAO.RegistraTransacion(puntosEnn); 
	}
	
}

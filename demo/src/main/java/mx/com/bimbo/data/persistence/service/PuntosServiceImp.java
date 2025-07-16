package mx.com.bimbo.data.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mx.com.bimbo.controllers.lealtadController;
import mx.com.bimbo.data.persistence.dao.IPuntosDAO;
import mx.com.bimbo.data.persistence.model.puntosEntity;
import mx.com.bimbo.dto.puntosDTO;
import mx.com.bimbo.mapper.puntosMapper;


@Transactional
@Service
@Slf4j
public class PuntosServiceImp implements IPuntosService {

	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private IPuntosDAO puntosDAO;	
	
	public Integer RegistraPuntos (puntosDTO puntosDto) 
	{
		try 
		{
			return puntosDAO.RegistraTransacion(puntosMapper.mapToPuntos(puntosDto));
		}
		catch (Exception ex)
		{
			log.error("Error al ejecutar el sp_ResgistraPuntos_Cta ", ex);
			return -1;
		}
	}
	
	public Integer RegistraPuntos (puntosEntity puntosEnn) 
	{
		try 
		{
			return puntosDAO.RegistraTransacion(puntosEnn); 
		}
		catch (Exception ex)
		{
			log.error("Error al ejecutar el sp_ResgistraPuntos_Cta ", ex);
			return -1;
		}
	}
	
}

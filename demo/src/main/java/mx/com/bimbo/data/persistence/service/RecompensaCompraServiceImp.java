package mx.com.bimbo.data.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mx.com.bimbo.controllers.lealtadController;
import mx.com.bimbo.data.persistence.dao.IRecompensaCompraDAO;
import mx.com.bimbo.data.persistence.model.RecompensaCompraEntity;
import mx.com.bimbo.data.persistence.model.puntosEntity;
import mx.com.bimbo.dto.recompensaCompraDTO;
import mx.com.bimbo.mapper.RecompensaCompraMapper;

@Transactional
@Service
@Slf4j
public class RecompensaCompraServiceImp implements IRecompensaCompraService {
		
	@Autowired
	private IRecompensaCompraDAO recompensaCompraDAO;
	
	private IPuntosService puntosService;
	
	
	RecompensaCompraServiceImp (IRecompensaCompraDAO recompensaCompraDao, IPuntosService puntoService)
	{
		recompensaCompraDAO = recompensaCompraDao;
		puntosService = puntoService;
	}
	
	
	@Override
	public Integer CompraRecompensa(recompensaCompraDTO compra) {
		 	
		RecompensaCompraEntity compraEnt = null; 
		puntosEntity puntosEnt = null;
		
		try
		{				
			compraEnt = RecompensaCompraMapper.mapToRecompensaCompraEntiry(compra);
			puntosEnt =  RecompensaCompraMapper.mapRecompensaCompraToPuntos(compraEnt);
			
			recompensaCompraDAO.save(compraEnt);
						
		}
		 catch (Exception ex) { 
			 log.error("Error a realizar la compra de puntos");
			return -1;
		}
	
		try
		{				
			puntosService.RegistraPuntos(puntosEnt);
		}
		 catch (Exception ex) { 
			 log.error("Error a realizar la compra de puntos");
			 recompensaCompraDAO.delete(compraEnt);;
			return -2;
		}
		
		return 0;
		
	}

}

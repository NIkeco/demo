package mx.com.bimbo.data.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mx.com.bimbo.data.persistence.dao.IRecompensaCompraDAO;
import mx.com.bimbo.data.persistence.model.RecompensaCompraEntity;
import mx.com.bimbo.data.persistence.model.puntosEntity;
import mx.com.bimbo.dto.recompensaCompraDTO;
import mx.com.bimbo.mapper.RecompensaCompraMapper;

@Transactional
@Service
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
		 		
		try
		{				
			RecompensaCompraEntity compraEnt = RecompensaCompraMapper.mapToRecompensaCompraEntiry(compra);
			puntosEntity puntosEnt =  RecompensaCompraMapper.mapRecompensaCompraToPuntos(compraEnt);
			
			recompensaCompraDAO.save(compraEnt);
						
			puntosService.RegistraPuntos(puntosEnt);

			
			return 0;
		}
		 catch (Exception ex) {  
			return 1;
		}
	
		
		
	}

}

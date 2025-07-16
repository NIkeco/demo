package mx.com.bimbo.data.persistence.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import lombok.extern.slf4j.Slf4j;
import mx.com.bimbo.controllers.lealtadController;
import mx.com.bimbo.data.persistence.model.puntosEntity;

@Repository
@Slf4j
public class PuntosDAO implements IPuntosDAO {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Qualifier("lealtadTransactionManager")
	JpaTransactionManager tm;
	
	public Integer  RegistraTransacion(puntosEntity tranPuntos)
	{
		try
		{
		
			StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("spResgistraPuntos");
			
			storedProcedure.setParameter("IdUsuario", tranPuntos.getIdUsuario())
				.setParameter("transaccion", tranPuntos.getTransaccion())
				.setParameter("descripcion", tranPuntos.getDescripcion())
				.setParameter("monto", tranPuntos.getMonto())
				.setParameter("fecha", tranPuntos.getFecha());
			
			storedProcedure.execute();
		
		}
		catch (Exception e) {
			log.error("Error al ejecutar el SP");
			return -1; 
		}
		
		return 0;
	}
	
}

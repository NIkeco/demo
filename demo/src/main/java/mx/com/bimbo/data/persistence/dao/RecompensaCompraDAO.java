package mx.com.bimbo.data.persistence.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public abstract class RecompensaCompraDAO implements IRecompensaCompraDAO {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Qualifier("lealtadTransactionManager")
	JpaTransactionManager tm;
	
	
	
}

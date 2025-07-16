package mx.com.bimbo.data.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.bimbo.data.persistence.model.RecompensaCompraEntity;


public interface IRecompensaCompraDAO extends JpaRepository<RecompensaCompraEntity, Long> {

}

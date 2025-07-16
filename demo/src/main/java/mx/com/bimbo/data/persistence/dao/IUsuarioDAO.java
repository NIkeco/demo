package mx.com.bimbo.data.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.bimbo.data.persistence.model.usuarioEntity;

public interface IUsuarioDAO extends JpaRepository<usuarioEntity, Long>{

	@Query(value = "SELECT new usuarioEntity(u.usuario, u.saldo) FROM usuarioEntity u WHERE u.idUsuario = :idUsuario", nativeQuery = false)
    public usuarioEntity findSaldoUsuarioById(@Param("idUsuario") Long idUsuario);

	
}

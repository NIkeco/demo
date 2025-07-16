package mx.com.bimbo.data.persistence.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NamedStoredProcedureQuery(
	    name="spResgistraPuntos",
	    procedureName="sp_ResgistraPuntos_Cta",
	    resultClasses = { puntosEntity.class },
    	parameters={
            @StoredProcedureParameter(name="IdUsuario", type=Long.class, mode=ParameterMode.IN),
            @StoredProcedureParameter(name="transaccion", type=String.class, mode=ParameterMode.IN),
            @StoredProcedureParameter(name="descripcion", type=String.class, mode=ParameterMode.IN),
            @StoredProcedureParameter(name="monto", type=Integer.class, mode=ParameterMode.IN),
            @StoredProcedureParameter(name="fecha", type=LocalDateTime.class, mode=ParameterMode.IN)
        }
)


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class puntosEntity {
	@Id
	@Column(name = "idUsuario")
	Long idUsuario;
	
	@Column(name = "Transaccion", length = 1)
	String transaccion;
	
	@Column(name = "Fecha")
	@CreationTimestamp
	LocalDateTime  fecha;
	
	@Column(name = "Descripcion", length = 50)
	String descripcion;
		
	@Column(name = "Monto")	
	Integer Monto;
	
}

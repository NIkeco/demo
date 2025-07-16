package mx.com.bimbo.data.persistence.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "RecompensaCompra")
@Getter
@Setter
@AllArgsConstructor
public class RecompensaCompraEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRecompensaCompra")
	Long idRecompensaCompra;
			
	@Column(name = "idUsuario")
	Long idUsuario;
	
	@Column(name = "idRecompensa")
	Long idRecompensa;
		
	@Column(name = "Fecha")
	@CreationTimestamp
	LocalDateTime  fecha;

	@Column(name = "Cantidad")	
	Integer Cantidad;	
	
	@Column(name = "Monto")	
	Integer Monto;
	
	@Column(name = "Descripcion", length = 100)
	String descripcion;

}

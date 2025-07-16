package mx.com.bimbo.data.persistence.model;

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
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class usuarioEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long idUsuario;
	
	@Column (name = "usuario", length= 20)	
	private String usuario;
	
	@Column (name = "contraseña", length = 300)
	private String contraseña;
	
	@Column (name = "fecha")
	private Integer fechaIngreso;
	
	@Column (name = "saldo")
	private Integer saldo;
	
	public usuarioEntity(String usuario, Integer saldo)
	{
		this.usuario = usuario;
		this.saldo = saldo;
		
	}
	
	
	
}

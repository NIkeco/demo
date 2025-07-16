package mx.com.bimbo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class recompensaCompraDTO {
	
	@NotNull(message = "el id Usuario ingreso es obligatorio")
	Long idUsuario;
	
	@NotNull(message = "el id Recompensa ingreso es obligatorio")
	Long idRecompensa;
	
	@NotNull(message = "la Cantidad es obligatorio")
	@Min(value = 1, message = "el Cantidad debe de ser mayo a 0")
	Integer cantidad;
	
	@NotNull(message = "la Monto es obligatorio")
	@Min(value = 1, message = "el Monto debe de ser mayo a 0")
	Integer monto;
	
	String descripcion;
}

package mx.com.bimbo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class puntosDTO {
	
	@NotNull(message = "el id Usuario es obligatorio")
	Long idUsuario;
	
	@NotNull(message = "la transaccion es obligatorio")
	@NotBlank(message = "la transaccion es obligatorio")
	@Pattern(regexp = "^[aAcC]$", message = "el valore  de la transaccion es incorrecto")
	String transaccion;
	
	String descripcion;
	
	@Min(value = 1, message = "el Monto debe de ser mayo a 0")
	@NotNull(message = "el Monto es obligatorio")
	Integer Monto;

}

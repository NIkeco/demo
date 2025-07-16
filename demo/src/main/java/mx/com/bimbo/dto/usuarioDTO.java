package mx.com.bimbo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class usuarioDTO {
	
	
	@Size(min = 6, max = 20 , message = "el usuario debe tener entre 6 a 20 caracteres")
	private String usuario;
	
	@Size(min = 8,  message = "la contraseña tener almenos 8 caracteres")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",  message = "la contraseña debe tener una al menos una letra mayuscula, minuscula, un numero y un caractacter especial")
	private String contraseña;
		
	@NotNull(message = "la fecha ingreso es obligatorio")
	private Integer fechaIngreso;
		
	//private Integer saldo;
}

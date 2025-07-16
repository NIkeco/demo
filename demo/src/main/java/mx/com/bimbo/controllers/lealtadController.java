package mx.com.bimbo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.bimbo.data.persistence.service.IPuntosService;
import mx.com.bimbo.data.persistence.service.IRecompensaCompraService;
import mx.com.bimbo.data.persistence.service.IUsuarioService;
import mx.com.bimbo.dto.ResponseDTO;
import mx.com.bimbo.dto.puntosDTO;
import mx.com.bimbo.dto.recompensaCompraDTO;
import mx.com.bimbo.dto.usuarioDTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lealtad")
@Slf4j
public class lealtadController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPuntosService puntosService;
	
	@Autowired
	private IRecompensaCompraService recompensaCompraService;
	
	@PostMapping("/altaUsuario")
	public Integer altaUsuario (@Valid @RequestBody usuarioDTO usuario) {
		
		return usuarioService.altaUsuario(usuario);
	}
	
	@PostMapping("/consultaSaldo")
	public Integer consultaSaldo (@RequestParam(value = "id", required = true) 
			 @NotNull(message = "id obligatorio") Long idUsuario) {
		return usuarioService.ConsultaSaldo(idUsuario);
	}
	
	@PostMapping("/registraPuntos")
	public Integer registraPuntos (@Valid @RequestBody puntosDTO puntos) {				
		return puntosService.RegistraPuntos(puntos);		
	}	
	
	@PostMapping ("/registraCompra")	
	public ResponseDTO registraCompra (@Valid @RequestBody recompensaCompraDTO recompensaCompra) {
		
		Integer saldo;
		
		saldo = usuarioService.ConsultaSaldo(recompensaCompra.getIdUsuario());
		
		if (recompensaCompra.getMonto() > saldo)
		{
			log.error("Consulta con el usuario: " + recompensaCompra.getIdUsuario() + " el saldo insufiente." );
			return new ResponseDTO( -1, "El saldo es insuficiente");
			
		}
		
		
		if (recompensaCompraService.CompraRecompensa(recompensaCompra) == 0)
		{
			return new ResponseDTO( 0, "");
		}
		else
		{
			log.error("Error al realizar la compra");
			return new ResponseDTO( -1, "Error al realizar la compra");
		}	
		
	}	
	
}

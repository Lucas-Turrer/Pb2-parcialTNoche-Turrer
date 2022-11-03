package test.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.pb2.Banco;
import unlam.pb2.Cliente;
import unlam.pb2.Denunciable;
import unlam.pb2.DispositivoMovil;
import unlam.pb2.Extraccion;
import unlam.pb2.FraudeException;
import unlam.pb2.Localidad;
import unlam.pb2.PagoConQR;
import unlam.pb2.TipoDeBloqueo;
import unlam.pb2.Transferencia;


public class TestCases {

	@Test
	public void queSePuedaCrearUnCliente() {
		Cliente cliente1 = new Cliente(2037931874,"Lucas",10000.00);
		
		assertNotNull(cliente1);
	}
	
	@Test
	public void queSePuedaCrearUnDispositivo() {
		Cliente cliente1 = new Cliente(2037931874,"Lucas",10000.00);
		Dispositivo computadoraPortatil = new Pc ("112.55.55.55","XP", Localidad.SanJusto);
		Dispositivo celular = new DispositivoMovil ("112.55.55.55", Localidad.SanJusto, "055852", TipoDeBloqueo.Huella);
		
		cliente1.agregarDispositivo(computadoraPortatil);
		cliente1.agregarDispositivo(celular);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = cliente1.cantidadDeDispositivosRegistrados();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaMonitorearUnaExtraccion() {
		Cliente cliente1 = new Cliente(2037931874,"Lucas",10000.00);
		Dispositivo computadoraPortatil = new Pc ("112.55.55.55","XP", Localidad.SanJusto);
		Dispositivo celular = new DispositivoMovil ("112.55.55.55", Localidad.SanJusto, "055852", TipoDeBloqueo.Huella);
		
		cliente1.agregarDispositivo(computadoraPortatil);
		cliente1.agregarDispositivo(celular);
		
		
		
		Extraccion nuevaExtraccion = new Extraccion ();
		nuevaExtraccion.realizarExtraccion(cliente1,2500.00);
		
		Double valorEsperado = 7500.00;
		Double valorObtenido = cliente1.getSaldoActual();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = FraudeException.class )
	public void queSePuedaMonitorearUnaTransferencia() throws FraudeException {
		Cliente cliente1 = new Cliente(2037931874,"Lucas",10000.00);
		Cliente cliente2 = new Cliente(2016525852,"Lucas",11000.00);
		Dispositivo computadoraPortatil = new Pc ("112.55.55.55","XP", Localidad.SanJusto);
		Dispositivo celular = new DispositivoMovil ("112.55.55.55", Localidad.SanJusto, "055852", TipoDeBloqueo.Huella);
		
		cliente1.agregarDispositivo(computadoraPortatil);
		cliente1.agregarDispositivo(celular);
		
		Banco bancoNacion = new Banco();
		bancoNacion.agregarALalistaNegra(cliente2);
		
		Transferencia nuevaTransferencia = new Transferencia (cliente1,5000.00, cliente2);
		
		bancoNacion.registrarTransaccion(nuevaTransferencia);
		
	}
	
	@Test (expected = FraudeException.class )
	public void queSePuedaMonitorearUnPagoConQR() throws FraudeException {
		Cliente cliente1 = new Cliente(2037931874,"Lucas",10000.00);
		Cliente cliente2 = new Cliente(2016525852,"Lucas",11000.00);
		Dispositivo computadoraPortatil = new Pc ("112.55.55.55","XP", Localidad.SanJusto);
		Dispositivo celular = new DispositivoMovil ("112.55.55.55", Localidad.SanJusto, "055852", TipoDeBloqueo.Huella);
		
		cliente1.agregarDispositivo(computadoraPortatil);
		cliente2.agregarDispositivo(celular);
		
		Banco bancoNacion = new Banco();
		bancoNacion.agregarALalistaNegra(celular);
		
		PagoConQR nuevoPagoConQR = new PagoConQR (cliente1,5000.00, celular);

		bancoNacion.registrarTransaccion(nuevoPagoConQR);
	}
	
	/*@Test
	public void queSePuedaMonitorearUnPagoDeServicio() {
		Cliente cliente1 = new Cliente(2037931874,"Lucas",10000.00);
		Cliente cliente2 = new Cliente(2016525852,"Lucas",11000.00);
		Dispositivo computadoraPortatil = new Pc ("112.55.55.55","XP", Localidad.SanJusto);
		Dispositivo celular = new DispositivoMovil ("112.55.55.55", Localidad.SanJusto, "055852", TipoDeBloqueo.Huella);
		
		cliente1.agregarDispositivo(computadoraPortatil);
		cliente1.agregarDispositivo(celular);
		
	
	}*/

}

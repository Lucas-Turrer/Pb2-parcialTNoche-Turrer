package test.unlam.pb2;

import java.util.Objects;

import unlam.pb2.Localidad;

public class Pc extends Dispositivo {
	private String so;

	public Pc(String numeroDeIP, String so, Localidad localidadDeConexion) {
		super(numeroDeIP, localidadDeConexion);
		this.so = so;
	}
	
	
	

}

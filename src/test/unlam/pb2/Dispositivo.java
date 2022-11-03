package test.unlam.pb2;

import java.util.Objects;

import unlam.pb2.Denunciable;
import unlam.pb2.Localidad;

public class Dispositivo implements Denunciable {
	private String numeroDeIP;
	private Localidad localidadDeConexion;
	
	public Dispositivo(String numeroDeIP, Localidad localidadDeConexion) {
		this.numeroDeIP = numeroDeIP;
		this.localidadDeConexion = localidadDeConexion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDeIP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dispositivo other = (Dispositivo) obj;
		return Objects.equals(numeroDeIP, other.numeroDeIP);
	}
	
	
	
	
}

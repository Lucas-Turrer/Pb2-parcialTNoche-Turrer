package unlam.pb2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import test.unlam.pb2.Dispositivo;

public class Cliente implements Denunciable{
	private Integer cuit;
	private String nombre;
	private Double saldoActual;
	private Set <Dispositivo> dispositivosDelCliente = new HashSet();

	public Cliente(Integer cuit, String nombre, Double saldoInicial) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.saldoActual = saldoInicial;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public Double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(Double saldoActual) {
		this.saldoActual = saldoActual;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cuit, other.cuit);
	}

	public void agregarDispositivo(Dispositivo dispositivoParaAgregar) {
		dispositivosDelCliente.add(dispositivoParaAgregar);
	}

	public Integer cantidadDeDispositivosRegistrados() {
		return dispositivosDelCliente.size();
	}
	
	

}

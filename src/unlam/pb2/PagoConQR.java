package unlam.pb2;

import java.util.Set;

import test.unlam.pb2.Dispositivo;

public class PagoConQR implements Rechazable {
	private Cliente clienteOrigen;
	private Double saldoAPagar;
	private Dispositivo celular;
	private Integer score = 0;

	public PagoConQR(Cliente clienteOrigen, Double saldoAPagar, Dispositivo celular) {
		this.clienteOrigen = clienteOrigen;
		this.saldoAPagar = saldoAPagar;
		this.celular = celular;
	}


	@Override
	public Boolean monitorear(Set<Denunciable> listaNegra) throws FraudeException {
		if(listaNegra.contains(celular)){
			score+=80;
		}
		if(score >=80) {
			throw new FraudeException();
		}
		return true;
	}

}

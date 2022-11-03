package unlam.pb2;

import java.util.Set;

public class Transferencia implements Monitoreable,Alertable, Rechazable {
	private Cliente clienteOrigen;
	private Double saldoDeLaTransferencia;
	private Cliente clienteDestino;
	private Integer score =0;
	
	public Transferencia(Cliente clienteOrigen, Double saldoDeLaTransferencia, Cliente clienteDestino) {
		this.clienteOrigen = clienteOrigen;
		this.saldoDeLaTransferencia = saldoDeLaTransferencia;
		this.clienteDestino = clienteDestino;
	}

	/*public void realizarTransferencia(Cliente clienteOrigen, Double dineroATransferir, Cliente clienteDestino, Denunciable listaNegra) {
		if(listaNegra.verificarCliente(clienteDestino)== false) {
			if(clienteOrigen.getSaldoActual()>=dineroATransferir) {
				Double dineroEnLaCuentaOrigen = clienteOrigen.getSaldoActual() - dineroATransferir;
				clienteOrigen.setSaldoActual(dineroEnLaCuentaOrigen);
				clienteDestino.setSaldoActual(dineroEnLaCuentaOrigen + clienteDestino.getSaldoActual());
			}
		}
	}*/

	

	

	@Override
	public void marcarComoCasoSospechoso() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarSiFueFraude(Boolean fueFraude) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean monitorear(Set<Denunciable> listaNegra) throws FraudeException{
		if(listaNegra.contains(clienteDestino)){
			score+=80;
		}
		if(score >=80) {
			throw new FraudeException();
		}
		return true;
	}

	@Override
	public Boolean monitorear() {
		// TODO Auto-generated method stub
		return null;
	}

}

package unlam.pb2;

import java.util.Set;

public class Extraccion implements Monitoreable,Alertable,Rechazable {
	
	public void realizarExtraccion(Cliente clienteDeLaOperacion, Double saldoAExtraer) {
		if(clienteDeLaOperacion.getSaldoActual() >= saldoAExtraer) {
			Double nuevoSaldoActual = clienteDeLaOperacion.getSaldoActual() - saldoAExtraer;
			clienteDeLaOperacion.setSaldoActual(nuevoSaldoActual);
		}
	}

	@Override
	public Boolean monitorear() {
		return true;
	}

	@Override
	public void marcarComoCasoSospechoso() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarSiFueFraude(Boolean fueFraude) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean monitorear(Set<Denunciable> listaNegra) {
		// TODO Auto-generated method stub
		return null;
	}

}

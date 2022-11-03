package unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Banco {


	private ArrayList<Rechazable> log = new ArrayList ();
	private Set<Denunciable> listaNegra = new HashSet();
	
	public Banco() {}
	
	public Boolean registrarTransaccion(Rechazable nueva) throws FraudeException{
		log.add(nueva);
		return nueva.monitorear(listaNegra);
	}

	public void agregarALalistaNegra(Denunciable clienteParaAgregar) {
		listaNegra.add(clienteParaAgregar);
	}
}

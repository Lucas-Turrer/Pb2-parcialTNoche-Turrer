package unlam.pb2;

import java.util.Set;

public interface Rechazable {
	public Boolean monitorear(Set<Denunciable> listaNegra) throws FraudeException;
}

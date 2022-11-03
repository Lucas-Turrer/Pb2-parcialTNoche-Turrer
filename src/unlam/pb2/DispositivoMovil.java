package unlam.pb2;

import test.unlam.pb2.Dispositivo;

public class DispositivoMovil extends Dispositivo {
	private String imei;
	private TipoDeBloqueo modoDeDesbloqueo;

	public DispositivoMovil(String numeroDeIP, Localidad localidadDeConexion, String imei, TipoDeBloqueo modoDeDesbloqueo) {
		super(numeroDeIP, localidadDeConexion);
		this.imei = imei;
		this.modoDeDesbloqueo = modoDeDesbloqueo;
	}

}

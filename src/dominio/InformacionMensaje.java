package dominio;

import java.io.Serializable;
        
public final class InformacionMensaje implements Serializable {

    private String mensaje;
    public String destinatario;
    private String remitente;

    public InformacionMensaje(String elRemitente, String dst, String elMensaje) {
        setRemitente(elRemitente);
        setDestinatario(dst);
        setMensaje(elMensaje);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String elMensaje) {
        mensaje = elMensaje;
    }

    public String getDestinatario() {
        if (destinatario != null && !destinatario.isEmpty())
            return destinatario;
        return "Destinatario no ingresado";
    }

    public void setDestinatario(String elDestinatario) {
        destinatario = elDestinatario;

    }

    public String getRemitente() {
        if(remitente != null && !remitente.isEmpty())
            return remitente;
        return "Remitente no ingresado";
    }

    public void setRemitente(String elRemitente) {
        this.remitente = elRemitente;
    }

    public void intercambiarRemitente() {
        String aux = destinatario;
        destinatario = remitente;
        remitente = aux;
    }

    @Override
    public String toString() {
        return getRemitente() + ": \n" + getMensaje();
    }

}

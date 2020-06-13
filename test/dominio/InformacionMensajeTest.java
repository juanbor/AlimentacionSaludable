package dominio;

import org.junit.Test;
import static org.junit.Assert.*;

public class InformacionMensajeTest {

    public InformacionMensajeTest() {
    }

    @Test
    public void testGetsSetsNullRemitente() {
        String remitente = null;
        String destinatario = null;
        String mensaje = null;
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        assertEquals(info.getRemitente(), "Remitente no ingresado");
    }

    @Test
    public void testGetsSetsNullMensaje() {
        String remitente = null;
        String destinatario = null;
        String mensaje = null;
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        assertEquals(info.getMensaje(), mensaje);
    }

    @Test
    public void testGetsSetsNullToString() {
        String remitente = null;
        String destinatario = null;
        String mensaje = null;
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        String esperadoToString = "Remitente no ingresado" + ": \n" + mensaje;
        assertEquals(info.toString(), esperadoToString);
    }

    @Test
    public void testGetsSetsStringsVaciosRemitente() {
        String remitente = "";
        String destinatario = "";
        String mensaje = "";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        assertEquals(info.getRemitente(), "Remitente no ingresado");
    }

    @Test
    public void testGetsSetsStringsVaciosDestinatario() {
        String remitente = "";
        String destinatario = "";
        String mensaje = "";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        assertEquals(info.getDestinatario(), "Destinatario no ingresado");
    }

    @Test
    public void testGetsSetsStringsVaciosMensaje() {
        String remitente = "";
        String destinatario = "";
        String mensaje = "";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        assertEquals(info.getMensaje(), mensaje);
    }

    @Test
    public void testGetsSetsStringsVaciosToString() {
        String remitente = "";
        String destinatario = "";
        String mensaje = "";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        String esperadoToString = "Remitente no ingresado" + ": \n" + mensaje;
        assertEquals(info.toString(), esperadoToString);
    }
    
    @Test
    public void testGetRemitenteWithData(){
        String remitente = "Santi";
        String destinatario = "Juan";
        String mensaje = "mensaje";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        String esperado = "Santi";
        assertEquals(esperado, info.getRemitente());
    }
    
    @Test
    public void testGetDestinatarioWithData(){
        String remitente = "Santi";
        String destinatario = "Juan";
        String mensaje = "mensaje";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        String esperado = "Juan";
        assertEquals(esperado, info.getDestinatario());
    }
    
    @Test
    public void testIntercambiarDestinatarioRemitenteCheckRemitente(){
        String remitente = "Santi";
        String destinatario = "Juan";
        String mensaje = "mensaje";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        info.intercambiarRemitente();
        String esperado = "Juan";
        assertEquals(esperado, info.getRemitente());
    }

    @Test
    public void testIntercambiarDestinatarioRemitenteCheckDestinatario(){
        String remitente = "Santi";
        String destinatario = "Juan";
        String mensaje = "mensaje";
        InformacionMensaje info = new InformacionMensaje(remitente, destinatario, mensaje);
        info.intercambiarRemitente();
        String esperado = "Santi";
        assertEquals(esperado, info.getDestinatario());
    }    
}

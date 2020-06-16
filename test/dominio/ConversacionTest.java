package dominio;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConversacionTest {

    public ConversacionTest() {
    }

    @Test 
    public void testGetSetsNullUsuario() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        Persona usuarioEsperado = new Usuario(null, null, null, null);
        assertEquals(conversacionATestear.getUsuario(), usuarioEsperado);
    }

    @Test 
    public void testGetSetsNullProfesional() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        Persona profesionalEsperado = new Profesional(null, null, null, null, null, null, null);
        assertEquals(conversacionATestear.getProfesional(), profesionalEsperado);
    }

    @Test
    public void testGetSetsNullLsitaMensajes() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.getListaMensajes().size(), 0);
    }
    
    @Test
    public void testSetListaMensajes() {
        Persona usuario = new Usuario("Santi", "Perez", null, null);
        Persona profesional = new Profesional("Juan", "Perez", "", null, null, null, null);
        ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
        listaMensajes.add(new InformacionMensaje(usuario.getNombreCompleto(), profesional.getNombreCompleto(), "Test"));
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.getListaMensajes().size(), 1);
    }
    @Test
    public void testGetSetsNullToString() {
        Persona usuario = null;
        Persona profesional = null;
        ArrayList listaMensajes = null;
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.toString(), "No hay mensajes para mostrar");
    }


    @Test
    public void testGetSetsDatosVaciosProfesional() {
        Persona usuario = new Usuario("", "", null, null);
        Persona profesional = new Profesional("", "", null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        Persona profesionalEsperado = new Profesional("", "", null, null, null, null, null);
        assertEquals(conversacionATestear.getProfesional(), profesionalEsperado);
    }

    @Test
    public void testGetSetsDatosVaciosListaMensajes() {
        Persona usuario = new Usuario(null, null, null, null);
        Persona profesional = new Profesional(null, null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.getListaMensajes().size(), 0);
    }
    
    @Test
    public void testToStringConDatos() {
        Persona usuario = new Usuario("Santi", "Perez", null, null);
        Persona profesional = new Profesional("Juan", "Perez", "", null, null, null, null);
        ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
        listaMensajes.add(new InformacionMensaje(usuario.getNombreCompleto(), profesional.getNombreCompleto(), "Test"));
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.toString(), "\nSanti Perez\nTest\n");
    }

    @Test
    public void testGetSetsDatosVaciosToString() {
        Persona usuario = new Usuario(null, null, null, null);
        Persona profesional = new Profesional(null, null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(conversacionATestear.toString(), "No hay mensajes para mostrar");
    }
    
    @Test
    public void testAgregarMensajeCambiandoRemitente(){
        Usuario usuario = new Usuario("Santi", null, null, null);
        Profesional profesional = new Profesional("Juan", null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assert(conversacionATestear.agregarMensaje("Test", true));
    }
    
    @Test
    public void testAgregarMensajeSinCambiarRemitente(){
        Usuario usuario = new Usuario("Santi", null, null, null);
        Profesional profesional = new Profesional("Juan", null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assert(conversacionATestear.agregarMensaje("Test", false));
    }

    @Test
    public void testGetFueAtendidaLaConsulta() {
        Persona usuario = new Usuario(null, null, null, null);
        Persona profesional = new Profesional(null, null, null, null, null, null, null);
        ArrayList listaMensajes = new ArrayList<>();
        Conversacion conversacionATestear = new Conversacion(usuario, profesional, listaMensajes);
        assertEquals(false, conversacionATestear.getFueAtendidaConsulta());
    }
    
    @Test (expected = NullPointerException.class)
    public void testEqualsNull1(){
        Usuario usuario1 = new Usuario("Santi", "Perez", null, null);
        Profesional profesional = new Profesional("", "", "", null, "", "", "");
        ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
        Conversacion conversacion1 = null;       
        Conversacion conversacion2 =  new Conversacion(usuario1, profesional, listaMensajes);
        boolean eq = conversacion1.equals(conversacion2);
    }
    
    @Test (expected = NullPointerException.class)
    public void testEqualsNull2(){
        Usuario usuario1 = new Usuario("Santi", "Perez", null, null);
        Profesional profesional = new Profesional("", "", "", null, "", "", "");
        ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
        Conversacion conversacion1 = null;       
        Conversacion conversacion2 =  new Conversacion(usuario1, profesional, listaMensajes);
        boolean eq = conversacion2.equals(conversacion1);
    }
    
    @Test
    public void testEqualsOk(){
        Usuario usuario1 = new Usuario("Santi", "Perez", null, null);
        Profesional profesional = new Profesional("", "", "", null, "", "", "");
        ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
        Conversacion conversacion1 = new Conversacion(usuario1, profesional, listaMensajes);       
        Conversacion conversacion2 =  new Conversacion(usuario1, profesional, listaMensajes);
        assertEquals(conversacion1, conversacion2);
    }
    
    @Test
    public void testEqualsFailUser(){
        Usuario usuario1 = new Usuario("Santi", "Perez", null, null);
        Usuario usuario2 = new Usuario("Juan", "Bordagorry", null, null);
        Profesional profesional = new Profesional("", "", "", null, "", "", "");
        ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
        Conversacion conversacion1 = new Conversacion(usuario1, profesional, listaMensajes);       
        Conversacion conversacion2 =  new Conversacion(usuario2, profesional, listaMensajes);
        assertNotEquals(conversacion1, conversacion2);
    }
    
    @Test
    public void testEqualsFailProfesional(){
        Usuario usuario1 = new Usuario("Santi", "Perez", null, null);
        Profesional profesional1= new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        Profesional profesional2 = new Profesional("", "", "", null, "", "", "");
        ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
        Conversacion conversacion1 = new Conversacion(usuario1, profesional1, listaMensajes);       
        Conversacion conversacion2 =  new Conversacion(usuario1, profesional2, listaMensajes);
        assertNotEquals(conversacion1, conversacion2);
    }
}
    
    


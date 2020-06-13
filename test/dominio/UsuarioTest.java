package dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {

    public UsuarioTest() {
    }

    @Test
    public void testGetsSetsVaciosListaAlimentos() {
        Usuario usuario = new Usuario("", "", "", "");
        assertEquals(usuario.getAlimentosIngeridos().size(), 0);
    }

    @Test
    public void testGetsSetsVaciosRestricciones() {
        Usuario usuario = new Usuario("", "", "", "");
        assertEquals(usuario.getRestricciones().size(), 0);
    }

    @Test
    public void testGetsSetsVaciosPreferencias() {
        Usuario usuario = new Usuario("", "", "", "");
        assertEquals(usuario.getPreferencias().size(), 0);
    }

    @Test
    public void testGetsSetsNullNombre() {
        Usuario usuario = new Usuario(null, null, null, null);
        assertEquals(usuario.getNombre(), "Nombre no ingresado");
    }

    @Test
    public void testGetsSetsNullApellido() {
        Usuario usuario = new Usuario(null, null, null, null);
        assertEquals(usuario.getApellido(), "Apellido no ingresado");
    }

    @Test
    public void testGetsSetsNullFechaNacimiento() {
        Usuario usuario = new Usuario(null, null, null, null);
        assertEquals(usuario.getFechaNacimiento(), "Fecha no ingresada");
    }

    @Test
    public void testGetsSetsNullNacionalidad() {
        Usuario usuario = new Usuario(null, null, null, null);
        assertEquals(usuario.getNacionalidad(), "Nacionalidad no ingresada");
    }
    @Test
    public void testGetsSetsEmptyNacionalidad() {
        Usuario usuario = new Usuario(null, null, "", null);
        assertEquals(usuario.getNacionalidad(), "Nacionalidad no ingresada");
    }
    
    @Test
    public void testGetsSetsWithDataNacionalidad() {
        Usuario usuario = new Usuario(null, null, null,"Uruguay");
        assertEquals("Uruguay", usuario.getNacionalidad());
    }
    

    @Test
    public void testGetsSetsNullListaAlimentos() {
        Usuario usuario = new Usuario(null, null, null, null);
        assertEquals(usuario.getAlimentosIngeridos().size(), 0);
    }

    @Test
    public void testGetsSetsNullRestricciones() {
        Usuario usuario = new Usuario(null, null, null, null);
        assertEquals(usuario.getRestricciones().size(), 0);
    }

    @Test
    public void testGetsSetsNullPreferencias() {
        Usuario usuario = new Usuario(null, null, null, null);
        assertEquals(usuario.getPreferencias().size(), 0);
    }
    
    @Test
    public void testGetNotNullListaAlimentos() {
        Usuario usuario = new Usuario(null, null, null, null);
        ArrayList<Alimento> alimentos = new ArrayList<>();
        alimentos.add(new Alimento("Carne", "Carne", new ArrayList<>(), null));
        Ingesta ingesta = new Ingesta("Ingesta", alimentos);
        ArrayList<Ingesta> ingestas = new ArrayList<>();
        ingestas.add(ingesta);
        usuario.setAlimentosIngeridos(ingestas);
        String[] expected = new String[1];
        expected[0] = "Lista de alimentos ingeridos[Carne]";
        Assert.assertArrayEquals(expected, usuario.getArrayAlimentosIngeridos());
    }

    @Test
    public void testGetNotNullRestricciones() {
        Usuario usuario = new Usuario(null, null, null, null);
        ArrayList<String> restricciones = new ArrayList<>();
        restricciones.add("Celiaquia");
        usuario.setRestricciones(restricciones);
        String[] restriccionesTest = new String[1];
        String[] expected = restricciones.toArray(restriccionesTest);
        Assert.assertArrayEquals(expected, usuario.getArrayRestricciones());
    }

    @Test
    public void testGetNotNullPreferencias() {
        Usuario usuario = new Usuario(null, null, null, null);
        ArrayList<String> preferencias = new ArrayList<>();
        preferencias.add("Carne");
        usuario.setPreferencias(preferencias);
        String[] preferenciasTest = new String[1];
        String[] expected = preferencias.toArray(preferenciasTest);
        Assert.assertArrayEquals(expected, usuario.getArrayPreferencias());
    }

}

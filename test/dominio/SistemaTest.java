package dominio;

import dominio.Sistema;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaTest {

    public SistemaTest() {

    }


    @Test
    public void testGetsSetsNullListaAlimentos() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = null;
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaAlimentos().size(), 0);
    }

    @Test
    public void testGetsSetsNullListaPlanes() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = null;
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaPlanesAlimentacion().size(), 0);
    }

    @Test
    public void testGetsSetsNullListaConversaciones() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = null;
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaConversaciones().size(), 0);
    }

    @Test 
    public void testGetsSetsNullPersonaLogueada() {
        ArrayList<Usuario> listaUsuarios = null;
        ArrayList<Profesional> listaProfesionales = null;
        ArrayList<Alimento> listaAlimentos = null;
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = null;
        ArrayList<Conversacion> listaConversaciones = null;
        Persona personaLogueada = new Usuario(null, null, null, null);
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        Persona personaLogueadaEsperada = new Usuario(null, null, null, null);
        assertEquals(sistemaATestear.getPersonaLogueada(), personaLogueadaEsperada);
    }

    @Test
    public void testGetsSetsDatosVaciosListaUsuarios() {
        Sistema sistemaATestear = new Sistema();
        assertEquals(sistemaATestear.getListaUsuarios().size(), 0);
    }

    @Test
    public void testGetsSetsDatosVaciosListaAlimentos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Profesional> listaProfesionales = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        ArrayList<Conversacion> listaConversaciones = new ArrayList<>();
        Persona personaLogueada = new Usuario(null, null, null, null);
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        assertEquals(sistemaATestear.getListaAlimentos().size(), 0);
    }

    @Test
    public void testAgregarMensajeConversacionListaVacia() {
        Sistema sistemaATestear = new Sistema();
        boolean pudeAgregarMensaje = sistemaATestear.agregarMensajeConversacion("Martin", "Lucia", "aa", false, false);
        assertFalse(pudeAgregarMensaje);
    }

    @Test
    public void testAgregarMensajeConversacionNull() {
        Sistema sistemaATestear = new Sistema();
        boolean pudeAgregarMensaje = sistemaATestear.agregarMensajeConversacion(null, null, "Segundo mensaje", false, false);
        assertFalse(pudeAgregarMensaje);
    }

    @Test
    public void testDevolverAlimentoNull() {
        Sistema sistemaATestear = new Sistema();
        Alimento alimentoEsperado = new Alimento(null, null, null, null);
        assertEquals(sistemaATestear.devolverAlimentoDadoNombre(null), alimentoEsperado);
    }

    @Test
    public void testDevolverAlimentoDatosVacios() {
        Sistema sistemaATestear = new Sistema();
        Alimento alimentoEsperado = new Alimento("", "", null, null);
        assertEquals(sistemaATestear.devolverAlimentoDadoNombre(""), alimentoEsperado);
    }

    @Test
    public void testDevolverAlimentoDatosCorrectos() {
        ArrayList listaAlimentos = new ArrayList<>();
        Alimento alimentoEsperado = new Alimento("Papa", "Verdura", null, null);
        listaAlimentos.add(alimentoEsperado);
        Sistema sistemaATestear = new Sistema(null, null, listaAlimentos, null, null, null);
        assertEquals(sistemaATestear.devolverAlimentoDadoNombre("Papa"), alimentoEsperado);
    }

    @Test
    public void testDevolverAlimentoDatosErroneos() {
        ArrayList listaAlimentos = new ArrayList<>();
        Alimento alimentoEsperado = new Alimento("Papa", "Verdura", null, null);
        listaAlimentos.add(alimentoEsperado);
        Sistema sistemaATestear = new Sistema(null, null, listaAlimentos, null, null, null);
        assertNotEquals(sistemaATestear.devolverAlimentoDadoNombre("Luca"), alimentoEsperado);
    }

    @Test
    public void testUsuarioDevolverPorNombreNull() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuarioEsperado = new Usuario(null, null, null, null);
        assertEquals(sistemaATestear.getProfesionalPorNombre(null), usuarioEsperado);
    }

    @Test 
    public void testProfesionalDevolverPorNombreNull() {
        Sistema sistemaATestear = new Sistema();
        Profesional profesionalEsperado = new Profesional(null, null, null, null, null, null, null);
        assertEquals(sistemaATestear.getProfesionalPorNombre(null), profesionalEsperado);
    }

    @Test
    public void testDevolverProfesionalPorNombreDatosVacios() {
        Sistema sistemaATestear = new Sistema();
        Profesional profesionalEsperado = new Profesional("", "", null, null, null, null, null);
        assertEquals(sistemaATestear.getProfesionalPorNombre(""), profesionalEsperado);
    }

    @Test
    public void testDevolverProfesionalPorNombreDatosErroneos() {
        Sistema sistemaATestear = new Sistema();
        Profesional profesionalEsperado = new Profesional("Martin", null, null, null, null, null, null);
        sistemaATestear.agregarProfesionalALaLista(profesionalEsperado);
        assertEquals(sistemaATestear.getProfesionalPorNombre("Martin"), profesionalEsperado);
    }

    @Test
    public void testDevolverUsuarioPorNombreDatosVacios() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuarioEsperado = new Usuario(null, null, null, null);
        assertEquals(sistemaATestear.getUsuarioPorNombre(""), usuarioEsperado);
    }

    @Test
    public void testDevolverUsuarioPorNombreDatosErroneos() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuario = new Usuario("Martin", "Martinez", null, null);
        sistemaATestear.agregarUsuarioALaLista(usuario);
        Usuario usuario2 = new Usuario("Martin", "Martinez", null, null);
        assertEquals(sistemaATestear.getUsuarioPorNombre("Martin Martinez"), usuario2);
    }

    @Test
    public void testAgregarPlanAlimentacionUsuarioNull() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuario1 = null;
        Profesional profesional1 = new Profesional("Juan", "Perez", null, null, null, null, null);
        assertFalse(sistemaATestear.agregarPlanSolicitado(usuario1, profesional1));
    }

    @Test
    public void testAgregarPlanAlimentacionProfesionalNull() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuario1 = new Usuario("Juan", "Perez", null, null);
        Profesional profesional1 = null;
        assertFalse(sistemaATestear.agregarPlanSolicitado(usuario1, profesional1));
    }

    @Test
    public void testAgregarPlanAlimentacionRepetidos() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuario1 = new Usuario("Juan", "Perez", null, null);
        Profesional profesional1 = new Profesional("Santiago", "Gonzalez", null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertFalse(sistemaATestear.agregarPlanSolicitado(usuario1, profesional1));
    }

    @Test
    public void testPlanesPendientes() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuario1 = new Usuario("Martin", "Gómez", null, null);
        Profesional profesional1 = new Profesional("Sandra", "Pazos", null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertEquals(sistemaATestear.getListaPlanesPendientes(profesional1).length, 1);
    }

    @Test
    public void testPlanesPendientes2() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuario1 = new Usuario("Martin", "Gómez", null, null);
        Profesional profesional1 = new Profesional("Sandra", "Pazos", null, null, null, null, null);
        Profesional profesional2 = new Profesional("Joaquin", "Bardanca", null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertEquals(sistemaATestear.getListaPlanesPendientes(profesional2).length, 0);
    }

    @Test
    public void testPlanesPendientesNull() {
        Sistema sistemaATestear = new Sistema();
        Usuario usuario1 = new Usuario("Martin", "Gómez", null, null);
        Profesional profesional1 = new Profesional("Sandra", "Pazos", null, null, null, null, null);
        sistemaATestear.agregarPlanSolicitado(usuario1, profesional1);
        assertEquals(sistemaATestear.getListaPlanesPendientes(null).length, 0);
    }

    @Test
    public void testAgregarAListaConversacionesDatosErroneos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Profesional> listaProfesionales = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        ArrayList<Conversacion> listaConversaciones = new ArrayList<>();
        Persona personaLogueada = new Usuario("Martin", null, null, null);
        Sistema sistemaATestear = new Sistema(listaUsuarios, listaProfesionales, listaAlimentos, listaPlanesAlimentacion, listaConversaciones, personaLogueada);
        Persona usuarioConversacion = new Usuario("Martin", null, null, null);
        Persona profesionalConversacion = new Profesional("Luis", null, null, null, null, null, null);
        sistemaATestear.crearConversacion(usuarioConversacion, profesionalConversacion, "Hola", true);
        boolean agregoConversacionRepetida = sistemaATestear.crearConversacion(usuarioConversacion, profesionalConversacion, "Hola", true);
        assertFalse(agregoConversacionRepetida);
    }

    @Test
    public void testAgregarIngestaDatosCorrectos() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        Ingesta ingesta1 = new Ingesta("11/02/17", null);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema();
        sistemaATestear.crearUsuario("Martin", null, null, null, null, null, null);
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(listaIngestas, "11/02/16", "Papa");
        assertTrue(retorno);
    }

    @Test
    public void testAgregarIngestaRepetida() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(new Alimento("Papa", null, null, null));
        Ingesta ingesta1 = new Ingesta("11/02/17", listaAlimentos);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema();
        sistemaATestear.crearUsuario("Martin", null, null, null, null, null, null);
        sistemaATestear.agregarIngestaAUsuario(listaIngestas, "11/02/17", "Papa");
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre("Martin");
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), "11/02/16", "Papa");
        assertTrue(retorno);
    }

    @Test
    public void testAgregarIngestaFechaRepetida() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(new Alimento("Papa", null, null, null));
        Ingesta ingesta1 = new Ingesta("11/02/17", listaAlimentos);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema();
        sistemaATestear.crearUsuario("Martin", null, null, null, null, null, null);
        sistemaATestear.agregarIngestaAUsuario(listaIngestas, "11/02/17", "Papa");
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre("Martin");
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), "11/02/17", "Papa");
        assertTrue(retorno);
    }

    @Test(expected = NullPointerException.class)
    public void testAgregarIngestaFechaNull() {
        ArrayList<Ingesta> listaIngestas = new ArrayList<>();
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(new Alimento("Papa", null, null, null));
        Ingesta ingesta1 = new Ingesta(null, listaAlimentos);
        listaIngestas.add(ingesta1);
        Sistema sistemaATestear = new Sistema();
        sistemaATestear.crearUsuario("Martin", null, null, null, null, null, null);
        sistemaATestear.agregarIngestaAUsuario(listaIngestas, null, "Papa");
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre("Martin");
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), null, "Papa");
        assertFalse(retorno);
    }

    @Test
    public void testAgregarIngestaAlimentoRepetidoFechaDistinta() {
        Sistema sistemaATestear = new Sistema();
        sistemaATestear.crearUsuario("Martin", null, null, null, null, null, null);
        Usuario user = (Usuario) sistemaATestear.getUsuarioPorNombre("Martin");
        boolean retorno = sistemaATestear.agregarIngestaAUsuario(user.getAlimentosIngeridos(), "11/02/16", "Papa");
        assertTrue(retorno);
    }

    @Test(expected = NullPointerException.class)
    public void testDevolverPlanDadoNombreNull() {
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        assertEquals(sistemaATestear.devolverPlanDadoNombre(null), new PlanAlimentacion(null, null, null, false, null));
    }

    @Test
    public void testDevolverPlanDatosValidos() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        assertEquals(sistemaATestear.devolverPlanDadoNombre("Plan"), plan1);
    }

    @Test
    public void testDevolverPlanNoPertenece() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        assertNotEquals(sistemaATestear.devolverPlanDadoNombre("Plan").getNombreDelPlan(), plan1.getNombreDelPlan());
    }

    @Test
    public void testAtenderSolicitudPlan() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan de alimentación", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, plan1.getNombreDelPlan());
        assertTrue(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanAtendidoTrue() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan de alimentación", user1, professional1, true, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, "Plan de alimentación");
        assertFalse(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanProfesionalDistinto() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan de alimentación", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        Profesional professional2 = new Profesional("Lautaro", null, null, null, null, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional2,
                user1, plan1.getNombreDelPlan());
        assertFalse(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanUsuarioDistinto() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan de alimentación", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        Usuario user2 = new Usuario("Martina", null, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user2, plan1.getNombreDelPlan());
        assertFalse(fueAtendido);
    }

    @Test
    public void testAtenderSolicitudPlanListaVacia() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan de alimentación", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        boolean fueAtendido = sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, plan1.getNombreDelPlan());
        assertFalse(fueAtendido);
    }

    @Test
    public void testListaPlanesAtendidosDatosCorrectos() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        Profesional professional1 = new Profesional("Ana", null, null, null, null, null, null);
        PlanAlimentacion plan1 = new PlanAlimentacion("Plan de alimentación", user1, professional1, false, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        listaPlanesAlimentacion.add(plan1);
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        sistemaATestear.atenderSolicitudDelPlan(plan1.getPlanDiaADia(), professional1,
                user1, plan1.getNombreDelPlan());
        boolean sonIguales = sistemaATestear.planesAtendidosDelUsuario(user1)[0].equals(plan1.getNombreDelPlan());
        assertTrue(sonIguales);
    }

    @Test
    public void testListaPlanesAtendidosListaVacia() {
        Usuario user1 = new Usuario("Martin", null, null, null);
        ArrayList<PlanAlimentacion> listaPlanesAlimentacion = new ArrayList<>();
        Sistema sistemaATestear = new Sistema(null, null, null, listaPlanesAlimentacion, null, null);
        assertEquals(sistemaATestear.planesAtendidosDelUsuario(user1).length, 0);
    }

    @Test
    public void testEnumPreferenciasCarnesBlancas() {
        String resultadoEsperado = "CARNESBLANCAS";
        assertEquals(Sistema.Preferencias.CARNESBLANCAS.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasCarnesRojas() {
        String resultadoEsperado = "CARNESROJAS";
        assertEquals(Sistema.Preferencias.CARNESROJAS.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasVerduras() {
        String resultadoEsperado = "VERDURAS";
        assertEquals(Sistema.Preferencias.VERDURAS.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasFrutas() {
        String resultadoEsperado = "FRUTAS";
        assertEquals(Sistema.Preferencias.FRUTAS.name(), resultadoEsperado);
    }

    @Test
    public void testEnumPreferenciasHarinas() {
        String resultadoEsperado = "HARINAS";
        assertEquals(Sistema.Preferencias.HARINAS.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesDiabetes() {
        String resultadoEsperado = "DIABETES";
        assertEquals(Sistema.Restricciones.DIABETES.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesVeganismo() {
        String resultadoEsperado = "VEGANISMO";
        assertEquals(Sistema.Restricciones.VEGANISMO.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesIntoleranciaLactosa() {
        String resultadoEsperado = "INTOLERANCIALACTOSA";
        assertEquals(Sistema.Restricciones.INTOLERANCIALACTOSA.name(), resultadoEsperado);
    }

    @Test
    public void testEnumRestriccionesHarinas() {
        String resultadoEsperado = "CELIAQUIA";
        assertEquals(Sistema.Restricciones.CELIAQUIA.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaJueves() {
        String resultadoEsperado = "JUEVES";
        assertEquals(Sistema.DiasDeLaSemana.JUEVES.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaViernes() {
        String resultadoEsperado = "VIERNES";
        assertEquals(Sistema.DiasDeLaSemana.VIERNES.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaSabado() {
        String resultadoEsperado = "SABADO";
        assertEquals(Sistema.DiasDeLaSemana.SABADO.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaDomingo() {
        String resultadoEsperado = "DOMINGO";
        assertEquals(Sistema.DiasDeLaSemana.DOMINGO.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaMiercoles() {
        String resultadoEsperado = "MIERCOLES";
        assertEquals(Sistema.DiasDeLaSemana.MIERCOLES.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaMartes() {
        String resultadoEsperado = "MARTES";
        assertEquals(Sistema.DiasDeLaSemana.MARTES.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDiasSemanaLunes() {
        String resultadoEsperado = "LUNES";
        assertEquals(Sistema.DiasDeLaSemana.LUNES.name(), resultadoEsperado);
    }

    @Test
    public void testEnumIngestasDiaDesayuno() {
        String resultadoEsperado = "DESAYUNO";
        assertEquals(Sistema.IngestasPorDia.DESAYUNO.name(), resultadoEsperado);
    }

    @Test
    public void testEnumIngestasDiaAlmuerzo() {
        String resultadoEsperado = "ALMUERZO";
        assertEquals(Sistema.IngestasPorDia.ALMUERZO.name(), resultadoEsperado);
    }

    @Test
    public void testEnumIngestasDiaCena() {
        String resultadoEsperado = "CENA";
        assertEquals(Sistema.IngestasPorDia.CENA.name(), resultadoEsperado);
    }

    @Test
    public void testEnumDevolverListaIngestas() {
        Sistema sistemaATestear = new Sistema();
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("DESAYUNO");
        listaEsperada.add("ALMUERZO");
        listaEsperada.add("CENA");
        assertEquals(sistemaATestear.devolverListaIngestasDeLaSemana(), listaEsperada);
    }


    @Test
    public void testEnumDevolverListaDiasDeLaSemana() {
        Sistema sistemaATestear = new Sistema();
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("LUNES");
        listaEsperada.add("MARTES");
        listaEsperada.add("MIERCOLES");
        listaEsperada.add("JUEVES");
        listaEsperada.add("VIERNES");
        listaEsperada.add("SABADO");
        listaEsperada.add("DOMINGO");
        assertEquals(sistemaATestear.devolverListaDiasDeLaSemana(), listaEsperada);
    }
    
    @Test
    public void testEnumDevolverListaDePaises(){
        Sistema sistemaATestear = new Sistema();
        assertEquals(sistemaATestear.devolverListaPaises().size(), 26);
    }
    
    @Test
    public void testCambiarFotoDeUsuario(){
        Sistema sistemaATestear = new Sistema();
        sistemaATestear.crearUsuario("Santiago", "Perez", "", "", null, null, null);
        Usuario user = sistemaATestear.getUsuarioPorNombre("Santiago Perez");
        sistemaATestear.cambiarFotoUsuario("Santiago", "Perez", new ImageIcon(getClass()
                        .getResource("/Imagenes/fotoDeUsuarioStandard.png")));
        assertEquals(new ImageIcon(getClass()
                        .getResource("/Imagenes/fotoDeUsuarioStandard.png")).getImage(), user.getFotoDePerfil().getImage());
    }
    
    @Test
    public void testAgregarProfesionalNull(){
        Sistema sistemaATestear = new Sistema();
        Profesional prof = null;
        assertFalse(sistemaATestear.agregarProfesionalALaLista(prof));
    }
    
    @Test
    public void testCrearProfesional(){
        Sistema sistemaATestear = new Sistema();
        assert(sistemaATestear.crearProfesional("Santiago", "Perez", "", null, "", "", ""));
    }
    
    @Test
    public void testCrearAlimento(){
        Sistema sistemaATestear = new Sistema();
        assert(sistemaATestear.crearAlimento("Carne", "", new ArrayList<>(), null));
    }
    
    @Test
    public void testAgregarAlimentoNull(){
        Sistema sistemaATestear = new Sistema();
        assertFalse(sistemaATestear.agregarAlimentoALaLista(null));
    }
    
    @Test
    public void testCrearConversacionConCambio(){
        Sistema sistemaATestear = new Sistema();
        Usuario user = new Usuario("Santiago", "Perez", "", "");
        Profesional prof = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        sistemaATestear.agregarProfesionalALaLista(prof);
        assert(sistemaATestear.crearConversacion(user, prof, "Test", true));
    }
    
    
    @Test
    public void testCrearConversacionSinCambio(){
        Sistema sistemaATestear = new Sistema();
        Usuario user = new Usuario("Santiago", "Perez", "", "");
        Profesional prof = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        sistemaATestear.agregarProfesionalALaLista(prof);
        assert(sistemaATestear.crearConversacion(user, prof, "Test", false));
    }
    
    @Test
    public void testGetProfesionalesConversacion(){
        Sistema sistemaATestear = new Sistema();
        Usuario user = new Usuario("Santiago", "Perez", "", "");
        Profesional prof = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        sistemaATestear.agregarProfesionalALaLista(prof);
        sistemaATestear.crearConversacion(user, prof, "Test", true);
        
        assertEquals(sistemaATestear.getListaNombresProfesionalesConversaciones("Juan Bordagorry").length, 1);
    }
    
    @Test
    public void testGetUsuariosConversacion(){
        Sistema sistemaATestear = new Sistema();
        Usuario user = new Usuario("Santiago", "Perez", "", "");
        Profesional prof = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        sistemaATestear.agregarProfesionalALaLista(prof);
        sistemaATestear.crearConversacion(user, prof, "Test", true);
        
        assertEquals(sistemaATestear.getListaNombresUsuariosConversacionesPendientes("Juan Bordagorry").length,1);
    }
    
    @Test
    public void testGetConversacion(){
        Sistema sistemaATestear = new Sistema();
        Usuario user = new Usuario("Santiago", "Perez", "", "");
        Profesional prof = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        sistemaATestear.agregarProfesionalALaLista(prof);
        sistemaATestear.crearConversacion(user, prof, "Test", true);
        
        assertEquals(sistemaATestear.getConversacion("Juan Bordagorry", "Santiago Perez"), "\nSantiago Perez\nTest\n");
    }
    
    @Test
    public void testAgregarMensajeUserAProf(){
        Sistema sistemaATestear = new Sistema();
        Usuario user = new Usuario("Santiago", "Perez", "", "");
        Profesional prof = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        sistemaATestear.agregarProfesionalALaLista(prof);
        sistemaATestear.crearConversacion(user, prof, "Test", true);
        assert(sistemaATestear.agregarMensajeConversacion("Santiago Perez", "Juan Bordagorry", "Testcito", true, true));
    }
    
        
    @Test
    public void testAgregarMensajeProfAUser(){
        Sistema sistemaATestear = new Sistema();
        Usuario user = new Usuario("Santiago", "Perez", "", "");
        Profesional prof = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        sistemaATestear.agregarProfesionalALaLista(prof);
        sistemaATestear.crearConversacion(user, prof, "Test", true);
        assert(sistemaATestear.agregarMensajeConversacion( "Juan Bordagorry","Santiago Perez", "Testcito", true, true));
    }
    
    @Test
    public void testNombresProfesionalesSinConsulta(){
        Sistema sistemaATestear = new Sistema();    
        Profesional prof1 = new Profesional("Juan", "Bordagorry", "", null, "", "", "");
        Profesional prof2 = new Profesional("Santiago", "Perez", "", null, "", "", "");
        sistemaATestear.agregarProfesionalALaLista(prof1);
        sistemaATestear.agregarProfesionalALaLista(prof2);
        Usuario user = new Usuario("Juan", "Perez", "", "");
        sistemaATestear.agregarUsuarioALaLista(user);
        
        sistemaATestear.crearConversacion(user, prof1, "Test", true);
        
        assertEquals(prof2, sistemaATestear.getNombresProfesionalesSinConversacionConUsuario(user).get(0));
        
    }
}

package dominio;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ImageIcon;

public final class Sistema implements Serializable {

    private List<Usuario> listaUsuarios;
    private List<Profesional> listaProfesionales;
    private List<Alimento> listaAlimentos;
    private List<PlanAlimentacion> listaPlanesAlimentacion;
    private List<Conversacion> listaConversaciones;
    private Persona personaLogueada;

    public Sistema(List<Usuario> unaListaUsuarios,
            List<Profesional> unaListaProfesionales,
            List<Alimento> unaListaAlimentos,
            List<PlanAlimentacion> unaListaPlanesAlimentacion,
            List<Conversacion> unaListaConversaciones,
            Persona personaLogueada) {

        setListaUsuarios(unaListaUsuarios);
        setListaProfesionales(unaListaProfesionales);
        setListaAlimentos(unaListaAlimentos);
        setListaConversaciones(unaListaConversaciones);
        setListaPlanesAlimentacion(unaListaPlanesAlimentacion);
        setPersonaLogueada(personaLogueada);
    }

    public Sistema() {
        setListaUsuarios(new ArrayList<>());
        setListaProfesionales(new ArrayList<>());
        setListaAlimentos(new ArrayList<>());
        setListaConversaciones(new ArrayList<>());
        setListaPlanesAlimentacion(new ArrayList<>());
        setPersonaLogueada(new Usuario("Nombre", "Apellido", "",
                                ""));

    }

    public Persona getPersonaLogueada() {
        return personaLogueada;
    }

    public void setPersonaLogueada(Persona personaLogueada) {
        this.personaLogueada = personaLogueada;

    }

    public List<Conversacion> getListaConversaciones() {
        return this.listaConversaciones;
    }

    public void setListaConversaciones(
            List<Conversacion> unaListaConversaciones) {
        if (unaListaConversaciones == null) {
            this.listaConversaciones = new ArrayList<>();
        } else {
            this.listaConversaciones = unaListaConversaciones;
        }
    }

    public List<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> unaListaUsuarios) {
        if (unaListaUsuarios == null) {
            this.listaUsuarios = new ArrayList<>();
        } else {
            this.listaUsuarios = unaListaUsuarios;
        }
    }

    public List<Profesional> getListaProfesionales() {
        return this.listaProfesionales;
    }

    public void setListaProfesionales(List<Profesional> unaListaProfesionales) {
        if (unaListaProfesionales == null) {
            this.listaProfesionales = new ArrayList<>();
        } else {
            this.listaProfesionales = unaListaProfesionales;
        }
    }

    public List<Alimento> getListaAlimentos() {
        return this.listaAlimentos;
    }

    public void setListaAlimentos(List<Alimento> unaListaAlimentos) {
        if (unaListaAlimentos == null) {
            this.listaAlimentos = new ArrayList<>();
        } else {
            this.listaAlimentos = unaListaAlimentos;
        }
    }

    public List<PlanAlimentacion> getListaPlanesAlimentacion() {
        return this.listaPlanesAlimentacion;
    }

    public void setListaPlanesAlimentacion(
            List<PlanAlimentacion> unaListaPlanesAlimentacion) {
        if (unaListaPlanesAlimentacion == null) {
            this.listaPlanesAlimentacion = new ArrayList<>();
        } else {
            this.listaPlanesAlimentacion = unaListaPlanesAlimentacion;
        }
    }

    public enum Preferencias {
        CARNESROJAS, CARNESBLANCAS, VERDURAS, FRUTAS, HARINAS;
    }

    public enum Restricciones {
        DIABETES, VEGANISMO, INTOLERANCIALACTOSA, CELIAQUIA;
    }

    public enum Paises {
        ARGENTINA, BOLIVIA, BRASIL, CHILE, COLOMBIA, COSTARICA, CUBA, ECUADOR,
        ELSALVADOR, GUAYANAFRANCESA, GRANADA, GUATEMALA, GUAYANA, HAITI,
        HONDURAS, JAMAICA, MEXICO, NICARAGUA, PARAGUAY, PANAMA, PERU,
        PUERTORICO, REPUBLICADOMINICANA, SURINAM, URUGUAY, VENEZUELA;
    }

    public enum DiasDeLaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
    }

    public enum IngestasPorDia {
        DESAYUNO, ALMUERZO, CENA;
    }

    public List<String> devolverListaPaises() {
        return Stream.of(Paises.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public List<String> devolverListaDiasDeLaSemana() {
        return Stream.of(DiasDeLaSemana.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public List<String> devolverListaIngestasDeLaSemana() {
        return Stream.of(IngestasPorDia.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public void guardarDatosSistema() {
        try {
            FileOutputStream archivo = new FileOutputStream("Sistema.data");
            BufferedOutputStream buffer = new BufferedOutputStream(archivo);
            try (ObjectOutputStream objetoASerializar
                    = new ObjectOutputStream(buffer)) {
                objetoASerializar.writeObject(this);
                objetoASerializar.flush();
            }
        } catch (IOException e) {
            Logger.getGlobal().log(Level.SEVERE,"Error guardando datos del sistema");
        }
    }

    public boolean crearUsuario(String nombre, String apellido,
            String fechaNacimiento, 
            String nacionalidad, List<String> preferencias,
            List<String> restricciones, List<Ingesta> alimentosIngeridos, Optional<String> key) {
        Usuario usuarioNuevo;
        usuarioNuevo = new Usuario(nombre, apellido, fechaNacimiento,
                nacionalidad);
        usuarioNuevo.setPreferencias(preferencias);
        usuarioNuevo.setRestricciones(restricciones);
        usuarioNuevo.setAlimentosIngeridos(alimentosIngeridos);
        usuarioNuevo.setPasswordKey(key);
        return agregarUsuarioALaLista(usuarioNuevo);
    }
    
    public void cambiarFotoUsuario(String nombre, String apellido, ImageIcon foto){
        Usuario user = listaUsuarios.stream().filter(u -> u.getApellido().equals(apellido) && u.getNombre().equals(nombre)).collect(Collectors.toList()).get(0);
        user.setFotoDePerfil(foto);
    }

    public boolean agregarUsuarioALaLista(Usuario usuarioARegistrar) {
        boolean fueAgregadoUsuario = false;
        if ((usuarioARegistrar != null) && !getListaUsuarios()
                .contains(usuarioARegistrar)) {
            getListaUsuarios().add(usuarioARegistrar);
            fueAgregadoUsuario = true;
        }
        return fueAgregadoUsuario;
    }

    public boolean crearProfesional(String nombre, String apellido,
            String fechaNacimiento, ImageIcon fotoPerfil,
            String tituloProfesional, String fechaGraduacion,
            String paisGraduacion, Optional<String> key) {
        Profesional profesionalNuevo = new Profesional(nombre, apellido,
                fechaNacimiento, fotoPerfil, tituloProfesional,
                fechaGraduacion, paisGraduacion);
        profesionalNuevo.setPasswordKey(key);
        return agregarProfesionalALaLista(profesionalNuevo);
    }

    public boolean agregarProfesionalALaLista(
            Profesional profesionalARegistrar) {
        if ((profesionalARegistrar != null)
                && !getListaProfesionales().contains(profesionalARegistrar)) {
            getListaProfesionales().add(profesionalARegistrar);
            return true;
        }
        return false;
    }

    public boolean crearAlimento(String nombre, String tipoAlimento,
            List<ComposicionAlimento> listaNutrientesConProporcion,
            ImageIcon fotoDelAlimento) {
        Alimento an = new Alimento(nombre, tipoAlimento,
                listaNutrientesConProporcion, fotoDelAlimento);
        return agregarAlimentoALaLista(an);
    }

    public boolean agregarAlimentoALaLista(Alimento alimentoAAgregar) {
        if (alimentoAAgregar != null && !getListaAlimentos().contains(alimentoAAgregar)) {
            getListaAlimentos().add(alimentoAAgregar);
            return true;
        }
        return false;
    }

    public boolean crearConversacion(Persona usuario, Persona profesional, String mensaje, boolean usuarioEsRemitente) {
        boolean fueAgregadaConversacion = false;
        if (usuario != null && profesional != null && mensaje != null && !mensaje.isEmpty()) {
            InformacionMensaje info;
            if (usuarioEsRemitente) {
                info = new InformacionMensaje(usuario.getNombreCompleto(), profesional.getNombreCompleto(), mensaje);
            } else {
                info = new InformacionMensaje(profesional.getNombreCompleto(), usuario.getNombreCompleto(), mensaje);
            }
            if (listaUsuarios.contains((Usuario) usuario) && listaProfesionales.contains((Profesional) profesional)) {
                ArrayList<InformacionMensaje> listaMensajes = new ArrayList<>();
                listaMensajes.add(info);
                Conversacion nuevaConversacion = new Conversacion(usuario, profesional, listaMensajes);
                fueAgregadaConversacion = agregarConversacionALaLista(nuevaConversacion);
            }
        }
        return fueAgregadaConversacion;
    }

    private boolean agregarConversacionALaLista(Conversacion nuevaConversacion) {
        boolean fueAgregadaConversacion = false;
        if (!getListaConversaciones().contains(nuevaConversacion)) {
            getListaConversaciones().add(nuevaConversacion);
            fueAgregadaConversacion = true;
        }
        return fueAgregadaConversacion;
    }

    public String[] getListaNombresProfesionalesConversaciones(String nombreUsuarioConversacion) {
        String[] nombresProfesionales = new String[getListaConversaciones().size()];
        ArrayList<String> nombresIngresados = new ArrayList<>();
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            String nombreCompleto = getListaConversaciones().get(i).getProfesional().getNombreCompleto();
            String nombreUsuarioCompleto = getListaConversaciones().get(i).getUsuario().getNombreCompleto();
            if (!nombresIngresados.contains(nombreCompleto) && nombreUsuarioCompleto.equals(nombreUsuarioConversacion)) {
                nombresProfesionales[i] = nombreCompleto;
                nombresIngresados.add(nombreCompleto);
            }
        }
        return nombresProfesionales;
    }

    public String[] getListaNombresUsuariosConversacionesPendientes(String profesional) {
        ArrayList<String> nombresIngresados = new ArrayList<>();
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            String nombreCompleto = getListaConversaciones().get(i).getUsuario().getNombreCompleto();
            String nombreProfesional = getListaConversaciones().get(i).getProfesional().getNombreCompleto();
            if (!nombresIngresados.contains(nombreCompleto) && 
                    profesional.equals(nombreProfesional) && 
                    !getListaConversaciones().get(i).getFueAtendidaConsulta()) {
                nombresIngresados.add(nombreCompleto);
            }
        }
        String[] nombreUsuarios = new String[nombresIngresados.size()];
        for (int i = 0; i < nombreUsuarios.length; i++) {
            nombreUsuarios[i] = nombresIngresados.get(i);
        }
        return nombreUsuarios;
    }

    public String getConversacion(String nombreCompletoProfesional, String nombreCompletoUsuario) {
        String retorno = "No hay conversación disponible.";
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            Conversacion conversacionActual = getListaConversaciones().get(i);
            String nombreCompletoProfesionalActual = conversacionActual.getProfesional().getNombreCompleto();
            String nombreUsuarioActual = conversacionActual.getUsuario().getNombreCompleto();
            if (nombreCompletoProfesionalActual.equals(nombreCompletoProfesional) && nombreUsuarioActual.equals(nombreCompletoUsuario)) {
                return conversacionActual.toString();
            }
        }
        return retorno;
    }

    public boolean agregarMensajeConversacion(String remitente, String destinatario, String mensaje, boolean intercambioRemitente, boolean consultaRespondida) {
        boolean pudeAgregarMensaje = false;
        if (remitente != null && !remitente.isEmpty() && destinatario != null && !destinatario.isEmpty()) {
            for (int i = 0; getListaConversaciones() != null && i < getListaConversaciones().size(); i++) {
                Conversacion conversacionActual = getListaConversaciones().get(i);
                String nombreApellidoProfesional = conversacionActual.getProfesional().getNombreCompleto();
                String nombreApellidoUsuario = conversacionActual.getUsuario().getNombreCompleto();
                if (destinatario.equals(nombreApellidoProfesional) && remitente.equals(nombreApellidoUsuario)
                        || destinatario.equals(nombreApellidoUsuario) && remitente.equals(nombreApellidoProfesional)) {
                    conversacionActual.agregarMensaje(mensaje, intercambioRemitente);
                    conversacionActual.setFueAtendidaConsulta(consultaRespondida);
                    pudeAgregarMensaje = true;
                }
            }
        }
        return pudeAgregarMensaje;
    }

    public List getNombresProfesionalesSinConversacionConUsuario(Persona personaLogueada) {
        List retorno = copiarLista(getListaProfesionales());
        for (int i = 0; i < getListaConversaciones().size(); i++) {
            Profesional profActual = (Profesional) getListaConversaciones().get(i).getProfesional();
            Persona usuarioActual = getListaConversaciones().get(i).getUsuario();
            if (usuarioActual.equals(personaLogueada)) {
                retorno.remove(profActual);
            }
        }
        return retorno;
    }

    private List copiarLista(List lista) {
        ArrayList nueva = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            nueva.add(lista.get(i));
        }
        return nueva;
    }

    public boolean agregarIngestaAUsuario(List<Ingesta> listaIngestasDelUsuario, String fechaIngesta, String nuevoAlimento) {
        boolean ingestaAgregada = false;
        if (listaIngestasDelUsuario != null) {

            if (yaExisteIngestaEnEsaFecha(listaIngestasDelUsuario, fechaIngesta)) {
                for (int i = 0; i < listaIngestasDelUsuario.size(); i++) {
                    if (listaIngestasDelUsuario.get(i).getFechaDeIngesta().equals(fechaIngesta)) {
                        List<Alimento> listaAlimentosActual = listaIngestasDelUsuario.get(i).getListaAlimentosPorFecha();
                        Alimento alimentoAAgregar = devolverAlimentoDadoNombre(nuevoAlimento);
                        listaAlimentosActual.add(alimentoAAgregar);
                    }
                }
            } else {
                Alimento alimentoAAgregar = devolverAlimentoDadoNombre(nuevoAlimento);
                ArrayList<Alimento> nuevaLista = new ArrayList<>();
                nuevaLista.add(alimentoAAgregar);
                Ingesta nuevaIngesta = new Ingesta(fechaIngesta, nuevaLista);
                listaIngestasDelUsuario.add(nuevaIngesta);
            }
            ingestaAgregada = true;

        }
        return ingestaAgregada;
    }

    private boolean yaExisteIngestaEnEsaFecha(List<Ingesta> listaIngestasDelUsuario, String fechaIngesta) {
        boolean existe = false;
        if (listaIngestasDelUsuario != null) {
            for (int i = 0; i < listaIngestasDelUsuario.size(); i++) {
                if (listaIngestasDelUsuario.get(i).getFechaDeIngesta().equals(fechaIngesta)) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public Alimento devolverAlimentoDadoNombre(String nuevoAlimento) {
        Alimento alimentoRetorno = new Alimento(null, null, null, null);
        for (int i = 0; i < this.listaAlimentos.size(); i++) {
            String alimentoActual = this.listaAlimentos.get(i).getNombre();
            if (alimentoActual.equals(nuevoAlimento)) {
                alimentoRetorno = this.listaAlimentos.get(i);
            }
        }
        return alimentoRetorno;
    }

    public Usuario getUsuarioPorNombre(String nombreCompleto) {
        Usuario usuarioRetorno = new Usuario(null, null, null, null);
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            String nombreActual = this.listaUsuarios.get(i).getNombreCompleto();
            if (nombreActual.equals(nombreCompleto)) {
                usuarioRetorno = this.listaUsuarios.get(i);
            }
        }
        return usuarioRetorno;
    }

    public Profesional getProfesionalPorNombre(String nombreCompleto) {
        Profesional profesionalRetorno = new Profesional(null, null, null, null, null, null, null);
        for (int i = 0; i < this.listaProfesionales.size(); i++) {
            String nombreActual = this.listaProfesionales.get(i).getNombreCompleto();
            if (nombreActual.equals(nombreCompleto)) {
                profesionalRetorno = this.listaProfesionales.get(i);
            }
        }
        return profesionalRetorno;
    }

    public boolean agregarPlanSolicitado(Usuario usuario, Profesional profesional) {
        boolean agreguePlan = false;
        if (usuario != null && profesional != null) {
            PlanAlimentacion planNuevo = new PlanAlimentacion("", usuario, profesional, false, null);
            if (!getListaPlanesAlimentacion().contains(planNuevo)) {
                this.getListaPlanesAlimentacion().add(planNuevo);
                agreguePlan = true;
            }
        }
        return agreguePlan;

    }

    public boolean atenderSolicitudDelPlan(String[][] planAlimentacion,
            Profesional profesional,
            Usuario usuario,
            String nombrePlan) {
        boolean fueAtendido = false;
        for (int i = 0; i < this.listaPlanesAlimentacion.size(); i++) {
            PlanAlimentacion actual = this.listaPlanesAlimentacion.get(i);
            if (actual.getProfesional().equals(profesional) && actual.getUsuario().equals(usuario)
                    && !actual.getFueAtendidoElPlan()) {
                actual.setNombreDelPlan(nombrePlan);
                actual.setPlanDiaADia(planAlimentacion);
                actual.setFueAtendidoElPlan(true);
                fueAtendido = true;
            }
        }
        return fueAtendido;
    }

    public String[] planesAtendidosDelUsuario(Usuario usuario) {
        ArrayList<String> listaAuxiliar = new ArrayList<>();
        for (int i = 0; i < this.listaPlanesAlimentacion.size(); i++) {
            PlanAlimentacion actual = this.listaPlanesAlimentacion.get(i);
            if (actual.getUsuario().equals(usuario) && actual.getFueAtendidoElPlan()) {
                listaAuxiliar.add(actual.getNombreDelPlan());
            }
        }
        String[] planesDelUsuario = new String[listaAuxiliar.size()];
        for (int i = 0; i < planesDelUsuario.length; i++) {
            planesDelUsuario[i] = listaAuxiliar.get(i);
        }
        return planesDelUsuario;
    }

    public PlanAlimentacion devolverPlanDadoNombre(String np) {
        PlanAlimentacion planRetorno = new PlanAlimentacion(null, null, null, false, null);
        if (np != null) {
            for (int i = 0; i < this.listaPlanesAlimentacion.size(); i++) {
                String nombrePlanActual = this.listaPlanesAlimentacion.get(i).getNombreDelPlan();
                if (nombrePlanActual.equals(np)) {
                    planRetorno = this.listaPlanesAlimentacion.get(i);
                }
            }
        }

        return planRetorno;
    }

    public String[] getListaPlanesPendientes(Profesional profesional) {
        if (profesional != null) {
            ArrayList<String> planesPendientes = new ArrayList<>();
            for (int i = 0; i < this.listaPlanesAlimentacion.size(); i++) {
                Profesional profesionalActual = this.listaPlanesAlimentacion.get(i).getProfesional();
                boolean fueAtendidoPlanActual = this.listaPlanesAlimentacion.get(i).getFueAtendidoElPlan();
                if (profesionalActual.equals(profesional) && !fueAtendidoPlanActual) {
                    String nombreUsuario = this.listaPlanesAlimentacion.get(i).getUsuario().getNombreCompleto();
                    planesPendientes.add(nombreUsuario);
                }
            }
            String[] nombreUsuarios = new String[planesPendientes.size()];
            for (int i = 0; i < nombreUsuarios.length; i++) {
                nombreUsuarios[i] = planesPendientes.get(i);
            }
            return nombreUsuarios;
        } else {
            return new String[0];
        }
    }
}

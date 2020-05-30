package dominio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public final class Usuario extends Persona {

    private String nacionalidad;
    private List<String> preferencias;
    private List<String> restricciones;
    public List<Ingesta> alimentosIngeridos;

    public Usuario(String unNombre,
            String unApellido,
            String unaFechaNacimiento,
            ImageIcon unaFotoDePerfil,
            String unaNacionalidad) {

        this.setNombre(unNombre);
        this.setApellido(unApellido);
        this.setFechaNacimiento(unaFechaNacimiento);
        this.setFotoDePerfil(unaFotoDePerfil);
        this.setNacionalidad(unaNacionalidad);
        this.setPreferencias(new ArrayList<>());
        this.setRestricciones(new ArrayList<>());
        this.setAlimentosIngeridos(new ArrayList<>());
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String unaNacionalidad) {
       
        nacionalidad = unaNacionalidad;
       
    }

    public List<String> getPreferencias() {
        return this.preferencias;
    }

    public void setPreferencias(List<String> listaPreferencias) {
        if (listaPreferencias == null) {
            this.preferencias = new ArrayList<>();
        } else {
            this.preferencias = listaPreferencias;
        }
    }

    public List<String> getRestricciones() {
        return this.restricciones;
    }

    public void setRestricciones(List<String> listaRestricciones) {
        if (listaRestricciones == null) {
            this.restricciones = new ArrayList<>();
        } else {
            this.restricciones = listaRestricciones;
        }
    }

    public List<Ingesta> getAlimentosIngeridos() {
        return this.alimentosIngeridos;
    }

    public void setAlimentosIngeridos(List<Ingesta> listaAlimentos) {
        if (listaAlimentos == null) {
            this.alimentosIngeridos = new ArrayList<>();
        } else {
            this.alimentosIngeridos = listaAlimentos;
        }

    }

    public String[] getArrayAlimentosIngeridos() {
        String[] retorno = new String[getAlimentosIngeridos().size()];
        for (int i = 0; i < getAlimentosIngeridos().size(); i++) {
            retorno[i] = getAlimentosIngeridos().get(i).toString();
        }
        return retorno;
    }

    public String[] getArrayRestricciones() {
        String[] retorno = new String[getRestricciones().size()];
        for (int i = 0; i < getRestricciones().size(); i++) {
            retorno[i] = getRestricciones().get(i);
        }
        return retorno;
    }

    public String[] getArrayPreferencias() {
        String[] retorno = new String[getPreferencias().size()];
        for (int i = 0; i < getPreferencias().size(); i++) {
            retorno[i] = getPreferencias().get(i);
        }
        return retorno;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void actualizarPreferenciasUsuario(Usuario usuario, List<String> preferencias) {
        usuario.setPreferencias(preferencias);
    }

    public void actualizarRestriccionesUsuario(Usuario usuario, List<String> restricciones) {
        usuario.setRestricciones(restricciones);
    }
}

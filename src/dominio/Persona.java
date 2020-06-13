package dominio;

import java.io.Serializable;
import java.util.Optional;

import javax.swing.ImageIcon;

public abstract class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    public ImageIcon fotoDePerfil;
    private Optional<String> passwordKey;

    public static String surnameError = "Apellido no ingresado";
    public static String nameError = "Nombre no ingresado";

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String unApellido) {
        if (unApellido == null || unApellido.isEmpty()) {
            this.apellido = surnameError;
        } else {
            this.apellido = unApellido;
        }
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String unaFecha) {
        if (unaFecha == null || unaFecha.isEmpty()) {
            this.fechaNacimiento = "Fecha no ingresada";
        } else {
            this.fechaNacimiento = unaFecha;
        }
    }

    public ImageIcon getFotoDePerfil() {
        return this.fotoDePerfil;
    }

    public void setFotoDePerfil(ImageIcon foto) {
        if (foto == null) {
            this.fotoDePerfil = new ImageIcon(getClass().getResource("/Imagenes/fotoDeUsuarioStandard.png"));
        } else {
            this.fotoDePerfil = foto;
        }
    }

    public String getNombreCompleto() {
        String retorno;
        if (getNombre().equals(nameError) && getApellido().equals(surnameError)) {
            retorno = nameError;
        } else {
            if (!getNombre().equals(nameError)) {
                if (getApellido().equals(surnameError)) {
                    retorno = getNombre();
                } else {
                    retorno = getNombre() + " " + getApellido();
                }
            } else {
                retorno = getApellido();
            }
        }
        return retorno;
    }

    public Optional<String> getPasswordKey() {
      return passwordKey;
    }

    public void setPasswordKey(Optional<String> passwordKey) {
      this.passwordKey = passwordKey;
    }

    @Override
    public String toString() {
        return this.getNombreCompleto();
    }

    @Override
    public boolean equals(Object obj) {
        Persona otraPersona;

        if (obj != null) {
            otraPersona = (Persona) obj;
        } else {
            throw new NullPointerException("equals recibe Null");
        }

        return this.getNombreCompleto().equals(otraPersona.getNombreCompleto());
    }
}

package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Ingesta implements Serializable {

    public String fechaDeIngesta;
    private List<Alimento> listaAlimentosPorFecha;

    public Ingesta(String f, List<Alimento> listaAlimentos) {
        setFechaDeIngesta(f);
        setLAPF(listaAlimentos);
    }

    public String getFechaDeIngesta() {
        return this.fechaDeIngesta;
    }

    public void setFechaDeIngesta(String unaFecha) {
        this.fechaDeIngesta = unaFecha;
    }

    public List<Alimento> getListaAlimentosPorFecha() {
        if (this.listaAlimentosPorFecha.isEmpty()) {
            return new ArrayList<>();
        } else {
            return this.listaAlimentosPorFecha;
        }
    }

    public void setLAPF(List<Alimento> list) {
        if (list == null || list.isEmpty()) {
            this.listaAlimentosPorFecha = new ArrayList<>();
        } else {
            this.listaAlimentosPorFecha = list;
        }
    }

    @Override
    public String toString() {
        if (this.listaAlimentosPorFecha.isEmpty()) {
            return "No hay alimentos ingeridos";
        } else {
            return "Lista de alimentos ingeridos" + this.getListaAlimentosPorFecha();
        }
    }

    @Override
    public boolean equals(Object obj) {
        Ingesta otraIngesta;
        
        if (obj != null) {
          otraIngesta = (Ingesta) obj;
        } else {
          throw new NullPointerException("equals recibe Null");
        }
        
        boolean sonIguales = this.getFechaDeIngesta().equals(otraIngesta.getFechaDeIngesta());
        sonIguales = sonIguales && this.getListaAlimentosPorFecha().equals(otraIngesta.getListaAlimentosPorFecha());
        return sonIguales;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fechaDeIngesta, listaAlimentosPorFecha);
    }

}

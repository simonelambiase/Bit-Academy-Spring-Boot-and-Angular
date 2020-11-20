package it.simonelambiase.www.springAcademy.springAcademy.model.objects;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferenzeCorso {
    private Integer idCorso;
    private List<OrarioCorso> orariCorso;

    public PreferenzeCorso(Integer idCorso, List<OrarioCorso> orariCorso) {
        this.idCorso = idCorso;
        this.orariCorso = orariCorso;
    }

    public Integer getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(Integer idCorso) {
        this.idCorso = idCorso;
    }

    public List<OrarioCorso> getOrariCorso() {
        return orariCorso;
    }

    public void setOrariCorso(List<OrarioCorso> orariCorso) {
        this.orariCorso = orariCorso;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PreferenzeCorso{");
        sb.append("idCorso=").append(idCorso);
        sb.append(", orariCorso=").append(orariCorso);
        sb.append('}');
        return sb.toString();
    }
}

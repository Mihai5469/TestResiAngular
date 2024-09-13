package org.testresi.testresiangular.DBobjects;

import java.io.Serializable;
import java.util.Date;


public class AnaArticolo implements Serializable {

    private long anaArticoloId;
    private String codAzienda;
    private String codMagazzino;
    private String codArticolo;
    private String desArticolo;
    private boolean annullamentoLogico;
    private Date timeCreazione;
    private String utenteCreazione;
    private String programmaCreazione;
    private Date timeAggiornamento;
    private String utenteAggiornamento;
    private String programmaAggiornamento;
    private int version;

    public long getAnaArticoloId() {
        return anaArticoloId;
    }

    public void setAnaArticoloId(long anaArticoloId) {
        this.anaArticoloId = anaArticoloId;
    }

    public String getCodAzienda() {
        return codAzienda;
    }

    public void setCodAzienda(String codAzienda) {
        this.codAzienda = codAzienda;
    }

    public String getCodMagazzino() {
        return codMagazzino;
    }

    public void setCodMagazzino(String codMagazzino) {
        this.codMagazzino = codMagazzino;
    }

    public String getCodArticolo() {
        return codArticolo;
    }

    public void setCodArticolo(String codArticolo) {
        this.codArticolo = codArticolo;
    }

    public String getDesArticolo() {
        return desArticolo;
    }

    public void setDesArticolo(String desArticolo) {
        this.desArticolo = desArticolo;
    }

    public boolean isAnnullamentoLogico() {
        return annullamentoLogico;
    }

    public void setAnnullamentoLogico(boolean annullamentoLogico) {
        this.annullamentoLogico = annullamentoLogico;
    }

    public Date getTimeCreazione() {
        return timeCreazione;
    }

    public void setTimeCreazione(Date timeCreazione) {
        this.timeCreazione = timeCreazione;
    }

    public String getUtenteCreazione() {
        return utenteCreazione;
    }

    public void setUtenteCreazione(String utenteCreazione) {
        this.utenteCreazione = utenteCreazione;
    }

    public String getProgrammaCreazione() {
        return programmaCreazione;
    }

    public void setProgrammaCreazione(String programmaCreazione) {
        this.programmaCreazione = programmaCreazione;
    }

    public Date getTimeAggiornamento() {
        return timeAggiornamento;
    }

    public void setTimeAggiornamento(Date timeAggiornamento) {
        this.timeAggiornamento = timeAggiornamento;
    }

    public String getUtenteAggiornamento() {
        return utenteAggiornamento;
    }

    public void setUtenteAggiornamento(String utenteAggiornamento) {
        this.utenteAggiornamento = utenteAggiornamento;
    }

    public String getProgrammaAggiornamento() {
        return programmaAggiornamento;
    }

    public void setProgrammaAggiornamento(String programmaAggiornamento) {
        this.programmaAggiornamento = programmaAggiornamento;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
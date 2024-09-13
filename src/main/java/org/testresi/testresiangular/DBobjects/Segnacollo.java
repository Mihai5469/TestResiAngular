package org.testresi.testresiangular.DBobjects;

import java.util.Date;

public class Segnacollo {
    private long segnacolloId;
    private String codAzienda;
    private String codMagazzino;
    private String codArticolo;
    private boolean annullamentoLogico;
    private Date timeCreazione;
    private String utenteCreazione;
    private String programmaCreazione;
    private Date timeAggiornamento;
    private String utenteAggiornamento;
    private String programmaAggiornamento;
    private int version;
    private String codiceCollo;
    private String codTipoReso;
    private String serial;
    private String qtaPrevista;
    private String qtaResa;
    private String cdsAvanzamento;

    public long getSegnacolloId() {
        return segnacolloId;
    }
    public void setSegnacolloId(long segnacolloId) {
        this.segnacolloId = segnacolloId;
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
    public String getCodiceCollo() {
        return codiceCollo;
    }
    public void setCodiceCollo(String codiceCollo) {
        this.codiceCollo = codiceCollo;
    }
    public String getCodTipoReso() {
        return codTipoReso;
    }
    public void setCodTipoReso(String codTipoReso) {
        this.codTipoReso = codTipoReso;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getQtaPrevista() {
        return qtaPrevista;
    }
    public void setQtaPrevista(String qtaPrevista) {
        this.qtaPrevista = qtaPrevista;
    }
    public String getQtaResa() {
        return qtaResa;
    }
    public void setQtaResa(String qtaResa) {
        this.qtaResa = qtaResa;
    }
    public String getCdsAvanzamento() {
        return cdsAvanzamento;
    }
    public void setCdsAvanzamento(String cdsAvanzamento) {
        this.cdsAvanzamento = cdsAvanzamento;
    }
}
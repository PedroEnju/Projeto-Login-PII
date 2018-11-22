package br.com.pedroenju.Model;

/**
 *
 * @author Pedro Smith Enju
 */
public class ModelLocacao {

    private int id_locacao;
    private String hora_inicio;
    private String hora_fim;
    private double km_inicio;
    private double km_fim;
    private double km_rodado;
    private double tempo_hora;
    private double valor_hora;
    private double valor_km;
    private double valor_total;
    private String status;
    private String automovel;
    private String cliente;

    public int getId_locacao() {
        return id_locacao;
    }

    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public double getKm_inicio() {
        return km_inicio;
    }

    public void setKm_inicio(double km_inicio) {
        this.km_inicio = km_inicio;
    }

    public double getKm_fim() {
        return km_fim;
    }

    public void setKm_fim(double km_fim) {
        this.km_fim = km_fim;
    }

    public double getKm_rodado() {
        return km_rodado;
    }

    public void setKm_rodado(double km_rodado) {
        this.km_rodado = km_rodado;
    }

    public double getTempo_hora() {
        return tempo_hora;
    }

    public void setTempo_hora(double tempo_hora) {
        this.tempo_hora = tempo_hora;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public double getValor_km() {
        return valor_km;
    }

    public void setValor_km(double valor_km) {
        this.valor_km = valor_km;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutomovel() {
        return automovel;
    }

    public void setAutomovel(String automovel) {
        this.automovel = automovel;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}

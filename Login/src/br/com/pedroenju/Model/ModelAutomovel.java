package br.com.pedroenju.Model;

/**
 *
 * @author Pedro Smith Enju
 */
public class ModelAutomovel {

    private int id_automovel;
    private String placa;
    private String cor;
    private String tipo_combustivel;
    private double km_atual;
    private String renavam;
    private String chassi;
    private double valor_locacao_hora;
    private double valor_locacao_km;
    private String status;
    private String modelo;

    public int getId_automovel() {
        return id_automovel;
    }

    public void setId_automovel(int id_automovel) {
        this.id_automovel = id_automovel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public double getKm_atual() {
        return km_atual;
    }

    public void setKm_atual(double km_atual) {
        this.km_atual = km_atual;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public double getValor_locacao_hora() {
        return valor_locacao_hora;
    }

    public void setValor_locacao_hora(double valor_locacao_hora) {
        this.valor_locacao_hora = valor_locacao_hora;
    }

    public double getValor_locacao_km() {
        return valor_locacao_km;
    }

    public void setValor_locacao_km(double valor_locacao_km) {
        this.valor_locacao_km = valor_locacao_km;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}

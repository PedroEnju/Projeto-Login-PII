package br.com.pedroenju.Dao;

import br.com.pedroenju.Model.ModelAutomovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pedro Smith Enju
 */
public class DaoAutomovel {

    private Connection conn;
    private ModelAutomovel model;

    public DaoAutomovel(Connection conn) {
        this.conn = conn;
    }

    public void salvar() {

        String sql = "insert into automovel (id_modelo,placa,cor,tipo_combustivel,km_atual,renavam,chassi,valor_locacao_hora,valor_locacao_km,status) values (?,?,?,?,?,?,?,?,?,?)";

        try {
            DaoModelo dm = new DaoModelo(this.conn);

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, dm.getID(this.model.getModelo()));
            ps.setString(2, this.model.getPlaca());
            ps.setString(3, this.model.getCor());
            ps.setString(4, this.model.getTipo_combustivel());
            ps.setDouble(5, this.model.getKm_atual());
            ps.setString(6, this.model.getRenavam());
            ps.setString(7, this.model.getChassi());
            ps.setDouble(8, this.model.getValor_locacao_hora());
            ps.setDouble(9, this.model.getValor_locacao_km());
            ps.setString(10, this.model.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public ArrayList<ModelAutomovel> getAll() {
        ArrayList<ModelAutomovel> modelo = new ArrayList();
        String sql = "select a.*,m.nome_modelo from automovel a inner join modelo m on m.id_modelo = a.id_modelo "
                + "and a.status = 'A' "
                + "order by m.nome_modelo";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DaoModelo dm = new DaoModelo(this.conn);
            while (rs.next()) {
                ModelAutomovel mm = new ModelAutomovel();
                mm.setModelo(dm.getModelo(rs.getInt("id_modelo")));
                mm.setPlaca(rs.getString("placa"));
                mm.setCor(rs.getString("cor"));
                mm.setTipo_combustivel(rs.getString("tipo_combustivel"));
                mm.setKm_atual(rs.getDouble("km_atual"));
                mm.setRenavam(rs.getString("renavam"));
                mm.setChassi(rs.getString("chassi"));
                mm.setValor_locacao_hora(rs.getDouble("valor_locacao_hora"));
                mm.setValor_locacao_km(rs.getDouble("valor_locacao_km"));
                mm.setStatus(rs.getString("status"));
                modelo.add(mm);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return modelo;
    }

    public int getID(String nome) {
        String sql = "select a.id_automovel,m.nome_modelo from automovel a inner join modelo m on m.id_modelo = a.id_modelo "
                + "and m.nome_modelo = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return (rs.getInt("id_automovel"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return 0;
    }

    public ModelAutomovel getByID(int id) {
        ModelAutomovel ma = new ModelAutomovel();
        String sql = "select a.*,m.nome_modelo from automovel a inner join modelo m on m.id_modelo = a.id_modelo "
                + "where m.id_modelo = ?";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ma.setId_automovel(rs.getInt("id_automovel"));
                ma.setModelo(rs.getString("nome_modelo"));
                ma.setPlaca(rs.getString("placa"));
                ma.setCor(rs.getString("cor"));
                ma.setTipo_combustivel(rs.getString("tipo_combustivel"));
                ma.setKm_atual(rs.getDouble("km_atual"));
                ma.setRenavam(rs.getString("renavam"));
                ma.setChassi(rs.getString("chassi"));
                ma.setValor_locacao_hora(rs.getDouble("valor_locacao_hora"));
                ma.setValor_locacao_km(rs.getDouble("valor_locacao_km"));
                ma.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return ma;
    }

    public void automovelStatus(int id, String status) {
        String sql = "update automovel set status = ? "
                + "where id_automovel = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void setModel(ModelAutomovel model) {
        this.model = model;
    }
}

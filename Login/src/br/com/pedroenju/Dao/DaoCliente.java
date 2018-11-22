package br.com.pedroenju.Dao;

import br.com.pedroenju.Model.ModelCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pedro Smith Enju
 */
public class DaoCliente {

    private Connection conn;
    private ModelCliente model;

    public DaoCliente(Connection conn) {
        this.conn = conn;
    }

    public boolean verificaCliente() {
        String sql = "select count(id_cliente) as count from cliente where nome_cliente = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, this.model.getNome_cliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("count") == 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return false;
    }

    public void salvar() {
        String sql = "insert into cliente (nome_cliente,cpf,status) values (?,?,?)";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, this.model.getNome_cliente());
            ps.setString(2, this.model.getCpf());
            ps.setString(3, this.model.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public ArrayList<ModelCliente> getAll() {
        ArrayList<ModelCliente> modelo = new ArrayList();
        String sql = "select * from cliente "
                + "where status = 'A' "
                + "order by nome_cliente";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModelCliente mc = new ModelCliente();
                mc.setId_cliente(rs.getInt("id_cliente"));
                mc.setNome_cliente(rs.getString("nome_cliente"));
                mc.setCpf(rs.getString("cpf"));
                mc.setStatus(rs.getString("status"));
                modelo.add(mc);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return modelo;
    }

    public int getID(String nome) {
        String sql = "select * from cliente "
                + "where nome_cliente = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return (rs.getInt("id_cliente"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return 0;
    }

    public void setModel(ModelCliente model) {
        this.model = model;
    }
}

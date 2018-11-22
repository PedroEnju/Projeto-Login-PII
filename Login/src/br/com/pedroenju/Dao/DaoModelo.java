package br.com.pedroenju.Dao;

import br.com.pedroenju.Model.ModelModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pedro Smith Enju
 */
public class DaoModelo {

    private Connection conn;
    private ModelModelo model;

    public DaoModelo(Connection conn) {
        this.conn = conn;
    }

    public boolean verificaMarca() {
        String sql = "select count(id_modelo) as count from modelo where nome_modelo = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, this.model.getNome_modelo());
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

        String sql = "insert into modelo (id_marca,nome_modelo,status) values (?,?,?)";

        try {
            DaoMarca dm = new DaoMarca(this.conn);

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, dm.getID(this.model.getMarca()));
            ps.setString(2, this.model.getNome_modelo());
            ps.setString(3, this.model.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public int getID(String nome) {
        String sql = "select * from modelo where nome_modelo = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (rs.getInt("id_modelo"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return 0;
    }

    public String getModelo(int id) {
        String sql = "select * from modelo where id_modelo = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (rs.getString("nome_modelo"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<ModelModelo> getAll() {
        ArrayList<ModelModelo> modelo = new ArrayList();
        String sql = "select * from modelo order by nome_modelo";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DaoMarca dm = new DaoMarca(this.conn);
            while (rs.next()) {
                ModelModelo mm = new ModelModelo();
                mm.setId_modelo(rs.getInt("id_modelo"));
                mm.setNome_modelo(rs.getString("nome_modelo"));
                mm.setStatus(rs.getString("status"));
                mm.setMarca(dm.getMarca(rs.getInt("id_marca")));
                modelo.add(mm);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return modelo;
    }

    public void setModel(ModelModelo model) {
        this.model = model;
    }

}

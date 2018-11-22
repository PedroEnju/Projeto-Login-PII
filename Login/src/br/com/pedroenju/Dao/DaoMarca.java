package br.com.pedroenju.Dao;

import br.com.pedroenju.Model.ModelMarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pedro Smith Enju
 */
public class DaoMarca {

    private Connection conn;
    private ModelMarca model;

    public DaoMarca(Connection conn) {
        this.conn = conn;
    }

    public boolean verificaMarca() {
        String sql = "select count(id_marca) as count from marca where nome_marca = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, this.model.getNome_marca());
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

    public void cadastrar() {

        String sql = "insert into marca (nome_marca,status) values (?,?)";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, this.model.getNome_marca());
            ps.setString(2, this.model.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public int getID(String nome) {
        String sql = "select * from marca where nome_marca = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (rs.getInt("id_marca"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return 0;
    }

    public String getMarca(int id) {
        String sql = "select * from marca where id_marca = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (rs.getString("nome_marca"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<ModelMarca> getAll() {
        ArrayList<ModelMarca> marca = new ArrayList();
        String sql = "select * from marca order by nome_marca";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModelMarca mm = new ModelMarca();
                mm.setId_marca(rs.getInt("id_marca"));
                mm.setNome_marca(rs.getString("nome_marca"));
                mm.setStatus(rs.getString("status"));
                marca.add(mm);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return marca;
    }

    public void setModel(ModelMarca model) {
        this.model = model;
    }

}

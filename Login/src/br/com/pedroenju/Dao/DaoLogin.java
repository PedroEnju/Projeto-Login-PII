package br.com.pedroenju.Dao;

import br.com.pedroenju.Model.ModelLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pedro Smith Enju
 */
public class DaoLogin {

    private Connection conn;
    private ModelLogin model;

    public DaoLogin(Connection conn) {
        this.conn = conn;
    }

    public ModelLogin verificarLogin() {

        String sql = "select * from usuario where login_user = ? and senha_user = ? and status = 'A'";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, this.model.getLogin());
            ps.setString(2, this.model.getSenha());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ModelLogin ml = new ModelLogin();
                ml.setLogin(rs.getString("login_user"));
                ml.setNome(rs.getString("nome_user"));
                ml.setEmail(rs.getString("email_user"));
                ml.setStatus(rs.getString("status"));
                return ml;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public void setModel(ModelLogin model) {
        this.model = model;
    }
}

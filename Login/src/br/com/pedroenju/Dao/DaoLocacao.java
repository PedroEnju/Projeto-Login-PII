package br.com.pedroenju.Dao;

import br.com.pedroenju.Model.ModelLocacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Pedro Smith Enju
 */
public class DaoLocacao {

    private Connection conn;
    private ModelLocacao model;

    public DaoLocacao(Connection conn) {
        this.conn = conn;
    }

    public void salvar() {
        String sql = "insert into locacao (id_automovel,id_cliente,hora_inicio,hora_fim,km_inicio,km_fim,km_rodado,tempo_hora,valor_hora,valor_km,valor_total,status) values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            DaoAutomovel dm = new DaoAutomovel(this.conn);
            dm.automovelStatus(dm.getID(this.model.getAutomovel()), "L");
            DaoCliente dc = new DaoCliente(this.conn);

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, dm.getID(this.model.getAutomovel()));
            ps.setInt(2, dc.getID(this.model.getCliente()));
            ps.setString(3, this.convertDate(this.model.getHora_inicio()));
            ps.setString(4, this.convertDate(this.model.getHora_fim()));
            ps.setDouble(5, this.model.getKm_inicio());
            ps.setDouble(6, this.model.getKm_fim());
            ps.setDouble(7, this.model.getKm_rodado());
            ps.setDouble(8, this.model.getTempo_hora());
            ps.setDouble(9, this.model.getValor_hora());
            ps.setDouble(10, this.model.getValor_km());
            ps.setDouble(11, this.model.getValor_total());
            ps.setString(12, this.model.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void setModel(ModelLocacao model) {
        this.model = model;
    }

    public String convertDate(String data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(data));
        data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
        return data;
    }
}

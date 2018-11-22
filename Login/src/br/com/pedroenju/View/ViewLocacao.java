package br.com.pedroenju.View;

import br.com.pedroenju.Model.ModelAutomovel;
import br.com.pedroenju.Model.ModelLocacao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author Pedro Smith Enju
 */
public class ViewLocacao extends JInternalFrame {

    private ActionListener al;
    private ModelLocacao model;
    private JComboBox cbCliente, cbAutomovel;
    private JTextField txtHora_Inicio, txtHora_Fim, txtKM_Inicio, txtKM_Fim, txtKM_Rodado, txtTempo_Hora, txtValor_Hora, txtValor_KM, txtValor_Total;

    private JButton btnCadastrar;

    public ViewLocacao(ActionListener al) throws HeadlessException {
        super("Locação de Veículo");
        this.al = al;
        showTela();
        config();
    }

    private void showTela() {
        this.setLayout(new BorderLayout());

        JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pCenter = new JPanel(new GridLayout(0, 2));
        JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        Dimension dText = new Dimension(200, 30);

        this.cbCliente = new JComboBox<>();
        this.cbCliente.setPreferredSize(dText);
        this.cbAutomovel = new JComboBox<>();
        this.cbAutomovel.setPreferredSize(dText);
        this.txtHora_Inicio = new JTextField();
        this.txtHora_Inicio.setPreferredSize(dText);
        this.txtHora_Fim = new JTextField();
        this.txtHora_Fim.setPreferredSize(dText);
        this.txtKM_Inicio = new JTextField();
        this.txtKM_Inicio.setPreferredSize(dText);
        this.txtKM_Fim = new JTextField();
        this.txtKM_Fim.setPreferredSize(dText);
        this.txtKM_Rodado = new JTextField();
        this.txtKM_Rodado.setPreferredSize(dText);
        this.txtTempo_Hora = new JTextField();
        this.txtTempo_Hora.setPreferredSize(dText);
        this.txtValor_Hora = new JTextField();
        this.txtValor_Hora.setPreferredSize(dText);
        this.txtValor_KM = new JTextField();
        this.txtValor_KM.setPreferredSize(dText);
        this.txtValor_Total = new JTextField();
        this.txtValor_Total.setPreferredSize(dText);

        this.btnCadastrar = new JButton("Alugar");

        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        JLabel lbTitle = new JLabel("Locação de Veículo");
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lbTitle.setForeground(Color.WHITE);
        pNorth.setBackground(Color.BLUE);
        pNorth.add(lbTitle);

        pCenter.add(new JLabel("Cliente"));
        pCenter.add(this.cbCliente);
        pCenter.add(new JLabel("Automóvel"));
        pCenter.add(this.cbAutomovel);
        pCenter.add(new JLabel("Hora Ínicio"));
        pCenter.add(this.txtHora_Inicio);
        pCenter.add(new JLabel("Hora Fim"));
        pCenter.add(this.txtHora_Fim);
        pCenter.add(new JLabel("Kilometragem Inicial"));
        pCenter.add(this.txtKM_Inicio);
        pCenter.add(new JLabel("Kilometragem Rodado"));
        pCenter.add(this.txtKM_Rodado);
        pCenter.add(new JLabel("Kilometragem Final"));
        pCenter.add(this.txtKM_Fim);
        pCenter.add(new JLabel("Tempo Hora"));
        pCenter.add(this.txtTempo_Hora);
        pCenter.add(new JLabel("Valor Hora"));
        pCenter.add(this.txtValor_Hora);
        pCenter.add(new JLabel("Valor Kilometragem"));
        pCenter.add(this.txtValor_KM);
        pCenter.add(new JLabel("Valor Total"));
        pCenter.add(this.txtValor_Total);

        pSouth.add(this.btnCadastrar);
        comandosBtn();
        txtField();
    }

    public ModelLocacao getModel() {
        this.model.setCliente(String.valueOf(this.cbCliente.getSelectedItem()));
        this.model.setAutomovel(String.valueOf(this.cbAutomovel.getSelectedItem()));
        this.model.setHora_inicio(this.txtHora_Inicio.getText());
        this.model.setHora_fim(this.txtHora_Fim.getText());
        this.model.setKm_inicio(Double.parseDouble(this.txtKM_Inicio.getText()));
        this.model.setKm_rodado(Double.parseDouble(this.txtKM_Rodado.getText()));
        this.model.setKm_fim(Double.parseDouble(this.txtKM_Fim.getText()));
        this.model.setTempo_hora(Double.parseDouble(this.txtTempo_Hora.getText()));
        this.model.setValor_hora(Double.parseDouble(this.txtValor_Hora.getText()));
        this.model.setValor_km(Double.parseDouble(this.txtValor_KM.getText()));
        this.model.setValor_total(Double.parseDouble(this.txtValor_Total.getText()));
        this.model.setStatus("A");
        return this.model;
    }

    public void setModel(ModelLocacao ml) {
        this.txtHora_Inicio.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime()));
        this.txtHora_Fim.setText(ml.getHora_fim());
        this.txtKM_Inicio.setText(String.valueOf(ml.getKm_inicio()));
        this.txtKM_Fim.setText(String.valueOf(ml.getKm_fim()));
        this.txtKM_Rodado.setText(String.valueOf(ml.getKm_rodado()));
        this.txtTempo_Hora.setText(String.valueOf(ml.getTempo_hora()));
        this.txtValor_Hora.setText(String.valueOf(ml.getValor_hora()));
        this.txtValor_KM.setText(String.valueOf(ml.getValor_km()));
        this.txtValor_Total.setText(String.valueOf(ml.getValor_total()));
        this.model = ml;
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setClosable(true);
    }

    private void comandosBtn() {
        this.cbAutomovel.addActionListener(this.al);
        this.btnCadastrar.addActionListener(this.al);

        this.cbAutomovel.setActionCommand("cbAutomovel.change");
        this.btnCadastrar.setActionCommand("cadastrar.locacao");
    }

    public void setCliente(ArrayList<String> lista) {
        DefaultComboBoxModel<ModelAutomovel> cbModel = new DefaultComboBoxModel(lista.toArray());
        this.cbCliente.setModel(cbModel);
    }

    public void setAutomovel(ArrayList<String> lista) {
        DefaultComboBoxModel<ModelAutomovel> cbModel = new DefaultComboBoxModel(lista.toArray());
        this.cbAutomovel.setModel(cbModel);
    }

    public String getAutomovel() {
        return (String.valueOf(this.cbAutomovel.getSelectedItem()));
    }

    private void txtField() {
        this.txtHora_Inicio.setEditable(false);
        this.txtHora_Fim.setEditable(false);
        this.txtKM_Inicio.setEditable(false);
        this.txtKM_Fim.setEditable(false);
        this.txtKM_Rodado.setEditable(false);
        this.txtTempo_Hora.setEditable(false);
        this.txtValor_Hora.setEditable(false);
        this.txtValor_KM.setEditable(false);
        this.txtValor_Total.setEditable(false);
    }
}

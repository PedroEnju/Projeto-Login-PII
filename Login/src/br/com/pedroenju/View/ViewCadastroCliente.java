package br.com.pedroenju.View;

import br.com.pedroenju.Model.ModelCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author Pedro Smith Enju
 */
public class ViewCadastroCliente extends JInternalFrame {

    private ActionListener al;
    private ModelCliente model;
    private JTextField txtNome_cliente, txtCpf;
    private JButton btnCadastrar;
    private JCheckBox cbStatus;

    public ViewCadastroCliente(ActionListener al) throws HeadlessException {
        super("Cadastro de Cliente");
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

        this.txtNome_cliente = new JTextField();
        this.txtNome_cliente.setPreferredSize(dText);
        this.txtCpf = new JTextField();
        this.txtCpf.setPreferredSize(dText);
        this.cbStatus = new JCheckBox();
        this.cbStatus.setSelected(true);

        this.btnCadastrar = new JButton("Cadastrar");

        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        JLabel lbTitle = new JLabel("Cadastro de Cliente");
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lbTitle.setForeground(Color.WHITE);
        pNorth.setBackground(Color.BLUE);
        pNorth.add(lbTitle);

        pCenter.add(new JLabel("Nome"));
        pCenter.add(this.txtNome_cliente);
        pCenter.add(new JLabel("CPF"));
        pCenter.add(this.txtCpf);
        pCenter.add(new JLabel("Status"));
        pCenter.add(this.cbStatus);

        pSouth.add(this.btnCadastrar);
        comandosBtn();
    }

    public void setModel(ModelCliente model) {
        this.model = model;
    }

    public ModelCliente getModel() {
        this.model.setNome_cliente(this.txtNome_cliente.getText());
        this.model.setCpf(this.txtCpf.getText());
        String status = "A";
        if (!cbStatus.isSelected()) {
            status = "I";
        }
        this.model.setStatus(status);
        return this.model;
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setClosable(true);
    }

    private void comandosBtn() {
        this.btnCadastrar.addActionListener(this.al);

        this.btnCadastrar.setActionCommand("cadastrar.cliente");
    }
}

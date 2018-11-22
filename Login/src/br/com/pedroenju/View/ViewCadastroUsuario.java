package br.com.pedroenju.View;

import br.com.pedroenju.Model.ModelLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Smith Enju
 */
public class ViewCadastroUsuario extends JInternalFrame implements ActionListener {

    private ModelLogin model;
    private JTextField txtLogin, txtNome, txtEmail;
    private JPasswordField txtSenha;
    private JRadioButton rbStatus;
    private JButton btnCadastrar;

    public ViewCadastroUsuario() throws HeadlessException {
        super("Cadastro de Usuário");
        showTela();
        config();
    }

    public ModelLogin getModel() {
        this.model.setLogin(this.txtLogin.getText());
        this.model.setSenha(String.valueOf(this.txtSenha.getPassword()));
        this.model.setNome(this.txtNome.getText());
        this.model.setEmail(this.txtEmail.getText());
        return this.model;
    }

    public void setModel(ModelLogin model) {
        this.model = model;
    }

    private void showTela() {
        this.setLayout(new BorderLayout());

        JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pCenter = new JPanel(new GridLayout(0, 2));
        JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        Dimension dText = new Dimension(200, 30);

        this.txtLogin = new JTextField();
        this.txtLogin.setPreferredSize(dText);
        this.txtSenha = new JPasswordField();
        this.txtNome = new JTextField();
        this.txtEmail = new JTextField();
        this.rbStatus = new JRadioButton("Status");
        this.btnCadastrar = new JButton("Cadastrar");

        this.add(pNorth, BorderLayout.NORTH);
        this.add(pCenter, BorderLayout.CENTER);
        this.add(pSouth, BorderLayout.SOUTH);

        JLabel lbTitle = new JLabel("Cadastro de Usuário");
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lbTitle.setForeground(Color.WHITE);
        pNorth.setBackground(Color.GREEN);
        pNorth.add(lbTitle);

        pCenter.add(new JLabel("Login"));
        pCenter.add(this.txtLogin);
        pCenter.add(new JLabel("Senha"));
        pCenter.add(this.txtSenha);
        pCenter.add(new JLabel("Nome Completo"));
        pCenter.add(this.txtNome);
        pCenter.add(new JLabel("Email"));
        pCenter.add(this.txtEmail);

        this.btnCadastrar.addActionListener(this);
        pSouth.add(this.btnCadastrar);

        comandosBtn();
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setClosable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void addAL(ActionListener al) {
        this.btnCadastrar.addActionListener(al);
    }

    private void comandosBtn() {
        this.btnCadastrar.setActionCommand("cadastrar.usuario");
    }
}

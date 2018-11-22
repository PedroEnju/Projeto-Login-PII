package br.com.pedroenju.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Pedro Smith Enju
 */
public class ViewPrincipal extends JFrame {

    private ActionListener al;
    private String nomeUsuario;

    private JMenuBar mbPrincipal;
    private JMenu mCadastro;
    private JMenuItem miUsuario, miAutomovel, miLocacao, miCliente;
    private JDesktopPane dpFundo;
    private JPanel pStatusBar;

    public ViewPrincipal(ActionListener al, String nomeUsuario) throws HeadlessException {

        super("Tela Principal");
        this.al = al;
        this.nomeUsuario = nomeUsuario;
        showTela();
        config();

    }

    private void showTela() {

        this.setLayout(new BorderLayout());

        //MENU
        this.mbPrincipal = new JMenuBar();
        //  -  Cadastro
        this.mCadastro = new JMenu("Cadastro");
        this.miUsuario = new JMenuItem("Usuário");
        this.miUsuario.setEnabled(false);
        this.miAutomovel = new JMenuItem("Automóvel");
        this.miLocacao = new JMenuItem("Locação");
        this.miCliente = new JMenuItem("Cliente");
        //CENTRO
        this.dpFundo = new JDesktopPane();
        //StatusBar
        this.pStatusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        this.add(this.mbPrincipal, BorderLayout.NORTH);
        this.mbPrincipal.add(mCadastro);
        this.mCadastro.add(miUsuario);
        this.mCadastro.add(miAutomovel);
        this.mCadastro.add(miLocacao);
        this.mCadastro.add(miCliente);

        this.add(this.dpFundo, BorderLayout.CENTER);
        this.add(this.pStatusBar, BorderLayout.SOUTH);

        desktopConfig();
        statusBar();
        comandosMenuItem();
    }

    private void config() {
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void comandosMenuItem() {
        //  -- ActionListener
        this.miUsuario.addActionListener(this.al);
        this.miAutomovel.addActionListener(this.al);
        this.miLocacao.addActionListener(this.al);
        this.miCliente.addActionListener(this.al);
        //  -- ActionCommand
        this.miUsuario.setActionCommand("cadastro.usuario");
        this.miAutomovel.setActionCommand("cadastro.automovel");
        this.miLocacao.setActionCommand("cadastro.locacao");
        this.miCliente.setActionCommand("cadastro.cliente");
    }

    private void statusBar() {
        this.pStatusBar.add(new JLabel("Usuário: " + this.nomeUsuario));
        String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        this.pStatusBar.add(new JLabel("-   Data de Login: " + data));
    }

    private void desktopConfig() {
        this.dpFundo.setBackground(Color.DARK_GRAY);
    }

    public void setFrame(JInternalFrame frame) {
        this.dpFundo.add(frame);
    }

    public JDesktopPane getDesktopPane() {
        return this.dpFundo;
    }
}

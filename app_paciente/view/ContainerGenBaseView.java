package app_paciente.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Style.Boton;
import Style.EstilosUI;

public class ContainerGenBaseView extends JPanel {
    private JPanel app_Bar;
    private JPanel contenedor_Gen;
    private JPanel panel_Lateral;
    private JPanel panel_Central;
    private JPanel sub_Panel_Lateral;
    private JButton perfil;
    private JButton hist_Medico;
    private JButton medicamentos;
    private JButton recomendaciones;
    private JButton agenda;
    private JButton chat;
    private JLabel titulo;
    private JPanel logo_container;
    private JLabel label_Logo;
    private ImageIcon logo;
    private Boton configuracion;

    public ContainerGenBaseView() {
        init();
    }

    public void init() {
        // Inicializar los componentes
        app_Bar = new JPanel();
        contenedor_Gen = new JPanel();
        panel_Lateral = new JPanel();
        panel_Central = new JPanel();
        panel_Central.setOpaque(false);
        sub_Panel_Lateral = new JPanel();
        perfil = new JButton("Perfil paciente");
        hist_Medico = new JButton("Historial medico");
        medicamentos = new JButton("Medicamentos");
        recomendaciones = new JButton("Recomendaciones");
        agenda = new JButton("Agenda");
        chat = new JButton("Chat");
        titulo = new JLabel("CUIDAME");
        titulo.setForeground(Color.WHITE);
        configuracion = new Boton("⚙️");
        configuracion.getPreferredSize();
        logo = new ImageIcon("Proyecto\\App_Paciente\\img\\logoApp.png");
        Image enviar_escalado = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        logo_container = new JPanel(new BorderLayout());
        label_Logo = new JLabel(new ImageIcon(enviar_escalado));
        logo_container.add(label_Logo, BorderLayout.CENTER);

        // Botones
        perfil.setActionCommand("perfil");
        hist_Medico.setActionCommand("hist_medico");
        medicamentos.setActionCommand("medicamentos");
        recomendaciones.setActionCommand("recomendaciones");
        agenda.setActionCommand("agenda");
        chat.setActionCommand("chat");
        configuracion.setActionCommand("configuracion");

        // Aplicar estilos
        EstilosUI.panelApp_Bar(app_Bar);
        EstilosUI.panelApp_Bar(logo_container);
        EstilosUI.aplicarEstiloPanelPrincipal(contenedor_Gen);
        EstilosUI.aplicarEstiloPanelSecundario(panel_Lateral);
        EstilosUI.aplicarEstiloPanelSecundario(panel_Central);
        EstilosUI.aplicarEstiloPanelSecundario(sub_Panel_Lateral);
        EstilosUI.aplicarEstiloBotonMenu(perfil);
        EstilosUI.aplicarEstiloBotonMenu(hist_Medico);
        EstilosUI.aplicarEstiloBotonMenu(medicamentos);
        EstilosUI.aplicarEstiloBotonMenu(recomendaciones);
        EstilosUI.aplicarEstiloBotonMenu(agenda);
        EstilosUI.aplicarEstiloBotonMenu(chat);

        // Configurar el subpanel lateral
        sub_Panel_Lateral.setLayout(new GridLayout(1, 2));
        sub_Panel_Lateral.add(agenda);
        sub_Panel_Lateral.add(chat);

        // Configurar el panel lateral
        panel_Lateral.setLayout(new GridLayout(5, 1));
        panel_Lateral.add(perfil);
        panel_Lateral.add(hist_Medico);
        panel_Lateral.add(medicamentos);
        panel_Lateral.add(recomendaciones);
        panel_Lateral.add(sub_Panel_Lateral);

        // Configurar el panel central
        panel_Central.setLayout(new BorderLayout());
        panel_Central.add(new PerfilPacienteView(), BorderLayout.CENTER);

        // Configurar el contenedor general
        contenedor_Gen.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.gridx = 0;
        cont.gridy = 0;
        cont.weightx = 0.15; // El panel lateral ocupa el 15% del ancho
        cont.weighty = 1.0;
        cont.fill = GridBagConstraints.BOTH; // Se expande en ambas direcciones
        contenedor_Gen.add(panel_Lateral, cont);

        cont.gridx = 1;
        cont.weightx = 0.85; // El panel central ocupa el 85% del ancho
        cont.fill = GridBagConstraints.BOTH; // Se expande en ambas direcciones
        contenedor_Gen.add(panel_Central, cont);

        // Configurar el appBar
        app_Bar.setLayout(new GridBagLayout());
        GridBagConstraints app = new GridBagConstraints();
        app.gridx = 0;
        app.gridy = 0;
        app.weightx = 0.15; // Logo ocupa el 15% del ancho
        app.fill = GridBagConstraints.BOTH;
        app_Bar.add(logo_container, app);

        app.gridx = 1;
        app.weightx = 0.70; // Título ocupa el 70% del ancho
        app.fill = GridBagConstraints.BOTH;
        app_Bar.add(titulo, app);

        app.gridx = 2;
        app.weightx = 0.15; // Botón de configuración ocupa el 15% del ancho
        app.fill = GridBagConstraints.BOTH;
        app_Bar.add(configuracion, app);

        // Configurar el layout principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // appBar ocupa la parte superior
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05; // Altura del appBar (5% de la ventana)
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(app_Bar, gbc);

        // contenedor_Gen ocupa el resto del espacio
        gbc.gridy = 1;
        gbc.weighty = 0.95; // Altura del contenedor general (95% de la ventana)
        add(contenedor_Gen, gbc);

        // Listener para ajustar tamaños dinámicamente
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarTamanos();
            }
        });
    }

    private void ajustarTamanos() {
        // Ajustar el tamaño del panel lateral dinámicamente
        int anchoTotal = getWidth();
        int anchoLateral = (int) (anchoTotal * 0.15); // 15% del ancho total
        panel_Lateral.setPreferredSize(new Dimension(anchoLateral, getHeight()));
        revalidate();
    }

    public JButton[] getBotones() {
        return new JButton[] { perfil, hist_Medico, medicamentos, recomendaciones, agenda, chat, configuracion };
    }

    public JPanel getPanelCentral() {
        return panel_Central;
    }

    public void setPanelCentral(JPanel panel) {
        panel_Central.removeAll();
        panel_Central.add(panel);
        panel_Central.revalidate();
        panel_Central.repaint();
    }
}
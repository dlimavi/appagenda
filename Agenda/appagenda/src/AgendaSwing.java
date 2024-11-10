import javax.swing.*;
import java.awt.event.ActionEvent;
public class AgendaSwing {
    private final Agenda agenda;
    JTextArea textArea;
    private JTextField nomeField;
    private JTextField telefoneField;

    public AgendaSwing() {
        agenda = new Agenda();
        criarInterface();
    }

    private void criarInterface() {
        JFrame frame = new JFrame("Agenda de Contatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 80, 25);
        panel.add(nomeLabel);

        nomeField = new JTextField(20);
        nomeField.setBounds(100, 20, 165, 25);
        panel.add(nomeField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 50, 80, 25);
        panel.add(telefoneLabel);

        telefoneField = new JTextField(20);
        telefoneField.setBounds(100, 50, 165, 25);
        panel.add(telefoneField);

        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(10, 80, 150, 25);
        panel.add(adicionarButton);

        textArea = new JTextArea();
        textArea.setBounds(10, 110, 350, 150);
        panel.add(textArea);

        adicionarButton.addActionListener((ActionEvent e) -> {
            String nome = nomeField.getText();
            String telefone = telefoneField.getText();
            agenda.adicionarContato(new Contato(nome, telefone));
            listarContatos();
        });
    }

    private void listarContatos() {
        StringBuilder sb = new StringBuilder();
        for (Contato contato : agenda.listarContatos()) {
            sb.append(contato).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new AgendaSwing();
    }
}
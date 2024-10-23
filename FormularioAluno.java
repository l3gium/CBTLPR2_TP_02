import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FormularioAluno extends JFrame {

    private JTextField nomeField, idadeField, enderecoField;
    private JButton okButton, limparButton, mostrarButton, sairButton;
    private List<Aluno> listaAlunos;

    public FormularioAluno() {
        listaAlunos = new ArrayList<>();  // Inicializa a lista de alunos

        // Configurações da janela
        setTitle("TP02 - LP2I4");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior com GridLayout 3x2 e gaps
        JPanel panelSuperior = new JPanel(new GridLayout(3, 2, 10, 10));

        // Componentes do painel superior
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(100, 20));  // Definindo largura e altura

        JLabel idadeLabel = new JLabel("Idade:");
        idadeField = new JTextField();
        idadeField.setPreferredSize(new Dimension(50, 20));  // Definindo largura e altura

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoField = new JTextField();
        enderecoField.setPreferredSize(new Dimension(100, 20));  // Definindo largura e altura

        // Adiciona os componentes ao painel superior
        panelSuperior.add(nomeLabel);
        panelSuperior.add(nomeField);
        panelSuperior.add(idadeLabel);
        panelSuperior.add(idadeField);
        panelSuperior.add(enderecoLabel);
        panelSuperior.add(enderecoField);

        // Painel inferior com GridLayout 1x4 para os botões
        JPanel panelInferior = new JPanel(new GridLayout(1, 4, 10, 10));

        // Botões
        okButton = new JButton("Ok");
        limparButton = new JButton("Limpar");
        mostrarButton = new JButton("Mostrar");
        sairButton = new JButton("Sair");

        // Adiciona os botões ao painel inferior
        panelInferior.add(okButton);
        panelInferior.add(limparButton);
        panelInferior.add(mostrarButton);
        panelInferior.add(sairButton);

        // Ações dos botões
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAluno();
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlunos();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adiciona os painéis à janela
        add(panelSuperior, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    // Método para adicionar aluno à lista
    private void adicionarAluno() {
        try {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String endereco = enderecoField.getText();
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setIdade(idade);
            aluno.setEndereco(endereco);
            aluno.setUuid(UUID.randomUUID());  // Gera um UUID para o aluno

            // Armazena o aluno na lista
            listaAlunos.add(aluno);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");

            // Limpa os campos após adicionar o aluno
            limparCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida. Por favor, insira um número.");
        }
    }

    // Limpa os campos do formulário
    private void limparCampos() {
        nomeField.setText("");
        idadeField.setText("");
        enderecoField.setText("");
    }

    // Exibe a lista de alunos cadastrados com seus IDs e nomes
    private void mostrarAlunos() {
        if (listaAlunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.");
        } else {
            StringBuilder mensagem = new StringBuilder("Resultado\n\n");
            for (Aluno aluno : listaAlunos) {
                mensagem.append("Id: ").append(aluno.getUuid().toString()).append("  Nome: ").append(aluno.getNome()).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensagem.toString(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Executa a aplicação
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioAluno().setVisible(true);
            }
        });
    }
}

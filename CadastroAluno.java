import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CadastroAluno extends JFrame {
    private JTextField nomeField, idadeField, enderecoField;
    private JButton okButton, limparButton, mostrarButton, sairButton;
    private List<Aluno> alunos;

    public CadastroAluno() {
        // Inicializar a lista de alunos
        alunos = new ArrayList<>();

        // Configurações da janela
        setTitle("Cadastro de Alunos");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos de texto e rótulos
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeField = new JTextField(5);

        JLabel enderecoLabel = new JLabel("Endereco:");
        enderecoField = new JTextField(20);

        // Botões
        okButton = new JButton("Ok");
        limparButton = new JButton("Limpar");
        mostrarButton = new JButton("Mostrar");
        sairButton = new JButton("Sair");

        // Adicionando componentes à janela
        add(nomeLabel);
        add(nomeField);
        add(idadeLabel);
        add(idadeField);
        add(enderecoLabel);
        add(enderecoField);
        add(okButton);
        add(limparButton);
        add(mostrarButton);
        add(sairButton);

        // Ações dos botões
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
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
    }

    // Método para cadastrar um aluno
    private void cadastrarAluno() {
        String nome = nomeField.getText();
        String idadeTexto = idadeField.getText();
        String endereco = enderecoField.getText();

        if (!nome.isEmpty() && !idadeTexto.isEmpty() && !endereco.isEmpty()) {
            try {
                int idade = Integer.parseInt(idadeTexto);  // Conversão para int
                Aluno aluno = new Aluno(nome, idade, endereco);
                alunos.add(aluno);
                JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
                limparCampos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira uma idade válida.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
        }
    }

    // Método para limpar os campos
    private void limparCampos() {
        nomeField.setText("");
        idadeField.setText("");
        enderecoField.setText("");
    }

    // Método para exibir a lista de alunos
    private void mostrarAlunos() {
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.");
        } else {
            StringBuilder mensagem = new StringBuilder("Alunos cadastrados:\n");
            for (Aluno aluno : alunos) {
                mensagem.append(aluno.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensagem.toString());
        }
    }

    // Método principal para executar a aplicação
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }
}

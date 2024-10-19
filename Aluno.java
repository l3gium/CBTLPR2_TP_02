import java.util.UUID;

public class Aluno {
    private String endereco;
    private int idade;
    private String nome;
    private UUID uuid;

    // Construtor
    public Aluno(String nome, int idade, String endereco) {
        this.uuid = UUID.randomUUID();  // Gera um ID único para o aluno
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters
    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public UUID getUuid() {
        return uuid;
    }

    // Setters
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ID: " + uuid + " | Nome: " + nome + " | Idade: " + idade + " | Endereco: " + endereco;
    }
}

```java
public class Atleta {

    // Atributos privados
    private int id;
    private String nome;
    private String posicao;
    private int idade;
    private double salario;
    private String status;

    // Construtor completo
    public Atleta(int id, String nome, String posicao,
                  int idade, double salario, String status) {

        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
        this.salario = salario;
        this.status = status;
    }

    // Getters públicos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public String getStatus() {
        return status;
    }
}
```

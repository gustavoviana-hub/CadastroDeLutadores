package br.com.Lutas.CadastroDeLutadores.lutadores;

import br.com.Lutas.CadastroDeLutadores.organizacoes.OrganizacaoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class LutadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String categoria;
    private String nacionalidade;
    private String estiloDeLuta;
    private int idade;
    private double peso;
    private double altura;
    @ManyToOne // @ManyToOne um luatdor pode ter só uma organização. @OneToManyMas uma organização pode ter vários lutadores.
    @JoinColumn(name = "organizacoes_id") // Foreing key ou chave estrangeira
    private OrganizacaoModel organizacao;

    // Com contrutores podemos contruir o lutador com as informações de uma vez.

    public LutadorModel() {

    }

    public LutadorModel(String nome, String email, String categoria, String nacionalidade, String estiloDeLuta, int idade, double peso, double altura) {
        this.nome = nome;
        this.email = email;
        this.categoria = categoria;
        this.nacionalidade = nacionalidade;
        this.estiloDeLuta = estiloDeLuta;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEstiloDeLuta() {
        return estiloDeLuta;
    }

    public void setEstiloDeLuta(String estiloDeLuta) {
        this.estiloDeLuta = estiloDeLuta;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

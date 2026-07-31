package CadastroDeLutadores.personagens.model;

import CadastroDeLutadores.missoes.model.MissoesModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class PersonagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String habilidade;
    private String raca;
    private String tecnica;

    // Um personagem tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    public PersonagemModel(String nome, String habilidade, String raca, String tecnica){
        this.nome = nome;
        this.habilidade = habilidade;
        this.raca = raca;
        this.tecnica = tecnica;
    }

    public PersonagemModel(){

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

}

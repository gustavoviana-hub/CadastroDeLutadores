package CadastroDeLutadores.missoes.model;

import CadastroDeLutadores.personagens.model.PersonagemModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String objetivo;
    private String status;
    private char rank;

    // Uma missão tem varios personagens
    @OneToMany(mappedBy = "missoes")
    private List<PersonagemModel> personagens;

    public MissoesModel(String nome, String objetivo, String status, char rank){
        this.nome = nome;
        this.objetivo = objetivo;
        this.status = status;
        this.rank = rank;
    }

    public MissoesModel(){

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char getRank() {
        return rank;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }
}

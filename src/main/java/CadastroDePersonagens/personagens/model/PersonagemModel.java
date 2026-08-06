package CadastroDePersonagens.personagens.model;

import CadastroDePersonagens.missoes.model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data -> cria todos os getter e setter
@Data

// @Entity -> transforma a classe em uma entidade
@Entity

//@Table -> conseguimos colocar o nome a nossa entidade que é a nossa classe no banco de dados
@Table(name = "tb_cadastro")

//@AllArgsConstructor -> cria construtores prenchido automaticamnete, e não precisa de recarga
@AllArgsConstructor

//@NoArgsConstructor -> cria o construtor vazio
@NoArgsConstructor

public class PersonagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "habilidade")
    private String habilidade;

    @Column(name = "raça")
    private String raca;

    @Column(name = "tecnica")
    private String tecnica;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    // Um personagem tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;


}

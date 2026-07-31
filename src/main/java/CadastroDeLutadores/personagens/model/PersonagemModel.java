package CadastroDeLutadores.personagens.model;

import CadastroDeLutadores.missoes.model.MissoesModel;
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
    private Long id;
    private String nome;
    private String habilidade;
    private String raca;
    private String tecnica;

    @Column(unique = true)
    private String email;

    // Um personagem tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;


}

package CadastroDePersonagens.missoes.model;

import CadastroDePersonagens.personagens.model.PersonagemModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "status")
    private String status;

    // Uma missão tem varios personagens
    @OneToMany(mappedBy = "missoes")
    private List<PersonagemModel> personagens;
}

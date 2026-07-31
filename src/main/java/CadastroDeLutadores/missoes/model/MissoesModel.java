package CadastroDeLutadores.missoes.model;

import CadastroDeLutadores.personagens.model.PersonagemModel;
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
    private Long id;
    private String nome;
    private String objetivo;
    private String status;
    private char rank;

    // Uma missão tem varios personagens
    @OneToMany(mappedBy = "missoes")
    private List<PersonagemModel> personagens;
}

package CadastroDePersonagens.personagens;

import CadastroDePersonagens.missoes.model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonagemDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private char rank;
    private MissoesModel missoes;

}

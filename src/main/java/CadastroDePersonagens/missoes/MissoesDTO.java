package CadastroDePersonagens.missoes;

import CadastroDePersonagens.personagens.model.PersonagemModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String objetivo;
    private String status;
    private List<PersonagemModel> personagens;

}

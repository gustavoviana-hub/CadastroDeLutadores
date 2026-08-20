package CadastroDePersonagens.personagens;

import CadastroDePersonagens.personagens.model.PersonagemModel;
import org.springframework.stereotype.Component;

@Component
public class PersonagemMapper {

    public PersonagemModel map(PersonagemDTO personagemDTO){
        PersonagemModel personagemModel = new PersonagemModel();
        personagemModel.setId(personagemDTO.getId());
        personagemModel.setNome(personagemDTO.getNome());
        personagemModel.setEmail(personagemDTO.getEmail());
        personagemModel.setImgUrl(personagemDTO.getImgUrl());
        personagemModel.setRank(personagemDTO.getRank());
        personagemModel.setMissoes(personagemDTO.getMissoes());

        return personagemModel;
    }

    public PersonagemDTO map(PersonagemModel personagemModel){
        PersonagemDTO personagemDTO = new PersonagemDTO();
        personagemDTO.setId(personagemModel.getId());
        personagemDTO.setNome(personagemModel.getNome());
        personagemDTO.setEmail(personagemModel.getEmail());
        personagemDTO.setImgUrl(personagemModel.getImgUrl());
        personagemDTO.setRank(personagemModel.getRank());
        personagemDTO.setMissoes(personagemModel.getMissoes());

        return personagemDTO;
    }

}

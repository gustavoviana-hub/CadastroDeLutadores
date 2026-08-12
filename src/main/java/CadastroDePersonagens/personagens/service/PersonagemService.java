package CadastroDePersonagens.personagens.service;

import CadastroDePersonagens.personagens.model.PersonagemModel;
import CadastroDePersonagens.personagens.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    // Listar todos os meus Personagens
    public List<PersonagemModel> listarPesronagens(){
        return personagemRepository.findAll();
    }

}

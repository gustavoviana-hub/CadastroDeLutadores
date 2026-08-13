package CadastroDePersonagens.personagens.service;

import CadastroDePersonagens.personagens.model.PersonagemModel;
import CadastroDePersonagens.personagens.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Listar todos personagens por ID
    public PersonagemModel listarPersonagemPorId(Long id){
        Optional<PersonagemModel> persoangemPorId = personagemRepository.findById(id);
            return persoangemPorId.orElse(null);
    }

    // Criar um novo Personagem
    public PersonagemModel criarPersoangem(PersonagemModel personagem){
        return personagemRepository.save(personagem);
    }

}

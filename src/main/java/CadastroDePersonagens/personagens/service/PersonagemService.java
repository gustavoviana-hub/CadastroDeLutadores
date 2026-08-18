package CadastroDePersonagens.personagens.service;

import CadastroDePersonagens.missoes.model.MissoesModel;
import CadastroDePersonagens.personagens.PersonagemDTO;
import CadastroDePersonagens.personagens.PersonagemMapper;
import CadastroDePersonagens.personagens.model.PersonagemModel;
import CadastroDePersonagens.personagens.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    private PersonagemRepository personagemRepository;
    private PersonagemMapper personagemMapper;

    public PersonagemService(PersonagemRepository personagemRepository, PersonagemMapper personagemMapper) {
        this.personagemRepository = personagemRepository;
        this.personagemMapper = personagemMapper;
    }

    // Listar todos os meus Personagens
    public List<PersonagemModel> listarPesronagens() {
        return personagemRepository.findAll();
    }

    //Listar todos personagens por ID
    public PersonagemModel listarPersonagemPorId(Long id) {
        Optional<PersonagemModel> persoangemPorId = personagemRepository.findById(id);
        return persoangemPorId.orElse(null);
    }

    // Criar um novo Personagem
    public PersonagemDTO criarPersoangem(PersonagemDTO personagemDTO) {
        PersonagemModel personagem = personagemMapper.map(personagemDTO);
        personagem = personagemRepository.save(personagem);
        return personagemMapper.map(personagem);
    }

    //Atualiza Personagem
    public PersonagemModel atualizarPersonagem(Long id, PersonagemModel personagemAtualizado){
        if (personagemRepository.existsById(id)){
            personagemAtualizado.setId(id);
            return personagemRepository.save(personagemAtualizado);
        }
        return null;
    }

    // Deletar Personagem
    public void deletarPersonagemPorId(Long id){
        personagemRepository.deleteById(id);
    }

}

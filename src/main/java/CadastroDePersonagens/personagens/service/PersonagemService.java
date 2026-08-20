package CadastroDePersonagens.personagens.service;

import CadastroDePersonagens.missoes.model.MissoesModel;
import CadastroDePersonagens.personagens.PersonagemDTO;
import CadastroDePersonagens.personagens.PersonagemMapper;
import CadastroDePersonagens.personagens.model.PersonagemModel;
import CadastroDePersonagens.personagens.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonagemService {

    private PersonagemRepository personagemRepository;
    private PersonagemMapper personagemMapper;

    public PersonagemService(PersonagemRepository personagemRepository, PersonagemMapper personagemMapper) {
        this.personagemRepository = personagemRepository;
        this.personagemMapper = personagemMapper;
    }

    // Listar todos os meus Personagens
    public List<PersonagemDTO> listarPesronagens() {
        List<PersonagemModel> personagem = personagemRepository.findAll();
        return personagem.stream()
                .map(personagemMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todos personagens por ID
    public PersonagemDTO listarPersonagemPorId(Long id) {
        Optional<PersonagemModel> personagemPorId = personagemRepository.findById(id);
        return personagemPorId.map(personagemMapper::map).orElse(null);
    }

    // Criar um novo Personagem
    public PersonagemDTO criarPersoangem(PersonagemDTO personagemDTO) {
        PersonagemModel personagem = personagemMapper.map(personagemDTO);
        personagem = personagemRepository.save(personagem);
        return personagemMapper.map(personagem);
    }

    //Atualiza Personagem
    public PersonagemDTO atualizarPersonagem(Long id, PersonagemDTO personagemDTO) {
        Optional<PersonagemModel> personagemExistente = personagemRepository.findById(id);
        if (personagemExistente.isPresent()) {
            PersonagemModel personagemAtualizado = personagemMapper.map(personagemDTO);
            personagemAtualizado.setId(id);
            PersonagemModel personagemSalvo = personagemRepository.save(personagemAtualizado);
            return personagemMapper.map(personagemSalvo);
        }
        return null;
    }

    // Deletar Personagem
    public void deletarPersonagemPorId(Long id){
        personagemRepository.deleteById(id);
    }

}

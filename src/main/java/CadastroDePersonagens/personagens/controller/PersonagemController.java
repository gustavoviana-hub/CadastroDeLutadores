package CadastroDePersonagens.personagens.controller;

import CadastroDePersonagens.personagens.PersonagemDTO;
import CadastroDePersonagens.personagens.model.PersonagemModel;
import CadastroDePersonagens.personagens.service.PersonagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    private PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    // Adicinar personagem (Create)
    @PostMapping("/criar")
    public PersonagemDTO criarNinja(@RequestBody PersonagemDTO persoangem){
        return personagemService.criarPersoangem(persoangem);
    }

    // Mostrar personagem por Id (Create)
    @GetMapping("/listar/{id}")
    public PersonagemDTO listarTodosOsPersonagens(@PathVariable Long id){
        return personagemService.listarPersonagemPorId(id);
    }

    // Mostrar todos os personagens (Read)
    @GetMapping("/listar")
    public List<PersonagemDTO> listarPersonagensPorId(){
        return personagemService.listarPesronagens();
    }

    // Atualizar Personagem
    @PutMapping("/alterar/{id}")
    public PersonagemDTO alterarPersonagemPorId(@PathVariable Long id, @RequestBody PersonagemDTO personagemAtualizado){
        return personagemService.atualizarPersonagem(id, personagemAtualizado);
    }

    // Deletar personagem (Delete)
    @DeleteMapping("/deletar/{id}")
    public void deletarPersonagemPorId(@PathVariable Long id){
        personagemService.deletarPersonagemPorId(id);
    }


}

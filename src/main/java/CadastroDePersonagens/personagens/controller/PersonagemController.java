package CadastroDePersonagens.personagens.controller;

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
    public PersonagemModel criarNinja(@RequestBody PersonagemModel persoangem){
        return personagemService.criarPersoangem(persoangem);
    }

    // Mostrar personagem por Id (Create)
    @GetMapping("/listar")
    public List<PersonagemModel> listarTodosOsPersonagens(){
        return personagemService.listarPesronagens();
    }

    // Mostrar todos os personagens (Read)
    @GetMapping("/listar/{id}")
    public PersonagemModel listarPersonagensPorId(@PathVariable Long id){
        return personagemService.listarPersonagemPorId(id);
    }

    // Alterar dados dos personagens (Update)
    @PutMapping("/alterarId")
    public String alterarPersonagemPorId(){
        return "Alterar Personagem por id";
    }

    // Deletar personagem (Delete)
    @DeleteMapping("/deletar/{id}")
    public void deletarPersonagemPorId(@PathVariable Long id){
        personagemService.deletarPersonagemPorId(id);
    }


}

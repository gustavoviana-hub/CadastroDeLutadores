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

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicinar personagem (Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Personagem Criado";
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
    @DeleteMapping("/deletar")
    public String deletarPorId(){
        return "Personagem deletado";
    }


}

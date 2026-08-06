package CadastroDePersonagens.personagens.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PersonagemController {

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
    public String mostrarTodosOsPersonagens(){
        return "Mostrar Personagens";
    }

    // Mostrar todos os personagens (Read)
    @GetMapping("/listarID")
    public String mostrarTodosPersonagensPorId(){
        return "Mostrar Personagens por ID";
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

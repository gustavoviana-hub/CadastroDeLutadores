package CadastroDePersonagens.personagens.controller;

import CadastroDePersonagens.personagens.PersonagemDTO;
import CadastroDePersonagens.personagens.service.PersonagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody PersonagemDTO persoangem){
        PersonagemDTO novoPersonagem = personagemService.criarPersoangem(persoangem);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Personagem criado com sucesso: " + novoPersonagem.getNome() + "(ID): " + novoPersonagem.getId());
    }

    // Mostrar personagem por Id (Create)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarTodosOsPersonagens(@PathVariable Long id){
        PersonagemDTO personagem = personagemService.listarPersonagemPorId(id);
        if (personagem !=null){
            return ResponseEntity.ok("Personagem encontrado: " + personagem.getNome());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Perdonagem com id: " + id + " Não existe nos nossos registros");
        }
    }

    // Mostrar todos os personagens (Read)
    @GetMapping("/listar")
    public ResponseEntity<List<PersonagemDTO>> listarPersonagensPorId(){
        List<PersonagemDTO> personagem = personagemService.listarPesronagens();
        return ResponseEntity.ok(personagem);
    }

    // Atualizar Personagem
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPersonagemPorId(@PathVariable Long id, @RequestBody PersonagemDTO personagemAtualizado){
        PersonagemDTO personagem = personagemService.atualizarPersonagem(id, personagemAtualizado);

        if (personagem != null){
            return ResponseEntity.ok(personagem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Personagem com id: " + id + " não encontrado");
        }
    }

    // Deletar personagem (Delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPersonagemPorId(@PathVariable Long id){
        if(personagemService.listarPersonagemPorId(id) != null){
            personagemService.deletarPersonagemPorId(id);
            return ResponseEntity.ok("Personagem com ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Personagem com id " + id + " não encontrado");
        }
    }


}

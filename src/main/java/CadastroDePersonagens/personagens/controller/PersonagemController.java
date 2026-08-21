package CadastroDePersonagens.personagens.controller;

import CadastroDePersonagens.personagens.PersonagemDTO;
import CadastroDePersonagens.personagens.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria um novo personagem", description = "Rota cria um novo personagem e inclui no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Personagem criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do personagem")
    })
    public ResponseEntity<String> criarNinja(@RequestBody PersonagemDTO persoangem){
        PersonagemDTO novoPersonagem = personagemService.criarPersoangem(persoangem);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Personagem criado com sucesso: " + novoPersonagem.getNome() + "(ID): " + novoPersonagem.getId());
    }

    // Mostrar personagem por Id (Create)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o personagem por id", description = "Rota list um perosnagem pelo seu id")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Personagem encontrado"),
            @ApiResponse(responseCode = "404", description = "Perosnagem não encontrado")
    })
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
    @Operation(summary = "Listar todos os personagens", description = "Essa rota mostra todos os personagens que tem no meu banco de dados")
    public ResponseEntity<List<PersonagemDTO>> listarPersonagensPorId(){
        List<PersonagemDTO> personagem = personagemService.listarPesronagens();
        return ResponseEntity.ok(personagem);
    }

    // Atualizar Personagem
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o personagem por id", description = "Rota altera personagem pelo seu id")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Personagem alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Personagem não encontrado, não foi possivel alterar")
    })
    public ResponseEntity<?> alterarPersonagemPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do personagem a ser atualizado no corpo da requisição")
            @RequestBody PersonagemDTO personagemAtualizado){

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

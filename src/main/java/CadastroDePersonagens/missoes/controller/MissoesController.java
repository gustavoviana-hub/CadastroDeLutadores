package CadastroDePersonagens.missoes.controller;

import CadastroDePersonagens.missoes.model.MissoesModel;
import CadastroDePersonagens.missoes.service.MissoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Listar Missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    // Listar Missoes Por Id
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // Criar Missao
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missaoNova){
        return missoesService.criarMissao(missaoNova);
    }

    // Atualizar Missoes Por Id
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@RequestBody MissoesModel missao, @PathVariable Long id){
        return missoesService.alterar(missao, id);
    }

    // Deletar Missao Por Id
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

}

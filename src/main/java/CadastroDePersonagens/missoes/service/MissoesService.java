package CadastroDePersonagens.missoes.service;

import CadastroDePersonagens.missoes.model.MissoesModel;
import CadastroDePersonagens.missoes.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    public MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missaoNova){
        return missoesRepository.save(missaoNova);
    }

    public MissoesModel alterar(MissoesModel alterarMissao, Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

}

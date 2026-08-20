package CadastroDePersonagens.missoes.service;

import CadastroDePersonagens.missoes.MissoesDTO;
import CadastroDePersonagens.missoes.MissoesMapper;
import CadastroDePersonagens.missoes.model.MissoesModel;
import CadastroDePersonagens.missoes.repository.MissoesRepository;
import CadastroDePersonagens.personagens.PersonagemDTO;
import CadastroDePersonagens.personagens.model.PersonagemModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    public MissoesRepository missoesRepository;
    public MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    public MissoesModel alterar(MissoesModel alterarMissao, Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

}

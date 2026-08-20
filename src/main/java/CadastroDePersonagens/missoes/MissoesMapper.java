package CadastroDePersonagens.missoes;

import CadastroDePersonagens.missoes.model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesmodel = new MissoesModel();
        missoesmodel.setId(missoesDTO.getId());
        missoesmodel.setNome(missoesDTO.getNome());
        missoesmodel.setObjetivo(missoesDTO.getObjetivo());
        missoesmodel.setStatus(missoesDTO.getStatus());
        missoesmodel.setPersonagens(missoesDTO.getPersonagens());

        return missoesmodel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTo = new MissoesDTO();
        missoesDTo.setId(missoesModel.getId());
        missoesDTo.setNome(missoesModel.getNome());
        missoesDTo.setObjetivo(missoesModel.getObjetivo());
        missoesDTo.setStatus(missoesModel.getStatus());
        missoesDTo.setPersonagens(missoesModel.getPersonagens());

        return missoesDTo;
    }

}

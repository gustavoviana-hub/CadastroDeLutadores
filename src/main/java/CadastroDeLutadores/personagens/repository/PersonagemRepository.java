package CadastroDeLutadores.personagens.repository;

import CadastroDeLutadores.personagens.model.PersonagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<PersonagemModel, Long> {
}

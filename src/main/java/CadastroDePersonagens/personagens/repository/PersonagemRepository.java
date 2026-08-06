package CadastroDePersonagens.personagens.repository;

import CadastroDePersonagens.personagens.model.PersonagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<PersonagemModel, Long> {
}

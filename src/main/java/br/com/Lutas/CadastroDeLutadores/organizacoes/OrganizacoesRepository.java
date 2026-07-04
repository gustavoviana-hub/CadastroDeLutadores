package br.com.Lutas.CadastroDeLutadores.organizacoes;

import br.com.Lutas.CadastroDeLutadores.lutadores.LutadorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacoesRepository extends JpaRepository<LutadorModel, Long> {
}


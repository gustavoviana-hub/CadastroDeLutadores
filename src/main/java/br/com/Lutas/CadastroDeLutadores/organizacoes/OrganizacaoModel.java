package br.com.Lutas.CadastroDeLutadores.organizacoes;

import br.com.Lutas.CadastroDeLutadores.lutadores.LutadorModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_organizacoes")
public class OrganizacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDaOrganizacao;

    @OneToMany(mappedBy = "organizacoes") // @OneToMany uma organização pode ter vários lutadores. @ManyToOne mais um lutador pode ter uma organização
    private List<LutadorModel> lutadores;

}

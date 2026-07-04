package br.com.Lutas.CadastroDeLutadores.lutadores;

import br.com.Lutas.CadastroDeLutadores.organizacoes.OrganizacaoModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LutadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String nacionalidade;

    private String estiloDeLuta;

    private int idade;

    private double peso;

    private double altura;

    @ManyToOne // @ManyToOne um luatdor pode ter só uma organização. @OneToManyMas uma organização pode ter vários lutadores.
    @JoinColumn(name = "organizacoes_id") // Foreing key ou chave estrangeira
    private OrganizacaoModel organizacao;

}

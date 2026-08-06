package CadastroDePersonagens.missoes.repository;

import CadastroDePersonagens.missoes.model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}

/*

 //  ORM -> vai traduzir tudo oque esta na nossa classe para o banco de dados //
 //  Hibernate -> é oque vai escanera a nossa classe verificando se tem algo novo ou deletado //

Aqui estamos extendendo o JpaRepository que é um tradutor para o nosso banco de dados.
ele vai informa ao nosso banco de dados que aqui na nossa API tem uma tabela missoes
com as infomações que colocamos la.
Ele funciona com o hibernate que é um escanner que fica escanendo a nossa classe MissoesModel
o tempo inteiro. Caso colocamos algo novo la, logo em seguida irá aparecer na nossa tabela
no banco de dados.

 */
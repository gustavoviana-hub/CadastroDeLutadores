-- V6: Migration para excluir coluna de habilidade na tabela de cadastros

ALTER TABLE tb_cadastro
DROP COLUMN habilidade;

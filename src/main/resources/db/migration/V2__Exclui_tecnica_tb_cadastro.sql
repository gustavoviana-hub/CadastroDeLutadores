-- V2: Migration para excluir coluna de tecnica na tabela de cadastros

ALTER TABLE tb_cadastro
DROP COLUMN tecnica;

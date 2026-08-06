-- V3: Migration para excluir coluna de raça na tabela de cadastros

ALTER TABLE tb_cadastro
DROP COLUMN raça;

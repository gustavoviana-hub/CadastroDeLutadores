-- V7: Migration para excluir coluna de rank na tabela de missoes

ALTER TABLE tb_missoes
DROP COLUMN rank;

-- V1: Cria as tabelas iniciais de cadastro e missões

CREATE TABLE tb_missoes (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255),
                            objetivo VARCHAR(255),
                            status VARCHAR(255),
                            rank VARCHAR(255)
);

CREATE TABLE tb_cadastro (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(255),
                             email VARCHAR(255) UNIQUE,
                             img_url VARCHAR(255),
                             tecnica VARCHAR(255),
                             raça VARCHAR(255),
                             habilidade VARCHAR(255),
                             missoes_id BIGINT,
                             CONSTRAINT fk_cadastro_missoes FOREIGN KEY (missoes_id) REFERENCES tb_missoes(id)
);
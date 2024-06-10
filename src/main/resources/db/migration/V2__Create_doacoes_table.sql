
CREATE TABLE doacoes (
    id BIGSERIAL PRIMARY KEY,
    doador_id BIGINT NOT NULL,
    data DATE NOT NULL,
    tipo_sanguineo VARCHAR(3) NOT NULL,
    quantidade_doada VARCHAR(255) NOT NULL,
    local VARCHAR(255) NOT NULL,
    FOREIGN KEY (doador_id) REFERENCES doadores(id)
);

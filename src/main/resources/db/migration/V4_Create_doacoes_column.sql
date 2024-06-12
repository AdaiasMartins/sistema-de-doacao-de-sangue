ALTER TABLE doacoes ADD COLUMN doador_id BIGINT NOT NULL;
ALTER TABLE doacoes
    ADD CONSTRAINT fk_doador
    FOREIGN KEY (doador_id)
    REFERENCES doadores (id)
    ON DELETE CASCADE;

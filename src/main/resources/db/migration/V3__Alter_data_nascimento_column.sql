ALTER TABLE doadores
ALTER COLUMN data_nascimento
SET DATA TYPE timestamp(6) without time zone
USING data_nascimento::timestamp(6);

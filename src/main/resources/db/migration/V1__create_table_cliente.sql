CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE clientes (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    renda NUMERIC(10, 2) NOT NULL,
    estado VARCHAR(2) NOT NULL

);
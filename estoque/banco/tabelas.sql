CREATE TABLE usuario
  (
    id serial NOT NULL,
    email character varying(255),
    nome character varying(255),
    senha character varying(255),
    CONSTRAINT usuario_pkey PRIMARY KEY (id ),
    CONSTRAINT usuario_email_key UNIQUE (email )
  );

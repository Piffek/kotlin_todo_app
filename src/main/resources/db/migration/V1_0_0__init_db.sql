DROP TABLE IF EXISTS flyway_schema_history;
CREATE TABLE flyway_schema_history
(
    installed_rank integer                 NOT NULL,
    version        character varying(50),
    description    character varying(200)  NOT NULL,
    type           character varying(20)   NOT NULL,
    script         character varying(1000) NOT NULL,
    checksum       integer,
    installed_by   character varying(100)  NOT NULL,
    installed_on   timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer                 NOT NULL,
    success        boolean                 NOT NULL
);
ALTER TABLE ONLY flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
CREATE INDEX flyway_schema_history_s_idx ON flyway_schema_history USING btree (success);


DROP TABLE IF EXISTS subtask;
CREATE TABLE subtask
(
    id            uuid NOT NULL,
    deadline      timestamp without time zone,
    done          boolean,
    rejected      boolean,
    remember_time integer,
    task_id       uuid,
    description   character varying(255),
    title         character varying(255)
);
ALTER TABLE ONLY subtask
    ADD CONSTRAINT subtask_pkey PRIMARY KEY (id);

DROP TABLE IF EXISTS task;
CREATE TABLE task
(
    id       uuid NOT NULL,
    name     character varying(255),
    rejected boolean
);
ALTER TABLE ONLY task
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);

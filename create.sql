create table todo (id bigint generated by default as identity ,prioridade integer, realizado boolean not null, descricao varchar(255), nome varchar(255), primary key (id));

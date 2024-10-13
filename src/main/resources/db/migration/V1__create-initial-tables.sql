-- 1
create table cliente(
                        id bigint primary key auto_increment,
                        nome varchar(255) not null,
                        cpf varchar(11) not null unique,
                        data_nascimento varchar(255) not null,
                        idade int not null,
                        data_cadastro varchar(255) not null,
                        sexo enum('M', 'F') not null,
                        estadocivil varchar(255) not null,
                        nomemae varchar(255) default null,
                        nomepai varchar(255) default null,
                        status_devedor bool default true,
                        email varchar(255) unique
);

-- 2
create table cartao (
                        id bigint primary key auto_increment,
                        numero varchar(16) not null unique,
                        cvv varchar(3) not null,
                        nome varchar(255) not null,
                        validadecartao varchar(255) not null,
                        bandeira varchar(20) not null,
                        status_cartao bool default true,
                        tipo_cartao enum('DEBITO', 'CREDITO'),
                        id_cliente bigint

);

ALTER TABLE cartao
    ADD CONSTRAINT cartao_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES cliente(id);

-- 3
create table fornecedor(
                           id bigint primary key auto_increment,
                           nome varchar(255) not null,
                           cnpj varchar(14) not null,
                           email varchar(80) not null unique,
                           status enum('ATIVO', 'INATIVO', 'PENDENTE'),
                           data_registro date not null,
                           condicoes_pagamento varchar(100)
);
-- 4
create table funcionario(
                            id bigint primary key auto_increment,
                            nome varchar(255) not null,
                            cpf varchar(11) not null unique,
                            data_nascimento varchar(255) not null,
                            idade int not null,
                            sexo enum('M', 'F') not null,
                            departamento varchar(50),
                            cargo varchar(80),
                            estado_civil enum('SOLTEIRO', 'CASADO', 'DIVORCIADO', 'VIUVO') default 'SOLTEIRO',
                            nomemae varchar(255) default null,
                            nomepai varchar(255) default null,
                            email varchar(255) unique,
                            salario float not null
);
-- 5
create table vendedor(
                         id bigint primary key auto_increment,
                         codigo_vendedor varchar(6) not null,
                         quantidade_vendas int not null,
                         comissao_vendas float default 0,
                         cargo varchar(80) not null,
                         data_contratacao varchar(255) not null,
                         meta_vendas int not null,
                         total_vendas int,
                         status varchar(255) not null,
                         id_funcionario bigint unique,
                         foreign key (id_funcionario) references funcionario(id)
);

-- 6
create table endereco(
                         id bigint primary key auto_increment,
                         estado varchar (50) not null,
                         cidade varchar (100) not null,
                         bairro varchar(255) not null,
                         cep varchar(8) not null,
                         rua varchar(255) not null,
                         numero int not null,
                         complemento varchar(255) default null,
                         tipo_endereco enum('INDUSTRIAL', 'RURAL', 'RESIDENCIAL'),
                         id_cliente bigint,
                         id_fornecedor bigint,
                         id_vendedor bigint ,
                         id_funcionario bigint ,
                         foreign key (id_funcionario) references funcionario(id),
                         foreign key (id_vendedor) references vendedor(id),
                         foreign key (id_fornecedor) references fornecedor(id),
                         foreign key (id_cliente) references cliente(id)
);

-- 7
create table telefone(
                         id bigint primary key auto_increment,
                         telefone varchar(11) default null unique,
                         id_cliente bigint default null,
                         id_fornecedor bigint default null,
                         id_vendedor bigint default null,
                         id_funcionario bigint default null,
                         foreign key (id_funcionario) references funcionario(id),
                         foreign key (id_vendedor) references vendedor(id),
                         foreign key (id_fornecedor) references fornecedor(id),
                         foreign key (id_cliente) references cliente(id)
);

-- 8
create table entrega(
                        id bigint primary key auto_increment,
                        status_entrega enum('PENDENTE', 'ANDAMENTO', 'REALIZADO') default 'PENDENTE',
                        id_endereco bigint,
                        id_funcionario bigint,
                        id_fornecedor bigint,
                        data_envio varchar(255) not null,
                        taxa_entrega float not null,
                        metodo_envio enum('TERRESTRE','AQUATICO','AEREO'),
                        observacao varchar(255) not null,
                        foreign key (id_fornecedor) references fornecedor(id),
                        foreign key (id_endereco) references endereco(id),
                        foreign key (id_funcionario) references funcionario(id)
);

-- 9
create table pedido(
                       id bigint primary key auto_increment,
                       quantidade_produtos int not null,
                       preco_total float not null,
                       datapedido varchar(255) not null,
                       tipo_pagamento enum('DINHEIRO', 'CARTAO', 'PIX') default 'DINHEIRO',
                       taxa_entrega float not null,
                       id_entrega bigint,
                       id_cliente bigint ,
                       id_vendedor bigint,
                       foreign key(id_cliente) references cliente(id),
                       foreign key(id_vendedor) references vendedor(id),
                       foreign key (id_entrega) references entrega(id)
);

-- 10
create table produto(
                        id bigint primary key auto_increment,
                        nome varchar(255) not null,
                        preco float not null,
                        marca varchar(40),
                        categoria varchar(50),
                        data_adicao varchar(255) not null,
                        status bool default true,
                        quantidade int not null,
                        validade varchar(255) not null,
                        data_fabricacao varchar(255) not null,
                        codigo_barras varchar(50),
                        id_fornecedor bigint,
                        id_pedido bigint,
                        foreign key(id_pedido) references pedido(id),
                        foreign key (id_fornecedor) references fornecedor(id)
);

create table usuario(
    id bigint primary key,
    login varchar(100) not null,
    senha varchar(100) not null
);
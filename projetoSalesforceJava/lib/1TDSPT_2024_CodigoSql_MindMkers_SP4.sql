/* Grupo: Mind Makers - 1TDSPT
552692 - Luis Henrique Oliveira da Silva
553698 - João Pedro Pereira
553568 - Sabrina da Motta Café*/

/* Apagando as tabelas, para evitar erro (tabela já existente) */
DROP TABLE Efetua CASCADE CONSTRAINTS;
DROP TABLE Forma_Pagamento CASCADE CONSTRAINTS;
DROP TABLE Cargo CASCADE CONSTRAINTS;
DROP TABLE Visita CASCADE CONSTRAINTS;
DROP TABLE Contata CASCADE CONSTRAINTS;
DROP TABLE Busca CASCADE CONSTRAINTS;
DROP TABLE Suporte CASCADE CONSTRAINTS;
DROP TABLE Produto CASCADE CONSTRAINTS;
DROP TABLE Compra_Venda CASCADE CONSTRAINTS;
DROP TABLE Usuario CASCADE CONSTRAINTS;
DROP TABLE Chat_Bot CASCADE CONSTRAINTS;

/* Criando tableas com Constraints e NOT NULL quando necessário */

CREATE TABLE Chat_Bot (
    info_prod VARCHAR(1000) NOT NULL,
    info_tecnica VARCHAR(1000) NOT NULL,
    info_comercial VARCHAR(1000) NOT NULL,
    info_acessibilidade VARCHAR(1000) NOT NULL,
    protocolo_form NUMBER(7) CONSTRAINT Chat_Bot_PK PRIMARY KEY
);

DESC Chat_bot;

CREATE TABLE Usuario (
    empresa_user VARCHAR(35) NOT NULL,
    email_user VARCHAR(60) NOT NULL,
    nome_user VARCHAR(35) NOT NULL,
    cnpj_user CHAR(14) CONSTRAINT Usuario_PK PRIMARY KEY,
    fk_Cargo_id_cargo NUMBER(5) NOT NULL
);

DESC Usuario;

CREATE TABLE Compra_Venda (
    nf_venda NUMBER(7) CONSTRAINT Compra_Venda_PK PRIMARY KEY,
    quantidade NUMBER(3) NOT NULL,
    data_emissao DATE NOT NULL,
    fk_Usuario_cnpj_user CHAR(14) CONSTRAINT Compra_Venda_Usuario_FK REFERENCES Usuario (cnpj_user)
);

DESC Compra_Venda;

CREATE TABLE Produto (
    teste_gratis_prod VARCHAR(1000) NOT NULL,
    avaliacao_prod VARCHAR(1000) NOT NULL,
    planos_prod VARCHAR(1000) NOT NULL,
    cod_prod NUMBER(6) CONSTRAINT Produto_PK PRIMARY KEY
);

DESC Produto;

CREATE TABLE Suporte (
    tipo_suporte VARCHAR(1000) NOT NULL,
    atendimento_suporte VARCHAR(1000) NOT NULL,
    categoria_suporte VARCHAR(1000) NOT NULL,
    protocolo_suporte NUMBER(7) CONSTRAINT Suporte_PK PRIMARY KEY
);

DESC Suporte;

CREATE TABLE Busca (
    fk_Produto_cod_prod NUMBER(6) CONSTRAINT Busca_Produto_FK REFERENCES Produto (cod_prod)
);

DESC Busca;

/*Criando tabela Contata de relacionamento N-N */
CREATE TABLE Contata (
    fk_Suporte_protocolo_suporte NUMBER(7) CONSTRAINT Contata_Suporte_FK REFERENCES Suporte (protocolo_suporte)
);

DESC Contata;

/*Criando tabela Visita de relacionamento N-N */
CREATE TABLE Visita (
    fk_Chat_Bot_protocolo_form NUMBER(7) CONSTRAINT Visita_Chat_Bot_FK REFERENCES Chat_Bot (protocolo_form),
    fk_Usuario_cnpj_user CHAR(14) CONSTRAINT Visita_Usuario_FK REFERENCES Usuario (cnpj_user)
);

DESC Visita;

CREATE TABLE Cargo (
    id_cargo NUMBER(5) CONSTRAINT Cargo_PK PRIMARY KEY,
    nm_cargo VARCHAR(15) NOT NULL,
    salario_cargo NUMBER(6) NOT NULL
);

DESC Cargo;

CREATE TABLE Forma_Pagamento (
    id_forma NUMBER(3) CONSTRAINT Forma_Pagamento_PK PRIMARY KEY,
    nome_forma VARCHAR(10) NOT NULL,
    bandeira_forma VARCHAR(10) NOT NULL
);

DESC Forma_Pagamento

/*Criando tabela Efetua de relacionamento N-N */
CREATE TABLE Efetua (
    fk_Forma_Pagamento_id_forma NUMBER(3) CONSTRAINT Efetua_Forma_Pagamento_FK REFERENCES Forma_Pagamento (id_forma),
    fk_Compra_Venda_nf_venda NUMBER(7) CONSTRAINT Efetua_Compra_Venda_FK REFERENCES Compra_Venda (nf_venda)
);

DESC Efetua;

/* Adicionando uma restrição de foreign key na tabela Usuario, para que cada Usuario se relacione com um Cargo, 
ou seja, não será possível adicionar ou alterar um fk_Cargo_id_cargo na tabela Usuario para um valor que não existe na tabela Cargo */
ALTER TABLE Usuario ADD CONSTRAINT Usuario_Cargo_FK FOREIGN KEY (fk_Cargo_id_cargo) REFERENCES Cargo (id_cargo);

DESC Usuario;

/*-----------------------------------*/

/*Sprint 4*/

/*Inserindo dados em tabelas*/

/*Inserindo dados na tabela Cargo*/
INSERT INTO Cargo (id_cargo, nm_cargo, salario_cargo) VALUES (1, 'Gerente', 7000);
INSERT INTO Cargo (id_cargo, nm_cargo, salario_cargo) VALUES (2, 'Analista', 5000);
INSERT INTO Cargo (id_cargo, nm_cargo, salario_cargo) VALUES (3, 'Desenvolvedor', 4000);

SELECT * FROM Cargo;

/*Inserindo dados na tabela Usuario*/
INSERT INTO Usuario (empresa_user, email_user, nome_user, cnpj_user, fk_Cargo_id_cargo) VALUES ('Empresa A', 'emailteste1@empresa.com', 'Luis Silva', '70955912000100', 1);
INSERT INTO Usuario (empresa_user, email_user, nome_user, cnpj_user, fk_Cargo_id_cargo) VALUES ('Empresa B', 'emailteste2@empresa.com', 'João Pereira', '04472871000169', 2);
INSERT INTO Usuario (empresa_user, email_user, nome_user, cnpj_user, fk_Cargo_id_cargo) VALUES ('Empresa C', 'emailteste3@empresa.com', 'Sabrina Café', '40295157000106', 3);
INSERT INTO Usuario (empresa_user, email_user, nome_user, cnpj_user, fk_Cargo_id_cargo) VALUES ('Empresa D', 'emailteste4@empresa.com', 'Pedro Santos', '45678901234567', 1);

SELECT * FROM Usuario;

/*Inserindo dados na tabela Produto*/
INSERT INTO Produto (teste_gratis_prod, avaliacao_prod, planos_prod, cod_prod) VALUES ('Sim', 'Boa', 'Basico', 1001);

SELECT * FROM Produto;

/*Inserindo dados na tabela Compra_Venda*/
INSERT INTO Compra_Venda (nf_venda, quantidade, data_emissao, fk_Usuario_cnpj_user) VALUES (1, 10, TO_DATE('2023-05-01', 'YYYY-MM-DD'), '70955912000100');
INSERT INTO Compra_Venda (nf_venda, quantidade, data_emissao, fk_Usuario_cnpj_user) VALUES (2, 20, TO_DATE('2023-06-01', 'YYYY-MM-DD'), '04472871000169');

SELECT * FROM Compra_Venda;

/*Atualização de dados*/

/*Atualizando dados na tabela Usuario*/
UPDATE Usuario SET email_user = 'novoemail@empresa.com' WHERE cnpj_user = '70955912000100';
UPDATE Usuario SET empresa_user = 'Nova Empresa A' WHERE cnpj_user = '70955912000100';
UPDATE Usuario SET nome_user = 'Luis H. Silva' WHERE cnpj_user = '70955912000100';

SELECT * FROM Usuario;

/*Remoção de dados*/

/*Removendo dados na tabela Usuario*/
DELETE FROM Usuario WHERE cnpj_user = '40295157000106';

/*Removendo dados na tabela Produto*/
DELETE FROM Produto WHERE cod_prod = 1001;

/*Removendo dados na tabela Compra_Venda*/
DELETE FROM Compra_Venda WHERE nf_venda = 2;


/*Relatórios*/

/*Relatório dos usuários ordenados pelo nome*/
SELECT * FROM Usuario ORDER BY nome_user;

/*Relatório - classificação de dados*/
SELECT empresa_user, email_user, nome_user, cnpj_user
FROM Usuario
ORDER BY nome_user;

/*Relatório mostrando a média salarial*/
SELECT AVG(salario_cargo) AS media_salarial
FROM Cargo;

/*Relatório mostrando a média de salários por cargo*/
SELECT nm_cargo, AVG(salario_cargo) AS media_salarial
FROM Cargo
GROUP BY nm_cargo;

/*Relatório mostrando o número de usuários por empresa*/
SELECT empresa_user, COUNT(*) AS numero_de_usuarios
FROM Usuario
GROUP BY empresa_user;

/*Relatório mostrando os usuários que possuem vendas registradas*/
SELECT nome_user, email_user
FROM Usuario
WHERE cnpj_user IN (SELECT fk_Usuario_cnpj_user FROM Compra_Venda);

/*Relatório mostrando os usuários que têm o cargo 'Gerente'*/
SELECT nome_user, email_user
FROM Usuario
WHERE fk_Cargo_id_cargo = (SELECT id_cargo FROM Cargo WHERE nm_cargo = 'Gerente');

/*Relatório unindo dados de Usuario e Cargo*/
SELECT u.nome_user, u.email_user, c.nm_cargo, c.salario_cargo
FROM Usuario u
JOIN Cargo c ON u.fk_Cargo_id_cargo = c.id_cargo;







































/*
	VIEW DO CLIENTE, POSSIBILITANDO A OBTENÇÃO DE DADOS BÁSICOS VINCULADOS AO CLIENTE COMO: 
    NOME, CPF, E-MAIL, CELULAR, SEXO, FOTO, TELEFONE, DATA DE NASCIMENTO, 
    ENDEREÇO DO CLIENTE E SEUS DADOS DE USUÁRIO.    
*/
CREATE VIEW view_cliente AS 

SELECT

/* CLIENTE */ 
cln.*,

/* USUÁRIO */
usr.usuario,
usr.senha,
usr.log,
usr.ativo,
usr.id_nivel_usuario,

/* NÍVEL USUÁRIO */
nvl.nivel,

/* ENDERECO */
endrc.logradouro,
endrc.numero,
endrc.cidade,
endrc.id_estado,
endrc.cep,
endrc.bairro,
endrc.complemento,

/* ESTADO */
estd.estado

FROM tbl_cliente AS cln

/* TBL_USUARIO */
INNER JOIN tbl_usuario AS usr
ON usr.id_usuario = cln.id_usuario

/* TBL_NIVEL_USUARIO */
INNER JOIN tbl_nivel_usuario AS nvl
ON nvl.id_nivel_usuario = usr.id_nivel_usuario

/* TBL_ENDERECO */
INNER JOIN tbl_endereco AS endrc
ON endrc.id_endereco = cln.id_endereco

/* TBL_ESTADO */
INNER JOIN tbl_estado AS estd
ON estd.id_estado = endrc.id_estado;
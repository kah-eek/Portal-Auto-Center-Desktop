/*
	VIEW DO PARCEIRO, POSSIBILITANDO A OBTENÇÃO DE DADOS BÁSICOS VINCULADOS AO PARCEIRO COMO,
    ENDEREÇO DO PARCEIRO E SEUS DADOS DE USUÁRIO.    
*/
CREATE VIEW view_parceiro AS 

SELECT

/* PARCEIRO */ 
prc.id_parceiro,
prc.nome_fantasia,
prc.cnpj,
prc.razao_social,
prc.id_endereco,
prc.ativo AS parceiro_ativo,
prc.foto_perfil,
prc.email,
prc.socorrista,
prc.telefone,
prc.celular,
prc.log_parceiro,
prc.id_usuario,
prc.id_plano_contratacao,

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

FROM tbl_parceiro AS prc

/* TBL_USUARIO */
INNER JOIN tbl_usuario AS usr
ON usr.id_usuario = prc.id_usuario

/* TBL_NIVEL_USUARIO */
INNER JOIN tbl_nivel_usuario AS nvl
ON nvl.id_nivel_usuario = usr.id_nivel_usuario

/* TBL_ENDERECO */
INNER JOIN tbl_endereco AS endrc
ON endrc.id_endereco = prc.id_endereco

/* TBL_ESTADO */
INNER JOIN tbl_estado AS estd
ON estd.id_estado = endrc.id_estado;
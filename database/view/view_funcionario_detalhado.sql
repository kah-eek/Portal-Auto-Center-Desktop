/*
	VIEW DO FUNCIONARIO, POSSIBILITANDO A OBTENÇÃO DE DADOS VINCULADOS AO FUNCIONARIO COMO,
    ENDEREÇO DO FUNCIONARIO E SEUS DADOS DE USUÁRIO.    
*/
CREATE VIEW view_funcionario_detalhado AS 

SELECT 

/* tbl_funcionario_pac*/
func.*,

/* tbl_cargo_funcionario_pac */
carg_func.cargo,

/* tbl_endereco */
endr.logradouro,
endr.numero,
endr.cidade,
endr.id_estado,
endr.cep,
endr.bairro,
endr.complemento,

/* tbl_estado */
estd.estado,

/* tbl_usuario */
usr.usuario,
usr.senha,
usr.id_nivel_usuario,
usr.log,
usr.ativo AS usuario_ativo,

/* tbl_nivel_usuario */
usr_nvl.nivel

FROM 

/* tbl_funcionario_pac  */
tbl_funcionario_pac AS func

/* tbl_cargo_funcionario_pac */
INNER JOIN tbl_cargo_funcionario_pac AS carg_func
ON carg_func.id_cargo_funcionario_pac = func.id_cargo_funcionario_pac

/* tbl_endereco */
INNER JOIN tbl_endereco AS endr
ON endr.id_endereco = func.id_endereco

/* tbl_estado */
INNER JOIN tbl_estado AS estd
ON estd.id_estado = endr.id_estado

/* tbl_usuario */
INNER JOIN tbl_usuario As usr
ON usr.id_usuario = func.id_usuario

/* tbl_nivel_usuario */
INNER JOIN tbl_nivel_usuario AS usr_nvl
ON usr_nvl.id_nivel_usuario = usr.id_nivel_usuario;
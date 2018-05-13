/*
	VIEW DE FUNCIONARIO, ONDE ESTA EXIBI TODOS OS DADOS BÁSICOS RELACIONADOS AO FUNCIONARIO DE UMA FORMA FORMATADA PARA O USUÁRIO FINAL
*/
CREATE VIEW view_funcionario_simples_formatado AS

SELECT 

/* tbl_funcionario_pac */
func.id_funcionario_pac, 
func.nome, 
func.id_cargo_funcionario_pac, 
DATE_FORMAT(DATE(func.log_funcionario_pac),"%d/%m/%Y") AS data_adimissao,
func.email, 
func.celular,

/* tbl_cargo_funcionario_pac */
carg_func.cargo

FROM 
tbl_funcionario_pac AS func

INNER JOIN tbl_cargo_funcionario_pac AS carg_func
ON carg_func.id_cargo_funcionario_pac = func.id_cargo_funcionario_pac;
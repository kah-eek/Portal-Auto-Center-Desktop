/*
	VIEW DE PARCEIRO, ONDE ESTA EXIBI TODOS OS DADOS BÁSICOS RELACIONADOS AO PARCEIRO DE UMA FORMA FORMATADA PARA O USUÁRIO FINAL
*/
CREATE VIEW view_parceiro_simples_formatado AS

SELECT 

/* tbl_parceiro */
parc.id_parceiro,
parc.nome_fantasia,
parc.razao_social,
parc.cnpj,
parc.id_endereco,
IF(parc.ativo = 1, 'Sim', 'Não') AS ativo,
IF(parc.socorrista = 1, 'Sim','Não') AS socorrista,
parc.email,
parc.telefone,
parc.foto_perfil,
parc.celular,
DATE_FORMAT(DATE(parc.log_parceiro),"%d/%m/%Y") AS log_parceiro,
parc.id_usuario,

/* tbl_plano_contratacao */
pln_contr.plano,
pln_contr.id_plano_contratacao

FROM tbl_parceiro AS parc

/* tbl_plano_contratacao */
INNER JOIN tbl_plano_contratacao AS pln_contr
ON pln_contr.id_plano_contratacao = parc.id_plano_contratacao;
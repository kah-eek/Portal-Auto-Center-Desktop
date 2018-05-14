/*
	VIEW DE CONTA DA PAC, ONDE ESTA EXIBI TODOS OS DADOS RELACIONADOS AS CONTAS DE UMA FORMA FORMATADA PARA O USUÁRIO FINAL
*/
CREATE VIEW view_conta_pac_formatado AS

SELECT 

/* tbl_conta_pac */
cnt.id_conta_pac,
cnt.id_categoria_conta_pac,
cnt.valor,
DATE_FORMAT(DATE(cnt.vencimento),"%d/%m/%Y") AS vencimento,
IF(cnt.paga = 1, 'Sim', 'Não') AS paga,

/* tbl_categoria_conta_pac */
ctg_cnt.categoria

FROM 

/* tbl_conta_pac */
tbl_conta_pac AS cnt

/* tbl_categoria_conta_pac */
INNER JOIN tbl_categoria_conta_pac AS ctg_cnt
ON ctg_cnt.id_categoria_conta_pac = cnt.id_categoria_conta_pac;
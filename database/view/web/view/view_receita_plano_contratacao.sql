/*
	VIEW DE PLANOS DE CONTRATACAO, ONDE SE PODE OBTER O VALOR TOTAL ARRECADADO COM OS PLANOS CONTRATADOS PELO PARCEIROS QUE SE ENCONTRAM ATIVOS
    
*/
CREATE VIEW view_receita_plano_contratacao AS

SELECT 

/* tbl_plano_contratacao */
SUM(pln_contr.valor) AS receita

FROM tbl_plano_contratacao AS pln_contr

/* tbl_parceiro */
INNER JOIN tbl_parceiro AS parc
ON parc.id_plano_contratacao = pln_contr.id_plano_contratacao

WHERE parc.ativo = 1;
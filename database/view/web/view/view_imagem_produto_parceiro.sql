/*
	VIEW DA IMAGEM DE PRODUTOS DO PARCEIRO, POSSIBILITANDO A OBTENÇÃO DE TODOS AS IMAGENS VINCULADAS AO PARCEIRO ATRAVÉS DE SEU NOME (nome_fantazia e razao_social) e seu ID (id_parceiro)
*/
CREATE VIEW view_imagem_produto_parceiro AS 

SELECT

/* tbl_imagem_produto_parceiro */
img_prdt_parc.*,

/* tbl_categoria_produto */
ctg_prdt.categoria,

/* tbl_produto */
prdt.id_categoria_produto,

/* tbl_parciero */
parc.razao_social,
parc.nome_fantasia

FROM tbl_imagem_produto_parceiro AS img_prdt_parc

/* tbl_produto */
INNER JOIN tbl_produto AS prdt
ON prdt.id_produto = img_prdt_parc.id_produto

/* tbl_parceiro */
INNER JOIN tbl_parceiro AS parc 
ON parc.id_parceiro = prdt.id_parceiro

/* tbl_categoria_produto */
INNER JOIN tbl_categoria_produto AS ctg_prdt
ON ctg_prdt.id_categoria_produto = prdt.id_categoria_produto;
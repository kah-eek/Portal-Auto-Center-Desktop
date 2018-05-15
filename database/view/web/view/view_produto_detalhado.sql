/*
	VIEW DE DETALHES DO PRODUTO, POSSIBILITANDO A OBTENÇÃO DE TODOS OS DADOS VINCULADOS AO PRODUTO
*/
CREATE VIEW view_produto_detalhado AS 

SELECT 
/* PRODUTO */
pdrt.*, 
/* MODELO PRODUTO */
mdl_pdrt.modelo,
mdl_pdrt.id_fabricante_produto,
mdl_pdrt.peso,
mdl_pdrt.altura,
mdl_pdrt.comprimento,
/* FABRICANTE PRODUTO */
fbcnt_pdrt.fabricante,
/* PARCEIRO */
parc.nome_fantasia,
parc.razao_social,
parc.cnpj,
parc.id_endereco,
parc.ativo,
parc.socorrista,
parc.email,
parc.telefone,
parc.foto_perfil,
parc.celular,
parc.log_parceiro,
/* ENDERECO */
endrc.logradouro,
endrc.numero,
endrc.cidade,
endrc.id_estado,
endrc.cep,
endrc.bairro,
endrc.complemento,
/* ESTADO */
estd.estado,
/* COR */
cor.cor,
/* CATEGORIA PRODUTO*/
ctg_pdrt.categoria
FROM tbl_produto AS pdrt
INNER JOIN tbl_modelo_produto AS mdl_pdrt 
ON mdl_pdrt.id_modelo_produto = pdrt.id_modelo_produto
INNER JOIN tbl_fabricante_produto AS fbcnt_pdrt
ON fbcnt_pdrt.id_fabricante_produto = mdl_pdrt.id_fabricante_produto
INNER JOIN tbl_parceiro AS parc 
ON parc.id_parceiro = pdrt.id_parceiro
INNER JOIN tbl_endereco AS endrc
ON endrc.id_endereco = parc.id_endereco
INNER JOIN tbl_estado AS estd
ON estd.id_estado = endrc.id_estado
INNER JOIN tbl_cor AS cor 
ON cor.id_cor = pdrt.id_cor
INNER JOIN tbl_categoria_produto AS ctg_pdrt
ON ctg_pdrt.id_categoria_produto = pdrt.id_categoria_produto;

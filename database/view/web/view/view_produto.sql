/*
	VIEW DE PRODUTO, POSSIBILITANDO A OBTENÇÃO DE DADOS BÁSICOS VINCULADOS AO PRODUTO COMO: 
    PARCEIRO;
    ENDEREÇO DO PARCEIRO;
    MODELO DO PRODUTO;
    IMAGEM DO PRODUTO;
    CATEGORIA DO PRODUTO.
    
*/
CREATE VIEW view_produto AS 

SELECT 

/* PRODUTO */
prdt.id_produto,
prdt.nome,
prdt.conteudo_embalagem,
prdt.garantia,
prdt.observacao,
prdt.preco,
prdt.descricao,

/* IMAGEM PRODUTO PARCEIRO */
img_prdt_parc.imagem,

/* MODELO PRODUTO */
mdl_prdt.modelo,

/* PARCEIRO */
parc.id_parceiro,
parc.nome_fantasia,
parc.id_endereco,
parc.telefone,
parc.celular,

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

/* CATEGORIA PRODUTO*/
ctg_prdt.categoria,
ctg_prdt.id_categoria_produto

FROM tbl_produto AS prdt

/* IMAGEM DO PRODUTO DO PARCEIRO */
INNER JOIN tbl_imagem_produto_parceiro AS img_prdt_parc
ON img_prdt_parc.id_produto = prdt.id_produto

/* MODELO DO PRODUTO */
INNER JOIN tbl_modelo_produto AS mdl_prdt
ON mdl_prdt.id_modelo_produto = prdt.id_modelo_produto

/* PARCEIRO */
INNER JOIN tbl_parceiro AS parc
ON parc.id_parceiro = prdt.id_parceiro

/* ENDEREÇO */
INNER JOIN tbl_endereco AS endrc
ON endrc.id_endereco = parc.id_endereco

/* ESTADO */
INNER JOIN tbl_estado AS estd 
ON estd.id_estado = endrc.id_estado

/* CATEGORIA DO PRODUTO*/
INNER JOIN tbl_categoria_produto AS ctg_prdt
ON ctg_prdt.id_categoria_produto = prdt.id_categoria_produto;
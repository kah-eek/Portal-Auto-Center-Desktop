use db_auto_center;


SELECT * FROM tbl_usuario where id_usuario = 66;
SELECT * FROM tbl_parceiro WHERE id_parceiro = 22;

UPDATE tbl_parceiro SET nome_fantasia = 'Disney Company', razao_social = 'Disney Animation LTDA.', cnpj = '0000000', id_endereco = 122, ativo = 1, socorrista = 0, email = 'disney@animation.com', telefone = '6666666', foto_perfil = 'disney.png', celular = '777777', id_usuario = 66, id_plano_contratacao = 2 WHERE id_parceiro = 22;
use db_auto_center;

SELECT * FROM tbl_parceiro;
DESCRIBE tbl_parceiro;
DESCRIBE tbl_endereco;
SELECT * FROM tbl_endereco;
SELECT * FROM tbl_plano_contratacao;
SELECT * FROM tbl_usuario;

INSERT INTO 

tbl_parceiro 
(
	nome_fantasia, 
    razao_social, 
    cnpj, 
    id_endereco, 
    socorrista, 
    email, 
    telefone, 
    foto_perfil, 
    celular, 
    id_usuario, 
    id_plano_contratacao
)
VALUES
(
	'Great Speed', 'Great Speed Importados LTDA', '4986598498', 99, '1', 'greatspeed@gspeed.com.br', '1152145785', 'path', '11124536528', 33, 2
);
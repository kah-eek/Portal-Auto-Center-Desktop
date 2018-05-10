use db_auto_center;

SELECT * FROM tbl_endereco;
DESCRIBE tbl_endereco;

INSERT INTO 

tbl_endereco
(
	logradouro, 
    numero, 
    cidade, 
    id_estado, 
    cep, 
    bairro, 
    complemento
)
VALUES
(
	'Rua Castro Alves', '245', 'São Paulo', '1', '14521452', 'Jardim Vitápolis', 'Casa 03'
);
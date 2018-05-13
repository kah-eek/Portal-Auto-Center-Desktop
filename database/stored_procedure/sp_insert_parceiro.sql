DELIMITER $$

CREATE PROCEDURE sp_insert_parceiro (
	/* VARIÁVEIS DE CADASTRO DO ENDERECO */
	IN _logradouro VARCHAR(210), 
    IN _numero VARCHAR(80), 
    IN _cidade VARCHAR(120), 
    IN _id_estado INT,
    IN _cep VARCHAR(8),
    IN _bairro VARCHAR(120),
    IN _complemento VARCHAR(250),
    
    /* VARIÁVEIS DE CADASTRO DO USUARIO */
    IN _usuario VARCHAR(160),
    IN _senha VARCHAR(280),
    IN _id_nivel_usuario INT,
    
    /* VARIÁVEIS DE CADASTRO DO PARCEIRO */
    IN _nome_fantasia VARCHAR(280),
    IN _razao_social VARCHAR(280),
    IN _cnpj VARCHAR(14),
    IN _socorrista TINYINT(1),
    IN _email VARCHAR(280),
    IN _telefone VARCHAR(11),
    IN _foto_perfil VARCHAR(350),
    IN _celular VARCHAR(12),
    IN _id_plano_contratacao INT,
	
    /* RESPONSE DO INSERT */
    OUT response INT)
BEGIN 
	
   /* VARIAVEIS A SEREM UTILIZADAS */
	DECLARE id_endereco INT;
	DECLARE id_usuario INT;
	DECLARE id_parceiro INT;
    /* --------------------------- */

	/* INSERT DO ENDERECO */
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
		_logradouro, _numero, _cidade, _id_estado, _cep, _bairro, _complemento
	);
    
    /* ARMAZENA O ID DO ENDERECO INSERIDO */
    SET id_endereco = LAST_INSERT_ID();
    
    /* VERIFICA SE A INSERCAO DO ENDERECO OCORREU COM SUCESSO */
    IF(id_endereco != 0) THEN
    
		/* ENDERECO REGISTRADO COM SUCESSO */
		
        /* INSERT DO USUARIO */
        INSERT INTO tbl_usuario 
		(
			usuario,
			senha,
			id_nivel_usuario
		) 
		VALUES
		(
			_usuario, _senha, _id_nivel_usuario
		);
        
        /* ARMAZENA O ID DO USUARIO INSERIDO */
        SET id_usuario = LAST_INSERT_ID();
		
        /* VERIFICA SE A INSERCAO DO USUARIO OCORREU COM SUCESSO */
		IF(id_usuario != 0) THEN 
			
            /* INSERT DO PARCEIRO */
            INSERT INTO tbl_parceiro 
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
				_nome_fantasia, _razao_social, _cnpj, id_endereco, _socorrista, _email, _telefone, _foto_perfil, _celular, id_usuario, _id_plano_contratacao
			);
            
             /* ARMAZENA O ID DO PARCEIRO INSERIDO */
			SET id_parceiro = LAST_INSERT_ID();
            
            /* VERIFICA SE A INSERCAO DO PARCEIRO OCORREU COM SUCESSO */
            IF(id_parceiro != 0) THEN
				
                /* ARMAZENA NA RESPONSE O ID DO PARCEIRO INSERIDO E A RETORNA */
                SET response = id_parceiro;
            
			/* FALAHA AO TENTAR REGISTRAR O USUARIO */
			ELSE
            
				SET response = -1;
            
            END IF;
                        
        /* FALAHA AO TENTAR REGISTRAR O USUARIO */
        ELSE     
			SET @response = -1;
		END IF;
	
    /* FALAHA AO TENTAR REGISTRAR O ENDERECO */
    ELSE
						
		SET response = -1;
        
	END IF;
    /* ----------------------------------------------------------------------------------------------- */
    
    /* RETORNA A RESPONSE FINAL DAS INSERCOES */
    SELECT response;
    
END $$

DELIMITER ;

/*
	TESTE DA STORED PROCEDURE
*/
CALL sp_insert_parceiro
(
	/* tbl_endereco */
	'Rua Carlos Alfreido', 
    '7548', 
    'Barueri', 
    1,
    '14568785',
    'Vila Velha',
    'Casa 03',
    
    /* tbl_usuario */
    'caique',
    '123',
    1,
    
    /* tbl_parceiro */
    'Software LTDA',
    'Software LTDA razao SOcial',
    '5641146541',
    0,
    'software@teste.com.br',
    '1125452154',
    'path',
    '11945587140',
    1,
    @response
);
SELECT @response;
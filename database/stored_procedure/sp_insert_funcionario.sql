DELIMITER $$

CREATE PROCEDURE sp_insert_funcionario (
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
    
    /* VARIÁVEIS DE CADASTRO DO FUNCIONARIO */
    IN _nome VARCHAR(210),
    IN _cpf VARCHAR(11),
    IN _rg VARCHAR(9),
    IN _dt_nascimento date,
    IN _id_cargo_funcionario_pac INT,
    IN _salario DECIMAL(8.2),
    IN _sexo CHAR(1),
    IN _celular VARCHAR(12),
    IN _email VARCHAR(280),
    IN _foto VARCHAR(320),
    IN _cnh VARCHAR(11),
    IN _pis VARCHAR(13),
    IN _certificado_reservista VARCHAR(10),
	
    /* RESPONSE DO INSERT */
    OUT response INT)
BEGIN 
	
   /* VARIAVEIS A SEREM UTILIZADAS */
	DECLARE id_endereco INT;
	DECLARE id_usuario INT;
	DECLARE id_funcionario INT;
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
            INSERT INTO tbl_funcionario_pac 
			(
				nome, 
                cpf, 
                rg, 
                id_endereco, 
                dt_nascimento, 
                id_cargo_funcionario_pac, 
                salario, 
                sexo, 
                celular, 
                email, 
                foto, 
                cnh, 
                pis, 
                certificado_reservista,
                id_usuario
				
			)
			VALUES
			(
				_nome, _cpf, _rg, id_endereco, _dt_nascimento, _id_cargo_funcionario_pac, _salario, _sexo, _celular, _email, _foto, _cnh, _pis, _certificado_reservista, id_usuario
			);
            
             /* ARMAZENA O ID DO PARCEIRO INSERIDO */
			SET id_funcionario = LAST_INSERT_ID();
            
            /* VERIFICA SE A INSERCAO DO PARCEIRO OCORREU COM SUCESSO */
            IF(id_funcionario != 0) THEN
				
                /* ARMAZENA NA RESPONSE O ID DO PARCEIRO INSERIDO E A RETORNA */
                SET response = id_funcionario;
            
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
CALL sp_insert_funcionario
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
    
    /* tbl_funcionario_pac */
    'Caique',
    '12587456985',
    '123587854',
    '1997-06-24',
    1,
    4750,
    'M',
    '11945587140',
    'caique@pac.com.br',
    'path',
    '452156',
    '56165165',
    '612651',
    @response
);
SELECT @response;
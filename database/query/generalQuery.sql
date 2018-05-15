use db_auto_center;

SELECT * FROM tbl_funcionario_pac;
SELECT * FROM tbl_usuario;

SELECT cpf,dt_nascimento FROM tbl_funcionario_pac WHERE dt_nascimento = '1998-02-24' AND cpf = '5489489';

SELECT * FROM tbl_pagamento_funcionario_pac WHERE id_pagamento_funcionario_pac = 188;
SELECT * FROM view_pagamento_funcionario_detalhado_formatado;
DELETE FROM tbl_pagamento_funcionario_pac WHERE id_pagamento_funcionario_pac != -1;

UPDATE tbl_pagamento_funcionario_pac SET pago = 1, data_pagamento_realizado = now() WHERE id_pagamento_funcionario_pac = 281;
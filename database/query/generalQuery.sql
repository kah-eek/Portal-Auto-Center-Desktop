use db_auto_center;

SELECT * FROM tbl_funcionario_pac;
SELECT * FROM tbl_usuario;

SELECT * FROM tbl_pagamento_funcionario_pac;
DELETE FROM tbl_pagamento_funcionario_pac WHERE id_pagamento_funcionario_pac != -1;
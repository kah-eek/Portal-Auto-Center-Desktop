use db_auto_center;

SELECT * FROM tbl_funcionario_pac;
SELECT * FROM tbl_usuario;

SELECT * FROM tbl_pagamento_funcionario_pac;
DELETE FROM tbl_pagamento_funcionario_pac WHERE id_pagamento_funcionario_pac != -1;

insert into tbl_pagamento_funcionario_pac (id_funcionario_pac)
 select id_funcionario_pac from tbl_funcionario_pac;
 
 INSERT INTO tbl_pagamento_funcionario_pac (id_funcionario_pac) 
SELECT id_funcionario_pac FROM tbl_funcionario_pac;

ALTER TABLE tbl_pagamento_funcionario_pac 
ADD COLUMN data_pagamento_realizado DATETIME NULL,
CHANGE COLUMN log_pagamento_funcionario_pac mes_pagamento DATETIME NOT NULL DEFAULT now();
/*
	VIEW DE PAGAMENTO DOS SALÁRIOS DOS FUNCIONÁRIOS DE FORMA FORMATADA PARA O USUARIO FINAL
*/
CREATE VIEW view_pagamento_funcionario_detalhado_formatado AS 

SELECT 

/* tbl_pagamento_funcionario_pac */
pgm_func.id_pagamento_funcionario_pac, 
pgm_func.id_funcionario_pac,
IF(pgm_func.pago = 0, 'Não','Sim') AS pago,
DATE_FORMAT(DATE(pgm_func.mes_pagamento), "%m/%Y") AS mes_pagamento,
DATE_FORMAT(DATE(pgm_func.data_pagamento_realizado),"%d/%m/%Y") AS data_pagamento_realizado,

/* tbl_funcionario_pac */
func.nome,
func.salario

FROM 

/* tbl_pagamento_funcionario_pac */
tbl_pagamento_funcionario_pac AS pgm_func

/* tbl_funcionario_pac */
INNER JOIN tbl_funcionario_pac AS func
ON func.id_funcionario_pac = pgm_func.id_funcionario_pac;

SELECT * FROM view_pagamento_funcionario_detalhado_formatado;
/*
	VIEW DAS DESPESAS INTERNAS DA EMPRESA.
    POSSIBILITA A OBTENÇÃO DO VALOR TOTAL DE DESPESAS INTERNAS DA EMPRESA, TENDO ESTA A BASE DE CÁLCULO O SALÁRIOS DOS FUNCIONÁRIOS E CONTAS (LUZ, ÁGUA, Telefone, ETC)
*/
CREATE VIEW view_total_despesas_internas AS

SELECT 

/* VALORES DAS CONTAS COMO ÁGUA, LUZ, TELEFONE, ECT. */
SUM(contas.valor)+
/* VALORES DOS SALÁRIOS DOS FUNCIONÁRIOS */
SUM(func.salario) 
AS total_despesa

FROM tbl_conta_pac AS contas, /* tbl_conta_pac */
tbl_funcionario_pac AS func;  /* tbl_funcionario_pac */
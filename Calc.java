

// System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));

// <hr>
/* <b>class Calc</b>  
   A classe Calc será utilizada diretamente, não haverá um <u>objeto</u> calculadora, então
   o método "Main()", e os demais métodos da classe CALC, devem ser <u>static</u> 
*/   
// <pre>
class Calc
{
	static double Adicao( double p_Prim, double p_Seg )
	{
		return (p_Prim + p_Seg);
	}
	
	static double Subtracao( double p_Prim, double p_Seg )
	{
		return (p_Prim - p_Seg);
	}
	
	static void CaixaBranca()
	{
		// Variáveis:
			String Casos_de_Teste[][] = { 
										  {"Adicao", "27", "13", "40" }, 
										  {"Subtracao", "50", "60", "-10" },
										  {"Adicao", "123", "321", "444" },
										  {"Subtracao", "99", "9", "11" }, 
										  {"Divisao", "63", "9" , "7" },
										  {"Divisao", "63", "9" , "4"}
										};
			int quant_teste = 0;
			int cont_teste = 0;
			String teste[] = { "", "", "", "" };
			String operacao = "";
			double prim_Oper = 0;
			double seg_Oper = 0;
			double esperado = 0;
			double calculado = 0;
			String resultado_teste = "";
			String mensagem = "";
		
		// Programa:
			quant_teste = Casos_de_Teste.length;
			for(cont_teste=0; cont_teste<quant_teste; cont_teste++)
			{
				// Executa o teste:
					operacao = Casos_de_Teste[cont_teste][0];
					prim_Oper = Double.parseDouble(Casos_de_Teste[cont_teste][1]);
					seg_Oper = Double.parseDouble(Casos_de_Teste[cont_teste][2]);
					esperado = Double.parseDouble(Casos_de_Teste[cont_teste][3]);
					
					switch(operacao)
					{
						case "Adicao": calculado = Adicao(prim_Oper, seg_Oper); 
									   break;
						case "Subtracao": calculado = Subtracao(prim_Oper, seg_Oper); 
										  break;
						case "Divisao": calculado = Divisao(prim_Oper, seg_Oper); 
										  break;
					}
					
				// Mostra o resultado do teste:
					resultado_teste = (calculado==esperado?"\t\tOk":"\t\tFalhou");
					
					mensagem = operacao+": "+prim_Oper+" e "+seg_Oper+" = "+
							   calculado+"/"+esperado+" => "+resultado_teste;
					
					System.out.println(mensagem);
			}
	}
	
	static double Divisao(double op1, double op2)
	{
		return op1 / op2;
	}
	
	public static void main(String[] p_Args)
	/*
		1. p_Args[0]: Operação
		2. p_Args[1]: Primeiro operando
		3. p_Args[2]: Segundo operando
	*/
	{
		// Variáveis:
			String operacao = "";
			double prim_Oper = 0;
			double seg_Oper = 0;
			double resultado = 0;
		
		// Programa:		
			operacao = p_Args[0];
			if ( operacao.equals("CaixaBranca") )
			{
				CaixaBranca();
			}
			else
			{
				prim_Oper = Double.parseDouble(p_Args[1]);
				seg_Oper = Double.parseDouble(p_Args[2]);
				
				switch(operacao)
				{
					case "Adicao": resultado = Adicao(prim_Oper, seg_Oper); break;
					case "Subtracao": resultado = Subtracao(prim_Oper, seg_Oper); break;
					case "Divisao": resultado = Divisao(prim_Oper, seg_Oper); break;
				}
				
				System.out.println(resultado);
			}
	}
}
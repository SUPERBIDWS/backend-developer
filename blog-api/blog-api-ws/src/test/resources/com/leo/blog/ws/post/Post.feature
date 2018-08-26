# language: pt

Funcionalidade: Consulta de postagens do blog

Esquema do Cenario: Consulta de post com suscesso

	Dado o id do post "<id>"
	Quando realizada uma consulta 
	Então deve retornar <statusCode> com os seguintes dados: <id> "<titulo>" "<dataPublicacao>" "<descricao>"
	
Exemplos:
|id|statusCode|titulo 	    |dataPublicacao     |descricao		      |
|1 |200		  |Post inicial |2018-08-22T21:35:10|Primeiro post do blog|
	
Esquema do Cenario: Consulta de post com retorno 404

	Dado o id do post "<id>"
	Quando realizada uma requisiçao cujo resultado é um not found
	Então deve retornar <statusCode>  e "<statusMessage>"
	
Exemplos:
|id|statusCode|statusMessage|
|1 |404		  |Not Found    |

Esquema do Cenario: Consulta de post com retorno 400

	Dado o id do post "<id>"
	Quando realizada uma requisiçao cujo resultado é um bad request
	Então deve retornar <statusCode>  e "<statusMessage>"
	
Exemplos:
|id|statusCode|statusMessage|
|a |400		  |Bad Request	|

Esquema do Cenario: Consulta de post com retorno 500

	Dado o id do post "<id>"
	Quando realizada uma requisiçao cujo resultado é um erro do servidor
	Então deve retornar <statusCode>  e "<statusMessage>"
	
Exemplos:
|id|statusCode|statusMessage		|
|1 |500		  |Internal Server Error|

	
# Superbid Webservices

# Teste prático 

API Rest desenvolvida utilizando a metodologia Test Driven Development (TDD).
Optou-se por consumir / produzir objetos JavaScript Object Notation (JSON) nos corpos da requisição e resposta. 

## Tecnologias utilizadas

* Spring Model-View-Controller: Fornece as anotações e a estrutura necessária para criar os pontos de extremidade REST por meio de HTTP.
* Spring Boot: Fornece uma estrutura de convenção sobre configuração e permite desenvolver e lançar serviço da Web no padrão do Spring.
* Apache Maven: Ferramenta de gerenciamento de compilação e dependência usada para criar, executar testes e empacotar serviço da Web em um arquivo JAR.
* JUnit: Para realizar testes unitários automatizados.
* Rest-assure: Framework para testar e validar serviços REST. 
* Postman: Ferramenta para testar e validar serviços REST. 
* Java 8: Linguagem de programação
* Git / GitHub: Ferramenta para versionamento do código
* H2: Banco de dados em memória

## Plano de ação:
	
	Definição das entidades - representação do post
	Definição dos repositorios - interação com o banco de dados
	Definição dos testes  
	Definição dos controller - mapeamento dos endpoints da aplicação
	Definição dos serviços - implementação das regras de negócio
	Definição DTO - para transferência de dados
		
REST Endpoints:
	
	GET: http://localhost:8080/blog/post -> Recupera a lista de todos os posts do blog -> 200 OK
	GET: http://localhost:8080/blog/post/{id} -> Recupera um post de acordo com o id -> 200 OK  ou 404 Not Found
	POST: http://localhost:8080/blog/post/ -> Adiciona / atualiza um post de acordo com o payload da requisição -> 201 Created ou 400 Bad Request
	DELETE: http://localhost:8080/blog/post/{id} ->  Exclui um post de acordo com o id passado -> 200 OK

**Devido a API ser apenas um protótipo optou-se por fazer a atualização utilizando o verbo POST ao invés do verbo PUT**. 
 
# Questionário

* Você já trabalhou com Spring Boot?
* O que você conhece sobre micro-serviços?
* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
* Qual a sua experiência na construção de APIs?
* Alguma vez já teve que construir uma API pública?
* Como você controla o acesso à API?
* Como você trata questões da evolução das APIs?
* Você acha válido fazer testes automatizados?
* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?
* Você conhece ou já trabalhou com containers?
* E orquestradores tipo Kubernetes ou Docker Swarm?
* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git?
* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?
* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?
* Você já trabalhou com SCRUM ou Kanban?
* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.



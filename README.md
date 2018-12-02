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

Sim. O Spring Boot facilita muito o processo de configuração e publicação das aplicações. 
Entendo que ele é uma ferramenta obrigatória nas aplicações Spring uma vez que permite ter 
um projeto rodando mais rápido e eliminando muitas complicações.

* O que você conhece sobre micro-serviços?

Microservice é um estilo arquitetural. Nele em vez da aplicação ser um grande monolito, ela é particionada 
em partes menores independentes e que colaboram entre si. Desta forma cada serviço pode ser implementando na 
tecnologia que se desejar, ter seu próprio banco de dados, ser deployado independentemente de outros etc.

* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
Como vantagens tem-se a facilidade para escalar e manter a aplicação, permite atualizações mais rápidas, 
complexidade mais simples comparando ao monolito, independência no desenvolvimento e deploy. Assim conseguindo disponibilizar funcionalidades mais rápido, 
liberdade na escolha de tecnologias e código criado e organizado em torno de uma funcionalidade do negócio.


Microserviços possuim alguns desafios. Como são unidades menores de funcionalidade que se comunicam por meio de APIs exigem métodos mais robustos de teste, 
deve se sempre ter em mente que um serviço pode falhar, exige um maior gerenciamento além do desafio da segurança dos aplicativos.


* Qual a sua experiência na construção de APIs?

Não tenho experiência profissional do desenvolvimento de APIs. As empresas que tive oportunidade de trabalhar 
utilizam sistemas monolito. Porém, tenho estudado e desenvolvido APIs em projetos pessoais.

* Alguma vez já teve que construir uma API pública?

Ainda não tive esta oportunidade.

* Como você controla o acesso à API?

Para proteger a APIs iria fazer uso de um certificados do lado do servidor e Spring Security junto com OAuth2 para proteger os pontos de extremidade.

* Como você trata questões da evolução das APIs?

Se não for preciso alterar a interface da API é possível evoluir a mesma de forma mais fácil. 
Se for preciso alterar a interface normalmente não será possível forçar todos os clientes a atualizarem para a nova. Assim, 
iria pelo caminho da implementação de novas versões de forma incremental de maneira que as versões novas e antigas sejam executadas simultaneamente. 

* Você acha válido fazer testes automatizados?

Extremamente válido. Entendo que é uma das principais formas de garantir a qualidade da aplicação e o caminho para se chegar ao Continuous Deployment.

* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?

Através da escalabilidade. Iria planejar um número suficiente de instâncias da API para atender a demanda.

* Você conhece ou já trabalhou com containers?

Sim. Conheco Docker.

* E orquestradores tipo Kubernetes ou Docker Swarm?

Sim. Conheco os dois.

* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git?

Gosto muito de trabalhar com pequenos commits, entendo que assim é mais fácil para fazer o merge.
Conheço e trabalho com git a algum tempo.

* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?

Gosto de trabalhar com um branch de desenvolvimento mas mantendo o mesmo o mais próximo possível do master. 
Meu github é: https://github.com/lincolnppires. 
Tenho repositorios de aplicações Spring, Microservices com kubernetes, Api Rest, design patters com Python e alguns outros.

* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?

Conheço. Onde trabalhava anteriormente estavamos no processo de implantação de CI. Utilizavamos o Jenkins.

* Você já trabalhou com SCRUM ou Kanban?
Conheço as duas metodologias. Gosto muito do SCRUM. Trabalhava com o SCRUM de forma adaptada.

* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.

Entendo que a dificuldades é mais cultural. 
É preciso que as pessoas envolvidas estejam motivadas com a metodologia e o processo.  



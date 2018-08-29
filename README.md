# blog

This is a simple blog application that uses Spring Boot, H2, Spring Data JPA and Spring Rest. This application provides the services of creating, editing, searching and deleting a post.

## Requirements
* Maven
* Java 8 and up

## Usage

Application is using Maven as a dependency management system, so all required libraries should be downloaded automatically. The project use Spring Boot and H2 running in in-memory mode is used as a database. All these services are configured automatically and no action from user is required to set them up.

```
$ git clone git://github.com/igotavares/blog.git
$ cd blog/
$ mvn compile
$ cd blog-war/
$ mvn spring-boot:run
```

## Tests

Following the order of the commands below it will be possible to test the services obtaining the respective results

Testing the create post service

```
curl -H "Content-Type: application/json" --request POST -d "{\"title\":\"Welcome\",\"description\":\"to the new world\",\"publicationDate\":\"2018-01-01 00:00:00\"}"  localhost:8080/blog/posts
```

Result

```
{"id":1}
```

Testing post search service

```
curl localhost:8080/blog/posts
```

Result

```
[{"id":1,"title":"Welcome","description":"to the new world","publicationDate":"2018-01-01 00:00:00"}]
```

Testing the post search service by id

```
curl localhost:8080/blog/posts/1
```

Result

```
{"id":1,"title":"Welcome","description":"to the new world","publicationDate":"2018-01-01 00:00:00"}
```

Testing the post change service

```
curl -H "Content-Type: application/json" --request PUT -d "{\"id\":1,\"title\":\"Title\",\"description\":\"Description\",\"publicationDate\":\"2019-01-01 00:00:00\"}" localhost:8080/blog/posts/1
```

Testing the post delete service

```
curl --request DELETE  localhost:8080/blog/posts/1
```

### Postman

```
https://www.getpostman.com/collections/b3680b4f92c7ef093a57
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Release History

* 1.0-SNAPSHOT
  * Work in progress


## Question�rio


* Voc� j� trabalhou com Spring Boot?
 
  	Sim, a maorias dos projetos na empresa na qual estou trabalhando utiliza Spring Boot. 

* O que voc� conhece sobre micro-servi�os?
	
	Tenho conhecimento sobre os conceitos, alguns padr�es adotados na arquitetura de micro-servi�os e tive a oportunidade de trabalhar em um processo de implanta��o de micro-servi�os na empresa que trabalho.
			
 
* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
  	As vantagens s�o que as aplica��es ficam mais flex�veis, escal�veis e com manuten��o mais simples.
  	A desvantagem � o aumento da complexidade das aplica��es.
 
* Qual a sua experi�ncia na constru��o de APIs?

	Foram poucas empresas na qual trabalhei que n�o tinham APIs. Ent�o j� criei APIs e dei manuten��es em algumas APIs,

* Alguma vez j� teve que construir uma API p�blica?
   
	N�o at� o presente momento.
  
* Como voc� controla o acesso � API?
  
	Utilizando Token. 
  
* Como voc� trata quest�es da evolu��o das APIs?	 		
	
	A evolu��o de uma API deve ser algo meticulosamente analisado para poder mensurar os seus impactos nas solu��es que elas afetam. Em alguns casos � recomendado trabalhar com um processo de versionamento dos servi�os, caso a API contenha uma grande quantidade de consumidores.
 
* Voc� acha v�lido fazer testes automatizados?
  
	Sim, trabalho no processo de implata��o de testes automatizados na fase de desenvolvimento. Atuo como Coaching de testes.

* Imagine que voc� precisa construir uma API que vai ter um grande n�mero de acessos. Como voc� garante que ela ter� um tempo de resposta acess�vel durante um pico de acesso?
	
	Escalando a aplica��o utilizando cluster e load balance.

* Voc� conhece ou j� trabalhou com containers?

	Tenho conhecimento. No momento n�o tenho experi�ncia na utiliza��o do docker em uma empresa, mas estou estudando, experimentando e adotando o docker nos projetos pessoais.

* E orquestradores tipo Kubernetes ou Docker Swarm?

	Tenho conhecimento, mas n�o trabalhei com os orquestradores.
  
* Fale um pouco sobre o processo de versionamento de aplica��es. Conhece Git?
  	
	Conhe�o o git. O versionamento de aplica��es � extremamente importante no desenvolvimento de software pois ele armazena o seu c�digo fonte mantendo o hist�rico. O versionamento facilita no desenvolvimento em equipes, pois a equipe consegue trabalhar em uma determinada vers�o do software sem impactar outras equipes ou uma derminada entrega.

* Como voc� usa branches, tags, etc. Tem algo no Github ou Gitlab?
	Utilizo as branches da seguinte forma: utilizo a master como Tag e nela cont�m a �ltima vers�o da aplica��o que est� em produ��o. Develop � a �ltima vers�o da aplica��o que est� em desenvolvimento, as feature branches s�o criadas para conter as novas demandas, hotfixes s�o as branches criadas para corre��es de bug de produ��o e a release branches s�o criadas para manter o c�digo que ser� disponibilizado em outro ambiente que n�o � o de produ��o.  
	Tenho projeto no Github e no Bitbucket.

* Voc� conhece CI/CD? J� chegou a fazer algum pipeline de CI/CD completo?
	Conhe�o, a empresa na qual trabalho j� tinha um processo CD. Na empresa atuei na arquitetura, desenvolvimento e implata��o dos testes de aceita��o seguindo a metodologia do BDD, configurei o jenkins e o servidor para a execu��o dos testes automatizados. Automatizei as execu��es dos scripts de banco de dados nos ambientes. 
	Sim, j� criei um pipeline completo.     
  
* Voc� j� trabalhou com SCRUM ou Kanban?
   	Sim, trabalhei com os dois.
  
* Conte um pouco sobre como foi fazer parte de um time �gil, quais dificuldades tiveram e como conseguiram superar.
	Participei de um processo de implata��o do Scrum na empresa que trabalho. Foram alguns meses de trabalho �rduo para conseguir a unifica��o da equipe, manter os rituais do SCRUM e manter as scripts sem altera��o de escopo. O Processo funcionou por alguns meses mas foi desfeito com a entrada da nova ger�ncia.
 
	
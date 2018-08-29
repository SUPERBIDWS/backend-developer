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


## Questionário


* Você já trabalhou com Spring Boot?
 
  	Sim, a maorias dos projetos na empresa na qual estou trabalhando utiliza Spring Boot. 

* O que você conhece sobre micro-serviços?
	
	Tenho conhecimento sobre os conceitos, alguns padrões adotados na arquitetura de micro-serviços e tive a oportunidade de trabalhar em um processo de implantação de micro-serviços na empresa que trabalho.
			
 
* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
  	As vantagens são que as aplicações ficam mais flexíveis, escaláveis e com manutenção mais simples.
  	A desvantagem é o aumento da complexidade das aplicações.
 
* Qual a sua experiência na construção de APIs?

	Foram poucas empresas na qual trabalhei que não tinham APIs. Então já criei APIs e dei manutenções em algumas APIs,

* Alguma vez já teve que construir uma API pública?
   
	Não até o presente momento.
  
* Como você controla o acesso à API?
  
	Utilizando Token. 
  
* Como você trata questões da evolução das APIs?	 		
	
	A evolução de uma API deve ser algo meticulosamente analisado para poder mensurar os seus impactos nas soluções que elas afetam. Em alguns casos é recomendado trabalhar com um processo de versionamento dos serviços, caso a API contenha uma grande quantidade de consumidores.
 
* Você acha válido fazer testes automatizados?
  
	Sim, trabalho no processo de implatação de testes automatizados na fase de desenvolvimento. Atuo como Coaching de testes.

* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?
	
	Escalando a aplicação utilizando cluster e load balance.

* Você conhece ou já trabalhou com containers?

	Tenho conhecimento. No momento não tenho experiência na utilização do docker em uma empresa, mas estou estudando, experimentando e adotando o docker nos projetos pessoais.

* E orquestradores tipo Kubernetes ou Docker Swarm?

	Tenho conhecimento, mas não trabalhei com os orquestradores.
  
* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git?
  	
	Conheço o git. O versionamento de aplicações é extremamente importante no desenvolvimento de software pois ele armazena o seu código fonte mantendo o histórico. O versionamento facilita no desenvolvimento em equipes, pois a equipe consegue trabalhar em uma determinada versão do software sem impactar outras equipes ou uma derminada entrega.

* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?
	Utilizo as branches da seguinte forma: utilizo a master como Tag e nela contém a última versão da aplicação que está em produção. Develop é a última versão da aplicação que está em desenvolvimento, as feature branches são criadas para conter as novas demandas, hotfixes são as branches criadas para correções de bug de produção e a release branches são criadas para manter o código que será disponibilizado em outro ambiente que não é o de produção.  
	Tenho projeto no Github e no Bitbucket.

* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?
	Conheço, a empresa na qual trabalho já tinha um processo CD. Na empresa atuei na arquitetura, desenvolvimento e implatação dos testes de aceitação seguindo a metodologia do BDD, configurei o jenkins e o servidor para a execução dos testes automatizados. Automatizei as execuções dos scripts de banco de dados nos ambientes. 
	Sim, já criei um pipeline completo.     
  
* Você já trabalhou com SCRUM ou Kanban?
   	Sim, trabalhei com os dois.
  
* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.
	Participei de um processo de implatação do Scrum na empresa que trabalho. Foram alguns meses de trabalho árduo para conseguir a unificação da equipe, manter os rituais do SCRUM e manter as scripts sem alteração de escopo. O Processo funcionou por alguns meses mas foi desfeito com a entrada da nova gerência.
 
	
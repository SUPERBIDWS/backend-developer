# Quer fazer parte da Superbid Webservices?

Obrigado por se interessar em fazer parte do nosso time!

Esse teste faz parte de uma das etapas do nosso processo de seleção e o objetivo é avaliarmos o seu nível de conhecimento nas tecnologias que usamos. Nesse teste você terá 2 tarefas:

* responder um questionário sobre tecnologia e metodologia de desenvolvimento
* construir uma aplicação simples para termos ideia de como é o seu código e o que você considera importante em um projeto

O questionário e a especificação da aplicação estão logo abaixo.

**A sua entrega será feita através de um Pull Request nesse repositório**. Faça um fork do repositório, implemente o seu código, responda as questões no `README.md` e faça um pull request. Sinta-se a vontade para colocar quaisquer outras informações que você considere pertinente no `README`.

# Questionário

* Você já trabalhou com Spring Boot?
> Sim. Trabalho com Spring Boot desde 2016. 
* O que você conhece sobre micro-serviços?
> Sobre micro-serviços eu tenho experiência com Spring Boot desde a criação, testes até o deploy utilizando docker. Claro tudo com o adorado Jenkins. :-)
* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
> A principal vantagem é que cada serviço é responsável por um domínio(ou entidade) como diz Eric Evans. A principal desvantagem que vejo é que para testar você têm que criar vários projetos e dependendo do tamanho do projeto dá um trabalho monstro. Porém é legal. :-)
* Qual a sua experiência na construção de APIs?
> Possuo experiência na construção de APIs internas apenas, preferencialmente, utilizando a notação /version/entity.
* Alguma vez já teve que construir uma API pública?
> Não tive a oportunidade de trabalhar na construção de API públicas, já consumi várias porém construir ainda nenhuma. :-( 
* Como você controla o acesso à API?
> Utilizando Oauth ou Oauth2, preferencialmente com Bearer Authentication.
* Como você trata questões da evolução das APIs?
> A evolução das APIs eu deixo sempre a antiga rodando, e crio sempre uma nova, quando possível, utilizando a notação /version/entity.
* Você acha válido fazer testes automatizados?
> Sim, acho muito importante tanto a utilização de testes unitários no backend e BDD nos testes automatizados integrados ou regressivos.
* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?
> Neste tipo de problema eu gosto de utilizar filas, geralmente RabbitMQ, Kafka ou até mesmo o Redis já me ajudaram bastante. 
* Você conhece ou já trabalhou com containers?
> Sim já trabalho com conteiners docker a 3 anos.
* E orquestradores tipo Kubernetes ou Docker Swarm?
> K8s eu nunca utilizei, já trabalhei com Docker Swarm por 2 anos.
* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git?
> Gosto muito de utilizar o Git/BitBucket/GitLab facilita muito nossa vida de dev, para os casos que fazemos algumas besteiras no código e é possível retornar a versão anterior/original. 
* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?
> Sim, utilizo branches sempre que preciso incluir uma nova característica no código ou então dar manutenção, assim facilita o merge e separa o código bom do código novo(com possíveis bugs). E tagueamente(tag) eu ainda não sei fazer. 
* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?
> Sim já trabalhei com CI com jenkins e docker efetuando deploy em homologação, CD eu ainda não tive a oportunidade de trabalhar.
* Você já trabalhou com SCRUM ou Kanban?
> Sim trabalho com SCRUM(pre-planning,planning,sprint 20 dias,daily, review e retro) e Kanban (JIRA) desde 2016.
* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.
> Eu gosto muito de fazer parte de um time ágil, porém uma das dificuldades que percebo em alguns times é que alguns membros não entregam o que prometem na daily e nem comunicam os outros membros do time, e o pior é que o membro não comunica os bloqueios durante a daily então dessa forma fica realmente dificil de ajudar. Até hoje não sei se é vergonha de pedir ajuda ou é a educação da pessoa. Talvez um dia eu estude mais sobre isso. :-)

# Teste prático (prazo 3 dias)

Considerando a funcionalidade de um blog, construa uma API Rest contendo as operações de básicas de CRUD: inclusão, atualização, exclusão e consulta. O recurso em questão deve ter a seguinte estrutura:

* Post
* ID
* Data de Publicação
* Título
* Descrição

## Tecnologias utilizadas 

* Spring Boot
* Java 8
* Hibernate
* Banco de dados em memória
* Postman Collection (para testes da api)

## Critérios a serem avaliados:

* Qualidade de Código
* Cobertura de Testes
* Definição dos Serviços Rest
* Documentação
* Qualquer critério que vocês considere pertinente

Uma dica: pense no teste prático como sendo um algo real que você faria ou gostaria de fazer no seu trabalho, pois esse será o seu cartão de visitas.

# Quer fazer parte da Superbid Webservices?

Obrigado por se interessar em fazer parte do nosso time!

Esse teste faz parte de uma das etapas do nosso processo de seleção e o objetivo é avaliarmos o seu nível de conhecimento nas tecnologias que usamos. Nesse teste você terá 2 tarefas:

* responder um questionário sobre tecnologia e metodologia de desenvolvimento
* construir uma aplicação simples para termos ideia de como é o seu código e o que você considera importante em um projeto

O questionário e a especificação da aplicação estão logo abaixo.

**A sua entrega será feita através de um Pull Request nesse repositório**. Faça um fork do repositório, implemente o seu código, responda as questões no `README.md` e faça um pull request. Sinta-se a vontade para colocar quaisquer outras informações que você considere pertinente no `README`.

# Questionário

* Você já trabalhou com Spring Boot?
Sim, nos últimos dois anos tenho atuado em uma arquitetura de microserviços(cerca de 80), utilizando tecnologias como spring boot e a suíte netflix oss(zuul, eureka, ribbon e etc...).


* O que você conhece sobre micro-serviços?
Micro-serviços é uma forma de desenvolver software, quebrando em mini pedaços, onde cada pedaço que é uma aplicação/serviço, representa uma área especializada de domínio de um negócio. Ex: Se uma empresa possui um departamento de RH e outro de Marketing, e iremos desenvolver para ambos, o ideal é que tenhamos no mínimo dois microserviços, ou seja, um específico para cada área.

* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
Vantagens: Equipes e atividades independentes, deploys independentes, desenvolvimento orientado ao negócio, uma vez que a estrutura de microserviços devem refletir a estrutura organizacional da empresa/negócio. 
Dificuldades: Mais difícil de depurar, manter em um fluxo a idempotência dos dados e etc, gerenciamento de versões e dependências de outros microserviços e etc..

* Qual a sua experiência na construção de APIs?
Tenho atuado na construção de apis por 8 anos, tendo a oportunidade de atuar com o desenvolvimeto de webservices SOAP, utilizando apache CXF, Spring e mais especificamente nos últimos 2 anos atuando com REST.

* Alguma vez já teve que construir uma API pública?
Sim. O projeto anterior consistia na plataforma de financiamento de autos do Santander. Se tratava de um conjunto de apis(composta por cerca de 80 microserviços) que eram consumidas por um front Angular e apps mobile, onde qualquer pessoa poderia acessar e preencher uma proposta de financiamento de auto.


* Como você controla o acesso à API?
Token/JWT.

* Como você trata questões da evolução das APIs?
Utilizando versionamento e/ou através de apis como graphql, que fazendo uma interface com as apis, abstraindo e alterações nas mesmas, reduzindo impactos em alterações.

* Você acha válido fazer testes automatizados?
Sem dúvida. Hoje uma necessidade estratégica de qualquer negócio, é poder corrigir e entregar essa correção para o cliente o mais rápido possível.
E isso só é possível através de um processo de integração contínua. E um dos pilares da IC é o teste automatizado.
Ele ajuda manter a qualidade do código, assegurando que novas funcionalidades/alterações não impactarão o que já está funcionando.

* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?
Stress Test Monitorado. Uma boa ferramenta de monitoramento é o Dynatrace.

* Você conhece ou já trabalhou com containers?
Sim. Docker.

* E orquestradores tipo Kubernetes ou Docker Swarm?
Kubernetes.

* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git?
Todo desenvolvimento de software é uma atividade dividida em partes(sistemas são feitos por várias pessoas), contínua(ninguem faz um sistema em um dia) e incremental. Visando organização, facilidade na composição de várias partes desenvolvidas e permitindo versionar partes que gostarámos de definir como fucnionais e prontas para o cliente, criaram se as ferramentas de versionamento. CVS, SVN e mais recente, o GIT.

* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?
Nos projetos que atuei, sempre trabalhamos utilizando um fluxo semelhante do gitflow.
Ex: Ao iniciar um sprint, geramos uma branch da develop. Realizada a implementação, é feito um merge request dessa branch para a develop.
No código da develop a equipe de QA e Homolgação do cliente fazem os testes. Uma vez estando ok, realizamos o merge para a master e geramos a tag para a produção.

* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?
Sim. O Jenkins. Apesar de conhecer o Jenkins, sempre tinha alguém na equipe da parte de gestão de configuração que era responsável pela manutenção dos pipelines.

* Você já trabalhou com SCRUM ou Kanban?
Sim, nos últimos 6 anos, todos os dias.

* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.
Maior dificuldade em qualquer projeto é a comunicação. Já atuei em projetos que o PO não ficava disponível integralmente para a equipe e isso impactava o desenvolvimento. Outra dificuldade é trabalhar com equipes remotas, que tem pouco ou nenhum conhecimento do negócio/tecnologia/arquitetura e etc...

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

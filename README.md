# Quer fazer parte da Superbid Webservices?

Obrigado por se interessar em fazer parte do nosso time!

Esse teste faz parte de uma das etapas do nosso processo de seleção e o objetivo é avaliarmos o seu nível de conhecimento nas tecnologias que usamos. Nesse teste você terá 2 tarefas:

* responder um questionário sobre tecnologia e metodologia de desenvolvimento
* construir uma aplicação simples para termos ideia de como é o seu código e o que você considera importante em um projeto

O questionário e a especificação da aplicação estão logo abaixo.

**A sua entrega será feita através de um Pull Request nesse repositório**. Faça um fork do repositório, implemente o seu código, responda as questões no `README.md` e faça um pull request. Sinta-se a vontade para colocar quaisquer outras informações que você considere pertinente no `README`.

# Questionário

* Você já trabalhou com Spring Boot?
R - Sim, APIs spring boot são muito comuns aqui no PagSeguro, a API de URA, por exemplo, é feita em spring boot.
* O que você conhece sobre micro-serviços?
R - Estou trababalhando no dia-a-dia com micro-serviços, pois o pagSeguro, para quem presto serviço, está migrando o seu monolítico inteiro para micro-serviços. Atualmente, já são mais de 200 micro-serviços dentro da empresa.
* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
R- Reusabilidade, desacoplamento, baixa complexidade, facilidade de delivery, etc...
* Qual a sua experiência na construção de APIs?
R - Tenho bastante experiência, pois venho fazendo isso constantemente dentro da empresa em que trabalho, pois a demanda em criar novas APIs é muito grande já que a empresa está tentando sair da estrutura monolítica atual.
* Alguma vez já teve que construir uma API pública?
R - A maioria das APIs do do PaSeguro são publicas, uma vez que são acessadas pelo cliente através do site.
* Como você controla o acesso à API?
R - No projeto atual, utilizamos tokens de autorização (que são basicamente api-keys) e criptografia de ponta-a-ponta com RSA e AES
* Como você trata questões da evolução das APIs?
R - Eu sempre dou preferência, no entanto esse é um critério que tem mais haver com a empresa. Aqui onde trabalho temos total controle das nossas APIs, podemos escolher as tecnologias que serão utilizadas bem como podemos realizar a evolução das mesmas sempre que acharmos necessário. A ultima API que criei, por exemplo, já está com java 10.
* Você acha válido fazer testes automatizados?
R - Muito válido! Isso nos dá segurança que precisamos para criar novas features sem a preocupação de quebrar o que já está feito. Um dos critérios do time que trabalho atualmente é sempre utlizar BDD e manter cobertura de destes acima de 80%. 
* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?
R - É importante sempre fazer testes de carga para evitar surpresas, outra sugestão é fazer enfileiramento de modo a permitir que as requisições sejam processadas de forma assincrona. Outra coisa que tenho feito e que tem dado bons resultados é trabalhar com paralelismo sempre que possível.
* Você conhece ou já trabalhou com containers?
R - Sim, atualmente, as API da empresa estão todas utilizando docker.
* E orquestradores tipo Kubernetes ou Docker Swarm?
R - Trabalho, atualmente, com o Marathon, mas conheço o Kubernetes e Docker Swarm porque já os estudei.
* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git?
R - Sim, utilizamos git nos nossos projetos.
* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?
R - Sim, temos vários flows que depende do projeto. O flow da API mais atual é basicamente branches feature e master. Mas temos flows mais complexos que envolver branches feature, develop, master e stable.
* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?
R - Sim, trabalhamos com integração e delivery contínuos no nosso dia-a-dia, utilizamos git e jenkis para isso. Quanto a pipeline, embora tenha o conhecimento para tal, nunca cheguei a criar uma por completo, no entanto já fiz ajustes adicionando novos estágios. Sendo o fortify o último que adicionei.
* Você já trabalhou com SCRUM ou Kanban?
R - Sim, scrum nas empresas anteriores e atualmente com kanban.
* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.
R - Fazer parte de um time ágil é algo muito bacana, pois é uma equipe madura e com alto nível técnico, mesmo assim tivemos alguns problemas no início, o principal deles, que era recorrente nas retrospectivas, era com o pair programming, que nunca era feito. O motivo era sempre o mesmo: o grande número de estórias priorizadas. Para resolver a questão diminuimos o WIP das estorias priorizadas e criamos um pequeno quadro onde era possível ver quais integrantes do time já haviam feito pair no mês atual. Com a pratica do pair conseguimos melhorar a qualidade das nossas entregas e também resolvemos outro problema que era a disparidade de conhecimento que havia no time.
Tinhamos outro problema que aconteceu no inicio quando o time era novo, tinhamos bastante receio de demonstrar fraqueza, esse problema foi resolvido com algumas dinamicas de aproximação que fizemos e também com um simpósio semanal onde cada pessoa apresentava um tema que podia ser tecnico ou não. Também adotamos o feedback 360 que ajudou bastante a resolver esse problema.

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

## Uma breve explicação do que foi feito

Além dos itens acima, utilizei swagger para documentar e Cucumber com Mockito para fazer os testes integrados (Obs. fiz os testes apenas para o GET findById, pois a idéia é só mostra o conhecimento, logo não vi necessidade em testar tudo :-) ).
Também foi utilizado Lombok.

URL do swagger: http://localhost:8080/swagger-ui.html 

## Critérios a serem avaliados:

* Qualidade de Código
* Cobertura de Testes
* Definição dos Serviços Rest
* Documentação
* Qualquer critério que vocês considere pertinente

Uma dica: pense no teste prático como sendo um algo real que você faria ou gostaria de fazer no seu trabalho, pois esse será o seu cartão de visitas.

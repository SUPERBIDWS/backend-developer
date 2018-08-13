# Quer fazer parte da Superbid Webservices?

Obrigado por se interessar em fazer parte do nosso time!

Esse teste faz parte de uma das etapas do nosso processo de seleção e o objetivo é avaliarmos o seu nível de conhecimento nas tecnologias que usamos. Nesse teste você terá 2 tarefas:

* responder um questionário sobre tecnologia e metodologia de desenvolvimento
* construir uma aplicação simples para termos ideia de como é o seu código e o que você considera importante em um projeto

O questionário e a especificação da aplicação estão logo abaixo.

**A sua entrega será feita através de um Pull Request nesse repositório**. Faça um fork do repositório, implemente o seu código, responda as questões no `README.md` e faça um pull request. Sinta-se a vontade para colocar quaisquer outras informações que você considere pertinente no `README`.

# Questionário

* Você já trabalhou com Spring Boot?

  Sim, atualmente trabalho com um projeto desenvolvido em Spring boot, além de já ter trabalhado em projetos pessoais 
  
* O que você conhece sobre micro-serviços?

  Que é uma arquitetura de projeto em que as diversas funcionalidades são quebradas em serviços independentes, mas que podem se comunicar entre si, diferente das aplicações monolíticas, onde tudo está na mesma api
  
* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural

  Uma das principais vantagens é a facilidade de se realizar mudanças ou correções. Por estarem dívidas, é fácil encontrar uma determinada funcionalidade e realizar qualquer alteração necessária sem prejudicar as outras funcionalidades ou parar todo a aplicação.
  
  Já a desvantagem é que esse tipo de arquitetura, aumenta a complexidade das aplicações, que pode ser desnecessária em soluções mais simples
  
* Qual a sua experiência na construção de APIs?

  Desde que comecei a trabalhar, já participei da criação de várias api (com e sem spring boot) utilizando diversos padrões de projetos
  
* Alguma vez já teve que construir uma API pública?

  Até o momento não
  
* Como você controla o acesso à API?

  Depende do projeto e arquitetura utilizadas. Já trabalhei e aplicações que usavam de tokens para a sua validação, mas atualmente, estou estudando a possibilidade de usar o spring security, para as aplicações spring boot 
  
* Como você trata questões da evolução das APIs?

A evolução de uma API deve ser algo muito bem estudado, para poder calcular os seus impactos nas soluções que elas afetam

* Você acha válido fazer testes automatizados?

  Sim. Muitas aplicações podem ter casos de uso e funcionalidades muito grandes, podendo demandar muito esforço para testar e retestar. A automação do teste facilita esse trabalho.
  
* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?

  Nunca tive que trabalhar com esse tipo de situação, mas já conversei com membros de uma equipe sobre um grande projeto da Sabesp e eles comentaram sobre o NodeBalance, que ajudaria nesse tipo de situação. Ainda não conheço a tecnologia, mas pretendo aprender para projetos futuros

* Você conhece ou já trabalhou com containers?

  Conheço. Último projeto que participei e o atual usam o docker para subir em um servidor openshift 
  
* E orquestradores tipo Kubernetes ou Docker Swarm?

  Nunca trabalhei
  
* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git?

  Conheço o git e trabalho muito com ele. O versionamento de aplicações é de extrema importância para o trabalho, não só por permitir acessar um histórico da aplicação, que por si só já é importante, mas também por permitir que várias pessoas possam trabalhar de forma eficiente no mesmo projeto.
  
* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?

  Geralmente uso branches para separar algum trabalho que venha fazer alguma mudança de algum impacto significativo, que deixado um branche master unicamente para guardar arquivos que irão gerar uma versão do projeto. Já as tags são usadas para guardar versões finalizadas. há alguns pequenos projetos no meu github, que usei para testar alguns conceitos 
  
* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?

  Conheço o conceitos de integração e entrega contínua, porém isso está sendo estudado aqui ainda.
  
* Você já trabalhou com SCRUM ou Kanban?

  Sim, com os dois
  
* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.

  Trabalho com times ágeis desde sempre aqui no trabalho, estamos sempre tentando melhorar a nossa compreensão do scrum. No último projeto que participei, fui scrum master de minha equipe. Uma das maiores dificuldades foi o de retomar o framework depois que fomos forçados a parar por alguma força externa, mas nós policiando, conseguimos voltar ao controle 



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

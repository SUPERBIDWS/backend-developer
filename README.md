# Quer fazer parte da Superbid Webservices ?

O teste consiste basicamente em algumas perguntas abaixo e um teste pratico, basta clonar o repositório responder as perguntas no próprio README.md e submeter o pull request.

## Questionário

* Você já trabalhou com Spring Boot? 
Sim, as primeiras aplicações com Spring Boot que eu desenvolvi foram criadas entre 2014 e 2015, e essa tem sido a forma padrão para novos projetos usando Spring desde então. Anteriormente, já trabalhava com aplicações Spring, passando por configurações em XML, Java e anotações.

* O que você conhece sobre micro-serviços?
Micro-serviços é uma abordagem para arquitetura de software que prega a utilização de diversos componentes pequenos, que se comunicam através de protocolos leves e simples, são construídos em seu domínio de negócio e sem dependência forte de outros componentes de forma que podem ser desenvolvidos, implantados e gerenciados independentemente.

* Cite algumas vantagens e desvantagens de usar esse modelo arquitetural
As vantagens incluem: implantação e escalabilidade independente; isolamento e contenção de falhas; possibilidade de utilização de stack multi-linguagem ou multi-tecnológico; tempo de desenvolvimento menor devido à menor complexidade de cada serviço.
As desvantagens estão na maior complexidade para gestão, monitoramento e logging de todos os serviços como um todo, além de maior latência por conta da troca de invocação de métodos por comunicação via rede. É necessária uma maior maturidade no entendimento de interfaces de comunicação e uma política de gestão de versão de APIs.

* Qual a sua experiência na construção de APIs?
Há mais de 10 anos construo aplicações tanto servidores quanto clientes de APIs, tanto em SOAP, mais antigamente, quanto em REST. A primeira aplicação cliente que desenvolvi envolvia comunicação com sistemas de planos de saúde para cobrança de procedimentos médicos, e se comunicava usando web services SOAP. Também usando SOAP, desenvolvi APIs que possibilitava aplicações externas acionarem operações diversas. Já há alguns, tenho desenvolvido APIs usando somente REST.

* Alguma vez já teve que construir uma API pública? 
Sim, como mencionado anteriormente, há muitos anos desenvolvi APIs em SOAP para operação de nossos sistemas. Há alguns anos, essas mesmas e outras APIs passaram a ser disponibilizadas em REST, o padrão atual. Posso dar um exemplo recente, em que um canal de televisão paga montou sua plataforma VOD usando APIs desenvolvidas por minha equipe. Essas APIs estavam integradas ao sistema de gestão interno deles, mas com infraestrutura e componentes independentes.

* Como você controla o acesso à API?
Utilizei diversas estratégias de controle de acesso e autenticação - desde cadastro de aplicações clientes, que deveriam usar suas palavras secretas para acesso, passando por autenticação direta do usuário - com sessão compartilhada entre todos os componentes -, até autorização via Oauth2 com serviços de autenticação próprios ou terceiros (como redes sociais), com e sem JWT. Na maioria das implantações anteriores, por se tratarem de sistemas corporativos, o serviço de autenticação e autorização estava integrado ao AD do cliente. Problemas distintos pedem abordagens distintas.

* Como você trata questões da evolução das APIs?
Da mesma que o código se altera ao longo do tempo e é controlado por um sistema de versionamento, o mesmo pode ser dito de APIs - precisam ter um controle de versão. Mudanças incrementais podem ser adicionadas à mesma versão, mas mudanças que geram quebra de código devem ser disponibilizadas em versões distintas, o que significa que uma API pode, em determinado momento, ser oferecida em mais de uma versão, geralmente com diferenciação na URL. Por sua importância, o planejamento da API tem sido um tópico de muita discussão interna. O desenvolvimento da API junto dos próprios serviços acaba levando a muitas e constantes alterações, o que acaba por exigir muito trabalho de sincronismo de servidores-clientes entre as equipes diversas. Uma abordagem que passamos a testar recentemente, principalmente com APIs para terceiros, é a API-first usando a especificação OpenAPI ( https://github.com/OAI/OpenAPI-Specification ), que define forma padrão para planejamento e documentação de API, agnóstica de linguagem.

* Você acha válido fazer testes automatizados?
Sim, testes automatizados são primordiais para a garantia de qualidade, estabilidade e consistência de versões, evitando erros de regressão, bugs introduzidos e que não foram testados manualmente, além de reduzir o tempo e os custos de testes. Há, também, outras possibilidades, como testes de stress, de carga, de compatibilidade com sistemas e navegadores, que podem ser realizados mais facilmente e em paralelo.

* Imagine que você precisa construir uma API que vai ter um grande número de acessos. Como você garante que ela terá um tempo de resposta acessível durante um pico de acesso?
Acredito que para uma resposta mais precisa necessitaria de mais detalhes sobre a API, mas os principais pontos para uma API responsiva para picos acesso passa por escalabilidade, de preferência automática, de seus componentes; caching de dados para evitar consultas e recálculos desnecessários; mudança para abordagem stateless nos componentes para reduzir consumo de memória e necessidade de sincronização; implementação de throtling e rate limit para chamadas de API de perfis de clients; adequação de tempos de timeout e adoção de circuit-breakers para contenção rápida de falhas; adoção de operações assíncronas, com a notificação do client sobre o andamento e resultado; replicação de dados em diversos databases para balanceamento de carga.

* Você conhece ou já trabalhou com containers? 
Sim, primariamente através de Docker, tanto para aplicações próprias quanto para aplicações de terceiro. Facilita bastante preparar e disponibilizar um ambiente tanto para desenvolvimento quanto para implantação.

* E orquestradores tipo Kubernetes ou Docker Swarm?
Tenho experiência com Kubernetes como serviço gerenciado - isto é, oferecido como serviço, como no caso das plataformas de nuvem do Google e da Amazon. Docker Swarm, apenas em ambientes internos, de teste e desenvolvimento. Na aplicação de VOD mencionada, foi utilizada a plataforma OpenShift, da Red Hat, baseada em Kubernetes instalada em datacenter do próprio cliente.

* Fale um pouco sobre o processo de versionamento de aplicações. Conhece Git? 
Sim, sou usuário do Git há muitos anos, pelo menos desde de 2013. Anteriormente a isso, utilizava Subversion. Não somente o código fonte das aplicações possui versionamento gerenciado, como também modelo de banco de dados e configurações. Adotamos um guia de estilo para mensagens de commit semelhante ao utilizado pela Udacity ( https://udacity.github.io/git-styleguide/ ). Para versionamento do release de nossas aplicações, seguimos a especificação SemVer (Semantic Versioning, https://semver.org/ ).

* Como você usa branches, tags, etc. Tem algo no Github ou Gitlab?
Utilizo branches, primariamente, para o desenvolvimento de features separadas e para correções de bugs. Nenhuma dessas tarefas é realizada nos branches principais, aos quais são integrados quando validados. Tags são utilizadas para fazer marcação de versões disponibilizadas e/ou implantadas em clientes, principalmente. Tenho conta no Github, utilizado pela empresa em que trabalho atualmente e para meus projetos em IA. Projetos pessoais estão, majoritariamente, no Bitbucket. Utilizei bastante o Gitlab em ambientes self-hosted.

* Você conhece CI/CD? Já chegou a fazer algum pipeline de CI/CD completo?
Sim, utilizamos Jenkins em servidor interno, integrado ao Github, para fazer orquestração do pipeline. Usamos Sonar para métricas de qualidade e Archiva para repositório de artefatos maven.

* Você já trabalhou com SCRUM ou Kanban? 
Sim, atualmente as equipes de desenvolvimento que eu lidero utilizam Scrum. Kanban tem sido utilizado para organização do trabalho das equipes de implantação e suporte.

* Conte um pouco sobre como foi fazer parte de um time ágil, quais dificuldades tiveram e como conseguiram superar.
A maior dificuldade é a mudança de cultura e mentalidade. Em uma empresa que historicamente sempre impôs um controle centralizado e top-down, a equipe estava muito mais acostumada a fazer o que lhe era mandado, e as reuniões diárias pareciam mais reuniões de status report. Além disso, a diretoria relutou em relaxar o controle sobre todos os processos. Neste ponto, a equipe aceitou e incorporou as mudanças mais rapidamente. Foram necessários muitas reuniões e sprints com bons resultados para que a diretoria passasse a apoiar essa mudança de gestão.


# Teste prático (prazo 3 dias)

Considerando a funcionalidade de um blog, construa uma API Rest contendo as operações de : Inclusão, Alteração, Lista e Remoção. O recurso deve ter a seguinte estrutura :

     * Post
     * ID
     * Data de Publicação
     * Título
     * Descrição

## Tecnologias utilizadas 

* Spring Boot
* Java 8
* Hibernate
* H2 in memory (persistência em memória)
* Postman Collection ( para testes da api )

## Critérios a serem avaliados:

* Qualidade de Código
* Cobertura de Testes
* Definição de Serviços Rest
* Documentação
* Qualquer critério que vocês considere pertinente

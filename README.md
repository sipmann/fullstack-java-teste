# Sistema de Viagens

Sistema desenvolvido para realizar o consumo do WebService de requisições de viagens. Este consumo é então armazenado em um banco ou enviado para uma fila para que seja armazenado por um dos consumidores (se assim for configurado).

# Utilização

Para utilizar temos duas principais possibilidades que podem ser vistas abaixo. Em ambas as possibilidades se faz necessário configurar as propriedades da aplicação que vão desde usuário e senha para consumir o WebService até os dados de acesso ao banco de dados.

Uma vez rodando o serviço, deve-se acessar a URL da aplicação na porta especificada, ex: `localhost:8080/viagens` e aguardar o consumo do serviço. Existe também a url `localhost:8080/viagens/fromdb` que irá realizar a listagem diretamente do banco.

## Build e run

Rode um package `mvn package` e em seguida rode o .jar com o WildFly empacotado `java -jar fullstack-java-teste-swarm.jar` e basta acessar *localhost:8080*.

## Docker

Para rodar utilizando docker é possível utilizar uma imagem já compilada e disponível no dockerhub ou construir o container localmente.

```shell
#docker build . -t viagem

docker run -d --name db -e "MYSQL_ROOT_PASSWORD=senha-mysql" -e MYSQL_DATABASE=viagens mariadb:latest

docker run -d --name viagemapp -p 8080:8080 --link db:db -e "applicationkeyClient=KEYCLIENT" \
-e "applicationUser=USERNAME" -e "applicationPassword=PASS" -e "appMysqlHost=db:3306" \
-e "appMysqlDB=viagens" -e "appMysqlUser=root" -e "appMysqlPass=senha-mysql" sipmann/viagem
```

Se desejar rodar o serviço juntamente com o Rabbitmq, é necessário rodar o container do rabbit (caso não possua um serviço já rodando) e em seguida adicionar as variáveis de ambiente ao docker run da app de viagem.

## Configuração

A configuração da aplicação se da por viriáveis de ambiente. Para uma aplicação distribuída, o ideal é obter as configurações de um serviço especializado para tal, podendo ser um serviço Consul ou outro serviço semelhante. Esta configuração centralizada em um serviço, propicia um melhor controle geral das configs.

Para fins de uso simplificado, a criação das tabelas esta marcada para rodar juntamente com a aplicação e o Hibernate, mas o database já deve vir criado. Caso seja do interesse rodar a criação manualmente o script esta no repositório com o nome de create.sql.

Variáveis de ambiente observadas pela aplicação:

| Nome                  | Descrição                  | Valor  Default           |
|-----------------------|----------------------------|-------------------------:|
| applicationkeyClient  | keyClient do WS            | fornecido no e-mail      |
| applicationUser       | userName do WS             | fornecido no e-mail      |
| applicationPassword   | password do WS             | fornecido no e-mail      |
| appMysqlHost          | Host:Porta do server mysql | localhost:3306           |
| appMysqlDB            | banco do mysql             | viagens                  |
| appMysqlUser          | usuario do mysql           | root                     |
| appMysqlPass          | senha do mysql             |                          |
| RABBITHOST            | Host do rabbit             | localhost                |

# Arquitetura

A arquitetura consistem em uma aplicação Java EE7 rodando em um servidor WildFly Swarm com persistencia de dados em um banco MariaDB. Esta persistência pode se dar por meio de uma fila de requisições com RabbitMQ ou diretamente atravéz de uam DAO. Para fornecimento das páginas e endpoint de acesso, utilizou-se Spring MVC juntamente com JPA e Hibernate para impacto em banco. Um resumo das versões abaixo.

* JDK 8
* JSP 2.1
* Hibernate 4.3
* Spring-Orm 4.1
* Spring-Mvc 4.1

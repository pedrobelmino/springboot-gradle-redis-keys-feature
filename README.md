LAB para executar de app spring boot grade fazendo uso do recurso redis feature keys
============================

**Pré-requisitos**
- Java 8
- Gradle
- Docker
- Docker-compose

**Execução dos container redis**
```bash
docker-compose -f redis/docker-compose.yml up
```
**Construção do projeto java**
```bash
./gradlew clean build
```
**Execução**
```bash
./gradlew bootRun
```

**Referências**
- https://github.com/benweizhu/spring-redis-docker-example

**Sucesso pra você!!**


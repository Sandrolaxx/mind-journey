# Boa e velha API com Spring🍃

Este projeto envolve o desenvolvimento de uma aplicação back-end utilizando Java e o framework Spring Boot. O foco está na utilização de ferramentas modernas para garantir eficiência e escalabilidade. Utilizando um banco com docker para rodar o Pg em ambiente de dev, a solução consiste em um API para o gerenciamento de viagens, tanto em grupo, quando sozinho. Volta e meia o QuarkusBoy tem de relembrar como o Spring funciona, por mais que é tudo a mesma coisa...

## 👨‍💻Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Postgres**: Banco de dados em memória para desenvolvimento e testes.
- **JPA (Java Persistence API)**: API para persistência de dados.
- **Flyway**: Ferramenta para gerenciamento de versões de banco de dados.
- **Records**: Utilização de records para transferências de dados.

Lombok é um [anti-pattern](https://noobtomaster.com/lombok/avoiding-common-pitfalls-and-anti-patterns) sua geração de valor é infima.

## 👨‍🏫Aprendizados

- Criação e gerenciamento de APIs RESTful com Spring Boot.
- Persistência de dados utilizando JPA.
- Banco de dados PG para desenvolvimento e testes.
- Migrações de banco de dados gerenciadas com Flyway.
- Utilização de records para transferência de dados de forma eficiente.

## Configuração do Ambiente

1. **Pré-requisitos**:
   - [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
   - [Maven](https://maven.apache.org/install.html)

2. **Clone o Repositório**:
   ```bash
   git clone https://github.com/sandrolaxx/trip-pass.git
   cd trip-pass
   ```

3. **Configure as Variáveis de Ambiente**:
   - Configure as propriedades necessárias no arquivo `application.properties` em caso de ambientes produtivos.

4. **Executar container**:
   ```bash
   docker run --name pg-test -e POSTGRES_USER=pg-test -e POSTGRES_PASSWORD=1329 -p 5446:5432 -d postgres
   ```

5. **Inicie a Aplicação**:
   ```bash
   mvn spring-boot:run
   ```

## Desenvolvimento

- **Flyway Migrations**:
  - Adicione novos scripts de migração na pasta `src/main/resources/db/migration`.

- **Records**:
  - Utilize records para transferências de dados, quando apropriado.

## Contribuição

1. Faça um fork do repositório.
2. Crie uma nova branch com sua feature ou correção: `git checkout -b minha-feature`.
3. Faça commit das suas alterações: `git commit -m 'Adiciona minha feature'`.
4. Envie para a branch: `git push origin minha-feature`.
5. Abra um Pull Request.

Ficarei muito feliz em receber seu PR😎
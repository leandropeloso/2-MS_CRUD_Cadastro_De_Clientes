###MICRO SERVIÇO DE CADASTRO DE CLIENTES

Este é um microserviço Java que implementa operações CRUD (Create, Read, Update, Delete) para gerenciar clientes (entidades comerciais) em uma aplicação. Abaixo está um resumo explicativo das principais classes e métodos, bem como suas funções, exceções e anotações.

1.	Classe ClientConstant:

Essa classe contém constantes para mensagens de erro ou informações específicas do cliente.

2.	Classe AdmClientController:

•	Esta classe é um controlador Spring Boot que lida com solicitações HTTP relacionadas a clientes;
•	Anotada com @RestController, torna a classe um controlador da API;
•	Anotada com @RequestMapping(“/api/clientes”), define o caminho base para todas as solicitações relacionadas a clientes.

Métodos:
•	createClient: Lidar com solicitações POST para criar um novo cliente. Verifica se o cliente já existe e lança uma exceção ClientConflictException em caso afirmativo;
•	findClientByIdOrAll: Lidar com solicitações GET para encontrar um cliente com base no ID ou obter todos os clientes. Retorna um cliente ou uma lista de clientes;
•	updateClient: Lidar com solicitações PUT para atualizar um cliente existente com base no CNPJ;
•	deleteClient: Lidar com solicitações DELETE para excluir um cliente com base no CNPJ.

3.	Classe AdmClientDTO:

Esta classe é um DTO (Data Transfer Object) que representa os dados do cliente. Ela contém validações usando anotações como @NotNull, @NotBlank, e @Email.

4.	Classe AdmClientEntity:
Essa classe representa a entidade do cliente com anotações JPA (Java Persistence API). É mapeada para uma tabela no banco de dados.

5.	Classe AdmClientNotFoundException:

Uma exceção personalizada lançada quando um cliente não é encontrado, anotada com @ResponseStatus(HttpStatus.NOT_FOUND).

6.	Classe ClientConflictException:
Uma exceção personalizada lançada quando ocorre um conflito, por exemplo, quando se tenta criar um cliente com um CNPJ já existente

7.	Classe ClientDataIntegrityException:

Uma exceção personalizada lançada em caso de violação de integridade de dados ao criar um cliente.

8.	Classe ValidationExceptionHandler:

Uma classe de manipulador de exceções para lidar com exceções relacionadas à validação de entrada (anotada com @ControllerAdvice. Trata exceções do tipo MethodArgumentNotValidException.

9.	Classe AdmClientRepository:

Uma interface que estende CrudRepository para realizar operações CRUD no banco de dados para a entidade AdmClientEntity.

10.	Classe AdmClientService:

Esta classe é um serviço que contém a lógica de negócios relacionada a clientes.
Métodos:
•	creatClient: Cria um novo cliente e lida com exceções, como conflito ou violação de integridade de dados;
•	findClientByIdOrAll: Encontra um cliente com base no ID ou retorna todos os clientes;
•	updateClient: Atualiza um cliente existente;
•	deleteClient: Exclui um cliente.

11.	Classe AdmClientApplication:

Classe principal da aplicação Spring Boot. Inicia a aplicação Spring Boot.

Este microserviço fornece uma API RESTful para criar, ler, atualizar e excluir clientes, com validações de entrada, exceções personalizadas e manipulação de erros. Ele é construído com o framework Spring Boot e utiliza um banco de dados para armazenar informações dos clientes.


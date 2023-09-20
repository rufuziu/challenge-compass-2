# ms-scholar-f

Este projeto utiliza a anotação `@FeignClient` para consumir a API principal em uma interface. O `@FeignClient` é configurado com o nome do microserviço e a URL principal. Com o uso de métodos de busca específicos, os dados de usuários e microserviços são recuperados por meio do nosso microserviço.

## Estrutura do Projeto

O projeto é composto por diversos componentes, incluindo:

- **Controllers**: Responsáveis por receber e direcionar as requisições HTTP. Eles interagem com os serviços para processar as solicitações e retornar respostas apropriadas.

- **Dtos (Data Transfer Objects)**: São objetos usados para transferir dados entre diferentes camadas do aplicativo. Eles contêm apenas as informações necessárias para uma resposta específica.

- **Services**: A camada de negócios do aplicativo. Os serviços implementam a lógica de negócios e se comunicam com outras camadas para buscar e manipular dados.

- **Role**: Responsável pela definição das regras de acesso, incluindo os papéis de "user" e "admin". A camada de segurança Dto é utilizada para controlar os acessos com base nas regras definidas.

## Funcionamento

- Os Controllers recebem as solicitações HTTP e direcionam para os serviços apropriados.

- Os Serviços implementam a lógica de negócios e se comunicam com as camadas de persistência, se necessário.

- Os Dtos são usados para transferir dados entre as camadas do aplicativo, garantindo que apenas as informações relevantes sejam retornadas nas respostas.

- O papel desempenhado pela camada Role é definir as regras de acesso, controlando quem pode acessar determinadas partes do sistema.

Esse projeto é uma estrutura básica para criar uma aplicação de microserviço que consome dados de um serviço principal e implementa regras de acesso baseadas em papéis definidos. Ele pode ser expandido e personalizado conforme as necessidades do seu aplicativo.

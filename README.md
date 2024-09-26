# Floruit Interconections

Um plugin BungeeCord para gerenciar a lista de servidores disponíveis e permitir que os jogadores se conectem a eles facilmente.

## Sumário

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Como Usar](#como-usar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Classes Principais](#classes-principais)
- [Como Configurar](#como-configurar)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Visão Geral

Floruit Interconections é um plugin para servidores BungeeCord que permite que jogadores listem servidores disponíveis e se conectem a eles com facilidade. O sistema oferece uma interface amigável e interativa, utilizando eventos de chat para gerenciar comandos de conexão.

## Funcionalidades

- Lista servidores disponíveis.
- Conexão rápida a servidores através de comandos no chat.
- Mensagens informativas para jogadores.
- Capacidade de extensão para adicionar mais funcionalidades no futuro.

## Como Usar

Para listar os servidores disponíveis, o jogador deve digitar o comando `/servers` no chat. Se não houver servidores disponíveis, uma mensagem informativa será exibida.

### Comandos

- `/servers`: Lista todos os servidores disponíveis.

## Estrutura do Projeto


- **commands**: Contém os comandos disponíveis para os jogadores.
- **listener**: Contém ouvintes para eventos do servidor.
- **FloruitInterconectionsPlugin.java**: Classe principal que inicializa o plugin.

## Classes Principais

### `FloruitInterconectionsPlugin`

- `onEnable()`: Inicializa o plugin, registra comandos e ouvintes.

### `ServerListCommand`

- `onServerList(ProxiedPlayer player)`: Manipula o comando `/servers` e envia a lista de servidores disponíveis.
- `isServerListEmpty()`: Verifica se a lista de servidores está vazia.
- `sendAvailableServersHeader(ProxiedPlayer player)`: Envia o cabeçalho da lista de servidores.
- `sendAvailableServers(ProxiedPlayer player)`: Envia a lista de servidores ao jogador.
- `createServerComponent(String serverName)`: Cria um componente de texto para cada servidor.
- `capitalizeServerName(String serverName)`: Capitaliza o nome do servidor.
- `sendEmptyLine(ProxiedPlayer player)`: Envia uma linha vazia.

### `PlayerChatListener`

- `onChatEvent(ChatEvent event)`: Escuta eventos de chat e processa comandos de conexão.

## Como Configurar

1. **Instalação**:
   - Certifique-se de que o BungeeCord está configurado.
   - Coloque o arquivo `.jar` do plugin na pasta `plugins` do seu servidor BungeeCord.

2. **Configuração**:
   - Não é necessária configuração adicional. O plugin detecta automaticamente os servidores registrados.

## Contribuição

Se você deseja contribuir para o projeto, siga estes passos:

1. Fork o repositório.
2. Crie uma nova branch (`git checkout -b feature/NomeDaFeature`).
3. Faça suas alterações e commit (`git commit -m 'Adiciona nova funcionalidade'`).
4. Envie a branch para o repositório remoto (`git push origin feature/NomeDaFeature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

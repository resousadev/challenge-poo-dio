# Challenge POO DIO 🚀

Este é um projeto de exemplo criado para demonstrar conceitos de Programação Orientada a Objetos (POO) usando Java e Spring Boot, seguindo as melhores práticas de desenvolvimento.

## 📋 Tecnologias Utilizadas

- **Java 21** - Última versão LTS do Java
- **Spring Boot 3.5.6** - Framework web moderno
- **Gradle 8.4** - Sistema de build
- **Lombok** - Redução de boilerplate code
- **Spring Boot DevTools** - Desenvolvimento mais eficiente
- **Bean Validation** - Validação de dados
- **Spring Boot Actuator** - Monitoramento da aplicação

## 🛠️ Configuração do Ambiente

### Pré-requisitos
- Java 21 ou superior
- VS Code com extensões Java instaladas
- Git

### Extensões Recomendadas para VS Code
- Extension Pack for Java
- Spring Boot Extension Pack
- Lombok Annotations Support for VS Code

## 🚀 Como Executar

1. **Clone o repositório**
   ```bash
   git clone <url-do-repositorio>
   cd challenge-poo-dio
   ```

2. **Navegue até o diretório da aplicação**
   ```bash
   cd application
   ```

3. **Execute a aplicação**
   ```bash
   ./gradlew bootRun
   ```

4. **Acesse a aplicação**
   - URL: http://localhost:8080
   - Health Check: http://localhost:8080/api/health

## 📖 Endpoints Disponíveis

### Básicos
- `GET /api/` - Mensagem de boas-vindas
- `GET /api/health` - Status da aplicação

### Cursos
- `GET /api/courses` - Lista todos os cursos
- `POST /api/courses` - Cria um novo curso
- `GET /api/courses/example` - Retorna um curso de exemplo

### Exemplo de requisição POST para criar um curso:
```json
{
    "title": "Java Avançado",
    "description": "Curso completo de Java com foco em conceitos avançados",
    "workload": 60
}
```

## 🏗️ Estrutura do Projeto

```
application/
├── src/
│   └── main/
│       ├── java/
│       │   └── io/resousadev/
│       │       ├── Main.java                 # Classe principal
│       │       ├── controller/
│       │       │   └── HelloController.java  # REST Controller
│       │       └── domain/
│       │           └── Course.java           # Entidade Curso
│       └── resources/
│           ├── application.properties        # Configurações principais
│           └── application-dev.properties    # Configurações de desenvolvimento
├── build.gradle                              # Configuração do Gradle
├── gradle.properties                         # Propriedades do Gradle
└── .vscode/                                  # Configurações do VS Code
    ├── settings.json
    ├── launch.json
    └── extensions.json
```

## 🎯 Conceitos de POO Demonstrados

1. **Encapsulamento** - Uso de atributos privados e métodos públicos
2. **Abstração** - Classes que representam entidades do mundo real
3. **Composição** - Relacionamento entre classes
4. **Anotações** - Uso do Lombok para reduzir boilerplate

## 🔧 Comandos Úteis

```bash
# Build do projeto
./gradlew build

# Executar testes
./gradlew test

# Limpar build
./gradlew clean

# Executar aplicação
./gradlew bootRun

# Verificar dependências
./gradlew dependencies
```

## 🐛 Resolução de Problemas

### Problema com Imports
Se você estiver enfrentando problemas com imports no VS Code:

1. Pressione `Ctrl+Shift+P`
2. Digite "Java: Restart Projects"
3. Execute o comando

### Problema com Build
Se o build falhar:
```bash
./gradlew clean build --refresh-dependencies
```

## 📝 Logs e Debug

A aplicação está configurada para usar diferentes níveis de log:
- **Desenvolvimento**: DEBUG level para pacotes internos
- **Produção**: INFO level

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👨‍💻 Autor

Desenvolvido como parte do Challenge POO da Digital Innovation One (DIO).

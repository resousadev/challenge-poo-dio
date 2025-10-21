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
   - Swagger UI: http://localhost:8080/swagger-ui.html (se habilitado)

## 📖 Endpoints Disponíveis

### Básicos
- `GET /api/` - Mensagem de boas-vindas
- `GET /api/health` - Status da aplicação

### Cursos
- `GET /courses/courses` - Lista todos os cursos
- `POST /courses/courses` - Cria um novo curso
- `GET /courses/courses/example` - Retorna um curso de exemplo

### Mentorias
- `GET /mentorings/` - Lista todas as mentorias
- `POST /mentorings/` - Cria uma nova mentoria
- `GET /mentorings/example` - Retorna uma mentoria de exemplo

### Exemplos de requisições POST:

**Criar um curso:**
```json
{
    "title": "Java Avançado",
    "description": "Curso completo de Java com foco em conceitos avançados",
    "workload": 60
}
```

**Criar uma mentoria:**
```json
{
    "title": "Mentoria em Spring Boot",
    "description": "Sessão de mentoria para desenvolvimento com Spring Boot",
    "date": "2024-12-01"
}
```

## 🏗️ Estrutura do Projeto

```
application/
├── src/
│   └── main/
│       ├── java/
│       │   └── io/resousadev/
│       │       ├── Main.java                    # Classe principal da aplicação
│       │       ├── controller/
│       │       │   ├── HelloController.java     # Controller básico da API
│       │       │   ├── CourseController.java    # Controller para gerenciar cursos
│       │       │   └── MentoringController.java # Controller para gerenciar mentorias
│       │       └── domain/
│       │           ├── Course.java              # Entidade Curso
│       │           └── Mentoring.java           # Entidade Mentoria
│       └── resources/
│           ├── application.properties           # Configurações principais
│           └── application-dev.properties       # Configurações de desenvolvimento
├── build.gradle                                 # Configuração do Gradle
├── gradle.properties                            # Propriedades do Gradle
└── .vscode/                                     # Configurações do VS Code
    ├── settings.json
    ├── launch.json
    └── extensions.json
```

## 🎯 Conceitos de POO Demonstrados

### Principais Conceitos
1. **Encapsulamento** - Uso de atributos privados com getters/setters automáticos via Lombok
2. **Abstração** - Classes `Course` e `Mentoring` representam entidades do mundo real
3. **Composição** - Relacionamento entre controllers e entidades de domínio
4. **Polimorfismo** - Métodos com comportamentos específicos em cada entidade

### Recursos Implementados
- **Builder Pattern** - Construção fluente de objetos usando `@Builder` do Lombok
- **Data Transfer Objects** - Entidades simples para transferência de dados
- **RESTful API** - Controllers seguindo padrões REST
- **Métodos de Negócio** - Lógicas específicas como `getDurationInDays()` e `isIntensive()` na classe Course
- **Validação de Dados** - Verificação de campos obrigatórios nos controllers

## 📚 Modelos de Domínio

### Course (Curso)
Representa um curso no sistema com os seguintes atributos:
- `title`: Título do curso
- `description`: Descrição detalhada
- `workload`: Carga horária em horas

**Métodos especiais:**
- `getDurationInDays()`: Calcula duração em dias (assumindo 8h/dia)
- `isIntensive()`: Verifica se é um curso intensivo (>40h)

### Mentoring (Mentoria)
Representa uma sessão de mentoria com:
- `title`: Título da mentoria
- `description`: Descrição da sessão
- `date`: Data da mentoria (LocalDate)

Ambas as classes utilizam anotações Lombok para reduzir código boilerplate:
- `@Data`: Gera getters, setters, toString, equals e hashCode
- `@Builder`: Permite construção fluente de objetos
- `@NoArgsConstructor` / `@AllArgsConstructor`: Construtores automáticos

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

# Gerar documentação Javadoc
./gradlew javadoc
```

## 🧪 Testando a API

Você pode testar os endpoints usando curl, Postman ou qualquer cliente HTTP:

### Teste básico de funcionamento:
```bash
curl http://localhost:8080/api/health
```

### Listar cursos:
```bash
curl http://localhost:8080/courses/courses
```

### Criar um curso:
```bash
curl -X POST http://localhost:8080/courses/courses \
  -H "Content-Type: application/json" \
  -d '{"title":"Java Spring Boot","description":"Curso completo de Spring Boot","workload":80}'
```

### Listar mentorias:
```bash
curl http://localhost:8080/mentorings/
```

### Criar uma mentoria:
```bash
curl -X POST http://localhost:8080/mentorings/ \
  -H "Content-Type: application/json" \
  -d '{"title":"Mentoria Java","description":"Sessão de dúvidas sobre Java","date":"2024-12-01"}'
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

# 🚀 Challenge POO DIO - Sistema de Gerenciamento de Bootcamps

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen)
![Gradle](https://img.shields.io/badge/Gradle-8.x-blue)
![Lombok](https://img.shields.io/badge/Lombok-1.18.30-red)

## 📋 Sobre o Projeto

Este projeto é uma aplicação Spring Boot que implementa um sistema de gerenciamento de Bootcamps utilizando conceitos de **Programação Orientada a Objetos (POO)**. O sistema permite o cadastro de desenvolvedores (Devs), criação de bootcamps com cursos e mentorias, inscrição de devs em bootcamps, e acompanhamento do progresso com cálculo de XP.

### 🎯 Conceitos de POO Aplicados

- **Abstração**: Classe abstrata `Content` que define o comportamento base para conteúdos
- **Herança**: Classes `Course` e `Mentoring` que estendem `Content`
- **Encapsulamento**: Uso de Lombok para getters/setters e controle de acesso
- **Polimorfismo**: Implementação do método abstrato `calculateXp()` de forma diferente em cada subclasse

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
src/main/java/io/resousadev/
├── Main.java                    # Classe principal Spring Boot
├── controller/                  # Camada de apresentação (REST API)
│   ├── BootcampController.java
│   ├── DevController.java
│   ├── CourseController.java
│   ├── MentoringController.java
│   └── HelloController.java
├── service/                     # Camada de negócio
│   ├── BootcampService.java
│   └── DevService.java
└── domain/                      # Camada de domínio (entidades)
    ├── Bootcamp.java
    ├── Dev.java
    ├── Content.java (abstract)
    ├── Course.java
    └── Mentoring.java
```

## 📦 Modelo de Domínio

### Content (Abstrato)
Classe base abstrata que representa qualquer conteúdo educacional:
- `title`: Título do conteúdo
- `description`: Descrição do conteúdo
- `calculateXp()`: Método abstrato para cálculo de XP

### Course (Curso)
Representa um curso com carga horária:
- `workload`: Carga horária em horas
- XP = `DEFAULT_XP * workload`
- Métodos: `getDurationInDays()`, `isIntensive()`

### Mentoring (Mentoria)
Representa uma sessão de mentoria:
- `date`: Data da mentoria
- XP = `DEFAULT_XP + MENTORING_BONUS_XP` (30 XP fixo)

### Dev (Desenvolvedor)
Representa um desenvolvedor inscrito:
- `name`: Nome do desenvolvedor
- `enrolledContents`: Conteúdos em que está inscrito
- `completedContents`: Conteúdos concluídos

### Bootcamp
Representa um bootcamp:
- `name`: Nome do bootcamp
- `description`: Descrição
- `startDate` / `endDate`: Período do bootcamp
- `enrolledDevs`: Desenvolvedores inscritos
- `contents`: Conteúdos do bootcamp

## 🚀 Tecnologias Utilizadas

- **Java 21**: Versão LTS mais recente
- **Spring Boot 3.5.6**: Framework para criação de aplicações
  - Spring Web (REST API)
  - Spring Boot Actuator (Monitoramento)
  - Spring Validation (Validações)
- **Lombok 1.18.30**: Redução de código boilerplate
  - `@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`
  - `@SuperBuilder` para herança
  - `@RequiredArgsConstructor` para injeção de dependência
- **Gradle**: Gerenciamento de dependências e build

## 🔧 Instalação e Execução

### Pré-requisitos
- Java 21 ou superior
- Gradle (opcional, pode usar o wrapper incluído)

### Executar a aplicação

#### Windows:
```cmd
gradlew.bat bootRun
```

#### Linux/Mac:
```bash
./gradlew bootRun
```

A aplicação estará disponível em: `http://localhost:8080`

### Compilar o projeto
```cmd
gradlew.bat build
```

### Gerar JAR executável
```cmd
gradlew.bat bootJar
```
O JAR será gerado em: `build/libs/challenge-poo-dio-1.0-SNAPSHOT.jar`

## 📚 API Endpoints

### Desenvolvedores (Devs)

#### Criar um desenvolvedor
```http
POST /devs?name={nome}
```

#### Buscar desenvolvedor por nome
```http
GET /devs/{nome}
```

#### Listar todos os desenvolvedores
```http
GET /devs
```

#### Progredir no conteúdo
```http
POST /devs/{nome}/progress
```
Marca o primeiro conteúdo inscrito como concluído.

#### Calcular XP total
```http
GET /devs/{nome}/xp
```

### Bootcamps

#### Adicionar bootcamp
```http
POST /bootcamps/add
Content-Type: application/json

{
  "name": "Bootcamp Java Developer",
  "description": "Aprenda Java do zero ao avançado",
  "startDate": "2025-10-23",
  "endDate": "2025-12-23",
  "contents": [...]
}
```

#### Inscrever dev em bootcamp
```http
POST /bootcamps/enroll?devName={nome}&bootcampName={bootcamp}
```

#### Listar bootcamps concluídos por dev
```http
GET /bootcamps/completed?devName={nome}
```

### Cursos

#### Criar curso
```http
POST /courses
Content-Type: application/json

{
  "title": "Java Básico",
  "description": "Fundamentos da linguagem Java",
  "workload": 40
}
```

### Mentorias

#### Criar mentoria
```http
POST /mentorings
Content-Type: application/json

{
  "title": "Code Review em Java",
  "description": "Práticas de revisão de código",
  "date": "2025-11-01"
}
```

## 📊 Funcionalidades

### Gerenciamento de Devs
- ✅ Criar e consultar desenvolvedores
- ✅ Inscrever em bootcamps
- ✅ Progredir nos conteúdos
- ✅ Calcular XP total baseado em conteúdos concluídos

### Gerenciamento de Bootcamps
- ✅ Criar bootcamps com múltiplos conteúdos
- ✅ Adicionar cursos e mentorias
- ✅ Listar bootcamps concluídos por dev
- ✅ Controlar inscrições

### Cálculo de XP
- **Cursos**: XP = 10 × carga horária
- **Mentorias**: XP = 30 (fixo)

### Validações
- ✅ Impede inscrição duplicada em bootcamp
- ✅ Valida existência de dev e bootcamp
- ✅ Impede progresso sem conteúdos inscritos

## 🧪 Testes

O projeto inclui testes unitários para as classes de domínio:

```cmd
gradlew.bat test
```

Testes disponíveis:
- `ContentInheritanceTest`: Testa herança e polimorfismo
- `CourseTest`: Testa funcionalidades específicas de Course
- `MentoringTest`: Testa funcionalidades específicas de Mentoring

### Relatório de Testes
Após executar os testes, o relatório HTML estará disponível em:
```
build/reports/tests/test/index.html
```

## 📖 Documentação JavaDoc

### Gerar JavaDoc
```cmd
gradlew.bat javadoc
```

A documentação será gerada em: `build/docs/javadoc/index.html`

### Visualizar JavaDoc
Abra o arquivo `build/docs/javadoc/index.html` no navegador para acessar a documentação completa das classes.

## 🔍 Monitoramento

A aplicação inclui Spring Boot Actuator para monitoramento:

- **Health Check**: `http://localhost:8080/actuator/health`
- **Info**: `http://localhost:8080/actuator/info`

## 🎓 Aprendizados

Este projeto demonstra:

1. **POO Avançada**: Abstração, herança, encapsulamento e polimorfismo
2. **Spring Boot**: Criação de REST APIs, injeção de dependência, camadas
3. **Lombok**: Redução de boilerplate com anotações
4. **Gradle**: Gerenciamento de build e dependências
5. **Arquitetura em Camadas**: Separação de responsabilidades (Controller → Service → Domain)
6. **Boas Práticas**: Javadoc, testes unitários, validações

## 🤝 Contribuindo

Este é um projeto de desafio educacional da Digital Innovation One (DIO).

## 📝 Licença

Projeto desenvolvido para fins educacionais como parte do desafio de POO da DIO.

## 👨‍💻 Autor

Desenvolvido por **resousadev** como parte do desafio de Programação Orientada a Objetos da DIO.

---

⭐ Se este projeto te ajudou, deixe uma estrela!


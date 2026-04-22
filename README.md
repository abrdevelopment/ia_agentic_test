# 🚀 Java + JUnit + GitHub Actions + Agentic Workflows

## 📌 Visão Geral

Este repositório é uma **Prova de Conceito (PoC)** que demonstra como integrar:

- ☕ **Java**
- 🧪 **JUnit 5** para testes automatizados
- ⚙️ **GitHub Actions** para CI tradicional
- 🤖 **GitHub Agentic Workflows (Technical Preview)** para **análise inteligente dos testes**

O objetivo é mostrar a **separação clara entre execução determinística (CI)** e **avaliação baseada em IA (Agente)**.

---

## 🧠 Arquitetura

```text
Push / Pull Request
        │
        ▼
GitHub Actions (CI)
- mvn test
        │
        ▼
Agentic Workflow
- Analisa logs JUnit
- Identifica falhas
- Explica causas
- Comenta no PR
```

---

## 📁 Estrutura do Projeto

```text
java-agentic-demo/
├── pom.xml
├── src/
│   ├── main/java/com/example/Calculator.java
│   └── test/java/com/example/CalculatorTest.java
└── .github/workflows/
    ├── ci.yml
    └── ci-test-analysis-agent.md
```

---

## ☕ Código de Exemplo

### Calculator.java

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }
}
```

---

## 🧪 Testes com JUnit

```java
@Test
void shouldThrowExceptionWhenDividingByZero() {
    Calculator calc = new Calculator();
    assertThrows(IllegalArgumentException.class,
            () -> calc.divide(10, 0));
}
```

---

## ⚙️ CI – GitHub Actions

Arquivo: `.github/workflows/ci.yml`

```yaml
- name: Run tests
  run: mvn test
```

Este workflow executa os testes JUnit e gera logs que serão avaliados pelo agente.

---

## 🤖 Agentic Workflow

Arquivo: `.github/workflows/ci-test-analysis-agent.md`

Responsabilidades do agente:
- Ler logs do CI
- Determinar se a falha é de teste ou código
- Explicar a causa técnica
- Comentar automaticamente no Pull Request

---

## 🧪 Como Testar o Agente

### 🔹 Erro proposital no teste

```java
assertEquals(6, calc.add(2, 3));
```

➡️ O agente deve indicar **erro no teste**.

---

### 🔹 Regressão no código

```java
public int divide(int a, int b) {
    return a / b;
}
```

➡️ O agente deve indicar **regressão de regra de negócio**.

---

## ✅ Boas Práticas

- Usar branches para experimentos
- Permissões mínimas no Agentic Workflow
- CI executa, agente interpreta
- Workflows versionados como código

---

## 🎯 Conclusão

Esta PoC demonstra como **Agentic Workflows ampliam o GitHub Actions**, trazendo capacidade de **análise contextual e explicativa**, mantendo segurança e controle.

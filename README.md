# Simple Spring Boot Demo Project

This demo project is built using Spring Boot to explore REST API development and SDK generation.

## 🧩 Features
- Exposes a REST API: `GET /api/users`
- Swagger/OpenAPI integration via springdoc
- Generates client SDKs for Android (Kotlin) and iOS (Swift)

## 🚀 How to Run the Spring Boot App

Make sure you have Java 17+ and Maven installed.

```bash
mvn clean install
mvn spring-boot:run
```

Access the app:
- API endpoint: http://localhost:8080/api/users
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI Spec: http://localhost:8080/v3/api-docs

## 📦 SDK Generation via OpenAPI Generator

### 🛠 Install OpenAPI Generator

If not installed:

```bash
brew install openapi-generator
```

Verify installation:

```bash
openapi-generator version
```

### 📱 Generate Android (Kotlin) SDK

```bash
openapi-generator generate \
  -i http://localhost:8080/v3/api-docs \
  -g kotlin \
  -o ./android-sdk
```

### 🍏 Generate iOS (Swift 5) SDK

```bash
openapi-generator generate \
  -i http://localhost:8080/v3/api-docs \
  -g swift5 \
  -o ./ios-sdk
```

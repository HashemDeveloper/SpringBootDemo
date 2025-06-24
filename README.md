# Simple Spring Boot Demo Project

This demo project is built using Spring Boot to explore REST API development and SDK generation.

## 🧩 Features
- Exposes a REST API: `GET /api/users`
- Swagger/OpenAPI integration via springdoc
- Generates client SDKs for Android (Kotlin) and iOS (Swift)

## 🚀 How to Run the Spring Boot App

Make sure you have Java 17+ and Maven installed.

If Maven is not installed:

```bash
brew install maven
```

Then run:

```bash
mvn clean install
mvn spring-boot:run
```

Access the app:
- **API endpoint**: http://localhost:8080/api/users
- **Swagger UI**: http://localhost:8080/swagger-ui/index.html
- **OpenAPI Spec**: http://localhost:8080/v3/api-docs

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

---

## 🔁 Offline SDK Generation Using `openapi.yaml`

You can also generate SDKs without running the server by using a local OpenAPI spec file.

### 💡 When to use YAML
- You want to version-control your API contract
- You’re offline or the backend is not running
- Frontend/mobile teams want to generate SDKs independently

Sample `openapi.yaml`:

```yaml
openapi: 3.0.1
info:
  title: SpringBootDemo API
  version: 1.0.0
  description: A simple demo API for listing users

servers:
  - url: http://localhost:8080
    description: Local development server

paths:
  /api/users:
    get:
      summary: Get all users
      operationId: getUsers
      responses:
        '200':
          description: List of users
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/User'

components:
  schemas:
    User:
      type: object
      properties:
        firstName:
          type: string
          example: Alice
        lastName:
          type: string
          example: Smith
```

### ✅ Generate SDK from YAML

```bash
openapi-generator generate \
  -i ./openapi.yaml \
  -g kotlin \
  -o ./android-sdk
```

Replace `kotlin` with `swift5` to generate the iOS SDK.

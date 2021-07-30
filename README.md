# Spring Boot Reply Service

## Building the project

To build the project, simply run

```
./gradlew build
```

## Starting project

To start the project, simply run

```
./gradlew bootRun
```

Once the service started, the endpoint will be available at `localhost:8080`, so you can make request to the service endpoint

```json
GET localhost:8080/reply/22-kbzw9ru

{
    message: "e8501e64cf0a9fa45e3c25aa9e77ffd5"
}
```

## API

**String Reply Service**

GET `/reply/{rule}-{message}`

| Parameters | Type     | Description                                                     |
| ---------- | -------- | --------------------------------------------------------------- |
| `rule`     | `String` | a 2-digit rule that will be used to process the message         |
| `message`  | `String` | the message to be processed in the following format `[a-z0-9]*` |

### Rules

| Rule    | Number | Description                                                              |
| ------- | ------ | ------------------------------------------------------------------------ |
| Reverse | 1      | Reverses a given input: `kbzw9ru` -> `ur9wzbk`                           |
| Hash    | 2      | Encodes the given input: `kbzw9ru` -> `0fafeaae780954464c1b29f765861fad` |

### Error Handling

A validation rule is added to handle invalid arguments provided by the clients calling the API. These validation rules will throw exceptions if conditions aren't met.

#### Implementing a new Rule

1. To create a new rule, go to `src/main/java/com/beta/rules`.
   1. Your new rule should implement the `Rule` interface.
2. Create your own implementation of the new rule inside the `apply(String)#String` method.

## Changelog

- **Version 2**
  - Updated **String Reply Service** `/reply/{rule}-{message}`
  - Error handling is in place. JSON response for erroneous services is
    `{"error" : "<ERROR Message goes here>"}`
- **Version 1**
  - Created **String Reply Service** `/reply/{message}`

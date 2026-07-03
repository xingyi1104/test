# AGENTS.md

This file provides guidance to the AI agent when working with code in this repository.

## Architecture

Spring Boot 3.2.5 / Java 26 project using MyBatis + MySQL.

Layered architecture: **Controller → Manager → Mapper**. The "manager" layer sits between controllers and mappers as the business logic layer (not "service").

## MyBatis Generator — Do Not Hand-Edit Generated Files

Files marked `@mbg.generated` are produced by MyBatis Generator and will be overwritten on regeneration:
- `src/main/java/trip/one/beans/*DO.java`, `*DOExample.java`
- `src/main/java/trip/one/mapper/*Mapper.java`
- `src/main/resources/mapper/*Mapper.xml`

To regenerate after schema changes:
```
mvn mybatis-generator:generate
```

Config is at `src/main/resources/generatorConfig.xml`. Update the `classPathEntry` to point to a real MySQL connector JAR path before running.

## Build & Run

```
mvn clean package -DskipTests
mvn spring-boot:run
```

Requires a running MySQL instance with database `btrip_one`. Connection config is in `src/main/resources/application.properties`.

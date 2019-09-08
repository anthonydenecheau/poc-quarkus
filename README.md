# POC Quarkus

## Features
* application CRUD (resteasy,hibernate validator, panache)
* Bdd : h2
* documentation
* health (readiness)

## TODO
* logging
* tracing
* metrics

## 
* url
    http://localhost:8080
    http://localhost:8080/swagger-ui
    http://localhost:8080/health

* commande
- run
```bash
mvn compile quarkus:dev
```
- test
```bash
mvn test
```
- quarkus
```bash
mvn quarkus:list-extensions 
```

```bash
mvn quarkus:add-extension -Dextensions="quarkus-jdbc-h2,quarkus-hibernate-orm-panache, quarkus-hibernate-validator,quarkus-resteasy-jsonb,quarkus-swagger-ui,quarkus-smallrye-health"
```

## References

* Tracing, heath, etc.
https://lordofthejars.github.io/quarkus-cheat-sheet/
 * application
https://github.com/quarkusio/quarkus-quickstarts/tree/master/hibernate-orm-panache-resteasy
* présentation
https://www.youtube.com/watch?v=JhAYfP99agc
* notes
bug swagger : https://github.com/quarkusio/quarkus/issues/3852

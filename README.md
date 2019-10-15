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
* fault tolerance

## 
- url
```bash
http://localhost:8080
http://localhost:8080/swagger-ui
http://localhost:8080/health
```

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
mvn quarkus:add-extension -Dextensions="quarkus-jdbc-h2,quarkus-hibernate-orm-panache, quarkus-hibernate-validator,quarkus-resteasy-jsonb,quarkus-swagger-ui,quarkus-smallrye-health"
```

- cloud run
```bash
mvn -N team.quad:cloudify-maven-plugin:0.1.0:gcloud-run

gcloud projects list
gcloud projects delete book-service-8535128678


gcloud config set project modern-dream-226714
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
* GCP
https://medium.com/@alexismp/deploying-a-quarkus-app-to-google-cloud-run-c4a8ca3be526
https://github.com/quad-teams/quarkus-google-cloud-run
https://cloud.google.com/sdk/docs/quickstart-windows
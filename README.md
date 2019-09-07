create
mvn io.quarkus:quarkus-maven-plugin:0.21.2:create -DprojectGroupId=org.acme -DprojectArtifactId=application-configuration -DclassName="org.acme.config.GreetingResource" -Dpath="/greeting"

mvn quarkus:add-extensions -Dextensions="quarkus-jdbc-h2,quarkus-hibernate-orm-panache,quarkus-hibernate-validator,quarkus-resteasy-jsonb"

run
mvn compile quarkus:dev

application
https://github.com/quarkusio/quarkus-quickstarts/tree/master/hibernate-orm-panache-resteasy
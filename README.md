create
mvn io.quarkus:quarkus-maven-plugin:0.21.2:create -DprojectGroupId=org.acme -DprojectArtifactId=application-configuration -DclassName="org.acme.config.GreetingResource" -Dpath="/greeting"

mvn quarkus:add-extensions -Dextensions="quarkus-jdbc-h2,quarkus-hibernate-orm-panache,quarkus-hibernate-validator,quarkus-resteasy-jsonb"

run
mvn compile quarkus:dev

echo "# poc-quarkus" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/anthonydenecheau/poc-quarkus.git
git push -u origin master

application
https://github.com/quarkusio/quarkus-quickstarts/tree/master/hibernate-orm-panache-resteasy
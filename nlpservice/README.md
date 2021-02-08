# NLPService

How to start the NLPService application
---

1. Run `mvn clean install` to build your application. In case you get ssl error, add the following switch to your project `-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true`
1. Start application with `java -jar target/nlpservice-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

## Deployment
- Add maven plugin for azure `mvn com.microsoft.azure:azure-webapp-maven-plugin:1.12.0:config -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=tr
ue`
- Execute the following in order `az login` then `mvn package azure-webapp:deploy`


## Reference:
This project have been generated using the following command `mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=2.0.18 -X -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true`

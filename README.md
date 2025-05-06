# quarkus-observability-openshift

This project creates an application based on the Quarkus framework and is a companion app for this blog post: https://developers.redhat.com/articles/2025/04/22/quarkus-opentelemetry-openshift 

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Configure OpenShift observability stack

Please follow the [OpenShift observability setup](openshift/README.md) guide.

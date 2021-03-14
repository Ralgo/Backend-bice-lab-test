# backend-bice-lab-test
BICE Bank Lab Test Project

Indecon Api Consumer

## Description

* This springboot based backend project uses swagger api to expose all of the rest services (this is useful
because the frontend app relies on it).

* Junit 5 for the unit test was used, and also for the http calls (indecon) is based on the spring component "WebClient".

* MockWebServer helps to get a dummy web server sending mock messages to the WebClient unit tests.

* OWASP dependency check tool is activated at the at the maven "verify" goal ***(mvn verify)***.

* The OWASP report it's located at the "target/dependency-check-report.html"

* ***Warning: The first time the OWASP tool is executed i'll take a lot of time because it's downloading all the vulnerabilities DB.***

* ***Java 11 it's needed!***

## Build

```
mvn install 
```
(to build, test, owasp and package)

## Execute

```
mvn spring-boot:run
```

# Walmart Book Shop Application

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Walmart Book Shop Application shows list of available books in a paginated fashion and details of books with specifications,features, and reviews. You can reach the application as followed link.

[Walmart Book Shop Application Live](http://projects.spring.io/spring-boot/)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Lombok](https://projectlombok.org/)
    * For IntelliJ [Lombok IntelliJ Plugin] (https://plugins.jetbrains.com/plugin/6317-lombok)
    * For Eclipse [Lombok Eclipse] (https://projectlombok.org/downloads/lombok.jar)

## Running the application locally

There are several ways to run a Spring application on your local machine. One way is to execute the `main` method in the `com.canemreayar.bookshop.BookShopApplication` class from your IDE.

Alternatively you can use the maven exec command like:

For calling below command,first you have to go the project folder directory.

```shell
mvn clean install
mvn exec:java -Dexec.mainClass=com.canemreayar.bookshop.BookShopApplication
```
## Calling api methods with Postman

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/291cfa620eb53863acb4)

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.


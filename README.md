
# Walmart Book Shop Application
[![Build Status](https://travis-ci.org/justayar/walmart_book_shop.svg?branch=master)](https://travis-ci.org/justayar/walmart_book_shop)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Walmart Book Shop Application shows list of available books in a paginated fashion and details of books with specifications,features, and reviews. You can reach the application with the followed link:

[Walmart Book Shop Application Live](http://35.204.232.28/bookList)

## Requirements

For building and running the application you need:

- [JDK 1.10](https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
- [Maven 3](https://maven.apache.org)
- [Lombok](https://projectlombok.org/)
    * For IntelliJ [Lombok IntelliJ Plugin] (https://plugins.jetbrains.com/plugin/6317-lombok)
    * For Eclipse [Lombok Eclipse] (https://projectlombok.org/downloads/lombok.jar)

## Running the application locally

There are several ways to run a Spring application on your local machine. One way is to execute the `main` method in the `com.canemreayar.bookshop.BookShopApplication` class from your IDE.

Alternatively you can use the maven spring-boot run command like:

For calling below commands,firstly you have to go the project folder directory.

```shell
mvn clean install
mvn spring-boot:run
```

After execution completed, you can open your favourite browser and call http://localhost:8080/bookList

If you would like to test api methods as a rest client, you can use below postman collections.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/291cfa620eb53863acb4)

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.


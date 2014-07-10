# Spring-web-skeleton

This is a skeleton(boilerplate) project for building a spring web project with spring-data-jpa.  And It's a maven web app.

You can use it to build a Web project with the supporting of AJAX.

Backend database is Mysql.

## Dependencies

- Spring MVC 3.2.8
- Spring Data Jpa 1.4.3
- Hibernate 4.3.0.Final
- Proxool 0.9.1 (for connection pool)
- Jackson-mapper-asl 1.9.13 (for ajax)

## Make it work

1. Modify ```src/main/resources/settings.properties``` for connection parameters like database url, username, password, etc.

2. in ```settings.properties```, ```connection.username``` and ```connection.password``` use maven properties, you can either specify it directly in the property file, or specify it in the maven ```~/.m2/settings.xml```, like: 

```
  <profiles>
    <profile>
      <id>mysqlConfig</id>
      <properties>
		<db.username>root</db.username>
		<db.password>122333</db.password>
      </properties>
    </profile>
  </profiles>
```

2. do ```mvn install```, this will execute test and run the spring framework, thus updating the database schema and insert some fake data.

3. do ```mvn jetty:run```, this will run a jetty server, so can visit it at "http://localhost:8080". Some test urls:
	- http://localhost:8080/
	- http://localhost:8080/user
	- http://localhost:8080/ajax/1
	
## Customize it

1. Change package name root, say, from 		```com.web``` to ```com.myproject```, you can do this with IDE

2. Modify ```src/main/spring-context.xml```, to make the ```<context:component-scan base-package="com.web" />``` complies with your settings. 

3. Modify ```src/main/jpa-context.xml```, adapt ```packagesToScan``` in ```<bean id="entityManagerFactory">```, and ```base-package``` in ```<jpa:repositories>```

4. Modify ```pom.xml```, for groupId, artifactId, name, url, finalName, etc.

5. Also you should modify ```src/main/webapp/WEB-INF/web.xml``` to make the package name complies (you can find all ```com.web``` and replace them).
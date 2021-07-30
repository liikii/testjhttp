## simple java example using java 8 and maven

---

#### mvn commands:
```shell
mvn archetype:generate -DgroupId=testjhttp -DartifactId=testjhttp
mvn package
mvn compile
mvn clean
```

#### mvn properties
```html
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
```


#### mvn repository:
```html
    <mirror>
      <id>aliyunmaven</id>
      <mirrorOf>*</mirrorOf>
      <name>阿里云公共仓库</name>
      <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
    
    <mirror>
      <id>huaweicloud</id>
      <mirrorOf>external:*,!aliyunmaven</mirrorOf>
      <name>华为云公共仓库</name>
      <url>https://mirrors.huaweicloud.com/repository/maven/</url>
    </mirror>
    
    <mirror>
      <id>apachemaven</id>
      <mirrorOf>external:*,!aliyunmaven,!huaweicloud</mirrorOf>
      <name>apache公共仓库</name>
      <url>https://repo.maven.apache.org/maven2</url>
    </mirror>
```

#### mvn dependency
```html
    <dependency>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.2.0</version>
    </dependency>
    <dependency>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-assembly-plugin</artifactId>
      <version>3.3.0</version>
    </dependency>
```



#### maven plugins
```html
    <plugin>
          <artifactId>maven-assembly-plugin</artifactId>
          <configuration>
            <!--这部分可有可无,加上的话则直接生成可运行jar包-->
            <archive>
              <manifest>
                <mainClass>testjhttp.App</mainClass>
              </manifest>
            </archive>
            <descriptorRefs>
              <descriptorRef>jar-with-dependencies</descriptorRef>
            </descriptorRefs>
          </configuration>
          <executions>
            <execution>
              <id>make-assembly</id>
              <!-- bind to the packaging phase -->
              <phase>package</phase>
              <goals>
                <goal>single</goal>
              </goals>
            </execution>
          </executions>
        </plugin>

        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.1.2</version>
          <configuration>
            <archive>
              <manifest>
                <addClasspath>true</addClasspath>
                <mainClass>testjhttp.App</mainClass> <!-- 此处为主入口-->
              </manifest>
            </archive>

          </configuration>
        </plugin>
```


#### mvn plugins
```html
    <plugins>
      <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-assembly-plugin</artifactId>
      </plugin>
      <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-jar-plugin</artifactId>
      </plugin>
    </plugins>
```
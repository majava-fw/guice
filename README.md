# Guice

_[Majava Framework](//github.com/majava-fw)_

<p>
    <a href="//github.com/majava-fw/guice/releases"><img src="https://img.shields.io/github/v/release/majava-fw/guice"></a>
    <a href="https://jitpack.io/#majava-fw/guice"><img src="https://img.shields.io/jitpack/v/majava-fw/guice"></a>
    <a href="//github.com/majava-fw/guice/commits/main"><img src="https://img.shields.io/github/last-commit/majava-fw/guice"></a>
    <a href="//github.com/majava-fw/guice/releases"><img src="https://img.shields.io/github/downloads/majava-fw/guice/total"></a>
    <a href="//github.com/majava-fw/guice/blob/main/LICENSE.md"><img src="https://img.shields.io/github/license/majava-fw/guice"></a>
    <a href="//github.com/majava-fw/guice"><img src="https://img.shields.io/github/languages/code-size/majava-fw/guice"></a>
    <a href="//github.com/majava-fw/guice/issues"><img src="https://img.shields.io/github/issues-raw/majava-fw/guice"></a>
    <a href="//java.com"><img src="https://img.shields.io/badge/java-8-orange"></a>
</p>

Java extension for Majava using [Google's Guice](https://github.com/google/guice) as Dependency Injection framework.

## Summary

1. [Installation](#installation)
    1. [Gradle](#gradle)
    2. [Maven](#maven)
2. [How to use](#how-to-use)
3. [Built With](#built-with)
4. [Authors](#authors)
5. [License](#license)

## Installation

Make sure to replace `%version%` with the latest version number, or a commit hash, e.g. `1.0.0`. You can find this
library [HERE](https://jitpack.io/#majava-fw/guice)

### Maven

Register the repository

```xml

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Now add the dependency itself

```xml

<dependency>
    <groupId>com.github.majava-fw</groupId>
    <artifactId>guice</artifactId>
    <version>%version%</version>
</dependency>
```

### Gradle

Register the repository

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```

Now add the dependency itself

```gradle
dependencies {
    implementation 'com.github.majava-fw:guice:%version%'
}
```

## How to use

First, you need to have desired understanding of how Guice works. \
Integrating this extension into Majava framework is really easy. Just use the Bootstrap class provided, instead of
default one:

```java
import tech.majava.guice.Bootstrap;

class Main {

    public static void main(String[] args) {
        Bootstrap.run(args);
    }

}
```

And now you don't need to register modules manually in the majava.yml - this extension will take care of it for you. \
If you would like to create custom Guice Modules, to handle injecting, just create a **final** class
extending `com.google.inject.AbstractModule` and it will be registered for you automatically!

## Built With

* [Java 8](https://java.com)

## Authors

* [Majksa (@maxa-ondrej)](https://github.com/maxa-ondrej)

## License

This project is licensed under the GPL-3.0 License - see the [LICENSE](LICENSE) file for details
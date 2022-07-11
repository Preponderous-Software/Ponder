# Ponder

## Description
This library contains a collection of modules that assist with the development of console applications and Minecraft plugins. 

## Projects

A [list of projects](https://github.com/Preponderous-Software/Ponder/wiki/Projects) is available on the wiki.

## Support

For support, you can join our [support discord server](https://discord.gg/G6wQxfcBMt).

### Experiencing a bug?

Please [fill out a bug report here](https://github.com/Preponderous-Software/Ponder/issues?q=is%3Aissue+is%3Aopen+label%3Abug).

## Example Application

An example of an application created with Ponder can be
found [here](https://github.com/Preponderous-Software/ExamplePonderApplication).

## Example Spigot Plugin

An example of a Minecraft plugin created with Ponder can be
found [here](https://github.com/Preponderous-Software/ExamplePonderPlugin).

## Maven

### repository

```
        <repository>
            <id>dansplugins.com</id>
            <url>https://repo.dansplugins.com/repository/maven-public/</url>
        </repository>
```

### ponder-bukkit

```

        <dependency>
            <groupId>com.dansplugins</groupId>
            <artifactId>ponder-bukkit</artifactId>
            <version>2.0.0</version>
        </dependency>
```

### ponder-cache

```

        <dependency>
            <groupId>com.dansplugins</groupId>
            <artifactId>ponder-cache</artifactId>
            <version>2.0.0</version>
        </dependency>
```

### ponder-commands

```

        <dependency>
            <groupId>com.dansplugins</groupId>
            <artifactId>ponder-commands</artifactId>
            <version>2.0.0</version>
        </dependency>
```

## Authors and acknowledgement

Name | Main Contributions
------------ | -------------
[Daniel Stephenson](https://github.com/dmccoystephenson) | Creator
Callum | wrote some methods that were used in AbstractPluginCommand and ApplicationCommand; contributed NMSAssistant and NMSVersion; improved ColorChecker; contributed ColorConverter; improved EventHandlerRegistry; improved UUIDChecker; improved ArgumentParser; contributed ConfigurationFile
[Pasarus](https://github.com/Pasarus) | wrote code that was used in JsonWriterReader and UUIDChecker; contributed Pair
Caibinus | wrote code that was used in BlockChecker
Deej | Set up the javadocs
VoChiDanh | Improved the BlockChecker and added the MaterialChecker
alyphen | Generified types of maps, lists and sets across the project, massively overhauled the project and split it into three modules, introduced tests

Have you made a contribution and don't see yourself above? Please add your name and open a PR!

## Project Status

This project is in active development.

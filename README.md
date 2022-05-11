# Ponder

## Description

Ponder is a library that assists with the development of software applications and plugins through the use of provided
tools, services and specifications. Functionality that can be used in many areas has been abstracted out into usable
frameworks. This greatly simplifies the process of creating and updating software.

A [list of features](https://github.com/Preponderous-Software/Ponder/wiki/Features) is available on the wiki.

## Projects

A [list of projects](https://github.com/Preponderous-Software/Ponder/wiki/Projects) is available on the wiki.

## Support

For support, you can join our [support discord server](https://discord.gg/G6wQxfcBMt).

### Experiencing a bug?

Please [fill out a bug report here](https://github.com/Preponderous-Software/Ponder/issues?q=is%3Aissue+is%3Aopen+label%3Abug)
.

## Installation/Configuration

For help with installation/configuration, check
out [this page](https://github.com/Preponderous-Software/Ponder/wiki/Setup-Tutorial-(Configuration)). Please keep in
mind that while this library can be used, it is unstable and likely to change.

## Usage

- [Tutorials](https://github.com/Preponderous-Software/Ponder/wiki/List-of-Tutorials)

## Example Application

An example of an application created with Ponder can be
found [here](https://github.com/Preponderous-Software/ExamplePonderApplication).

## Example Spigot Plugin

An example of a Minecraft plugin created with Ponder can be
found [here](https://github.com/Preponderous-Software/ExamplePonderPlugin).

## Maven

- Maven Dev Build

```
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>

        <dependency>
            <groupId>com.github.Preponderous-Software</groupId>
            <artifactId>Ponder</artifactId>
            <version>07e0c073e9</version>
        </dependency>
```

- Maven Release

```
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
        <dependency>
            <groupId>com.github.Preponderous-Software</groupId>
            <artifactId>Ponder</artifactId>
            <version>v1.0</version>
        </dependency>
```

## Roadmap

- [Known Bugs](https://github.com/Preponderous-Software/Ponder/issues?q=is%3Aopen+is%3Aissue+label%3Abug)
- [Planned Features](https://github.com/Preponderous-Software/Ponder/issues?q=is%3Aopen+is%3Aissue+label%3AEpic)
- [Planned Improvements](https://github.com/Preponderous-Software/Ponder/issues?q=is%3Aopen+is%3Aissue+label%3Aimprovement)

## Contributing

- [Notes on Contributing](https://github.com/Preponderous-Software/Ponder/wiki/Contributing)

## Authors and acknowledgement

Name | Main Contributions
------------ | -------------
[Daniel Stephenson](https://github.com/dmccoystephenson) | Creator
Callum | wrote some methods that are used in AbstractPluginCommand and ApplicationCommand; contributed NMSAssistant and NMSVersion; improved ColorChecker; contributed ColorConverter; improved EventHandlerRegistry; improved UUIDChecker; improved ArgumentParser; contributed ConfigurationFile
[Pasarus](https://github.com/Pasarus) | wrote code that is used in JsonWriterReader and UUIDChecker; contributed Pair
Caibinus | wrote code that is used in BlockChecker
Deej | Set up the javadocs
VoChiDanh | Improved the BlockChecker and added the MaterialChecker
alpyhen | Generified types of maps, lists and sets across the project

Have you made a contribution and don't see yourself above? Please add your name and open a PR!

## Project Status

This project is in active development.

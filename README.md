<p align="center"><img src="./common/src/main/resources/icon.png" width=96></p>

<h1><p align="center">Intentional Pickup</p></h1>

<p align="center">A simple mod that makes mobs only pickup items that are intentionally dropped by players.</p>

<div align="center">

[Download on Modrinth](https://modrinth.com/project/intentional-pickup/versions) |
[Download from Releases](https://github.com/VoxelBill/intentional-pickup/releases)

</div>

## About The Project

**Intentional Pickup** is a small and lightweight mod for Fabric and NeoForge that changes mobs to ***only*** pickup items that are dropped by players. This change should reduce lag by preventing mass build-up of mobs in caves in long term worlds and servers. If running on a server the mod is only required on the server side and is not required to be on the client.

## Run

1. Download `intentional_pickup-x.x.x+mc26.2.jar` from one of the places at the top of this README.
2. Copy the downloaded jar file to your `mods` folder.

## Getting Started With Development

To get a local copy up and running, follow these simple steps.

### Prerequisites

Ensure you have the following installed on your machine:

* **Java Development Kit (JDK)**: Version 25 or higher.
  * [Download JDK](https://adoptium.net/)
* **Gradle**: Version 9.2 or higher.
  * [Install Gradle](https://gradle.org/install/)
* **Minecraft**: Version 26.2

### Build

1. **Clone the repository**
```sh
git clone https://github.com/VoxelBill/intentional-pickup.git
```

2. Navigate to the project directory
```sh
cd intentional-pickup
```

3. Build the project with Gradle
```sh
./gradlew clean build
```

You can find the built mod at `intentional-pickup/<loader>/build/libs/intentional_pickup-x.x.x+mc26.2.jar`.

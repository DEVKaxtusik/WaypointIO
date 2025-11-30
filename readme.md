# **WaypointIO**

> A small yet powerful library for adding custom waypoints to Minecraft's Locator Bar.

[![Minecraft](https://img.shields.io/badge/minecraft-1.21.5+-brightgreen.svg)](https://minecraft.net)
[![Java](https://img.shields.io/badge/java-21+-orange.svg)](https://adoptium.net/)
[![License](https://img.shields.io/github/license/DEVKaxtusik/WaypointIO.svg)](LICENSE)

---

## **Features**

* 🎯 Simple fluent API
* 🎨 Customizable colors & styles
* 📦 Resource pack icon support (Experimental)
* 🔄 Real-time updates
* 👥 Per-player waypoints
* 🚀 No entities — pure packets (built on PacketEvents)

---

## **Requirements**

* Minecraft **1.21.5+**
* Paper / Spigot / Purpur
* [PacketEvents](https://github.com/retrooper/packetevents) **2.10.0+**
* Java **21+**

---

## **Installation**

### **Maven**

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.DEVKaxtusik</groupId>
        <artifactId>WaypointIO</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### **Gradle**

```gradle
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.DEVKaxtusik:WaypointIO:Tag")
}
```

---

## **Quick Start**

```java
// Initialize in onEnable()
WaypointIO.initialize(JavaPlugin);

// Create waypoint
Waypoint waypoint = WaypointIO.getInstance().builder()
        .name("Home")
        .location(player.getLocation())
        .style(WaypointStyle.DEFAULT)
        .color(Color.GREEN)
        .build();

// Show to player
WaypointIO.getInstance().getManager().showWaypoint(player, waypoint);
```

---

## **Advanced Usage**

### **Update a waypoint**

```java
waypointIO.getManager().updateWaypoint(player, updatedWaypoint);
```

### **Custom resource pack icon (Experimental)**

```java
Waypoint custom = waypointIO.builder()
        .customStyle("namespace", "path")
        .color(Color.YELLOW)
        .build();
```

### **Remove waypoint**

```java
waypointIO.getManager().hideWaypoint(player, waypointId);
```

---

## **Documentation**

See **CONTRIBUTING.md** for full documentation and usage examples.

---

## **Contributing**

Contributions welcome! Please read **CONTRIBUTING.md** for guidelines.

---

## **License**

GPLv3 License — see **LICENSE** for details.

---

## **Credits**

Built with **PacketEvents**
Made with ❤️ by **[DEVKaxtusik](https://github.com/DEVKaxtusik)**

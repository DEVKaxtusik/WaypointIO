# **WaypointIO**

> A small yet powerful library for adding custom waypoints to Minecraft's Locator Bar.

[![Minecraft](https://img.shields.io/badge/minecraft-1.21.5+-brightgreen.svg)](https://minecraft.net)
[![Java](https://img.shields.io/badge/java-21+-orange.svg)](https://adoptium.net/)
[![License](https://img.shields.io/github/license/DEVKaxtusik/WaypointIO.svg)](LICENSE)

---

## **Features**

- 🎯 **Simple Fluent API** — Create waypoints with an intuitive builder pattern  
- 🎨 **Customizable** — Full control over colors and built-in styles  
- 📦 **Resource Pack Support** — Use custom icons from your resource packs *(Experimental)*  
- 🔄 **Real-time Updates** — Modify waypoints on the fly  
- 👥 **Per-Player** — Waypoints are individual to each player  
- 🚀 **Zero Entities** — Pure packet-based implementation (built on PacketEvents)

---

## **Requirements**

- Minecraft **1.21.5+**
- Paper / Spigot / Purpur
- [PacketEvents](https://github.com/retrooper/packetevents) **2.11.1+**
- Java **21+**

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
        <version>v1.1.0</version>
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
    implementation("com.github.DEVKaxtusik:WaypointIO:v1.1.0")
}
```

---

## **Quick Start**

### **1. Initialize the Manager**

You must initialize the `WaypointManager` in your plugin’s `onEnable()`.
This performs the version check automatically.

```java
public class MyPlugin extends JavaPlugin {
    
    private WaypointManager waypointManager;

    @Override
    public void onEnable() {
        try {
            // Initialize manager (throws exception if server version < 1.21.5)
            this.waypointManager = new WaypointManager(this);
        } catch (UnsupportedOperationException e) {
            getLogger().severe("WaypointIO requires Minecraft 1.21.5+");
            getServer().getPluginManager().disablePlugin(this);
        }
    }
}
```

---

### **2. Create and Show a Waypoint**

```java
// 1. Create a Waypoint object using the Builder
Waypoint home = new WaypointBuilder()
        .name("Home")
        .location(player.getLocation())
        .style(WaypointStyle.DEFAULT)
        .color(Color.GREEN)
        .build();

// 2. Show it to the player
waypointManager.showWaypoint(player, home);
```

---

## **Advanced Usage**

### **Update a Waypoint**

Create a *new* Waypoint object with the **same ID** to update it.

```java
Waypoint updatedHome = new WaypointBuilder()
        .id(home.getId()) // IMPORTANT: Use the same ID
        .name("Home (Moved)")
        .location(newLocation)
        .color(Color.YELLOW)
        .build();

waypointManager.updateWaypoint(player, updatedHome);
```

---

### **Custom Resource Pack Icon (Experimental)**

Use custom icons defined in your server resource pack.

```java
Waypoint custom = new WaypointBuilder()
        .name("Quest Marker")
        .location(targetLoc)
        .customStyle("my_namespace", "quest_icon") // References my_namespace:quest_icon
        .color(Color.WHITE)
        .build();

waypointManager.showWaypoint(player, custom);
```

---

### **Remove Waypoints**

```java
// Remove a specific waypoint
waypointManager.hideWaypoint(player, home.getId());

// Remove ALL waypoints for a player
waypointManager.hideAllWaypoints(player);
```

---

## **Contributing**

Contributions are welcome!
Please read **CONTRIBUTING.md** for guidelines on reporting bugs or submitting pull requests.

---

## **License**

**GPLv3 License** — see `LICENSE` for details.

---

## **Credits**

* Built with PacketEvents
* Made with ❤️ by **DEVKaxtusik**

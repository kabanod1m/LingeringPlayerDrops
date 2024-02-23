# LingeringPlayerDrops
A Fabric Minecraft mod that prevents items that players drop from ever despawning. Configure with gamerules playerDropItemsLinger and playerDeathItemsLinger.

### Installation
Requires Minecraft 1.20.1, [Fabric Loader](https://fabricmc.net/) >=0.14.25 and [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api).

### Configuration
The mod can be configured by setting the world's game rules "playerDropItemsLinger" and "playerDeathItemsLinger" to either true or false. False is vanilla behavior where items disappear after 5 minutes.\
\
Please note that setting those game rules to false will NOT make all previously dropped disappear! To clean up your world from such items, you need to go approximately where they are (load chunks in the area) and execute these commands for example:\
Teleport to self:\
/tp @e[type=minecraft:item,nbt={Age:-32768s}] @s\
Kill lingering items:\
/kill @e[type=minecraft:item,nbt={Age:-32768s}]

### License
LingeringPlayerDrops is licensed under MIT.

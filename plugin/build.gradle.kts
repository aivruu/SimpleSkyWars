plugins {
	id("com.github.johnrengelman.shadow") version("7.1.2")
	id("net.minecrell.plugin-yml.bukkit") version("0.5.2")
	`java-library`
}

val directory = property("group") as String
val release = property("version") as String
val libraries = "$directory.libraries"

repositories {
	maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
	maven("https://repo.glaremasters.me/repository/concuncan/")
	maven("https://repo.extendedclip.com/content/repositories/snapshots/")
	maven("https://jitpack.io/")
	mavenCentral()
}

dependencies {
	compileOnly("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
	
	compileOnly("com.grinderwolf:slimeworldmanager-api:2.2.1")
	compileOnly("me.clip:placeholderapi:2.11.2")
	
	implementation(project(":api"))
	implementation("com.github.InitSync.XConfig:bukkit:1.1.3")
	implementation("com.github.InitSync:XTitle:1.0.1")
}

bukkit {
	name = "SimpleSkyWars"
	main = "$directory.plugin.SimpleSkyWars"
	authors = listOf("InitSync")
	
	apiVersion = "1.13"
	version = release
	
	depend = listOf("SlimeWorldManager")
	softDepend = listOf("PlaceholderAPI")
	
	commands {
		register("simpleskywars") {
			description = "-> Command to handle the plugin."
			aliases = listOf("ssw")
		}
		
		register("skywars") {
			description = "-> Command to use/play the minigame features."
			aliases = listOf("sw")
		}
	}
}

tasks {
	shadowJar {
		archiveFileName.set("SimpleSkyWars-$release.jar")
		destinationDirectory.set(file("$rootDir/bin/"))
		minimize()
		
		relocate("net.xconfig.bukkit", "$libraries.xconfig")
		relocate("net.xtitle", "$libraries.xtitle")
	}
	
	withType<JavaCompile> {
		options.encoding = "UTF-8"
	}
	
	clean {
		delete("$rootDir/bin/")
	}
}
plugins {
	id("com.github.johnrengelman.shadow") version("7.1.2")
	`java-library`
	`maven-publish`
}

val release = property("version") as String

repositories {
	maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
	mavenCentral()
}

dependencies {
	compileOnly("org.spigotmc:spigot-api:1.13.2-R0.1-SNAPSHOT")
}

tasks {
	shadowJar {
		archiveFileName.set("SimpleSkyWarsAPI-$release.jar")
		destinationDirectory.set(file("$rootDir/bin/"))
	}
	
	clean {
		delete("$rootDir/bin/")
	}
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = "net.simpleskywars.api"
			artifactId = "api"
			version = release
			
			from(components["java"])
		}
	}
}
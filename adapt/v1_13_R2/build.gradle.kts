plugins {
	`java-library`
}

repositories {
	maven("https://repo.codemc.org/repository/nms/")
	mavenCentral()
}

dependencies {
	compileOnly("org.spigotmc:spigot:1.13.2-R0.1-SNAPSHOT")
	
	implementation(project(":api"))
}
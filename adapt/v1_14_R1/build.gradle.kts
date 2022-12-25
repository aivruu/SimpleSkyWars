plugins {
	`java-library`
}

repositories {
	maven("https://repo.codemc.org/repository/nms/")
	mavenCentral()
}

dependencies {
	compileOnly("org.spigotmc:spigot:1.14.4-R0.1-SNAPSHOT")
	
	implementation(project(":api"))
}
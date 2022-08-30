plugins {
	id("fabric-loom") version "1.0-SNAPSHOT"
	id("java")
}

version = project.properties["mod_version"] as String
group = project.properties["maven_group"] as String

repositories {
	maven("https://maven.parchmentmc.org")
}

dependencies {
	minecraft("com.mojang:minecraft:${project.properties["minecraft_version"]}")
	mappings(loom.layered {
		officialMojangMappings()
		parchment("org.parchmentmc.data:parchment-1.19.2:2022.08.21@zip")
	})

	modImplementation("net.fabricmc:fabric-loader:${project.properties["loader_version"]}")
	modImplementation("net.fabricmc.fabric-api:fabric-api:${project.properties["fabric_version"]}")
}


tasks.processResources {
	inputs.property("version", project.version)

	filesMatching("fabric.mod.json") {
		expand("version" to project.version)
	}
}

tasks.withType<JavaCompile> {
	options.release.set(17)
}

java {
	withSourcesJar()

	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

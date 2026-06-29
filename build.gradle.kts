plugins {
    id("java-library")
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")

    // Avaje
    maven("https://repo1.maven.org/maven2/")

    // LogienchLibのRepositoryをここに追加
}

dependencies {
    testCompileOnly("org.jetbrains:annotations:26.1.0")

    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")

    // Avaje Inject
    implementation("io.avaje:avaje-inject:11.4")

    annotationProcessor(
        "io.avaje:avaje-inject-generator:11.4"
    )

    // ClassGraph
    implementation("io.github.classgraph:classgraph:4.8.180")

    // LogienchLib
    // implementation("???")

    // JUnit
    testImplementation(platform("org.junit:junit-bom:5.13.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks {
    runServer {
        minecraftVersion("1.21.8")
        jvmArgs("-Xms2G", "-Xmx2G")
    }

    processResources {
        val props = mapOf("version" to version)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }

    test {
        useJUnitPlatform()
    }
}

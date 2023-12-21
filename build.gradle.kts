val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kgraphql_version: String by project
val postgresql_version: String by project
val exposed_version: String by project


plugins {
    base
    application
    kotlin("jvm") version "1.8.0"
}

group = "com.redskill"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("com.apurebase:kgraphql:$kgraphql_version")
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")

    implementation("org.postgresql:postgresql:$postgresql_version")

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

tasks {
    compileKotlin { kotlinOptions { jvmTarget = JavaVersion.VERSION_18.toString() } }
    compileTestKotlin { kotlinOptions { jvmTarget = JavaVersion.VERSION_18.toString() } }

    test {
        useJUnitPlatform()
    }
}


repositories {
    mavenCentral()
}
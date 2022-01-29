import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
import java.util.Properties
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("gradle.plugin.com.ewerk.gradle.plugins:querydsl-plugin:1.0.10")
	}
}

plugins {
	id("org.springframework.boot") version "2.5.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("plugin.jpa") version "1.5.31"
	kotlin("jvm") version "1.5.31"
	kotlin("kapt") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
	id("com.gorylenko.gradle-git-properties") version "1.5.1"
}


group = "com.exercise"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations.forEach {
	it.exclude("org.springframework.boot", "spring-boot-starter-tomcat")
}
repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2020.0.4"

dependencies {
	implementation("io.springfox", "springfox-swagger2", "2.9.2")
	implementation("io.springfox", "springfox-swagger-ui", "2.9.2")
	implementation("com.querydsl:querydsl-jpa:5.0.0")
	implementation("com.querydsl:querydsl-apt:5.0.0")
	implementation("com.querydsl:querydsl-sql-spring:5.0.0")
	kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-undertow")
	//	implementation("org.springframework.boot:spring-boot-starter-amqp:2.5.5")
//	implementation("org.springframework.boot:spring-boot-starter-web:2.5.5")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
	implementation("org.flywaydb:flyway-core:8.0.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j:2.0.2")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.0.4")
	runtimeOnly("mysql:mysql-connector-java:8.0.25")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.5")
//	testImplementation("org.springframework.amqp:spring-rabbit-test:2.3.9")
	kapt("org.springframework.boot:spring-boot-configuration-processor:2.5.5")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.5")
	runtimeOnly("com.h2database:h2:1.4.200")
	testImplementation("org.junit.jupiter", "junit-jupiter-api")
	testImplementation("org.mockito:mockito-core:4.0.0")
	testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	doFirst {
		val git = org.ajoberstar.grgit.Grgit.open {
			file(".")
		}
		val infoFile = file("${projectDir}/src/main/resources/build-info.properties")
		val properties = Properties()
		val localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
		properties.setProperty("info.version", "1.1.4")
		properties.setProperty("info.git.hash", git.head().getAbbreviatedId(7))
		properties.setProperty("info.git.buildDate", localDateTime)
		properties.store(infoFile.writer(), "Build Information")
	}
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

val querydslSourcesDir = file("src/main/generated")

sourceSets {
	main {
		java {
			listOf("src/main/java", querydslSourcesDir)
		}
		kotlin {
			listOf("src/main/kotlin", querydslSourcesDir)
		}
	}
}

tasks.getByName<BootJar>("bootJar") {
	enabled = true
}
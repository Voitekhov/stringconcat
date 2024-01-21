object Plugins {
    const val springBoot = "org.springframework.boot"
    const val springDependencyManagement = "io.spring.dependency-management"
    const val kotlinSpring = "plugin.spring"
    const val kotlinJpa = "org.jetbrains.kotlin.plugin.jpa"

    const val gradleVersions = "com.github.ben-manes.versions"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting"
}

object Libs {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib"
    const val kotlinStdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"

    const val springBootWebfluxStarter = "org.springframework.boot:spring-boot-starter-webflux:${Versions.springBoot}"
    const val springBootStarterDataJpa = "org.springframework.boot:spring-boot-starter-data-jpa:${Versions.springBoot}"
    const val springBootStarterRest = "org.springframework.boot:spring-boot-starter-data-rest:${Versions.springBoot}"
    const val springBootTestStarter = "org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}"
    const val springBootDevTools = "org.springframework.boot:spring-boot-devtools"
    const val springWeb = "org.springframework:spring-web:${Versions.springWeb}"

    const val postgresql = "org.postgresql:postgresql:${Versions.postgresql}"
    const val liqubase = "org.liquibase:liquibase-core:${Versions.liqubase}"

    const val junit5Api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    const val junit5JupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"

    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    const val javaxPersistenceApi = "javax.persistence:javax.persistence-api:${Versions.javaxPersistenceApi}"

    const val log4j = "org.apache.logging.log4j:log4j-core:${Versions.log4j}"

    const val jacksonKotlinModule = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jacksonKotlinModule}"

    const val kotlinxHtml = "org.jetbrains.kotlinx:kotlinx-html-jvm:${Versions.kotlinxHtml}"

    const val projectreactor = "io.projectreactor:reactor-test:${Versions.projectreactor}"
}

object Versions {
    const val kotlin = "1.5.0"

    const val springBoot = "2.2.1.RELEASE"
    const val springDependencyManagement = "1.0.8.RELEASE"
    const val springWeb = "5.2.0.RELEASE"

    const val gradleVersions = "0.38.0"

    const val detekt = "1.17.0"

    const val postgresql = "42.3.4"
    const val liqubase = "4.9.1"

    const val junit5 = "5.8.2"

    const val javaxInject = "1"
    const val javaxPersistenceApi = "2.2"

    const val log4j = "2.17.2"

    const val jacksonKotlinModule = "2.10.0"
    const val kotlinxHtml = "0.6.12"
    const val projectreactor = "3.3.0.RELEASE"

}

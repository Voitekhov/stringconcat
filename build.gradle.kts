import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.kotlin
    id(Plugins.gradleVersions) version Versions.gradleVersions
    id(Plugins.detekt) version Versions.detekt
    jacoco
    id(Plugins.springBoot) version Versions.springBoot
    id(Plugins.springDependencyManagement) version Versions.springDependencyManagement
    kotlin(Plugins.kotlinSpring) version Versions.kotlin
    id(Plugins.kotlinJpa) version Versions.kotlin apply false
}

allprojects {

    apply {
        plugin("kotlin")
        plugin(Plugins.gradleVersions)
        plugin(Plugins.detekt)
        plugin("jacoco")
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
        jcenter()
    }

    detekt {
        allRules = false
        buildUponDefaultConfig = true
        config = files("$rootDir/detekt/detekt-config.yml")
        input = files(
            io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_SRC_DIR_KOTLIN,
            io.gitlab.arturbosch.detekt.extensions.DetektExtension.Companion.DEFAULT_TEST_SRC_DIR_KOTLIN,
        )

        tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
            reports {
                xml.enabled = true
                html.enabled = true
                txt.enabled = true
            }
        }

        reports {
            html.enabled = true
        }

        dependencies {
            detektPlugins("${Plugins.detektFormatting}:${Versions.detekt}")
        }
    }


    jacoco {
        toolVersion = "0.8.9"

    }

    tasks.jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    minimum = "0.5".toBigDecimal()
                }
            }
        }
    }

    tasks.jacocoTestReport {
        dependsOn(tasks.test)
        finalizedBy(tasks.jacocoTestCoverageVerification)
    }

    tasks.test {
        useJUnitPlatform()
        finalizedBy(tasks.jacocoTestReport)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    configurations.all {
        resolutionStrategy {
            eachDependency {
                if (requested.version.isSnapshotVersion()) {
                    throw GradleException(
                        "Dependency with SNAPSHOT version found: ${requested.name} ${requested.version}"
                    )
                }
            }
        }
    }
}


buildscript {
    dependencies {
        classpath(Libs.kotlinStdlibJdk8)
        classpath(Libs.kotlinReflect)
    }
}

val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}


dependencies {
    // spring modules
    implementation(Libs.springBootWebfluxStarter)
    implementation(Libs.springBootStarterDataJpa)
    implementation(Libs.springBootStarterRest)

    // kotlin
    implementation(Libs.kotlinReflect)
    implementation(Libs.kotlinStdlibJdk8)

    implementation(project(":presentation"))
    implementation(project(":persistence"))
    implementation(project(":useCasePeople"))
    implementation(project(":businessPeople"))
    implementation(project(":quoteGarden"))
    implementation(project(":avatarsDicebear"))

    // dev tools
    developmentOnly(Libs.springBootDevTools)

    //persistance
    implementation(Libs.postgresql)
    implementation(Libs.liqubase)

    // tests
    testImplementation(Libs.junit5Api)
    testImplementation(Libs.springBootTestStarter) {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation(Libs.projectreactor)
}

fun String?.isSnapshotVersion(): Boolean = this?.contains("SNAPSHOT", true) ?: false

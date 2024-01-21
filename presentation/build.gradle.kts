plugins {
    kotlin(Plugins.kotlinSpring)
    id(Plugins.springDependencyManagement)
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    // spring modules
    implementation(Libs.springBootWebfluxStarter)
    implementation(Libs.springBootStarterRest)

    // tools
    implementation(Libs.jacksonKotlinModule)

    // view
    implementation(Libs.kotlinxHtml)

    // kotlin
    implementation(Libs.kotlinReflect)
    implementation(Libs.kotlinStdlibJdk8)

    // tests
    testImplementation(Libs.junit5Api)
    testRuntimeOnly(Libs.junit5JupiterEngine)
    testImplementation(Libs.springBootTestStarter) {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation(Libs.projectreactor)
}

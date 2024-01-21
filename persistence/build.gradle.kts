plugins {
    id(Plugins.springDependencyManagement)
    id(Plugins.kotlinJpa)
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    implementation(Libs.javaxPersistenceApi)
    implementation(Libs.log4j)
    implementation(Libs.springBootStarterDataJpa)

    // kotlin
    implementation(Libs.kotlinReflect)
    implementation(Libs.kotlinStdlibJdk8)

    // tests
    testImplementation(Libs.junit5Api)
    testRuntimeOnly(Libs.junit5JupiterEngine)
}

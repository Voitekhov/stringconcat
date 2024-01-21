dependencies {
    implementation(project(":businessPeople"))

    implementation(Libs.javaxInject)
    implementation(Libs.springWeb)

    // kotlin
    implementation(Libs.kotlinReflect)
    implementation(Libs.kotlinStdlibJdk8)

    // tests
    testImplementation(Libs.junit5Api)
    testRuntimeOnly(Libs.junit5JupiterEngine)
}

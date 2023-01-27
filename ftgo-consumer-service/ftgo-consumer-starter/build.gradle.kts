tasks.getByName("bootJar") {
    enabled = true;
}

apply(plugin = "org.graalvm.buildtools.native")

dependencies {
    implementation(project(":ftgo-consumer-common"))
    implementation(project(":ftgo-consumer-inbound"))
    implementation(project(":ftgo-consumer-logic"))
    implementation(project(":ftgo-consumer-outbound"))
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootBuildImage> {
    if (org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentArchitecture().isArm) {
        builder.set("dashaun/builder-arm:tiny")
    }
}
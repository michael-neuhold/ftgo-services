tasks.getByName("bootJar") {
    enabled = true;
}

apply(plugin = "org.graalvm.buildtools.native")

dependencies {
    implementation(project(":ftgo-courier-inbound"))
    implementation(project(":ftgo-courier-logic"))
    implementation(project(":ftgo-courier-outbound"))
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootBuildImage> {
    if (org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentArchitecture().isArm) {
        builder.set("dashaun/builder-arm:tiny")
    }
}
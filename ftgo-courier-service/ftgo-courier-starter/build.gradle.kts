tasks.getByName("bootJar") {
    enabled = true;
}

apply(plugin = "org.graalvm.buildtools.native")

dependencies {
    implementation(project(":ftgo-courier-inbound"))
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootBuildImage> {
    if (org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentArchitecture().isArm) {
        builder.set("dashaun/builder-arm:tiny")
    }
}
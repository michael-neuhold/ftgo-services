tasks.getByName("bootJar") {
    enabled = true;
}

dependencies {
    implementation(project(":ftgo-consumer-inbound"))
}
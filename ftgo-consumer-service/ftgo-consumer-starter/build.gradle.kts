tasks.getByName("bootJar") {
    enabled = true;
}

dependencies {
    implementation(project(":ftgo-consumer-inbound"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
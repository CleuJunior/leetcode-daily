plugins {
    id("java")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

group = "br.com.leetcode"
version = "0.1"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}
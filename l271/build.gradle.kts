plugins {
    id("java")
}

group = "br.com.leetcode"
version = "0.1"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}
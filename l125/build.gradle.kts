plugins {
    id("java")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

group = "br.com.leetcode"
version = "unspecified"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}
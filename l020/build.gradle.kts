plugins {
    id("java")
}

group = "com.leetcode"
version = "unspecified"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
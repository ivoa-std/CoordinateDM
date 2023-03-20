plugins {
    id("net.ivoa.vo-dml.vodmltools") version "0.3.14"
    `maven-publish`
    application
}

group = "org.javastro.ivoa.dm"
version = "1.0-SNAPSHOT"

vodml {
    vodmlDir.set(file("vo-dml"))
    bindingFiles.setFrom(file("vo-dml/coord.vodml-binding.xml")
    )

}

dependencies {
    api("org.javastro.ivoa.vo-dml:ivoa-base:1.0-SNAPSHOT") // IMPL using API so that it appears in transitive compile
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

application {
    mainClass.set("Genschema")
}

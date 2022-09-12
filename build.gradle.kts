plugins {
    id("net.ivoa.vo-dml.vodmltools") version "0.3.7"
    application
}
vodml {
    vodmlDir.set(file("vo-dml"))
    bindingFiles.setFrom(file("vo-dml/coord.vodml-binding.xml")
    )

}

dependencies {
    implementation("org.javastro.ivoa.vo-dml:ivoa-base:1.0-SNAPSHOT")
}

application {
    mainClass.set("Genschema")
}

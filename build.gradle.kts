plugins {
    id("net.ivoa.vo-dml.vodmltools") version "0.3.14"
    `maven-publish`
    application
}

group = "org.javastro.ivoa.dm"
version = "1.0-SNAPSHOT"

vodml {
    vodmlDir.set(file("vo-dml"))
    vodslDir.set(file("model"))
    bindingFiles.setFrom(file("vo-dml/coord.vodml-binding.xml")
    )

}



tasks.register("UmlToVodml", net.ivoa.vodml.gradle.plugin.XmiTask::class.java) {
    xmiScript.set("xmi2vo-dml_Modelio3.7_UML2.4.1.xsl") // the conversion script
    xmiFile.set(file("./model/coords_1.0_uml2p4p1.xmi")) //the UML XMI to convert
    vodmlFile.set(file("./vo-dml/Coords-v1.0.vo-dml.xml")) // the output VO-DML file.
    description = "convert UML to VO-DML"
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

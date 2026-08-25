# CI / GitHub Actions

diese Repository verwendet GitHub Actions um automatisch den Build und Test des Projekts auf Windows durchzuführen.

Der Workflow wird bei jedem pull request und bei jedem push auf den Branch 'main' durchgeführt.

## Workflow Steps

1. Checkout
2. Set up JDK 21
3. Build
4. Test anhand der im Projekt vorhandenen Tests
5. Dependency graph

Der Workflow wird in der Datei .github/workflows/maven-build-and-test.yml definiert und ersetzt das lokale Testen nicht, sondern dient als zusätzliche Absicherung.

Ein Fehlgeschlagener CI Workflow blockiert keinen Merge und verhindert somit nicht das eigenmächtige Mergen von fehlerhaftem Code, kann aber u.a. auf einen fehlgeschlagenen Testfall hindeuten. Dazu sollte man die vollständigen Logs im Actions Tab dieses Repositories einsehen.

Unit tests werden als teil des source codes dieses Projekts entwickelt und gepflegt. Der Workflow führt Maven anhand der `pom.xml` im Unterverzeichnis `bauanleitung-helfer3` aus. Der Workflow ist aktuell nurauf Windows ausgerichtet. Sollte kompatibilität auch auf anderen plattformen erwünscht sein, kann dies in der [Workflow Konfiguration](.github/workflows/maven-build-and-test.yml) entsprechend konfigurieren oder mich in einem Issue darüber wissen lassen.
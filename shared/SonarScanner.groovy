import groovy.transform.CompileStatic

/**
 * Clase para trabajar con SonarScanner.
 * Esta clase proporciona métodos para gestionar el escaneo de una aplicación en SonarQube con SonarScanner.
 * @author jcescobarn
 * @version 1.0
 */
@CompileStatic
class SonarScanner {

    /**
    * Método para ejecutar el escaneo de una aplicación en SonnarQube con Sonnar Scanner
    * @param projectKey la clave del proyecto en sonarqube
    * @param projectName Nombre del proyect a evaluar
    * @param sourcePath Ruta del proyecto que se desea analizar
    */

    static void scanApplication(String projectKey, String projectName, String sourcePath) {
        def scannerHome = tool "SonarScanner" // Herramienta de SonnarScanner configurada en Jenkins
        def sonarQubeServer = "SONAR"

        withSonarQubeEnv(sonarQubeServer) {
            sh "${scannerHome}/bin/sonnar-scanner" +
                " -Dsonar.projectKey=${projectKey} " +
                " -Dsonar.projectName=${projectName} " +
                " -Dsonar.sources=${sourcePath}"
        }

    }

}

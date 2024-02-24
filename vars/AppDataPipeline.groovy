import SonarScanner

/**
 * Clase para definir un pipeline de Jenkins para escanear un proyecto de aplicación.
 * Este pipeline utiliza SonarScanner para realizar el análisis estático del código.
 * @jcescobarn 
 * @version 1.0
 */

class AppDataPipeline {

    /** Configuración del pipeline */
    def pipelineConfig

    /**
     * Constructor de la clase AppDataPipeline.
     * @param pipelineConfig Configuración del pipeline.
     */
    AppDataPipeline(Map pipelineConfig) {
        this.pipelineConfig = pipelineConfig
    }

    /**
     * Método para construir y ejecutar el pipeline.
     * Este método define las etapas y pasos del pipeline.
     */
    public void pipeline() {
        pipeline {
            agent any

            stages {
                stage('Scan Project') {
                    steps {
                        script {
                            SonnarScanner.scanApplication(
                                projectKey: pipelineConfig.projectKey,
                                projectName: pipelineConfig.projectName,
                                sourcePath: pipelineConfig.sourcePath
                            )
                        }
                    }
                }
            }
        }
    }
}

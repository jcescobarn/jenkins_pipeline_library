import ../shared.SonnarScanner


class AppDataPipeline{

    def pipelineConfig

    AppDataPipeline(Map pipelineConfig){
        this.pipelineConfig = pipelineConfig
    }

    def build(){
        pipeline{
            agent any

            stages{
                stage('Scan Project'){ 
                    steps {
                        script {
                            SonnarScanner.scanApplication(
                                projectKey: config.projectKey,
                                projectName: config.projectName,
                                sourcePath: config.sourcePath
                            )
                        }
                    }
                }
            }
        }
    }

}


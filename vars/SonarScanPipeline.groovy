def call(Map params = [:]) {
    pipeline {
        agent any

        parameters {
            string(name: 'projectKey', defaultValue: 'defaultKey', description: 'Key of the project')
            string(name: 'projectName', defaultValue: 'defaultName', description: 'Name of the project')
            string(name: 'sourcePath', defaultValue: '.', description: 'Source path of the project')
        }

        stages {
            stage('Scan Project') {
                steps {
                    script {
                        SonnarScanner.scanApplication(
                            projectKey: params.projectKey,
                            projectName: params.projectName,
                            sourcePath: params.sourcePath
                        )
                    }
                }
            }
        }
    }
}
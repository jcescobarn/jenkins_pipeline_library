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
                        def scannerHome = tool "SonarQube Scanner";
                        withSonarQubeEnv('SonarQube') {
                            sh "${scannerHome}/bin/sonar-scanner"+
                            " -Dsonar.projectKey=${params.projectKey}"+
                            " -Dsonar.projectName=${params.projectName}"+
                            " -Dsonar.sources=${params.sourcePath}"
                        }
                    }
                }
            }
        }
    }
}
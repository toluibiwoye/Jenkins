pipeline {
    agent any // This tells Jenkins to use any available agent to run the pipeline

    stages {
        stage('Checkout') {
            steps {
                // Checks out the source code from remote repository
                git 'https://github.com/toluibiwoye/Jenkins'
            }
        }

        stage('Build') {
            steps {
            sh 'mvn clean install' // command to build project
            }
        }
    }
}

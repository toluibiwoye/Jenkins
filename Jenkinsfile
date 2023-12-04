pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/toluibiwoye/Jenkins.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build without tests
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Run JUnit tests with Maven
                sh 'mvn test'
            }
            post {
                // This block runs after the steps in the 'Test' stage
                always {
                    // Archive the JUnit test results
                    junit '**/target/surefire-reports/*.xml'
                }
                success {
                    echo 'Tests passed!'
                }
                failure {
                    echo 'Tests failed!'
                }
            }
        }
    }
    post {
        always {
            // Clean up the workspace to free space after the build and test are done
            cleanWs()
        }
    }
}

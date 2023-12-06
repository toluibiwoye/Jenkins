pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/toluibiwoye/Jenkins.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build without tests, corrected typo in '-DskipTests'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Set the Maven tool
                def mvnHome = tool 'M3'
                // Run JUnit tests with Maven using the tool
                bat "\"${mvnHome}\\bin\\mvn\" test"
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

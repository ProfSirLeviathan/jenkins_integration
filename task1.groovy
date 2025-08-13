pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning the repository...'
                git branch: 'aryan', url: 'https://github.com/infuse-training-aug-2025/jenkins-session.git'
            }
        }

        stage('Run Batch File') {
            steps {
                echo 'Running the batch file...'
                script {
                    def result = bat(script: 'random_number.bat', returnStatus: true)
                    if (result != 0) {
                        error "Batch file failed. Random number was less than 30."
                    } else {
                        echo "Batch file executed successfully. Random number was 30 or greater."
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
pipeline {
    agent any
    stages {
        stage('Fast Task') {
            steps {
                echo 'Starting fast task...'
                bat 'ping -n 6 127.0.0.1 >nul'
                echo 'Fast task completed.'
            }
        }
        stage('Slow Task') {
            steps {
                echo 'Starting slow task...'
                bat 'ping -n 16 127.0.0.1 >nul'
                echo 'Slow task completed.'
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}
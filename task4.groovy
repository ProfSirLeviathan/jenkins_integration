pipeline {
    agent any
    triggers {
        cron('*/1 * * * *')//every minute
    }
    stages {
        stage('Show Current Time') {
            steps {
                script {
                    def currentTime = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('IST'))
                    echo "Current IST Time: ${currentTime}"
                }
            }
        }
    }
}
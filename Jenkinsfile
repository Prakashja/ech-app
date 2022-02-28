pipeline{
    agent any
    triggers {
        cron("0 7 * * *")
        cron("0 18 * * *")
    }
    stages{
        stage('Run Jar'){
            steps{
                script{
                    sh '''
                    java -jar example.jar
                    '''
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}

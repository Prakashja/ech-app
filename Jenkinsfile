pipeline{
    agent any

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

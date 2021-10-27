pipeline{
    agent any

    stages{
        stage('build'){
            steps{
                script{
                    sh '''
                    mvn clean package
                    '''
                }
            }
        }
        stage('docker build'){
            steps{
                script{
                    sh '''
                    docker build -t sana03/myrestapi:${BUILD_NUMBER} .
                    '''
                }
            }
        }
        stage('docker push'){
            steps{
                script{
                    sh '''
                    docker push sana03/myrestapi:${BUILD_NUMBER}
                    '''
                }
            }
        }
    }
}

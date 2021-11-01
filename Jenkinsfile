pipeline{
    agent any

    stages{
        stage('mvn build'){
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
        stage('Deploy'){
            steps{
                script{
                    sh '''
                    ansible-playbook -i remote-details application.yaml  --extra-vars "version=sana03/myrestapi:${BUILD_NUMBER}" 
                    '''
                }
            }
        }
    }
}

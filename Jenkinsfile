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
                    chmod 400 devops-key.pem
                    ansible-playbook -i remote-details application.yaml  --extra-vars "version=sana03/myrestapi:${BUILD_NUMBER}" 
                    '''
                }
            }
        }
        stage('Deployment_validation'){
            steps{
                script{
                    sh '''
                    echo "running validation test for the app"
                    sleep 30s
                    echo "running validation test ..."
                    echo "running validation test ....."
		    curl -vk http://65.1.131.185:8090/wish
                    curl -vk http://65.1.131.185:8090/info
                    curl -vk http://13.127.18.204:8090/status
                    '''
                }
            }
        }
    post { 
        always { 
            cleanWs()
        }
    }
    }
}

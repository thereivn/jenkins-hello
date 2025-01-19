pipeline {
    agent docker

    stages{
        stage('Pull image'){
            steps{
                script{
                    sh 'docker pull thereivn/reivn-fastapi-v:0.0.1'
                    echo 'Image reivn-fastapi-v:0.0.1 pull done'
                }
            }
        }
        stage('Run docker image'){
            steps{
                script{
                    sh 'docker run -d --rm --name fastapp -p 8050:80 thereivn/reivn-fastapi-v:0.0.1'
                }
            }
        }
        stage('Check Docker container and check fastapi app'){
            sh 'docker ps | grep fastapp'
            sh 'curl -I http://localhost:8050'
        }
    }
}
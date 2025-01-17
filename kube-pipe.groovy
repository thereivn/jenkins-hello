pipeline {
    agent any

    stages {
        stage('get pods'){
            steps{
                script{
                    sh 'kubectl get pods'
                }
            }
        }
    }
}
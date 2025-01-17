pipeline {
    agent any
    environment {
        KUBECONFIG = '/home/thereiv/.kube/config'
    }

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
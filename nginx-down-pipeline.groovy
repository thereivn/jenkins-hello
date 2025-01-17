pipeline {
    agent any
    environment {
        KUBECONFIG = '/home/thereiv/.kube/config'
    }

    stages {
        stage('Get pods and services'){
            steps{
                script{
                    sh 'kubectl get pods'
                    sh 'kubectl get service'
                }
            }
        }
        stage('Delete nginx server'){
            steps{
                script{
                    sh 'kubectl delete -f nginx-pod.yaml'
                    sh 'kubectl delete -f nginx-service.yaml'
                    sh 'sleep 2'
                }
            }
        }
        stage('Get pods and services after deleting nginx'){
            steps{
                script{
                    sh 'kubectl get pods'
                    sh 'kubectl get service'
                }
            }
        }
    }
}
pipeline {
    agent any
    environment {
        KUBECONFIG = '/home/thereiv/.kube/config'
    }

    stages {
        stage('Starting pod with nginx'){
            steps {
                script {
                    sh 'kubectl apply -f nginx-pod.yaml'
                }
            }
        }
        stage('Starting nginx-service'){
            steps {
                script {
                    sh 'kubectl apply -f nginx-service.yaml'
                }
            }
        }
        stage('Waiting while nginx is start'){
            steps{
                script{
                    sh 'sleep 10'
                }
            }
        }
        stage('View pods and services'){
            steps {
                script {
                    sh 'kubectl get pods'
                    sh 'kubectl get services'
                }
            }
        }
    }
}
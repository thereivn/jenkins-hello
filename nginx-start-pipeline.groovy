pipeline {
    agent any

    stages {
        stage('Starting pod with nginx'){
            steps {
                script {
                    sh 'kubectl apply -f nginx-pod.yaml --validate=false'
                }
            }
        }
        stage('Starting nginx-service'){
            steps {
                script {
                    sh 'kubectl apply -f nginx-service.yaml --validate=false'
                }
            }
        }
        stage('Waiting while nginx is start'){
            steps{
                script{
                    sh 'sleep 5'
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
        stage('Opening nginx server in browser'){
            steps{
                script{
                    sh 'xdg-open http://localhost:8030'
                }
            }
        }
    }
}
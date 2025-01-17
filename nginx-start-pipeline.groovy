pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Клонирование репозитория с манифестами
                git 'https://github.com/thereivn/jenkins-hello.git'
            }
        }
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
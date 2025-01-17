pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Клонирование репозитория с манифестами
                git 'https://github.com/ваш_пользователь/ваш_репозиторий.git'
            }
        }
        stage('Starting pod with nginx'){
            steps {
                script {
                    sh 'kubectl apply -f ./yaml-files/nginx-pod.yaml'
                }
            }
        }
        stage('Starting nginx-service'){
            steps {
                script {
                    sh 'kubectl apply -f ./yaml-files/nginx-service.yaml'
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
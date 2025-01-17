pipeline {
    agent any

    stages {
        stage('Pull Nginx Image') {
            steps {
                script {
                    // download nginx image
                    sh 'docker pull nginx'
                }
            }
        }
        stage('Run Nginx Container in Docker') {
            steps {
                script {
                    // run nginx container
                    sh 'docker run -d --rm --name my-nginx -p 8030:80 nginx'
                }
            }
        }
        stage('Check nginx') {
            steps {
                script {
                    // checking nginx available
                    sh 'curl -I http://localhost:8030'
                }
            }
        }
        stage('All done, open nginx in browser!') {
            steps {
                script {
                    // opening nginx
                    sh 'xdg-open http://localhost:8030'
                }
            }
        }
    }
}
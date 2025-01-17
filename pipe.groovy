pipeline {
    agent any

    stages {
        stage('Hello jenkins!') {
            steps {
                script {
                    echo 'Hello, World! From pipe.groovy :3'
                }
            }
        }
    }
}
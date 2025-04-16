pipeline {
    agent any

    tools {
        maven 'Maven 3'  // Jenkins-ი გამოიყენებს თქვენს დაყენებულ Maven ინსტრუმენტს
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo 'Building project...'
                    sh 'mvn clean install'  // Maven-ის გამოყენებით პროექტის ბილდირება
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    echo 'Running tests...'
                    sh 'mvn test'  // Maven-ის გამოყენებით ტესტების გაშვება
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying application...'
                    sh 'mvn deploy'  // Maven-ის გამოყენებით აპლიკაციის განახლება
                }
            }
        }
    }
}

    post {
        success {
            script {
                echo 'Build and deployment successful!'
            }
        }
        failure {
            script {
                echo 'Build or deployment failed.'
            }
        }
    }
}

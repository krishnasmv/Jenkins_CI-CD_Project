// executing multiple commands or multiple actions on a single stage.

pipeline {
    agent any
    
    stages {
        stage('one') {
            steps {
                git 'https://github.com/devopsbyraham/jenkins-java-project.git'
                sh 'mvn compile'
                sh 'mvn test'
                sh 'mvn clean package'
            }
        }
    }
}
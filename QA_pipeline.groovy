pipeline {
    agent any 
    
    stages{
        stage('checkout') {
            steps {
                git 'https://github.com/devopsbyraham/jenkins-java-project.git'
            }
        }
        stage('build') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('code quality') {
            steps {
                sh '''
                mvn sonar:sonar \
                  -Dsonar.projectKey=netflix \
                  -Dsonar.host.url=http://13.38.32.159:9000 \
                  -Dsonar.login=3f017506d83cd334fba02ecf9db706c429ab5d38
                '''
            }
        }
        stage('artifact') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
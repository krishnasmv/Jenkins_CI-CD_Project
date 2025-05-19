pipeline {
    agent {
        label 'slave1'
    }
    
    stages {
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
                     -Dsonar.projectKey=project-netflix \
                     -Dsonar.host.url=http://52.47.193.26:9000 \
                     -Dsonar.login=54f6a0567ef5a12acda5eecee7ce51e0feb16bb1
                '''
            }
        }
        stage('artifact') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('deploy') {
            steps {
                deploy adapters:[
                    tomcat9(
                        credentialsId: 'a3f384b0-0de7-4b62-9800-24043d1d135d',
                        path: '',
                        url: 'http://13.39.49.204:8080/'
                        )
                    ],
                    contextPath: 'netflix',
                    war: 'target/*.war'
            }
        }
    }
}
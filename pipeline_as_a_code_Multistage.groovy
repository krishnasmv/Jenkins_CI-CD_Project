pipeline {
    agent any
    
    stages {
        stage('one') {
            steps {
                git 'https://github.com/devopsbyraham/jenkins-java-project.git'
                sh 'mvn compile'
            }
        }
        stage('two') {
            steps {
                sh 'mvn test'
                sh 'mvn clean package'
            }
        }
    }
}

//or

pipeline {
    agent any
    
    stages {
        stage('one') {
            steps {
                git 'https://github.com/devopsbyraham/jenkins-java-project.git'
                sh '''
                mvn compile
                mvn test
                mvn package
                mvn install
                mvn clean package
                '''
            }
        }
    }
}
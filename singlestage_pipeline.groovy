pipeline {
    agent any
    
    stages{
        stage('abc') {
            steps {
                sh 'touch file2'
            }
        }
    }
}
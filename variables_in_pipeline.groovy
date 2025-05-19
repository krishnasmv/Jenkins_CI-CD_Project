assigning the value 

a=10
name=raham

1. USER DEFINED VARIABLES:
a. local vars: we can define inside job
2. global vars: we can define outside jobs

2. JENKINS ENV VARS:
their vars are going to change as per build.

HOW TO PASS VARIABLES ON PIPELINE:


pipeline {
    agent any 
    
    environment {
        name = "raham"
        loc = "hyderabad"
    }
    stages {
        stage('one') {
            steps {
                echo "hai all my name is $name and im from $loc"
                sh 'env'
            }
        }
    }
}

=====================================================================

POST BUILD ACTIONS:
actions the we perform after the build is called as post build action.

always: if build failed or success it will run the post actions.
success: it will execute post actions only when the build is successful.
failure: it will execute post actions only when the build is failed.

pipeline {
    agent any 
    
    environment {
        name = "raham"
        loc = "hyderabad"
    }
    stages {
        stage('one') {
            steps {
                s 'env'
            }
        }
    }
    post {
        always {
            echo "the build is done"
        }
    }
}
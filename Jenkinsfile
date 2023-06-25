pipeline {

    environment {
        registry = "vkakkar1975/springbootapp"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }


    agent any

    stages {
        stage('Build') {
            steps {
                sh '''
                export JAVA_HOME='/usr/lib/jvm/java-11-openjdk-11.0.19.0.7-1.amzn2.0.1.x86_64'
                echo $JAVA_HOME
                echo 'Testing..'
                /opt/maven/bin/mvn --version
                /opt/maven/bin/mvn install
                ls -l ./target/
                '''
            }
        }
        stage('Create') {
            steps {
                script {
                   dockerImage = docker.build registry + ":3.0.0"
                }
            }
        }
        
        stage('Deploy') {
            steps {
               script {
                 docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                 }
               }
            }
        }
    }
}

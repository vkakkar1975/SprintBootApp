pipeline {

    agent any

    stages {
        stage('Build App') {
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
        stage('Build image for App') {
            steps {
               script {
                       dockerImage = docker.build("vkakkar1975/springbootapp:3.0.0")
               }
            }
       }
  
       stage('Push image') {
            steps {
                script {
                    withDockerRegistry([ credentialsId: "registryCredential", url: "" ]) {
                        dockerImage.push()
                    }
                }
            }  
       }


      stage('Test Pushed image') {
            agent {
                docker {
                    image 'vkakkar1975/springbootapp:3.0.0'
                }
            }
            steps {
                sh 'sleep 30'
                sh 'curl -s http://localhost:8080/getMessage'
                sh 'curl -s http://localhost:8080/getDate'
                sh 'curl -s http://localhost:8080/getLocale'
                sh 'echo "Test Passed'
            }
     }
    }
}

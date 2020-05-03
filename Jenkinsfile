pipeline {
  environment {
    registry = "moumitadas0991/docker-test"
    registryCredential = 'dockerhub'
    mvnHome = tool 'Maven'
    dockerImage = ''
    TOMCAT_USER = "deployuser"
    TOMCAT_PASSWORD = "123456"
    WAR_PATH = "target/cicd-pipeline.war"
    TOMCAT_HOST = "tomcat"
    TOMCAT_PORT = "8080"
    CONTEX_NAME = "myapp"
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/MoumitaDas1990/cicd-pipeline.git'
      }
    }
    stage('Build') {
      steps {
        withEnv(["MVN_HOME=$mvnHome"]) {
			sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean install'
		}
		archiveArtifacts 'target/*.war'
      }
    }
    stage('Deploy tomcat') {
      steps {
        sh 'curl -v -u $TOMCAT_USER:$TOMCAT_PASSWORD -T $WAR_PATH "http://$TOMCAT_HOST:$TOMCAT_PORT/manager/text/deploy?path=/$CONTEX_NAME&update=true"'
      }
    }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
  }
}
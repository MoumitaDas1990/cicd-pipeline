pipeline {
  environment {
    registry = "moumitadas0991/docker-test"
    registryCredential = 'dockerhub'
    mvnHome = tool 'Maven'
    sonar = tool 'Sonar'
    dockerImage = ''
    TOMCAT_USER = "admin"
    TOMCAT_PASSWORD = "nimda"
    WAR_PATH = "target/cicd-pipeline.war"
    TOMCAT_HOST = "localhost"
    TOMCAT_PORT = "8888"
    CONTEX_NAME = "myapp"
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/MoumitaDas1990/cicd-pipeline.git'
      }
    }
    stage('Build and test') {
      steps {
        withEnv(["MVN_HOME=$mvnHome"]) {
			bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean install/)
		}
		archiveArtifacts 'target/*.war'
      }
    }
    stage('Run sonar') {
      steps {
         withSonarQubeEnv('Sonar') {
			bat("\"${sonar}\"\\bin\\sonar-scanner")
		}
		  timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
      }
    }
    stage('Deploy tomcat') {
      steps {
        bat('curl -v -u deployuser:123456 -T target/cicd-pipeline.war "http://localhost:8888/manager/text/deploy?path=/myapp&update=true"')
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
    stage('Remove Unused docker containers') {
      steps{
        bat("docker container prune --force")
      }
    }
  }
  post {
        always {
          step([$class: 'Mailer',
            notifyEveryUnstableBuild: true,
            recipients: "moumitadas0991@gmail.com",
            sendToIndividuals: true])
        }
    }
}
pipeline {
  agent {
    kubernetes {
      idleMinutes 5  // how long the pod will live after no jobs have run on it
      yamlFile './jenkins/podConfiguration.yaml'
      defaultContainer 'soapui'
    }
  }
  environment {
    SERVICE_NAME = "mipr-funds-api-proxy"
    SERVICE_GROUP = "apigw"
    AWS_DEFAULT_REGION = "us-gov-west-1"
  }
  options { 
      // Used to put timestamps on the console output
      timestamps() 
  }
  stages {
    stage('Run SysIntTest Suite') {
      steps {
        script {
          currentBuild.displayName = "${DEPLOY_ENV}/${SERVICE_NAME}:${SERVICE_VERSION}".toLowerCase()
          withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: "${AWS_CREDENTIALS}"]]) {
            dir("./soap-ui") {
              sh '''
                # set -x
                env
                ls -al
                testrunner.sh -s"Mock Service Test Suite" -r -a MIPR-Mock-Service-soapui-project.xml
              '''
            }
          }
        }
      }
    }
  }
}
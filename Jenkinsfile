pipeline {
  agent any
  tools {
    maven 'Maven 3.8.7'
    jdk 'JDK17'
  }
  stages {
    stage('Initialize') {
      steps {
        bat '''
            java -version
            mvn --version
            docker --version
        '''
      }
    }
    stage('Build') {
      steps {
        // Get some code from a GitHub repository
        git 'https://github.com/dummy80/demo.git'

        // Run Maven on a Unix agent.
        // sh "mvn -Dmaven.test.failure.ignore=true clean package"

        // To run Maven on a Windows agent, use
        bat 'mvn -Dmaven.test.failure.ignore=true clean package'
      }

      post {
        // If Maven was able to run the tests, even if some of the test
        // failed, record the test results and archive the jar file.
        success {
          junit '**/target/surefire-reports/TEST-*.xml'
          archiveArtifacts 'target/*.jar'
        }
      }
    }

    stage('Containerize') {
      steps {
        bat 'docker build -t cherivstav/demo-spring-restapi:latest .'
        bat 'docker push cherivstav/demo-spring-restapi:latest'
      }
    }

    stage('Deploy') {
      steps {
          withCredentials([string(credentialsId: 'oc-token', variable: 'OC_TOKEN')]) {
            bat 'oc login --token=%OC_TOKEN% --server=https://api.openshift.demo.li9.com:6443'
          }
        bat 'helm upgrade --install my-demo-spring-restapi c:\\oc\\helm\\my-demo'
      }
    }
  }
}

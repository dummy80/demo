pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build App1') {
          steps {
            echo 'step one'
            echo 'step two'
          }
        }

        stage('Build App2') {
          steps {
            echo 'Pd one'
            echo 'Pd two'
          }
        }

      }
    }

    stage('Deploy') {
      parallel {
        stage('Deploy App1') {
          steps {
            echo 'Deploy 1'
          }
        }

        stage('Deploy App2') {
          steps {
            echo 'msg deploy app2'
          }
        }

      }
    }

  }
}
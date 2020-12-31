pipeline {
  agent any
  stages {
    stage('Build On DEV') {
      parallel {
        stage('Build On DEV') {
          steps {
            bat 'echo "run on DEV"'
          }
        }

        stage('Run On DEV') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Build On QA') {
      parallel {
        stage('Build On QA') {
          steps {
            bat 'echo "run on qa"'
          }
        }

        stage('Run On QA') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Build On Stage') {
      parallel {
        stage('Build On Stage') {
          steps {
            bat 'echo "run on stage"'
          }
        }

        stage('Run On Stage') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Build On PROD') {
      parallel {
        stage('Build On PROD') {
          steps {
            bat 'echo "run on prod"'
          }
        }

        stage('Run On PROD') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Publish Reports') {
      steps {
        sh 'echo "yuegfvd"'
      }
    }

  }
}
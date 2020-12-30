pipeline {
  agent any
  stages {
    stage('Run On DEV') {
      parallel {
        stage('Run On DEV') {
          steps {
            sh 'echo "run on DEV"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Run On QA') {
      parallel {
        stage('Run On QA') {
          steps {
            sh 'echo "run on qa"'
          }
        }

        stage('chome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            sh 'echo "run on firefox"'
          }
        }

      }
    }

    stage('Run On Stage') {
      parallel {
        stage('Run On Stage') {
          steps {
            sh 'echo "run on stage"'
          }
        }

        stage('chome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            sh 'echo "run on firefox"'
          }
        }

        stage('safari') {
          steps {
            sh 'echo "run on safari"'
          }
        }

      }
    }

    stage('Run On PROD') {
      parallel {
        stage('Run On PROD') {
          steps {
            sh 'echo "run on prod"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

  }
}
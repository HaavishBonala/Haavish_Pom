pipeline {
  agent any
  stages {
    stage('Run On DEV') {
      parallel {
        stage('Run On DEV') {
          steps {
            bat 'echo "run on DEV"'
          }
        }

        stage('chrome') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Run On QA') {
      parallel {
        stage('Run On QA') {
          steps {
            bat 'echo "run on qa"'
          }
        }

        stage('chome') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            bat 'echo "run on firefox"'
          }
        }

      }
    }

    stage('Run On Stage') {
      parallel {
        stage('Run On Stage') {
          steps {
            bat 'echo "run on stage"'
          }
        }

        stage('chome') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            bat 'echo "run on firefox"'
          }
        }

        stage('safari') {
          steps {
            bat 'echo "run on safari"'
          }
        }

      }
    }

    stage('Run On PROD') {
      parallel {
        stage('Run On PROD') {
          steps {
            bat 'echo "run on prod"'
          }
        }

        stage('chrome') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

  }
}

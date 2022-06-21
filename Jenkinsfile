pipeline {
             agent any
             stages {
             stage('build') {
                          steps {
                                echo 'building the application..'
                                bat './gradlew assemble'
                                                  }
                                      }
             stage('test') {
                                       steps {
                                             echo 'testing the application..'
                                             bat './gradlew test'
                                                               }
                                                   }
             stage('publish to sonarqube') {
                                                    steps {
                                                          echo 'publishing results to sonarqube...'
                                                          bat './gradlew sonarqube'
                                                                            }
                                                                }

            stage('deploy to docker') {
                                                   steps {
                                                         echo 'deploying the application..'
                                                         bat './gradlew docker'
                                                                           }
                                                               }

            stage('run on docker') {
                                                               steps {
                                                                     echo 'running the application..'
                                                                     bat './gradlew dockerRun'
                                                                                       }
                                                                           }

             }
             }
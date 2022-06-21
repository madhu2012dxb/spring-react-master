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

    stage('create and push image') {
    steps {
    echo 'creating image and pushing to local docker..'
    bat './gradlew docker'
    }
    }

    stage('start container') {
    steps {
    echo 'running the application..'
    bat './gradlew dockerRun'
    }
    }

  }
  }
pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave4_Mac'
    }

    //Opciones específicas de Pipeline dentro del Pipeline
    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    //Una sección que define las herramientas “preinstaladas” en Jenkins
    //tools {
    // jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    // gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
    // }
    tools {
        jdk 'JDK8_Mac'
    }

    //Aquí comienzan los “items” del Pipeline
    stages{
        stage('Checkout') {
        steps{
            echo "------------>Checkout<------------"
            checkout([
                $class: 'GitSCM',
                branches: [[name: '*/master']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [],
                gitTool: 'Default',
                submoduleCfg: [],
                userRemoteConfigs: [[
                    url:'https://github.com/andresdiaz1802/parkinglot'
                ]]
            ])
        }
    }

    stage('Compile & Unit Tests') {
        steps{
            echo "------------>Unit Tests<------------"
            sh 'chmod u+x gradlew'
            sh './gradlew --b ./app/build.gradle test'
            // sh './gradlew --b ./app/build.gradle connectedAndroidTest'

            // sh './gradlew --b ./app/build.gradle androidTest'
            sh './gradlew --b ./app/build.gradle jacocoTestReport'
        }
    }

    stage('Static Code Analysis') {
        steps{
            echo '------------>Análisis de código estático<------------'
            withSonarQubeEnv('Sonar') {
                sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
            }
        }
    }

    stage('Build') {
        steps {
            echo "------------>Build<------------"
            //Construir sin tarea test que se ejecutó previamente
            sh 'chmod u+x gradlew'
            // sh './gradlew clean'
            sh './gradlew --b ./app/build.gradle build -x test'
            }
        }
    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
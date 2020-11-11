pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/testautomation112020/qa.git'
            }

        }
        stage('run') {
                    steps {

                        // Run Maven on a Unix agent.
                        sh "mvn -Dmaven.test.failure.ignore=true clean test -pl qa-junit"
                        sh "pwd; ls-la"

                        // To run Maven on a Windows agent, use
                        // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                    }

                }

    }
}

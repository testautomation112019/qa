pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/testautomation112019/qa.git'
            }

        }
        stage('run') {
                    steps {

                        // Run Maven on a Unix agent.
                        sh "mvn -Dmaven.test.failure.ignore=true clean test"
                        sh "pwd; ls -la"

                        // To run Maven on a Windows agent, use
                        // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                    }

                }
        stage('report') {
                steps {
                        allure([
                                 includeProperties: false,
                                 jdk: '',
                                 properties: [[key: 'allure.issues.tracker.pattern', value: 'http://tracker.company.com/%s'],
                                 [key: 'allure.tests.management.pattern', value: 'http://tms.company.com/%s']],
                                 reportBuildPolicy: 'ALWAYS',
                                 results: [[path: 'qaapi/target/allure-results'], [path: 'qajunit/targed/allure-results'], [path: 'qagui/targed/allure-results']]
                        ])

                        cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/cucumber.json', jsonReportDirectory: 'qagui/target', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1

                }
        }

    }
}

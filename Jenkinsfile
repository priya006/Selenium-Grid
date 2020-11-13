node {
	stage ('SCM checkout'){
		git "https://github.com/priya006/Selenium-Grid.git"
		}
	stage ('Build'){
    	dir("Selenium_Grid") {
	   sh "mvn clean install"
       }
       	dir("Selenium_Grid/target") {
	   sh "java -jar Selenium_Grid-1.0-SNAPSHOT.jar"
       }
		}
}
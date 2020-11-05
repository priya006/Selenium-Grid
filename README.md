# Selenium-Grid 
-------------------
Selenium-Grid is used to run parallel executions in multiple machines at the same time.
Run the Test in the Hub and the actual execution takes place in node machine 

### Architecture Diagram
![Selenium_Grid](https://github.com/priya006/Selenium-Grid/blob/master/Selenium_Grid.png)

### How to Run Selenium Grid Test in Mac Node using Firefox browser
1. Download Selenium Server [Grid](https://www.selenium.dev/downloads/) 
2. From the hub(Main Machine where the test is run) CD to where the jar is downloaded and 
type the command `java -jar selenium-server-standalone-3.141.59.jar -role hub`
3. From hub/browser check if the hub is running  http://localhost:4444/grid/console
4. From Node machine type `http://IpAddressOfhub:4444/grid/console`
5. From the Node computer type the command `java -Dwebdriver.gecko.driver="pathwheregeckodriver.exeisdownloaded" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://IpAddressOfhub:4444/grid/register -port 5566`
so that node registers to the hub
6. From the hub/browser check http://localhost:4444/grid/console to see listening status





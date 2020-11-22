# Selenium-Grid 
-------------------
Selenium-Grid is used to run parallel executions in multiple machines at the same time.
Run the Test in the Hub and the actual execution takes place in node machine

# Table of Contents

1. [Environment](https://github.com/priya006/Selenium-Grid#environment)
2. [Architecture Diagram](https://github.com/priya006/Selenium-Grid#architecture-diagram)
3. [Assumptions](https://github.com/priya006/Selenium-Grid#assumptions)
4. [How to Run Selenium Grid Test in Mac Node using Firefox browser](https://github.com/priya006/Selenium-Grid#how-to-run-selenium-grid-test-in-mac-node-using-firefox-browser)
5. [Installation](https://github.com/priya006/Selenium-Grid#installation)
6. [How to configure Selenium grid with Android real Device as a Node using Appium
](https://github.com/priya006/Selenium-Grid#how-to-configure-selenium-grid-with-android-real-device-as-a-node-using-appium)
7. [How to configure Selenium grid with Android Emulator as a Node using Appium
](https://github.com/priya006/Selenium-Grid#how-to-configure-selenium-grid-with-android-emulator-as-a-node-using-appium)
8. [How to configure Selenium grid with IOS Simulator as a Node using Appium
](https://github.com/priya006/Selenium-Grid#how-to-configure-selenium-grid-with-ios-simulator-as-a-node-using-appium)
9. [Parallel Execution
](https://github.com/priya006/Selenium-Grid#parallel-execution)
10. [Selenium Tests on SauceLabs](https://github.com/priya006/Selenium-Grid#selenium-tests-on-saucelabs)
11. [Selenium Test on BrowserStack
    ](https://github.com/priya006/Selenium-Grid#selenium-test-on-browserstack)
12. [Selenium Test executed in AWS ec2 Instance. Selenium hub and Nodes are created as Docker containers](https://github.com/priya006/Selenium-Grid#selenium-test-in-aws-ec2-instance-and-the-selenium-hub-and-nodes-are-created-as-docker-containers)
13. [Troubleshooting Tips
](https://github.com/priya006/Selenium-Grid#troubleshooting-tips)
14. [Tips](https://github.com/priya006/Selenium-Grid#tips)
15. [References
](https://github.com/priya006/Selenium-Grid#references)



## Environment 

1. Appium Version : 1.18.3
2. Node.js : v10.16.0
3. selenium-server-standalone: 3.141.59
4. ChromeDriver: 83.0.4103 and 86.0.4240
5. npm: 6.9.0
6. Java SDK: 1.8.0_251
7. GeckoDriver: 0.27.0-macos
8. Android Emulator: API_27_Android_8.1_15GB
9. Android Real Device: OnePlus6T_AndroidVersion_10
10. IOS Simulator: iphone11_IOS_13.6
11. Safari: 13.1[SafariDriver Not Needed to download]

### Architecture Diagram
![Selenium_Grid](https://github.com/priya006/Selenium-Grid/blob/master/Selenium_Grid.png)

### Assumptions
1. Android Studio is set up with emulators created 
2. Xcode Set up and simulators are created

### How to Run Selenium Grid Test in Mac Node using Firefox browser
1. Download Selenium Server [Grid](https://www.selenium.dev/downloads/) 
2. From the hub(Main Machine where the test is run) CD to where the jar is downloaded and 
type the command `java -jar selenium-server-standalone-3.141.59.jar -role hub`
3. From hub/browser check if the hub is running  http://localhost:4444/grid/console
4. From Node machine type `http://IpAddressOfhub:4444/grid/console`
5. From the Node computer type the command `java -Dwebdriver.gecko.driver="pathwheregeckodriver.exeisdownloaded" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://IpAddressOfhub:4444/grid/register -port 5566`
so that node registers to the hub
6. From the hub/browser check http://localhost:4444/grid/console to see listening status

### Installation
1. `npm install -g appium` if you already have `npm` and `node js`
2.  Install `npm install -g appium-doctor ` and run the command `appium-doctor`
3. Run the command ` brew install carthage`   
   
### How to configure Selenium grid with Android real Device as a Node using Appium
1. Start the Selenium Stand alone server in a `Machine A`. This machine act as a hub. Command `java -jar selenium-server-standalone-3.141.59.jar -role hub`
2. Create a Configuration json file. Example: `Real_Device_Android_Node.json`
 
 **Selenium Grid Node Configuration Json File Template:**
```
{
  "capabilities":
      [
        {
          "browserName": "<e.g._iPhone5_or_iPad4>",
          "version":"<version_of_iOS_e.g._7.1>",
          "maxInstances": 1,
          "platform":"<platform_e.g._MAC_or_ANDROID>"
        }
      ],
  "configuration":
  {
    "cleanUpCycle":2000,
    "timeout":30000,
    "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "url":"http://<host_name_appium_server_or_ip-address_appium_server>:<appium_port>/wd/hub",
    "host": "<host_name_appium_server_or_ip-address_appium_server>",
    "port": <appium_port>,
    "maxSession": 1,
    "register": true,
    "registerCycle": 5000,
    "hubPort": <grid_port>,
    "hubHost": "<Grid_host_name_or_grid_ip-address>"
    "hubProtocol": "<Protocol_of_Grid_defaults_to_http>"
  }
}
```
3. In the Node machine (Say: Machine B) run the command ` appium --chromedriver-executable  <pathwherechromedriverisinstalled> -p 4725 --nodeconfig  <pathwheretheconfigurationjsonis>`
The Json file `Real_Device_Android_Node.json` has **localhost** for hub host key since the Android real device was connected to a laptop where the Selenium Stand alone server was running
4.Finally, run the Selenium test from the class `SeleniumGrid`

### How to configure Selenium grid with Android Emulator as a Node using Appium
1. Start the Selenium Stand alone server in a `Machine A`. This machine act as a hub. Command `java -jar selenium-server-standalone-3.141.59.jar -role hub`
2. Create a Configuration json file. Example: `Android_Emultor_Node.json`
3. Start the emulator and Run the command `adb devices`. Make sure to see emulator-5554	device is attached
4. Check the version of chrome in the emulator and download the compatible chromedriver.
5. Start  the Appium Sever with Emulator node attached. Example: `appium --chromedriver-executable  /Users/pboopathi/Downloads/chromedriver2 -p 4999 --nodeconfig  Android_Emulator_Node.json`
6. Run the test and watch the test running in Emulator :) 

### How to configure Selenium grid with IOS Simulator as a Node using Appium
![Selenium_Grid](https://github.com/priya006/Selenium-Grid/blob/master/Selenium_Grid_Server_Client.png)

1. Start the Selenium Stand alone server in a `Machine A`. This machine act as a hub. Command `java -jar selenium-server-standalone-3.141.59.jar -role hub`
2.  Create a Configuration json file. Example: `IOS_Simulator_Node.json`
3. Start the Simulator and Run the command `instruments -s devices` to make sure to see simulators attached to the laptop
4. No need to Install SafariDriver if the Safari Browser version is 10 and above.
5. Start  the Appium Sever with Simulator node attached. Example: `appium  -p 5777  --nodeconfig  IOS_Simulator_Node.json`
6. Run the test and watch the test running in Simulator :) 

### Parallel Execution
1. Selenium Stand alone server acting as **hub** is started. In the same machine/laptop **nodes** are also started and registered with the hub.
![Parallel_Execution](https://github.com/priya006/Selenium-Grid/blob/master/ParallelExecution_Grid_TestNG.png)
2. TestNG xml helps doing Parallel Execution. `Selenium_Grid_TestNG.xml` is executed

### Selenium Tests on SauceLabs
1. Create an account in [SauceLabs](https://saucelabs.com/sign-up) and login to follow below steps
2. Navigate to [UserSettings](https://app.saucelabs.com/user-settings) and get the `UserName` and `AccessKey`
3. Choose the `API`, `Device`, `Operating System`, `Browser` from [Platform Configurator](https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/). Get the code from Code generator from here
4. Execute the test class `SaucelabSeleniumGrid` via TestNG `Sauce_labs_Selenium_Grid.xml`
5. Test Results could be monitored [here](https://app.saucelabs.com/dashboard/tests/vdc)

### Selenium Test on BrowserStack
1. Create an account in [BrowserStack](https://www.browserstack.com/)
2. Make a Note of `USERNAME` and `Access_key
3. Configure [Capabilities](https://www.browserstack.com/automate/capabilities?tag=selenium-4)
4. Execute the class `BrowserStackSeleniumGrid` via TestNG `BrowserStack_Selenium_grid_TestNG.xml`
5. Test Results could be monitored in BrowserStack Dashboard
![TestResults](https://github.com/priya006/Selenium-Grid/blob/master/BrowserStack.png)

## Selenium Test in AWS ec2 Instance and the Selenium hub and Nodes are created as Docker containers
 
**Pre-req:** Sign up in AWS with an Account. And login as root user.
1. LaunchInstance > Community AMI's > Pick Amazon Linux machine with docker and docker-compose > Select t2.medium (Should [ay for this instance]) > Click Configure Intsnace Details > Make no change in configure instance details > Click Add storage Button > Click Add Tags > Click Configure Security Group > Change type as "ssh" Source as "Anywhere" > Add Rule and type as Custom TCP  port as "4444" > Launch your instance > Select a New Key pair > Give it a key value > Click Download Key pair > Click Launch instance
![AWSUI](https://github.com/priya006/Selenium-Grid/blob/master/AWS_UI.png)
2. Copy the public IP Address. Example: 35.165.129.54
3. Change the access permissions for the downloaded `pem`file. Example: `chmod 400 Seleniu_Grid_new.pem`
4. ssh to the Amazon ec2 instance. `ssh -i Seleniu_Grid_new.pem ec2-user@<Public IPv4 address>` Example: ec2-user@35.165.129.54
5. Execute the command `sudo yum update`
6. Remove old `1.7`version of Java and install `Java 1.8`. Execute the command `sudo  yum remove  java -y`
7. Install java 1.8 by running the command `sudo yum install java-1.8.0-openjdk -y`
8. Check the versions of docker and docker-compose. `docker -v` `docker-compose -v`
9. Create a file in ec2 instance withe the name `docker-compose.yml`. The container images will go into this file and it has the logic how the nodes connects to selenium_hub
10. Copy the content from https://github.com/SeleniumHQ/docker-selenium/blob/trunk/docker-compose-v3.yml and save the file as `docker-compose.yml`
11. To create the Selenium hub and Nodes. Run the command `docker-compose up -d`. This command downloads all images
12. To  check the docker containers started execute the command `docker ps -a`
![DockerContainer](https://github.com/priya006/Selenium-Grid/blob/master/Docker_Container.png)
13. To view grid console <https://publicipaddress:4444/grid/console> To View the running nodes and it's status from browser navigate to http://publicipaddress:4444/ui/index.html#/
14. Scale a container like so `docker-compose scale chrome=5`
15. Run  the Test class `SeleniumTestInAWSDocker` through `AWS_Docker_Selenium_Grid.xml` TestNG file

How to Kill the ec2 instance created:
-----------------------------------
1. docker-compose down to  tear down all the running docker containers
2. To tear down the ec2 machine. Go to AWS UI > Instances > Select the instance > Terminate instance
![Terminateec2](https://github.com/priya006/Selenium-Grid/blob/master/Terminate_ec2_Instance.png)

## Troubleshooting Tips
1. If there is issue while registering the node to the hub. Start the Selinium server/hub and navigate to http://localhost:4444/wd/hub from teh browser to see the full stack trace
2. It is important to set JAVA_HOME. [Guide to set Java home](https://medium.com/@spmadhi/easy-steps-to-install-and-set-java-home-in-mac-machine-c84b7bbc94e6)
3. It is important to understand **Chromedriver/Chrome compatibility**. List of Chromedriver versions and their matching minimum Chrome versions could be found [here](https://raw.githubusercontent.com/appium/appium-chromedriver/master/config/mapping.json)
4. After connecting the Real Android device to laptop using wire. Run the command `adb devices` to check if the device  is listed
5. Turn on `USB debugging` in Real device. System > Developer options > Debugging >  USB debugging

## Tips
1. How to find the version of browser. Type https://www.whatismybrowser.com/
   This could be helpful to find the version of browser you are using from Ipad or any device
2. Run the command `instruments -s devices` to get the list of IOS devices associated to your laptop
3. IOS Real Device or Simulator turn on the  `Allow Remote Automation`option. Navigate to `settings > safari > advanced`
4. Run the command `appium-doctor` and make sure you see green tick for all the checks.
4. Enable Developer  Options in Android Emulator before trying ti run the tests. Settings > System > About emulated device > Click the `Build Number 7 times`.   
5. [vysor](https://chrome.google.com/webstore/detail/vysor/gidgenkbbabolejbgbpnhbimgjbffefm?hl=en-US) extension could be handy when running selenium tests in mobile. As the extension let's to view Android phone in Computer.
 

**References**
----------------
1. [appium-chromedriver](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md)
2. [Download ChromeDriver](https://chromedriver.chromium.org/downloads)

# Selenium-Grid 
-------------------
Selenium-Grid is used to run parallel executions in multiple machines at the same time.
Run the Test in the Hub and the actual execution takes place in node machine

## Environment 

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
5. Start  the Appium Sever with Emulator node attached. Example: `appium --chromedriver-executable  /Users/pboopathi/Downloads/chromedriver2 -p 4999 --nodeconfig  Android_Emultor_Node.json`
6. Run the test and watch the test running in Emulator :) 

### How to configure Selenium grid with IOS Simulator as a Node using Appium
![Selenium_Grid](https://github.com/priya006/Selenium-Grid/blob/master/Selenium_Grid_Server_Client.png)

1. Start the Selenium Stand alone server in a `Machine A`. This machine act as a hub. Command `java -jar selenium-server-standalone-3.141.59.jar -role hub`
2.  Create a Configuration json file. Example: `IOS_Emulator_Node.json`
3. Start the Simulator and Run the command `instruments -s devices` to make sure to see simulators attached to the laptop
4. No need to Install SafariDriver if the Safari Browser version is 10 and above.
5. Start  the Appium Sever with Simulator node attached. Example: `appium  -p 5777  --nodeconfig  IOS_Emulator_Node.json`
6. Run the test and watch the test running in Simulator :) 

### Parallel Execution

## Troubleshooting Tips
1. If there is issue while registering the node to the hub. Start the Selinium server/hub and navigate to http://localhost:4444/wd/hub from teh browser to see the full stack trace
2. It is important to set JAVA_HOME. [Guide to set Java home](https://medium.com/@spmadhi/easy-steps-to-install-and-set-java-home-in-mac-machine-c84b7bbc94e6)
3. It is important to understand **Chromedriver/Chrome compatibility**. List of Chromedriver versions and their matching minimum Chrome versions could be found [here](https://raw.githubusercontent.com/appium/appium-chromedriver/master/config/mapping.json)
4. After connecting the Real Android device to laptop using wire. Run the command `adb devices` to check if the device  is listed
5. Turn on `USB debugging` in Real device. System > Developer options > Debugging >  USB debugging

## Tips
1. How to find the version of browser. Type https://www.whatismybrowser.com/
   This could be helpful to find the version of browser you are using from Ipad
2. Run the command `instruments -s devices` to get the list of IOS devices associated to your laptop
3. IOS Real Device or Simulator turn on the  `Allow Remote Automation`option. Navigate to `settings > safari > advanced`
4. Run the command `appium-doctor` and make sure you see green tick for all the checks. 
 

**References**
----------------
1. [appium-chromedriver](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md)
2. [Download ChromeDriver](https://chromedriver.chromium.org/downloads)

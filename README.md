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

###Installation
1. `npm install -g appium` if you already have `npm` and `node js`
   Install `npm install -g appium-doctor ` and run the command `appium-doctor`
   
### How to configure Selenium grid with Android real Device as a Node using Appium
1. Start the Selenium Stand alone server in a Machine A. This machine act as a hub. Command `java -jar selenium-server-standalone-3.141.59.jar -role hub`
2. Create a Configuration json file
#### Selenium Grid Node Configuration Json File
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
3. In the Node machine (Say: Machine B)run the command ` appium -p 4725 --nodeconfig  <pathwheretheconfigurationjsonis>
`



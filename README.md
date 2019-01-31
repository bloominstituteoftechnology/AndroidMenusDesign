# Android Menus Design

For this app, you'll design an app and then implement the navigation drawer and action bar menu for that app.

## Requirements

This project will be all about polish. I know you know how to replace fragments, change activities or whatever else you'd want to do with a menu item. So I want you to instead spend time making these menus look awesome. Look as some of your favorite apps and see how they utilize these menus and then design your own app to use them.
The following pieces are required, I recommend you build them in order.

### App Design
You'll need to write up a simple design for your app with structure example:

>High Level Description:  
>The Light Controller app will allow users to create custom light settings and store them persistently. It will also allow them to select from a list of previously used settings. Finally the user will be able to configure multiple light controllers and select between them in the settings selection page.  
>
>Individual Activities:
>- Light Selecting (which also allows users to select the controller)
>	- Select from a list of previous light configurations
>	- Shows number of times each configuration has been used
>- Light Configuration
>	- Create or Edit light configurations
>- Controller Configuration
>	- Create or Edit controller configurations
>
>Navigation Drawer:  
>Main Menu: Allow user to select which activity or fragment to view.  
>Secondary Menu: Allow user to toggle night mode for the app  
>Header: Show the user the name of the controller which is selected, show them the name of the active pattern, and have the background color be the base color of the configuration.  
>
>Action Bar Menu:
>- As action, turn off lights
>- As Action, add new light configuration or controller depending on active fragment
>- Toggle display count visibility
>- Allow user to select sort mode on light configurations on page


This writeup will be included at the bottom of this README file. As your next project week will be implementing a project of your design. This can be a starting point for it.

### Menu Implementation
Once you have your app design writeup put together, we'll have you implement a menu system which will simulate the implementation of this flow.
When each item is selected, show a `Toast` telling use what would happen.
> Toasts can be made with the following code `Toast.makeText(context, "My message", Toast.LENGTH_SHORT).show();`

If an item is selected that would replace the current UI fragment or activity, indicate this in the text view that is included in your empty activity layout

## Go Further

There are a few additional features which you can include in order to improve your app

* Polish, polish, polish. Take this time to make your menus and app look awesome. Once the menus are done, build a custom theme and app icons for it as well.
* Start implementing some of the features from your design. First step, instead of just changing the text, build multiple stock fragments and swap them out with the menu selection. Once that is done, you can start adding implementation to those fragments.


# App Description

### Overview
   The app will monitor noise levels of the environment and act on if noise levels get above a threshold.  Target audience would be for parents to easily enforce a time-out for kids based on noise levels and promote quiet time.

### Individual Activities
 * Main Activity

    >Initial screen would allow user to select a premade configuration (either a stock on or one created by user earlier) or create a new configuration.

* NoiseMonitor activity

    >Selection of an existing configuration would open a NoiseMonitor activity.  App would    listen to the noise levels of the environment and provide visiual and possible audible feedback depending on configuration.  A countdown timer may also be displayed if configuration was set up to use that.

*   NoiseMonitorConfig activity

    >Selecting a new configuration would open this activity.  Selecting an existing one via long=press would open the same activity with the configuration pre-populated.  User would be able to set whether a countdown timer would be used.  If used, the length of time would be able to be set as well as options for notification when time is up.  Another option would allow timer to automatically reset when noise levels get too high.

*   Settings activity

    >This activity would allow user set/change global settings.  One setting would be whether phone is pinned to that app and locked to that activity on start of NoiseMonitor Activity.  Notification settings like selection of sound when timer is complete or noise has exceeded tht threshold would be set. Stretch goal would be to add notification to another device either via text/email/messaging app, or through another instance of the app running on the 2nd device.
    
### Navigation Drawer

*   Main Menu: Allow user to select whether app is locked a NoiseMonitor Activity.  Settings for it would be in the Setting activity.  Allow user to enter settings activity.  Allow user to select a night mode.
*   Secondary Menu:  Allow user to select a night mode.
*   Header: Display an icon, name of selected configuration.  Use one of the colors in the color resource file as the background.

#### Action Bar Menu

*   As action, add new configuration depending on which activity is in view.
*   Option to view a log of activity.
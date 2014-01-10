sensorsub-droid
===============

android app to control SensorSub.  Extreme Alpha.


Build Instructions:

On Mac:
```
$ cd Documents/workspace
$ git clone https://github.com/bertobot/sensorsub-droid
$ open Eclipse.app
```

On Linux:
```
$ cd workspace
$ git clone https://github.com/bertobot/sensorsub-droid
$ eclipse
```

1. In Eclipse + ADT plugin, start (yes, start) a new Java project.  For the Application Name, fill in "sensorsub-droid".  You'll notice the tooltips will change, alerting you that a project already exists.
2. Run the project (either by the run drop down or the run button), as an Android Application.  Use either your Android device or an Android virtual device.
3. That's it!

Enter the hostname or ip address of the submarine and click "Connect".  Once you've done so, you'll be presented with a new activity, which will feed the submarine move directives based on where on the device you've touched.

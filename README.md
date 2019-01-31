# Chrome 72 Bug

Example app that demonstrate a possible bug in Chrome 72 WebView on Android. Clone the repo, load in to Android Studio, build and push to a device.

## Background
We received a report from one of our users today saying that a certain part of our app that relies on a WebView stopped working. We tracked it down to being a difference between Chrome 71 and Chrome 72 installed on the device.

When debugging what the WebView was doing we noticed that, whilst we were passing it a correct looking HTML string, the WebView did not render anything. We looked at the Elements tab in the remote Chrome Dev Tools and noticed the document was heavily truncated. So we could understand why the rendering wasn't working..... the document as it it was trying to render was broken.

Upon closer inspection it appeared to break before the first use of the # character in the inline CSS. So our assumption is that something between Chrome 71 and Chrome 72 broke handling of this use of CSS.

As far as I am aware what we are trying to render in the WebView is a valid, albeit poor, use of HTML / CSS and it should work as before.

1.  Build and load the example project onto an Android device. 
2. Ensure that you have Chrome 71 (I used 71.0.3578.99) installed as the stable version of Chrome. 
3. Ensure that you have Chrome 72 (72.0.3626.73) installed as the beta version of Chrome. 
4. Select the stable version (Chrome 71) from the Developer Options -> WebView Implementation. 
5. Run the Chrome72Bug example app. 
6. Select the FAB button to load an example HTML into the WebView. 
7. Switch to the beta version (Chrome 72) from the Developer Options -> WebView Implemenation. 
8. Run the Chrome72Bug example app. 
9. Select the FAB button to load an example HTML into the WebView. 

### Expected result
After step (6) and (9) the example HTML will be rendered in the WebView.

### Actual result
After step (9) the example HTML does not render.

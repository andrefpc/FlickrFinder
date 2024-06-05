![flickr_logo](https://github.com/andrefpc/FlickrFinder/assets/4115436/98ac9375-4780-4ccd-80c6-d65d7aeb8288)

![](https://img.shields.io/badge/version-v1.0.0-blue)  ![](https://img.shields.io/badge/platform-android-red)

## Welcome
Flickr Finder is an app to search for posts on Flickr. 
The app was created for an assessment process.

## Setup

The app supports Light and Dark mode.

### Software Setup
-  [Android Studio (Jellyfish)](https://developer.android.com/studio?gclid=Cj0KCQiAjKqABhDLARIsABbJrGnu24-EGDCgj0GwU72bgw2QqhSlGUDbodJeBTlnr-_CGEPDQrZJZOcaArQ9EALw_wcB&gclsrc=aw.ds "Android Studio")

### API Reference

- [Flickr Api](https://www.flickr.com/services/feeds/docs/photos_public/ "Flickr Api")
  - GET [https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags=porcupine](https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags=porcupine)

### Language

- Kotlin

### Architecture

- MVVM (Model View ViewModel)

### Dependency Injection

- [Koin](https://insert-koin.io/ "Koin")

### Multithreading

- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAjw7rWKBhAtEiwAJ3CWLKmcgJFMZLK1QyQwWwfd5_Oy7Da_YNByntiMwhAcQxbpwAbj9fqIORoCIWEQAvD_BwE&gclsrc=aw.ds "Coroutine")
- [LiveDatas](https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br "LiveDatas")  

### HTTP Client

- [Retrofit](https://square.github.io/retrofit/ "Retrofit")


### Testing Tools

- [Espresso](https://developer.android.com/training/testing/espresso "Espresso")
- JUnit
- Mockito

### Other Tools

- [Glide](http://bumptech.github.io/glide/ "Glide") - load remote images.
- [Gson](https://github.com/google/gson "Gson") - JSON serialization.
- [Material Design](https://material.io/develop/android/docs/getting-started "Material Design") - UI tools.

## Packages Structure
- 📔 **api** (Store the retrofit interfaces for do HTTP requests )
- 📔 **data** (Store the data objects )
- 📔 **di** (Store the dependecy injection setup files )
- 📔 **extensions** (Store the app extensions )
- 📔 **repository** (Store the repositories to call the api interfaces )
- 📔 **ui** (Store the UI files, like Activities, Fragments, Adapters and the ViewModels )
- 📔 **util** (Store the util classes )

## Assessment Requirements
- [x] The search results should come from the API listed above (replacing the word “porcupine” with the one typed by the user).
- [x] The search results should be updated after each keystroke or change to the search string.
- [x] When performing the search, show a progress indicator without blocking the UI.
- [x] Tapping on an image should display an image detail view that contains the following details:
    - [x] The image
    - [x] Text element that displays the title
    - [x] Text element that displays the description
    - [x] Text element that displays the author
    - [x] Text element that displays a formatted version of the published date
- [x] Add at least one unit test that covers some portion of your code.

## Extras
Extra:
- [ ] Accessibility support such as
    - [ ] Large font support
    - [x] Talkback support
- [x] Additional unit tests
- [ ] UI tests
- [x] Support landscape orientation
- [x] Add a button in the detail view to share the image and metadata
- [ ] Animate the image transition from the grid view to the detail view
- [x] Add a text element that displays the width and height of the image to the detail page 

## Unit Tests
<img width="1662" alt="Screenshot 2024-06-05 at 18 56 25" src="https://github.com/andrefpc/FlickrFinder/assets/4115436/593dd412-105e-4116-b86b-0ae1de9ca6ba">

## Screen records

https://github.com/andrefpc/FlickrFinder/assets/4115436/54cecd7f-a8ad-4ff1-8991-29eab6f2d0be

https://github.com/andrefpc/FlickrFinder/assets/4115436/a0db3d49-3322-4483-936d-2bc79e32aba2



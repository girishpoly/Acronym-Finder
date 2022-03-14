# Acronym Finder : Android MVVM App Architecture for Albertsons coding challenge using Architectural Components

# Highlights

1. MVVM Architectural pattern
2. Used Data Binding to show data on the UI
3. Unit test demonstration using JUnit and Mockito
4. UI unit test demonstration using Espresso

The application has been designed using **Android Architecture components**. The application is built in such a way that whenever there 
is a service call to get the fullform of an Acronym, the result will be displayed in a recycler view.

The whole application is built based on the MVVM architectural pattern.

# Application Architecture

The main advantage of using MVVM, there is no two way dependency between ViewModel and Model unlike MVP. Here the view can observe the data changes in the viewmodel 
as we are using LiveData which is lifecycle aware. 

# Programming Practices Followed
a) Android Architectural Components <br/>
b) Dagger 2 for Dependency Injection <br/>
c) MVVM <br/>
d) Retrofit with Okhttp <br/>
e) Data Binding <br/>
f) JUnit and Mockito for Unit testing <br/>
g) Repository pattern <br/>

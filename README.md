
# RJGames | Jetpack Compose & Rawg.io API

RJGames is a sample Android app that shows how to use Jetpack Compose and Rawg.io API to build a gaming app. With RJGames, you can browse top-rated titles, search for your favorite games, and see details about each game.

The purpose of this repository is to serve as a guide for beginners.

![Cover Image](https://user-images.githubusercontent.com/50443794/224314547-44c6663d-349b-4679-b006-293c87978c4e.png)

## Contents

* [Preview](https://github.com/kerimbr/RJGames-Jetpack-Compose-Rawg.io-API#preview-view)
* [Setup](https://github.com/kerimbr/RJGames-Jetpack-Compose-Rawg.io-API#run-it)
* [Project Folder Structure](https://github.com/kerimbr/RJGames-Jetpack-Compose-Rawg.io-API#project-structure)
* [Project Architecture](https://github.com/kerimbr/RJGames-Jetpack-Compose-Rawg.io-API#project-architecture)
* [Dependencies](RJGames-Jetpack-Compose-Rawg.io-API#dependencies)


## Preview (Video)

https://user-images.githubusercontent.com/50443794/224317126-9fe7b055-d1e9-40f4-8343-45cc85fc533e.mp4
## Run It

* Clone the repository
* Create a file named ```gradle.properties``` in the root folder
* Define constant variable named ```API_Key``` 
* Get an API key from ```https://rawg.io/```

#### gradle.properties

```
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
android.useAndroidX=true
kotlin.code.style=official
android.nonTransitiveRClass=true

API_KEY=YOUR_API_KEY
```
## Project Structure
Project Folder Structure | Description
:-------------------------------------:|:-------------------------------------:
![image](https://user-images.githubusercontent.com/50443794/224317943-ff368703-0a74-4457-b96e-0839c2b54f5c.png) | The folder structure of the project is as shown on the left. The Clean Architecture approach has been used. Below are the explanations and details of the folders.

* core
* data
* di
* domain
* presentation


## Project Architecture

In this project, a modular architecture is designed using Clean Architecture and MVVM approaches to make the development and maintenance of the application easier. Clean Architecture ensures that each layer of the application is independent of each other and responsible for a specific task

![Project Architecture](https://user-images.githubusercontent.com/50443794/224318396-879f80c2-570f-4379-906a-8357c71da7b7.png)

## Dependencies


* Jetpack Compose 💙💚
* Material 3 💖
* Material Icons
* Navigation
* Retrofit
* GSON
* OkHttp
* Lifecycle[ViewModel] (for Jetpack Compose)
* Glide (landscapist)
* Hilt
* Paging 3
* Lottie
* Room

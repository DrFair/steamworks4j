This guide will explain in extremely specific steps how to build the natives on the different platforms.

You can find the official build instructions here:
http://code-disaster.github.io/steamworks4j/build-instructions.html

__All platforms pre-build steps:__
1. Make sure you have the Steam SDK downloaded and extracted into the project root folder.  
   You can download it from Steam here: https://partner.steamgames.com/doc/sdk
   When writing this, the target SDK version was 1.55.
   The file structure has to be like this:
   `<Project root>/sdk/public...`
   `<Project root>/sdk/redistributable_bin...`
2. Make sure you have a clean project. Run the clean tasks for the different maven projects.
3. Run JNICodeGenerator from the project root directory.  
   This will generate C++ source files at `steamworks4j/java-wrapper/src/main/native/` and `steamworks4j/server/src/main/native/`.

Now everything is set up and ready to build.  
Remember you have to do the above steps on all the platforms before going to the below steps.

__Windows:__
1. Visual Studio 2022 command line environment is required. If you do not have Visual Studio 2022 installed, do so now. I selected just Desktop environment tools module.
2. Download premake5.exe and place it inside the build-natives folder.
   This can be downloaded from https://premake.github.io/download/
3. Launch the Visual Studio 2022 command line environment:
    1. Click on the windows start menu.
    2. Click all apps to show all the apps on your system.
    3. Scroll down to Visual Studio 2022 folder. Open it and launch Developer Command Prompt for VS 2022.
4. Navigate to the project build-natives folder.
5. Run `build-win.bat vs2022`.
6. Make sure there were no errors. If there were, it means something went wrong. Most commonly, this is a syntax error or that you didn't follow the pre build steps.
7. Commit and push the new windows natives, so that you can later package the library for all platforms.
8. You're done! Head to the next platform.

__Linux:__
1. A fairly recent version of GCC is required. One that support C++11.  
   If you do not have it installed yet, you can usually do so from the terminal with the command:  
   `sudo apt-get install gcc`
2. Make sure premake4 is installed. You can do usually do so from the terminal with the command:  
   `sudo apt-get install premake4`
3. Open a terminal and navigate to the build-natives folder.
4. Run `./build-linux.sh`.
5. Make sure there were no errors. If there were, it means something went wrong. Check the pre-build steps again, and the required linux installs above.
6. Commit and push the new linux natives, so that you can later package the library for all platforms.
7. You're done!

__Mac OS:__
1. Make sure you have XCode installed. You can do so from the app store.
2. Download premake5 and place it inside the build-natives folder.
   This can be downloaded from https://premake.github.io/download/
3. Open a terminal and navigate to the build-natives folder.
4. Run `./build-osx.sh`. This must be done from an Apple silicon Mac in the new versions.
5. Make sure there were no errors. If there were, it means something went wrong. Check the pre-build steps again, the the required mac installs above.
6. Commit and push the new mac natives, so that you can later package the library for all platforms.
7. You're done!

__Finally:__
1. Make sure you have committed and pushed all the platform specific natives, and pulled on the last platform you intend to package on.
2. Run the Steam API Java Wrapper install maven task.
3. Find the final library jars in `java-wrapper/target/`. They will be called `steamworks4j-<version>.jar` and the javadocs and sources.
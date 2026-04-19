# Clinical Architect Demo

This is a React Native (Expo) project demonstrating the Clinical Architect frontend. It includes native Android files generated via Expo Prebuild.

## Prerequisites & Running Android Studio

**IMPORTANT:** Before opening the `android` folder in Android Studio, you **must** install the Node dependencies. The Android build scripts (Gradle) rely on executing `node` to locate the React Native and Expo plugins inside `node_modules`.

If you try to sync Gradle before installing dependencies, you will receive an error like: `Process 'command 'node'' finished with non-zero exit value 1`.

### Setup Instructions:

1. Clone the repository.
2. Open a terminal in the root directory (`app-demo`).
3. Run `npm install` to download all dependencies.
4. Open Android Studio.
5. Select "Open" and navigate to `app-demo/android`.
6. Allow Gradle to sync and build the project.

## Running the Web/Local Demo

If you just want to run the React Native local development server (which supports web, iOS, and Android emulators):

```bash
npm install
npm run start
# or for web specifically
npm run web
```
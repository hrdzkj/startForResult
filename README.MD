# startForResult

This library launch an activity for which you would like a result when it finished more easily .
When this activity exits, your IStartForResult.ICallback interface will be called
with the given resultCode.

if you call startActivityForResult(),then you can use com.hrdzkj.startForResult too

## Installation

add the following remote maven url to your root `build.gradle` file:
```groovy
allprojects {
    repositories {
     ......
     maven {url 'https://dl.bintray.com/gxjfict/AndroidMaven/'}
    }
}
```
add the following dependency to your app module `build.gradle`  file:
```groovy
dependencies {
    implementation 'com.hrdzkj:startForResult:0.1'
}
```
## Usage

### Basic

To begin using this Optional, it's like using java.util.Optional:


```java
        Intent intent = new Intent(MainActivity.this,ToActivity.class);
        StartForResultUtil.getInstance(MainActivity.this)
                .startForResultWithCallback(new Intent(MainActivity.this,ToActivity.class), (resultCode, data) -> {
            Log.v(TAG,"---------->StartForResultresultCode="+resultCode);
        });

```

## LICENSE
```

    Copyright 2018 hrdzkj

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

```

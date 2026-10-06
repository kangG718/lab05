# 실습 5: 사칙연산 TDD와 안드로이드 앱

이 저장소에는 과제의 두 실습을 함께 담았습니다. Python 테스트와 안드로이드 앱은 같은 사칙연산 규칙을 사용하지만, Python 테스트가 앱을 직접 실행하거나 검사하지는 않습니다.

## 1. Python TDD

`tdd/test_FourBasicOpt.py`를 먼저 작성해 실패를 확인한 다음, `tdd/FourBasicOpt.py`를 구현했습니다.

```bash
cd tdd
python3 -m unittest -v test_FourBasicOpt.py
```

8개 테스트가 통과합니다. 0으로 나누기는 교재의 `0` 반환 예시 대신 Python의 실제 연산 규칙에 따라 `ZeroDivisionError`를 검사합니다. 콘솔 실행 결과는 `evidence/tdd_console_output.txt`에도 기록했습니다.

## 2. 안드로이드 앱

`android_app/`은 Java와 XML로 작성한 간단한 사칙연산 앱입니다. 숫자 두 개를 입력하고 연산자를 선택한 뒤 **계산하기**를 누르면 결과를 표시합니다. 빈 입력과 잘못된 숫자에는 안내 문구를, 0으로 나누기에는 오류 문구를 표시합니다.

Android Studio에서 `android_app/`을 프로젝트로 열거나, 아래 명령으로 APK를 빌드할 수 있습니다.

```bash
cd android_app
./gradlew :app:assembleDebug
```

빌드 결과: `android_app/app/build/outputs/apk/debug/app-debug.apk`

SDK 설정은 `compileSdk 37`, `minSdk 23`, `targetSdk 33`입니다. M2 Mac의 Android Studio Rabbit 1에서 빌드를 확인했습니다. 삼성 SM-G885S(Android 10) 실기기에 APK를 설치해 `100 + 10 = 110`, `100 - 10 = 90`, `100 ÷ 10 = 10`, `100 × 10 = 1000`, `100 ÷ 0` 오류 안내를 확인했습니다.

## 실행 증빙

- `evidence/android_app_division.png`: 실기기에서 `100 ÷ 10 = 10` 화면 캡처
- `evidence/android_app_divide_by_zero.png`: 실기기에서 0으로 나누기 안내 화면 캡처
- `evidence/tdd_console.png`: Mac 터미널에서 실행한 Python 테스트 최종 콘솔 캡처
- `evidence/tdd_console_output.txt`: Python 테스트의 실제 콘솔 출력 기록

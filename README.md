# Mobile Automation — Simple Apps

Automation testing aplikasi Android **Simple Apps** (Flutter) menggunakan
Katalon Studio + Appium.

## Prasyarat

| Tool | Versi |
| --- | --- |
| Katalon Studio | 11.x |
| Appium | 3.6.0 |
| Appium driver UiAutomator2 | 7.x |
| Node.js | 20.19+ |
| Java (untuk backend) | 21 |
| Android Emulator | AVD Android Studio |

## Setup

1. Clone repo ini:
```bash
   git clone https://github.com/<username>/mobile-automation.git
```
2. Salin `app-release.apk` ke folder `apk/`
   (APK tidak disimpan di repo karena ukurannya besar).
3. Jalankan backend Simple Apps:
```bash
   java -jar simple-apps-backend-0.0.1-SNAPSHOT.jar
```
   Lalu selesaikan gerbang Lisensi → .env → Cloudinary di http://localhost:8080
4. Nyalakan emulator dan install APK:
```bash
   adb install -r apk/app-release.apk
```
5. Di aplikasi, isi Pengaturan Koneksi:
   Host `10.0.2.2`, Port `8080`.
6. Di Katalon: Preferences → Katalon → Mobile → Appium Directory
   diarahkan ke folder instalasi Appium.

## Menjalankan test

Buka project di Katalon Studio 11 → pilih Test Case / Test Suite →
Run → Android → pilih emulator.

## Struktur folder

| Folder | Isi |
| --- | --- |
| `Test Cases/` | Skenario test |
| `Object Repository/` | Locator elemen aplikasi |
| `Keywords/` | Custom keywords |
| `Test Suites/` | Kumpulan test case yang dijalankan bersama |
| `Profiles/` | Variabel environment (host, akun, dll) |
| `apk/` | Tempat APK (tidak di-commit) |

## Catatan

- Data aplikasi hilang setiap backend di-restart (H2 in-memory),
  jadi setiap test harus menyiapkan datanya sendiri.
- Captcha di mode TESTING dibaca dari atribut `content-desc`
  elemen `captcha_value_hint`.
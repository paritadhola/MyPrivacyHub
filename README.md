# 📱 MyPrivacy Hub

**MyPrivacy Hub** is a personal privacy management Android app built with Jetpack Compose, Room, and DataStore. It allows users to securely manage their data, control telemetry and location consents, and export their profile and settings to a JSON file.

---

## 🚀 Features

- 🔐 **Biometric Login** – Secure login using fingerprint authentication  
- 🧾 **User Profile** – Save and update your name and email  
- ✅ **Consent Controls** – Toggle location and analytics data sharing preferences  
- 💾 **Local Data Persistence** – Store user profile with Room and consent preferences with DataStore  
- 📤 **Export to JSON** – Export profile and preferences to local storage as a `.json` backup  
- (Upcoming) 📥 **Import from JSON** – Restore preferences from a previously saved backup  
- (Upcoming) 🔗 **Share Backup** – Send backup via email, cloud, etc.

---

## 🛠 Built With

| Tech                | Purpose                          |
|---------------------|----------------------------------|
| **Jetpack Compose** | UI Layer                         |
| **Room DB**         | Local profile storage            |
| **DataStore**       | Consent preference storage       |
| **Biometric API**   | Fingerprint login                |
| **Gson**            | Export data as JSON              |
| **Kotlin Coroutines** | Asynchronous operations       |


## 🧪 How to Run

1. Clone this repository  
2. Open in **Android Studio (Arctic Fox or later)**  
3. Connect an Android device or emulator  
4. Run the app  
5. Enroll at least 1 fingerprint for biometric login

---

## 📤 Export Format

The app exports the following structure as `my_privacy_backup.json`:

```json
{
  "name": "Abc Xyz",
  "email": "john@example.com",
  "consent_location": true,
  "consent_analytics": false
}
```

---

## 🔐 Security Notes

- Data is stored **locally only**
- Biometric login ensures authorized access
- Exported JSON can be optionally encrypted or shared

---

## 📌 Future Improvements

- Add **import from JSON**
- Enable **backup sharing**
- Add **encrypted export**
- Support multiple users (optional)

---

## 👩‍💻 Author

Parita Shamjibhai Dhola  
[LinkedIn](#) | [Portfolio](#)


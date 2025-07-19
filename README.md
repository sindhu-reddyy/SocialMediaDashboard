# SocialMediaDashboard
A JavaFX-based social media dashboard
# 📱 JavaFX Social Media Dashboard

A stylish, modular JavaFX-based Social Media Dashboard featuring login/signup authentication, a sidebar-based navigation system, responsive UI, and animated content transitions. Built for educational/demo purposes with extendable architecture.

---

## 🚀 Features

- 🔐 **Login & Signup UI** with password hashing (SHA-256)
- 🎨 **Responsive UI** with CSS styling
- 📁 Modular components:
  - `HeaderBar` with dynamic title and logout
  - `Sidebar` with active tab highlight
  - `ContentArea` for dynamic page switching
- 👤 **Profile Page** with editable user info
- 💬 **Messages Page** with sample layout
- ⚙️ **Settings Page**
- 📊 **Analytics Page** with animated charts (e.g., Pie/Line Chart)
- 🔁 Smooth fade animations between page transitions
- 🗄️ **SQLite Database Integration** for login/signup
- 👁️ Show/Hide Password toggle

---

## 🛠️ Technologies Used

- Java 17+
- JavaFX
- SQLite (via `sqlite-jdbc` driver)
- CSS (for UI styling)
- Scene Builder (optional, for FXML design)

---

## 📸 Screenshots

> Add screenshots of your UI here once hosted (optional)

---

## 🗂️ Project Structure

SocialMediaDashboard/
├── Main.java
├── LoginPage.java
├── SignupPage.java
├── Sidebar.java
├── HeaderBar.java
├── ContentArea.java
├── ProfilePage.java
├── MessagesPage.java
├── AnalyticsPage.java
├── SettingsPage.java
├── DBUtil.java
├── user.db (SQLite DB)
├── style.css

## 📦 Setup & Run

### 🔧 Prerequisites

- JDK 17+ installed
- JavaFX SDK installed
- SQLite JDBC driver (`sqlite-jdbc-3.50.2.0.jar`) added to classpath

### ▶️ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/sindhu-reddyy/SocialMediaDashboard.git
   cd SocialMediaDashboard
Compile and run using terminal or your favorite IDE (e.g., IntelliJ IDEA, Eclipse)

🔐 Login Credentials (Demo)
Username: testuser

Password: test123

(or register your own via Signup page)

🧠 Author
Sindhu Gutha
📧 sindhugutha2006@gmail.com
📍 B.Tech CSE (AI & ML), 2nd Year
📅 July 2025 

📜 License
This project is intended for academic/demo purposes. Modify and use freely.

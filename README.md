# 🎵 MediaLibrary

A simple **Java-based media library** where users can manage **songs, movies, and books**.  
This project demonstrates **object-oriented programming (OOP)** concepts such as encapsulation, constructors, getters/setters, and method overriding, while also performing calculations like **average ratings** and **total song costs**.

---

## 🚀 Features

### **Song Management**
- Add songs with title, rating, price, and favorite status
- View song details using a custom `toString()` format
- Calculate total cost, total ratings, and average values

### **Movie Management**
- Store movies with title, rating, and duration
- Convert duration from minutes to hours & minutes
- Display movie details neatly formatted

### **Book Management**
- Add books with title and rating
- Simple display using `toString()`

### **Statistics**
- Shows **number of songs**, **total cost**, **average cost**, and **average rating**

---

## 🛠️ Tech Stack

- **Language**: Java (JDK 17+ recommended)
- **IDE**: [Visual Studio Code](https://code.visualstudio.com/)
- **Version Control**: Git & GitHub

---

## 📂 Project Structure

MediaLibrary/

├── src/

│ ├── Song.java # Song class

│ ├── Movie.java # Movie class

│ ├── Book.java # Book class

│ └── MediaLib.java # Main program

├── .gitignore # Ignored files and folders

└── README.md # Project documentation

---

## ⚡ Getting Started

### **1. Clone the repository**
```bash
git clone https://github.com/<your-username>/MediaLibrary.git
cd MediaLibrary
```

### **2. Compile the project**
```bash
javac -d out src/*.java
```

### **3. Run the Program**
```bash
java -cp out MediaLib
```

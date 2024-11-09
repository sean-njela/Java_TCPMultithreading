# 🌐 TCP Multithreaded Server and Client

Welcome to the **TCP Multithreaded Server and Client** application 🚀 — a Java-based implementation of a TCP client-server model using multithreading. The server can handle multiple clients concurrently, and the client can send messages to the server for an echo-like response. 🖥️

## 📝 Features

- 🖥️ **Multithreaded TCP Server**: The server can accept multiple client connections and process them simultaneously using threads.
- 💬 **Echo Functionality**: The server echoes the received messages back to the client, enclosed in `<strong>` tags.
- 🚀 **Client Communication**: The client sends messages to the server and displays the server’s response.
- 🔄 **Concurrency**: Each client connection is handled in a separate thread, allowing multiple clients to interact with the server simultaneously.

---

## 🚀 Getting Started

### 1️⃣ **Prerequisites**

Ensure you have the following installed:

- ☕ **Java JDK** (Java Development Kit) — Version 8 or above.

### 2️⃣ **Installation**

Clone the repository and navigate to the folder:

```bash
git clone https://github.com/sean-njela/tcp_multithreading.git
cd tcp_multithreading
```

### 3️⃣ **Usage**

#### Start the TCP Server

To start the server, simply run the following command:

```bash
java TCPMultithreading
```

#### Start the TCP Client

After starting the server, run the client by executing:

```bash
java TCPClient
```

---

## 📂 How It Works

1. **TCP Server** (`TCPMultithreading`):

   - The server listens on port `7777` for incoming connections.
   - When a client connects, it spawns a new thread (`ServerThread`) to handle the communication with that client.
   - Each thread listens for client messages and sends the received message back, wrapped in `<strong>` tags.
   - This process is repeated for each new client that connects.

2. **TCP Client** (`TCPClient`):
   - The client connects to the server running on `localhost` at port `7777`.
   - It sends messages to the server and receives the server's response.
   - Communication continues until the user types "END".

### Example Output

**Server:**

```bash
$ java TCPMultithreading
The server is up!
New client connected 192.168.1.100
The Server Thread No. 12 for the client 5001 has started!
```

**Client:**

```bash
$ java TCPClient
Client with the socket 5001 has started!
Hello Server
Produced content: <strong>Hello Server</strong>
How are you?
Produced content: <strong>How are you?</strong>
END
```

---

## ⚠️ Error Handling

- 🛑 **IOExceptions**: Any issues during socket communication will result in an exception being printed in the logs.
- ⚠️ **Thread Interruption**: If the thread is interrupted (for example, if the client disconnects abruptly), an error will be logged.

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## ❤️ Contributions

Feel free to submit pull requests or raise issues. Contributions are always welcome!

---

## 👤 Author

**TNjela**

- GitHub: [@seannjela](https://github.com/sean-njela/tcp_multithreading.git)
- Project Link: [@Project_link](https://roadmap.sh/projects/tcp-server-client)

---

## 🎉 Acknowledgements

Feel free to contribute with enhancements and additional features!

Happy Coding! 🎉

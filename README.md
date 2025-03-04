# JavaImageServerClient

## Overview
This project implements a **client-server architecture** in Java, enabling a client application to request the rendering of various geometric shapes (**circles, rectangles, squares, polygons, and lines**) with customizable attributes, including **color, size, position, and rotation**. The server processes these requests, generates the corresponding images, and transmits them back to the client.

This system is designed for **graphical computing, shape manipulation, and network-based rendering**, utilizing **multi-threading** to accommodate concurrent client connections. Additionally, the client-side application features a **graphical user interface (GUI)** to facilitate user interaction and shape customization.

## Features
- **Supports multiple geometric primitives:** Circles, rectangles, squares, polygons, and lines.
- **Customizable attributes:** Users can define color, dimensions, position, and rotation.
- **Maintains aspect ratio:** Ensures proportional scaling of images.
- **Multi-threaded server architecture:** Allows concurrent request handling without performance degradation.
- **Scalable design:** Supports future enhancements and additional features.
- **Interactive GUI client:** Enables users to configure and request shape renderings easily.
- **Centralized server-side processing:** Offloads rendering logic to a dedicated server component.

## Technologies Used
- **Java** (Swing for GUI development, ServerSocket for network communication, Graphics2D for rendering)
- **BufferedImage & ImageIO** for image processing and transmission
- **Multi-threading** for concurrent client handling
- **IntelliJ IDEA** as the development environment
- **TCP/IP Networking** for client-server interaction

## Installation & Setup
### 1. Clone the Repository
```sh
git clone https://github.com/your-repo/shape-drawing-server.git
cd shape-drawing-server
```

### 2. Open the Project in IntelliJ IDEA
1. Launch **IntelliJ IDEA**.
2. Select **File > Open...** and choose the project directory.
3. If prompted, configure the **Java SDK** and dependencies.
4. Set up **Run/Debug Configurations** for `ShapeServer` and `ShapeClient`.

### 3. Compile the Server and Client
```sh
javac ShapeServer.java
javac ShapeClient.java
```

### 4. Run the Server
```sh
java ShapeServer
```
The server listens on **port 5000** and awaits client connections.

### 5. Run the Client
```sh
java ShapeClient
```
The GUI interface enables users to select shapes, modify attributes, and transmit requests to the server.

## Usage Instructions
1. **Start the server** before launching any clients.
2. **Run the client application** to initiate interaction.
3. **Select a geometric shape** from the available options.
4. **Customize shape attributes** (color, size, position, rotation).
5. **Send the request** to the server.
6. The **server processes** the request and returns the generated image.
7. The **client displays** the received image while maintaining its aspect ratio.
8. **Repeat the process** to render additional shapes.

## Example Requests
### Circle
```
circle,100,100,#FF0000,50,0
```
Renders a **red circle** centered at `(100,100)`, with a radius of `50`.

### Rotated Rectangle
```
rectangle,50,50,#00FF00,80,40,45
```
Renders a **green rectangle** at `(50,50)`, with dimensions `80x40`, rotated `45°`.

### Line
```
line,20,30,200,250,#0000FF
```
Draws a **blue line** from `(20,30)` to `(200,250)`.

### Polygon
```
polygon,150,150,#FF00FF,5,60,30
```
Renders a **magenta pentagon** centered at `(150,150)`, with `5` sides, a `60`-pixel radius, and rotated `30°`.

## Future Enhancements
- **Dashed line support** for enhanced visual effects.
- **Gradient fill support** for more dynamic rendering.
- **Batch shape rendering** within a single request.
- **Zoom and pan functionality** in the GUI for improved visualization.
- **Enhanced logging mechanisms** for request tracking and debugging.
- **Image export functionality** for saving rendered outputs.
- **Custom stroke patterns** for advanced artistic effects.

## License
This project is distributed under the **MIT License**, allowing modification and redistribution with proper attribution.

## Author
- **lekiet1214**
- 📧 [sisu1214@gmail.com](mailto:sisu1214@gmail.com)
- 🌐 [GitHub Profile](https://github.com/lekiet1214)

Contributions are welcome! Feel free to enhance this project. 🚀


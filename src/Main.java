import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     OutputStream out = socket.getOutputStream()) {

                    // Read shape details from client
                    String request = in.readLine();
                    System.out.println("Received: " + request);

                    // Parse request (Format: "shapeType,x,y,color,sides/size,radius/width,height")
                    String[] parts = request.split(",");
                    String shapeType = parts[0];
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    Color color = Color.decode(parts[3]); // Color in hex format (e.g., #FF0000)

                    BufferedImage image;

                    if ("polygon".equalsIgnoreCase(shapeType)) {
                        int sides = Integer.parseInt(parts[4]); // Number of sides
                        int radius = Integer.parseInt(parts[5]); // Radius
                        image = drawPolygon(x, y, color, sides, radius);
                    } else {
                        int width = Integer.parseInt(parts[4]); // Width or size
                        int height = (parts.length > 5) ? Integer.parseInt(parts[5]) : width; // Height (default: square)

                        image = drawShape(shapeType, x, y, color, width, height);
                    }

                    // Send image to client
                    ImageIO.write(image, "png", out);
                    System.out.println("Image sent to client.");

                } catch (Exception e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage drawShape(String shapeType, int x, int y, Color color, int width, int height) {
        int canvasSize = 400;
        BufferedImage image = new BufferedImage(canvasSize, canvasSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasSize, canvasSize);

        // Draw shape
        g.setColor(color);
        if ("circle".equalsIgnoreCase(shapeType)) {
            g.fillOval(x, y, width, width); // width is used as diameter
        } else if ("rectangle".equalsIgnoreCase(shapeType)) {
            g.fillRect(x, y, width, height);
        } else if ("square".equalsIgnoreCase(shapeType)) {
            g.fillRect(x, y, width, width); // Square has equal width and height
        }

        g.dispose();
        return image;
    }

    private static BufferedImage drawPolygon(int x, int y, Color color, int sides, int radius) {
        int canvasSize = 400;
        BufferedImage image = new BufferedImage(canvasSize, canvasSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasSize, canvasSize);

        // Create polygon points
        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];

        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            xPoints[i] = x + (int) (radius * Math.cos(angle));
            yPoints[i] = y + (int) (radius * Math.sin(angle));
        }

        // Draw polygon
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, sides);

        g.dispose();
        return image;
    }
}

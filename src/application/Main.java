package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        // Entrada dos dados do cliente
        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());

        Client client1 = new Client(name, email, birthDate);

        // Entrada dos dados do pedido
        System.out.println("Enter order data:");
        System.out.print("Status (ex: PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED): ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        System.out.print("How many items to this order? ");
        int quantityItems = sc.nextInt();
        sc.nextLine();

        List<OrderItem> orderItems = new ArrayList<>();

        for (int i = 0; i < quantityItems; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            Product productInfo = new Product(productName, productPrice);
            OrderItem item = new OrderItem(productQuantity, productPrice, productInfo);
            orderItems.add(item);
        }

        // Criando o pedido com os itens
        Order order = new Order(new Date(), status, client1, orderItems);

        // Exibindo os detalhes do pedido
        System.out.println("\nORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        Menu menu = new Menu(inventario);
        Pedido pedido = new Pedido(menu);
        Scanner scan = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("""
                    Restaurante
                    1)Menu
                    2)Inventario
                    3)Pedido
                    4)Salir
                    Ingrese la opcion deseada: """);
            opcion = scan.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("""
                            Menu
                            1)Mostrar
                            2)Agregar
                            Ingrese la opcion deseada: """);
                    String opc1 = scan.next();
                    switch (opc1){

                        case "1":
                            menu.mostrar();
                            break;

                        case "2":
                            menu.agregar();
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("""
                            Inventario 
                            1)Mostrar
                            2)Agregar
                            Ingrese la opcion deseada: """);
                    String opc2 = scan.next();
                    switch (opc2){

                        case "1":
                            inventario.mostrarProductos();
                            break;

                        case "2":
                            System.out.println("Ingrese el nombre del producto:");
                            String nombreProducto = scan.next();
                            System.out.println("¿Es un producto para el Desayuno o Almuerzo?");
                            String tipoProducto = scan.next();
                            inventario.agregarProducto(nombreProducto, tipoProducto);
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("""
                            Pedido
                            1)Mostrar
                            2)Agregar
                            3)Pagar
                            Ingrese la opcion deseada: """);
                    String opc3 = scan.next();
                    switch (opc3){

                        case "1":
                            pedido.mostrar();
                            break;

                        case "2":
                            pedido.agregar();
                            break;

                        case "3":
                            pedido.pagoPedido();
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 4:

                    System.out.println("Un placer servirle");
                    System.out.println("HASTA LUEGO");
                    break;

                default:

                    System.out.println("Opción no válida");

            }
        } while (opcion != 4);

    }
}
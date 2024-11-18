import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Map<Integer, List<Producto>> pedidosDesayuno;
    private Map<Integer, List<Producto>> pedidosAlmuerzo;
    private Menu menu;
    Scanner scan = new Scanner(System.in);
    public Pedido(Menu menu) {

        this.menu = menu;
        pedidosDesayuno = new HashMap<>();
        pedidosAlmuerzo = new HashMap<>();

    }

    public void agregar() {

        System.out.println("¿Es un pedido de Desayuno o Almuerzo?");
        String tipo = scan.next();
        System.out.println("Ingrese el número de mesa (1-15):");
        int mesa = scan.nextInt();

        if (mesa < 1 || mesa > 15) {

            System.out.println("Número de mesa no válido.");

        }
        if ((tipo.equalsIgnoreCase("desayuno") && pedidosDesayuno.containsKey(mesa)) || (tipo.equalsIgnoreCase("almuerzo") && pedidosAlmuerzo.containsKey(mesa))) {

            System.out.println("Mesa no disponible.");

        }
        List<Producto> pedido = new ArrayList<>();
        String opcion;
        do {

            menu.mostrar();
            System.out.println("Ingrese el nombre del producto a agregar o 'C' para finalizar:");
            opcion = scan.nextLine();
            if (!opcion.equalsIgnoreCase("c")) {

                if (tipo.equalsIgnoreCase("desayuno")) {

                    pedido.add(new Desayuno(opcion));

                } else if (tipo.equalsIgnoreCase("almuerzo")) {

                    pedido.add(new Almuerzo(opcion));
                }
            }
        } while (!opcion.equalsIgnoreCase("c"));

        if (tipo.equalsIgnoreCase("desayuno")) {

            pedidosDesayuno.put(mesa, pedido);

        } else if (tipo.equalsIgnoreCase("almuerzo")) {

            pedidosAlmuerzo.put(mesa, pedido);

        }

    }

    public void mostrar() {

        System.out.println("Ingrese el número de mesa:");
        int mesa = scan.nextInt();
        if (pedidosDesayuno.containsKey(mesa)) {

            System.out.println("Pedido de Desayuno para la mesa " + mesa + ":");
            for (Producto p : pedidosDesayuno.get(mesa)) {

                System.out.println(p.getNombre());

            }

        } else if (pedidosAlmuerzo.containsKey(mesa)) {

            System.out.println("Pedido de Almuerzo para la mesa " + mesa + ":");
            for (Producto p : pedidosAlmuerzo.get(mesa)) {

                System.out.println(p.getNombre());

            }

        } else {

            System.out.println("No hay pedidos para la mesa " + mesa + ".");

        }

    }

    public void pagoPedido() {

        System.out.println("Ingrese el número de mesa:");
        int mesa = scan.nextInt();
        if (pedidosDesayuno.containsKey(mesa)) {

            System.out.println("Pedido de Desayuno para la mesa " + mesa + ":");
            for (Producto p : pedidosDesayuno.get(mesa)) {

                System.out.println(p.getNombre());

            }
            System.out.println("¿Desea pagar el pedido? (si/no)");
            String opcion = scan.next();
            if (opcion.equalsIgnoreCase("si")) {

                pedidosDesayuno.remove(mesa);
                System.out.println("Pedido pagado. Mesa disponible para un nuevo pedido.");

            }

        } else if (pedidosAlmuerzo.containsKey(mesa)) {

            System.out.println("Pedido de Almuerzo para la mesa " + mesa + ":");
            for (Producto p : pedidosAlmuerzo.get(mesa)) {

                System.out.println(p.getNombre());

            }
            System.out.println("¿Desea pagar el pedido? (si/no)");
            String opcion = scan.next();
            if (opcion.equalsIgnoreCase("si")) {

                pedidosAlmuerzo.remove(mesa);
                System.out.println("Pedido pagado. Mesa disponible para un nuevo pedido.");

            }
        } else {

            System.out.println("No hay pedidos para la mesa " + mesa + ".");
        }
    }
}

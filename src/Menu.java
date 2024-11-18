public class Menu {

    private Map<String, List<Producto>> menuDesayuno;
    private Map<String, List<Producto>> menuAlmuerzo;
    private Inventario inventario;
    Scanner scan = new Scanner(System.in);

    public Menu(Inventario inventario) {

        this.inventario = inventario; menuDesayuno = new HashMap<>();
        menuAlmuerzo = new HashMap<>();

    }

    public void agregar() {

        System.out.println("¿Desea agregar al menú de Desayuno o Almuerzo?");
        String tipo = scan.nextLine();
        if (tipo.equalsIgnoreCase("desayuno")) {

            System.out.println("Productos disponibles para Desayuno:");
            inventario.mostrarProductos();
            System.out.println("Ingrese el nombre del producto a agregar:");
            String producto = scan.nextLine();
            menuDesayuno.putIfAbsent("Desayuno", new ArrayList<>());
            menuDesayuno.get("Desayuno").add(new Desayuno(producto));

        } else if (tipo.equalsIgnoreCase("almuerzo")) {

            System.out.println("Productos disponibles para Almuerzo:");
            inventario.mostrarProductos();
            System.out.println("Ingrese el nombre del producto a agregar:");
            String producto = scan.nextLine();
            menuAlmuerzo.putIfAbsent("Almuerzo", new ArrayList<>());
            menuAlmuerzo.get("Almuerzo").add(new Almuerzo(producto));

        }

    }
    public void mostrar() {

        System.out.println("¿Desea ver el menú de Desayuno o Almuerzo?");
        String tipo = scan.nextLine();
        if (tipo.equalsIgnoreCase("desayuno")) {

            System.out.println("Menú de Desayuno:");
            if (menuDesayuno.containsKey("Desayuno")) {

                List<Producto> productosDesayuno = menuDesayuno.get("Desayuno");
                for (int i = 0; i < productosDesayuno.size(); i++) { Producto p = productosDesayuno.get(i);

                    System.out.println(p.getNombre());
                }
            } else {

                System.out.println("No hay productos para el desayuno.");

            }


        } else if (tipo.equalsIgnoreCase("almuerzo")) {

            System.out.println("Menú de Almuerzo:");
            if (menuAlmuerzo.containsKey("Almuerzo")) {
                List<Producto> productosAlmuerzo = menuAlmuerzo.get("Almuerzo");
                for (int i = 0; i < productosAlmuerzo.size(); i++) {

                    Producto p = productosAlmuerzo.get(i);
                    System.out.println(p.getNombre());
                }
            } else {

                System.out.println("No hay productos para el almuerzo.");
            }
        }
    }

}

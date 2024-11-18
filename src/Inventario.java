import java.util.ArrayList;
import java.util.List;

public class Inventario implements Invent {

    private List<Producto> desayuno;
    private List<Producto> almuerzo;

    public Inventario() {

        desayuno = new ArrayList<>();
        almuerzo = new ArrayList<>();
        productos();
    }

    @Override
    public void agregarProducto(String nombre, String tipo) {

        if (tipo.equalsIgnoreCase("desayuno")) {

            desayuno.add(new Desayuno(nombre));

        } else if (tipo.equalsIgnoreCase("almuerzo")) {

            almuerzo.add(new Almuerzo(nombre));
        }
    }

    @Override
    public void mostrarProductos() {

        System.out.println("Productos de Desayuno:");
        for (Producto p : desayuno) {

            System.out.println(p.getNombre());
        }
        System.out.println("Productos de Almuerzo:");

        for (Producto p : almuerzo) {

            System.out.println(p.getNombre());

        }
    }

    public void productos() {

        //Desayuno
        agregarProducto("Caldo de costilla", "desayuno");
        agregarProducto("Caldo de pescado", "desayuno");
        agregarProducto("Changua", "desayuno");
        agregarProducto("Pollo Dorado", "desayuno");
        agregarProducto("Huevos", "desayuno");
        agregarProducto("Carne Sudada", "desayuno");
        //Almuerzo
        agregarProducto("Ajiaco", "almuerzo");
        agregarProducto("Sopa de pasta", "almuerzo");
        agregarProducto("Pasta", "almuerzo");
        agregarProducto("Frijol", "almuerzo");
        agregarProducto("Sobrebarriga", "almuerzo");
        agregarProducto("Pechuga", "almuerzo");
    }

}

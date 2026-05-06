package biblioteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n============================");
            System.out.println("   GESTOR DE BIBLIOTECA");
            System.out.println("============================");
            System.out.println("1) Agregar libro");
            System.out.println("2) Listar materiales");
            System.out.println("3) Buscar por titulo");
            System.out.println("4) Prestar material");
            System.out.println("5) Devolver material");
            System.out.println("6) Agregar socio");
            System.out.println("7) Listar socios");
            System.out.println("8) Salir");
            System.out.print("Elegi una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opcion invalida. Ingresa un numero.");
                scanner.next();
                opcion = 0;
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Anio: ");
                    int anio = Integer.parseInt(scanner.nextLine());
                    biblioteca.agregarMaterial(new Libro(titulo, anio, autor, isbn));
                }
                case 2 -> biblioteca.listarMateriales();
                case 3 -> {
                    System.out.print("Titulo a buscar: ");
                    String titulo = scanner.nextLine();
                    MaterialBiblioteca resultado = biblioteca.buscarPorTitulo(titulo);
                    if (resultado != null) {
                        System.out.println("Encontrado: " + resultado);
                    } else {
                        System.out.println("No se encontro el material.");
                    }
                }
                case 4 -> {
                    System.out.print("Titulo a prestar: ");
                    biblioteca.prestarMaterial(scanner.nextLine());
                }
                case 5 -> {
                    System.out.print("Titulo a devolver: ");
                    biblioteca.devolverMaterial(scanner.nextLine());
                }
                case 6 -> {
                    System.out.print("Nombre del socio: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ID del socio: ");
                    String id = scanner.nextLine();
                    biblioteca.agregarSocio(new Socio(nombre, id));
                }
                case 7 -> biblioteca.listarSocios();
                case 8 -> System.out.println("Saliendo... Hasta luego!");
                default -> System.out.println("Opcion invalida. Intenta de nuevo.");
            }

        } while (opcion != 8);

        scanner.close();
    }
}
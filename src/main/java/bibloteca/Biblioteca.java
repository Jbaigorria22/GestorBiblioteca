package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<MaterialBiblioteca> materiales;
    private List<Socio> socios;

    public Biblioteca() {
        this.materiales = new ArrayList<>();
        this.socios     = new ArrayList<>();
    }

    // ── Materiales ──────────────────────────────────────────

    public void agregarMaterial(MaterialBiblioteca m) {
        materiales.add(m);
        System.out.println("Material agregado: " + m.getTitulo());
    }

    public void listarMateriales() {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
        System.out.println("\n-- Materiales en biblioteca --");

        for (MaterialBiblioteca m : materiales) {
            System.out.println(m);
        }
    }

    public MaterialBiblioteca buscarPorTitulo(String titulo) {
        for (MaterialBiblioteca m : materiales) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return m;
            }
        }
        return null;
    }

    public void prestarMaterial(String titulo) {
        MaterialBiblioteca m = buscarPorTitulo(titulo);
        if (m != null) {
            m.prestar();
        } else {
            System.out.println("Material no encontrado: " + titulo);
        }
    }

    public void devolverMaterial(String titulo) {
        MaterialBiblioteca m = buscarPorTitulo(titulo);
        if (m != null) {
            m.devolver();
        } else {
            System.out.println("Material no encontrado: " + titulo);
        }
    }

    // ── Socios ───────────────────────────────────────────────

    public void agregarSocio(Socio s) {
        socios.add(s);
        System.out.println("Socio registrado: " + s.getNombre());
    }

    public void listarSocios() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
            return;
        }
        System.out.println("\n-- Socios registrados --");

        for (Socio s : socios) {
            System.out.println(s);
        }
    }
}
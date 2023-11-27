package controlador;

import vista.VistaMenuPrincipal;

public class ControladorMain {

    public static void main(String[] args) throws Exception {
        VistaMenuPrincipal menu = new VistaMenuPrincipal();
        ControladorMenuPrincipal menuControlador = new ControladorMenuPrincipal(menu);
    }

}

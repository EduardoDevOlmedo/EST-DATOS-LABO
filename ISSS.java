import java.util.Scanner;

class Node {
    int data; //contiene el dato
    Node next; //hace referencia al siguiente en la lista
    String paciente; //lleva el nombre del paciente
    Node(int dato, String patient) {
        data = dato;
        next = null;
        paciente = patient;
    }
}

class ListaEnlazadaSimple {
    Node head;

    public void insert(int data, String patient) { //metodo para insertar un nuevo dato a la lista
        Node newNode = new Node(data, patient);
        if (head == null) { //si no existiese ningún dato en la lista, hacer este el head
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) { //itera sobre la lista hasta que el siguiente que hace referencia sea nulo, es decir, el fin de dicha lista
                temp = temp.next;
            }
            temp.next = newNode; //el ciclo anterior llega hasta el final, por tanto se le agrega al final el nuevo elemento
        }
    }

    public void delete(int data) { //método para eliminar algún dato específico
        Node current = head; //se lleva al actual
        Node prev = null; //se lleva al anterior como referencia

        if (current != null && current.data == data) { //si el que se quiere eliminar es al root
            head = current.next;
            return;
        }

        while (current != null && current.data != data) { //se itera la lista hasta llegar al dato que se quiere eliminar
            prev = current;
            current = current.next;
        }

        if (current == null) { //si se llega al final, el elemento de por sí ya no existe, por tanto no hacemos nada
            return;
        }

        prev.next = current.next; //se reemplaza la referencia al actual con una referencia al siguiente, efectivamente eliminando el actual
    }
    public boolean search_name(String patient) {
        Node current = head;
        while (current != null) {
            if (current.paciente.equals(patient)) { //itera hasta llegar al dato a buscar
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public boolean search(int data) { //método para buscar algún dato específico
        Node current = head;
        while (current != null) {
            if (current.data == data) { //itera hasta llegar al dato a buscar
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        System.out.println();
        while (current != null) { //se itera hasta llegar al final
            System.out.println(current.data + ", " + current.paciente);
            current = current.next;
        }
        System.out.println();
    }
}

public class ISSS {
    public static void main(String[] args) {
        ListaEnlazadaSimple list = new ListaEnlazadaSimple();
        // populamos la lista para que sea mas realista y esos dias no esten disponible de por si
        list.insert(1, "Taylor");
        list.insert(3, "Kanye");

        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de citas del ISSS \n");
        System.out.println("Podra modificar, agregar o buscar si un cupo esta disponible \n");
        int respuesta = 0;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar cita");
            System.out.println("2. Eliminar cita");
            System.out.println("3. Buscar cita");
            System.out.println("4. Mostrar citas tomadas");
            System.out.println("5. Salir");
            respuesta = leer.nextInt();

            switch (respuesta) {
                case 1:
                    System.out.println("Ingrese el dia de cita a agregar (un numero entre 1 - 30):");
                    int citaAgregada = leer.nextInt();
                    System.out.println("Ingrese el nombre del paciente:");
                    String paciente = leer.next();
                    if (list.search(citaAgregada)) { //si existe ya una cita en ese día, no hacemos nada
                        System.out.println("Ese cupo ya ha sido tomado.");
                        break;
                    }
                    if (!validateDate(citaAgregada)) { //si es una fecha inválida, no hacemos nada
                        System.out.println("El dia agregado de fecha es invalida.");
                        break;
                    }
                    list.insert(citaAgregada, paciente);
                    System.out.println("Se agrego el cupo.");
                    break;

                case 2:
                    System.out.println("Ingrese el dia de cita a eliminar (entre 1 - 30):");
                    int citaEliminada = leer.nextInt();
                    if (!list.search(citaEliminada)) { //si la cita no se encuentra, no pasa nada
                        System.out.println("Ese cupo no se ha tomado.");
                        break;
                    }
                    if (!validateDate(citaEliminada)) { //si es una fecha inválida, no hacemos nada
                        System.out.println("El dia agregado de fecha es invalida.");
                        break;
                    }
                    list.delete(citaEliminada);
                    System.out.println("Se elimino el cupo.");
                    break;

                case 3:
                    System.out.println("Desea buscar por día de cita (1) o por nombre de paciente (2)?");
                    int ans = leer.nextInt();
                    switch (ans) {
                        case 1:
                            System.out.println("Ingrese el dia de cita a buscar (entre 1 - 30):");
                            int elementoBuscar = leer.nextInt();

                            if (!validateDate(elementoBuscar)) { //si es una fecha inválida, no hacemos nada
                                System.out.println("Fecha invalida.");
                                break;
                            }
                            if (list.search(elementoBuscar)) {
                                System.out.println("El cupo en el día " + elementoBuscar + " está ocupado.");
                            } else {
                                System.out.println("El cupo en el día " + elementoBuscar + " no está ocupado.");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del paciente tal y como se ingresó:");
                            String patient = leer.next();
                            if (list.search_name(patient)) {
                                System.out.println("El paciente " + patient + " se encuentra en el sistema de citas.");
                            } else {
                                System.out.println("El paciente " + patient + " NO se encuentra en el sistema de citas.");
                            }
                            break;
                    }
                    break;

                case 4: //muestra todas las citas tomadas
                    System.out.println("Dias de citas tomados:");
                    list.display();
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el sistema de citas del ISSS.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
        } while (respuesta != 5);

        leer.close();
    }

    static boolean validateDate(int dia) { //método para validar el día
        return dia >= 1 && dia <= 30;
    }
}

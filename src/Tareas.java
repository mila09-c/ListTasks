import java.util.Scanner;

public class Tareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList<Task> taskList = new SinglyLinkedList<>();
        int option;
        do {
            System.out.println("===================== SISTEMA DE GESTIÓN DE TAREAS ================================");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar todas las tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Total de tareas");
            System.out.println("5. Modificar estado de tarea");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingresa el nombre de la tarea: ");
                    String desc = scanner.nextLine();
                    System.out.print("Ingresa el estado (Urgente / Pendiente / Completada): ");
                    String status = scanner.nextLine();
                    taskList.insertLast(new Task(desc, status));
                    System.out.println("¡Tarea agregada con éxito!");
                    break;

                case 2:
                    System.out.println("--- LISTA DE TAREAS ---");
                    taskList.traverse();
                    break;

                case 3:
                    System.out.print("Ingresa el nombre de la tarea a eliminar: ");
                    String descDel = scanner.nextLine();
                    System.out.print("Ingresa el estado de la tarea: ");
                    String statusDel = scanner.nextLine();

                    boolean removed = taskList.remove(new Task(descDel, statusDel));
                    if (removed) {
                        System.out.println("¡Tarea eliminada correctamente!");
                    } else {
                        System.out.println("No se encontró una tarea con ese nombre.");
                    }
                    break;

                case 4:
                    int total = taskList.countTasks();
                    System.out.println("Total de tareas registradas: " + total);
                    break;

                case 5:
                    System.out.print("Nombre de la tarea a modificar: ");
                    String name = scanner.nextLine();
                    System.out.print("Nuevo estado: ");
                    String state = scanner.nextLine();

                    if (taskList.updateTaskStatus(name, state)) {
                        System.out.println("¡Modificado con éxito!");
                    } else {
                        System.out.println("No se encontró.");
                    }
                    break;

                case 6:
                    System.out.println("Checa siempre tus tareas pendientes/urgentes. No procrastines");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (option != 6);

        scanner.close();
    }
}
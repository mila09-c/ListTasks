public class SinglyLinkedList<T> {
    // Es el inicio de la lista
    private Node<T> head;
    // Cantidad de nodos en la lista
    private int size;

    public SinglyLinkedList() {
        // Como es una lista vacia, no hay primer nodo
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    // Recorre toda la lista y muestra sus datos
    public void traverse() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        // Variable de trabajo LOCAL para empezar en el primer nodo
        Node<T> current = head;

        // Recorremos hasta pasar el ultimo nodo
        while (current != null) {
            // Obtenemos el dato y lo mostramos
            System.out.println(current.getData());

            // Avanzamos current al siguiente nodo
            current = current.getNext();
        }
        System.out.println();
    }

    // Insertar un nodo al inicio
    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);

        // El nuevo nodo apunta al que antes era el primero
        newNode.setNext(head);

        // Ahora el nuevo nodo es el primero
        head = newNode;
        size++;
    }

    // Insertar un nodo al final
    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);

        // Si la lista esta vacia el nuevo Node es el head
        if (isEmpty()) {
            head = newNode;
        } else {
            // Buscamos el ultimo nodo con la variable de trabajo
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // El ultimo nodo ahora apunta al nuevo
            current.setNext(newNode);
        }
        size++;
    }

    // Busca un dato en la lista
    public boolean contains(T data) {
        Node<T> current = head;

        while (current != null) {
            // Comparamos objetos con equals, no con ==
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Eliminamos la primera aparicion del dato y regresa true si lo encuentra.
    public boolean remove(T data) {
        // Lista vacía: no hay nada que borrar
        if (isEmpty()) {
            return false;
        }

        // SI el dato está en el primer nodo
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        }

        // Buscamos en el resto de la lista
        Node<T> previous = head;
        Node<T> current = head.getNext();

        // Avanzamos los dos juntos hasta encontrar el dato o llegar al final
        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.getNext();
        }

        // Si current llego a null significa que recorrimos todo y no estaba el dato
        if (current == null) {
            return false;
        }

        // Saltamos a current: el anterior ahora apunta al que venia despues
        previous.setNext(current.getNext());
        size--;
        return true;
    }

    // Muestra cuantas tareas hay en el sistema
    public int countTasks() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean updateTaskStatus(String targetDescription, String newStatus) {
        Node<T> current = head;
        while (current != null) {
            Task task = (Task) current.getData();
            if (task.getDescription().equalsIgnoreCase(targetDescription)) {
                task.setStatus(newStatus); // Actualizamos el estado
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Vacia la lista
    public void clear() {
        head = null;
        size = 0;
    }
}
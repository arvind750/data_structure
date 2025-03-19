import java.util.Scanner;

class TextState {
    String content;
    TextState next;
    TextState prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int maxHistory;
    private int size;

    public TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.size = 0;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            newState.prev = current;
            current.next = newState;
            current = newState;
            tail = newState;
            size++;

            if (size > maxHistory) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class TextEditorManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor(10);

        while (true) {
            System.out.println("\n1. Type Text\n2. Undo\n3. Redo\n4. Display Current State\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

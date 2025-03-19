class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head;

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addAtEnd(itemName, itemId, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        Item temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item not found.");
            return;
        }

        prev.next = temp.next;
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID: " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String itemName) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private Item mergeSort(Item head, boolean ascending, boolean byName) {
        if (head == null || head.next == null) {
            return head;
        }

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, ascending, byName);
        Item right = mergeSort(nextOfMiddle, ascending, byName);

        return merge(left, right, ascending, byName);
    }

    private Item merge(Item left, Item right, boolean ascending, boolean byName) {
        if (left == null) return right;
        if (right == null) return left;

        int comparison;
        if (byName) {
            comparison = left.itemName.compareToIgnoreCase(right.itemName);
        } else {
            comparison = Double.compare(left.price, right.price);
        }

        if ((ascending && comparison <= 0) || (!ascending && comparison > 0)) {
            left.next = merge(left.next, right, ascending, byName);
            return left;
        } else {
            right.next = merge(left, right.next, ascending, byName);
            return right;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return null;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " | ID: " + temp.itemId + " | Quantity: " + temp.quantity + " | Price: $" + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtEnd("Laptop", 101, 10, 1200.00);
        inventory.addAtBeginning("Smartphone", 102, 20, 800.00);
        inventory.addAtEnd("Tablet", 103, 15, 500.00);
        inventory.addAtPosition("Monitor", 104, 12, 300.00, 2);

        inventory.displayInventory();

        System.out.println("\nUpdating quantity:");
        inventory.updateQuantity(102, 25);

        System.out.println("\nSearching for item by ID:");
        inventory.searchById(103);

        System.out.println("\nSearching for item by Name:");
        inventory.searchByName("Laptop");

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting by Name (Ascending):");
        inventory.sortByName(true);
        inventory.displayInventory();

        System.out.println("\nSorting by Price (Descending):");
        inventory.sortByPrice(false);
        inventory.displayInventory();

        System.out.println("\nRemoving an item:");
        inventory.removeItem(104);
        inventory.displayInventory();
    }
}

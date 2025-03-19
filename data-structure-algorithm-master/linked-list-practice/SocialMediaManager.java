import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public User searchUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public User searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);
        if (user1 == null || user2 == null || user1 == user2) {
            System.out.println("Invalid friend connection.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid user.");
            return;
        }
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid user.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }

        System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            for (int id : mutualFriends) {
                User friend = searchUserById(id);
                if (friend != null) {
                    System.out.println(friend.name);
                }
            }
        }
    }

    public void displayFriends(int userId) {
        User user = searchUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println(user.name + "'s friends:");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
        } else {
            for (int id : user.friendIds) {
                User friend = searchUserById(id);
                if (friend != null) {
                    System.out.println(friend.name);
                }
            }
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        User temp = head;
        if (temp == null) {
            System.out.println("No users in the system.");
            return;
        }

        System.out.println("All Users:");
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMedia socialMedia = new SocialMedia();

        socialMedia.addUser(1, "Alice", 25);
        socialMedia.addUser(2, "Bob", 27);
        socialMedia.addUser(3, "Charlie", 22);
        socialMedia.addUser(4, "David", 24);

        socialMedia.displayAllUsers();

        socialMedia.addFriend(1, 2);
        socialMedia.addFriend(1, 3);
        socialMedia.addFriend(2, 4);

        socialMedia.displayFriends(1);
        socialMedia.displayFriends(2);

        socialMedia.findMutualFriends(1, 2);

        socialMedia.removeFriend(1, 2);

        socialMedia.displayFriends(1);

        socialMedia.countFriends();

        scanner.close();
    }
}

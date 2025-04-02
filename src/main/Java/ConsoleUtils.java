public class ConsoleUtils {
  public static void printSectionHeader(String text) {
      System.out.println("\n\u001B[35m========== " + text.toUpperCase() + " ==========\u001B[0m\n");
  }
  
  public static void printWithTypingEffect(String text) {
      for (char c : text.toCharArray()) {
          System.out.print(c);
          try {
              Thread.sleep(30);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }
      }
      System.out.println();
  }
  
  public static void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
  }
}
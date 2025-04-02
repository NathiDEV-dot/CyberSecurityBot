import java.util.Scanner;

public class ChatBot {
    private String userName;
    
    public void startInteraction() {
        ConsoleUtils.clearScreen();
        AudioPlayer.playWelcomeSound();
        AsciiArt.display();
        
        Scanner scanner = new Scanner(System.in);
        ConsoleUtils.printWithTypingEffect("\u001B[36mHello! Welcome to the Cybersecurity Awareness Bot. What's your name?\u001B[0m");
        userName = scanner.nextLine().trim();
        
        ConsoleUtils.printWithTypingEffect("\u001B[32mWelcome, " + userName + "! I'm here to help you stay safe online.\u001B[0m");
        ConsoleUtils.printWithTypingEffect("\u001B[33mType 'help' to see what questions you can ask, or 'exit' to quit.\u001B[0m");
    }
    
    public String generateResponse(String input) {
        input = input.toLowerCase();
        
        if (input.contains("how are you")) {
            return "I'm just a program, but I'm functioning well! How about you, " + userName + "?";
        } else if (input.contains("help")) {
            return """
                   You can ask me about:
                   - Passwords (how to create strong ones)
                   - Phishing (how to spot scams)
                   - Malware (how to stay protected)
                   - Privacy (how to protect your data)""";
        } else if (input.contains("password")) {
            return "Strong passwords should:\n- Be at least 12 characters long\n- Include numbers and symbols\n- Not contain personal information\n- Be unique for each account";
        } else if (input.contains("phishing")) {
            return "Watch out for:\n- Urgent or threatening language\n- Misspelled email addresses\n- Suspicious links\n- Requests for personal information\nWhen in doubt, contact the organization directly!";
        } else if (input.contains("malware")) {
            return "Protect yourself by:\n- Keeping software updated\n- Not downloading from untrusted sources\n- Using antivirus software\n- Being cautious with email attachments";
        } else if (input.contains("privacy")) {
            return "Protect your privacy by:\n- Reviewing app permissions\n- Using VPNs on public WiFi\n- Enabling two-factor authentication\n- Regularly checking privacy settings";
        } else {
            return "I'm not sure I understand. Try asking about:\n- Passwords\n- Phishing\n- Malware\n- Privacy\nOr type 'help' for options.";
        }
    }
    
    public void run() {
        startInteraction();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("\n\u001B[34m" + userName + "> \u001B[0m");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                System.out.println("\u001B[31mPlease enter a question...\u001B[0m");
                continue;
            }
            
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("\u001B[35mGoodbye " + userName + "! Stay safe online!\u001B[0m");
                break;
            }
            
            String response = generateResponse(input);
            ConsoleUtils.printSectionHeader("Response");
            System.out.println("\u001B[36m" + response + "\u001B[0m");
        }
        
        scanner.close();
    }
}
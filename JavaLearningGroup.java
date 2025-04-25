/*
 * مشروع تعليم الجافا - المجموعة الكبيرة (40+ عضو)
 * الموعد النهائي: كل خميس الساعة 8 مساءً
 * القائد: [اسمك هنا]
 * تاريخ الإنشاء: [التاريخ]
 */

import java.util.ArrayList;
import java.util.Scanner;

public class JavaLearningGroup {

    // بيانات المجموعة
    private static final String GROUP_NAME = "مجموعة تعليم الجافا";
    private static final int TOTAL_MEMBERS = 40;
    private static final String DEADLINE = "كل خميس الساعة 8 مساءً";
    
    // أعضاء المجموعة
    private ArrayList<Member> members = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JavaLearningGroup program = new JavaLearningGroup();
        program.run();
    }

    public void run() {
        System.out.println("🚀 مرحبًا بكم في " + GROUP_NAME);
        System.out.println("⏰ الموعد النهائي لتسليم المهام: " + DEADLINE);
        
        initializeMembers();
        displayMenu();
    }

    // تهيئة بيانات الأعضاء
    private void initializeMembers() {
        for (int i = 1; i <= TOTAL_MEMBERS; i++) {
            members.add(new Member("عضو " + i));
        }
    }

    // القائمة الرئيسية
    private void displayMenu() {
        while (true) {
            System.out.println("\n===== القائمة الرئيسية =====");
            System.out.println("1. عرض تقدم الأعضاء");
            System.out.println("2. تحديث حالة عضو");
            System.out.println("3. إرسال تذكير بالموعد");
            System.out.println("4. خروج");
            System.out.print("اختر خيارًا: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    showProgress();
                    break;
                case 2:
                    updateMemberStatus();
                    break;
                case 3:
                    sendReminder();
                    break;
                case 4:
                    System.out.println("✔ تم حفظ البيانات. إلى اللقاء!");
                    return;
                default:
                    System.out.println("⚠ خيار غير صحيح!");
            }
        }
    }

    // عرض تقدم جميع الأعضاء
    private void showProgress() {
        System.out.println("\n===== تقدم الأعضاء =====");
        System.out.println("| الاسم    | التثبيت | الأساسيات | الحلقات | المصفوفات | الدوال |");
        
        for (Member member : members) {
            System.out.printf("| %-8s | %-7s | %-9s | %-7s | %-9s | %-6s |\n",
                member.getName(),
                member.getStatus("installation"),
                member.getStatus("basics"),
                member.getStatus("loops"),
                member.getStatus("arrays"),
                member.getStatus("methods"));
        }
    }

    // تحديث حالة عضو
    private void updateMemberStatus() {
        System.out.print("أدخل رقم العضو (1-" + TOTAL_MEMBERS + "): ");
        int memberId = scanner.nextInt();
        
        if (memberId < 1 || memberId > TOTAL_MEMBERS) {
            System.out.println("⚠ رقم عضو غير صحيح!");
            return;
        }
        
        Member member = members.get(memberId - 1);
        
        System.out.println("\n===== تحديث حالة " + member.getName() + " =====");
        System.out.println("1. التثبيت");
        System.out.println("2. الأساسيات");
        System.out.println("3. الحلقات");
        System.out.println("4. المصفوفات");
        System.out.println("5. الدوال");
        System.out.print("اختر المهمة: ");
        
        int task = scanner.nextInt();
        System.out.print("الحالة (✔/✗): ");
        String status = scanner.next();
        
        switch (task) {
            case 1: member.setStatus("installation", status); break;
            case 2: member.setStatus("basics", status); break;
            case 3: member.setStatus("loops", status); break;
            case 4: member.setStatus("arrays", status); break;
            case 5: member.setStatus("methods", status); break;
            default: System.out.println("⚠ مهمة غير صحيحة!");
        }
        
        System.out.println("✔ تم التحديث!");
    }

    // إرسال تذكير بالموعد
    private void sendReminder() {
        System.out.println("\n📢 تذكير: الموعد النهائي لتسليم المهام هو " + DEADLINE);
        System.out.println("يرجى التأكد من إتمام المهام التالية:");
        System.out.println("- حل جميع التمارين المطلوبة");
        System.out.println("- رفع الكود على GitHub");
        System.out.println("- المشاركة في المناقشات");
    }
}

class Member {
    private String name;
    private String installationStatus = "✗";
    private String basicsStatus = "✗";
    private String loopsStatus = "✗";
    private String arraysStatus = "✗";
    private String methodsStatus = "✗";

    public Member(String name) {
        this.name = name;
    }

    // Getters
    public String getName() { return name; }
    
    public String getStatus(String task) {
        switch (task) {
            case "installation": return installationStatus;
            case "basics": return basicsStatus;
            case "loops": return loopsStatus;
            case "arrays": return arraysStatus;
            case "methods": return methodsStatus;
            default: return "✗";
        }
    }

    // Setters
    public void setStatus(String task, String status) {
        if (!status.equals("✔") && !status.equals("✗")) return;
        
        switch (task) {
            case "installation": installationStatus = status; break;
            case "basics": basicsStatus = status; break;
            case "loops": loopsStatus = status; break;
            case "arrays": arraysStatus = status; break;
            case "methods": methodsStatus = status; break;
        }
    }
}

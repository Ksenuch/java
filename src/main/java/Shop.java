import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    private static String[] someNames = {"Саша", "Маша", "Федя", "Глаша"};
    private static String[] products = {"Молоко", "Колбаса", "Хлеб", "Сыр", "Пиво", "Кетчуп"};

    public static void main(String[] args) throws InterruptedException, IOException {
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Работник, введите ваше имя:");
        Employee employee = new Employee(scanner.nextLine());

        System.out.println("Магазин открыт!");

        for (int i = 0; i < randomize(0, 10); i++)
            Employee.products.add(
                    new Product(products[randomize(0, products.length)], randomize(0, 300))
            );

        int days4sales = 0;
        int percent = 0;
        while (true) {
            Employee.Display();

            Thread.sleep(randomize(0, 10) * 1000);
            Consumer c = new Consumer(
                    someNames[randomize(0, someNames.length)],
                    new Product(products[randomize(0, products.length)], randomize(0, 300))
            );

            System.out.println("В магазин пришел покупатель: " + c.getName());
            System.out.println(c.getName() + " хочет купить " + c.getWantsToBuy().getName() + " за " + c.getWantsToBuy().getPrice());
            System.out.println("Введите 1, чтобы обслужить и что-нибудь другое, чтобы выгнать");
            int choice = scanner.nextInt();

            if(choice == 1) {
                if (employee.Serve(c)) {
                    System.out.println("Клиент обслужен успешно: +" + c.getWantsToBuy().getPrice());
                    storage.addConsumer(c);
                }
                else
                    System.out.println("Вы не смогли договориться с клиентом (");
            }
            else {
                System.out.println("Вы выгнали покупателя, вы плохой человек");
            }

            System.out.println("Введите 1, чтобы продолжить работу и что-нибудь другое, чтобы закрыть магазин");
            choice = scanner.nextInt();

            if (choice != 1)
                break;

            if (days4sales == 0)
                Employee.makesale(-percent);
                if (randomize(0, 101) <= 50) {
                    percent = randomize(5, 50);
                    Employee.makesale(percent);
                    days4sales = randomize(0, 8);

                    System.out.println("Внимание!!! Скидка!!! Целых " + percent + " процентов !!!\nскидка продлится " + days4sales + " дней");
                }
            else
                days4sales--;

            if (Employee.products.size() == 0) {
                System.out.println("Вы все продали, вам пора домой, отличная работа, ты супер!");
                break;
            }

            else if (Employee.products.size() == 1)
                if (Employee.products.get(0).getName() == "Пиво") {
                    System.out.println("Вы уже почти все продали, вы хорошо поработали, кстати, на складе осталось одно пиво,\n" +
                            "то, что нужно для хорошего отдыха)" + "\nЕсли захотите его забрать, мы вычтем это из вашей зарплаты," + employee.getName());

                    System.out.println("Нажмите 1, чтобы забрать пиво и пойти домой, или что-нибудь другое, чтобы попытаться его продать");
                    choice = scanner.nextInt();

                    if(choice == 1) {
                        Employee.money -= Employee.products.get(0).getPrice();
                        System.out.println("Правильное решение)\nУдачи");
                        break;
                    }
                }
        }

        System.out.println("Вы сегодня заработали: " + Employee.money + "\nудачи вам отдохнуть, " + employee.getName());
    }

    private static int randomize(int min, int max) {
        return (int) (min + Math.random() * max);
    }
}

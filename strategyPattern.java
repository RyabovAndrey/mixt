public class strategyPattern {
    /* Пример реализации паттерна Strategy*/

    // Класс реализующий конкретную стратегию, должен реализовывать этот интерфейс
    // Класс контекста использует этот интерфейс для вызова конкретной стратегии
    interface Strategy {
        int execute(int a, int b);
    }

    // Реализуем алгоритм с использованием интерфейса стратегии
    static class ConcreteStrategyAdd implements Strategy {

        public int execute(int a, int b) {
            System.out.println("Called ConcreteStrategyAdd's execute()");
            return a + b;  // Do an addition with a and b
        }
    }

    static class ConcreteStrategySubtract implements Strategy {

        public int execute(int a, int b) {
            System.out.println("Called ConcreteStrategySubtract's execute()");
            return a - b;  // Do a subtraction with a and b
        }
    }

    static class ConcreteStrategyMultiply implements Strategy {

        public int execute(int a, int b) {
            System.out.println("Called ConcreteStrategyMultiply's execute()");
            return a * b;   // Do a multiplication with a and b
        }
    }

    // Класс контекста использующий интерфейс стратегии
    static class  Context {

        private Strategy strategy;

        // Constructor
        public Context() {
        }

        // Set new strategy
        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public int executeStrategy(int a, int b) {
            return strategy.execute(a, b);
        }
    }

    // Тестовое приложение
    public static void main(String[] args) {

            Context context = new Context();

            context.setStrategy(new ConcreteStrategyAdd());
            int resultA = context.executeStrategy(3,4);

            context.setStrategy(new ConcreteStrategySubtract());
            int resultB = context.executeStrategy(3,4);

            context.setStrategy(new ConcreteStrategyMultiply());
            int resultC = context.executeStrategy(3,4);

            System.out.println("Result A : " + resultA );
            System.out.println("Result B : " + resultB );
            System.out.println("Result C : " + resultC );
    }

}

//Шаги подробно, я не хочу ноль Т_Т
//1. Создаем интерфейс Итератора с методами hasNext() и next().
//2. Создаем класс коллекции, который будет содержать метод, возвращающий объект Итератора.
//3. Создаем реализацию Итератора, которая будет использовать внутренний указатель для перехода между элементами коллекции.
//4. Используем метод Итератора next() для получения следующего элемента в коллекции, пока метод hasNext() возвращает true.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        collection.add("Item 1");
        collection.add("Item 2");
        collection.add("Item 3");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface MyIterator extends Iterator<String> {
}

class MyCollection implements Iterable<String> {
    private List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    @Override
    public MyIterator iterator() {
        return new MyIteratorImpl();
    }

    private class MyIteratorImpl implements MyIterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < items.size();
        }

        @Override
        public String next() {
            return items.get(index++);
        }
    }
}
//я пытался реализовать пример паттерна Итератор на Java) не судите строго
//Мой код создает коллекцию MyCollection, которая реализует интерфейс Iterable.
//коллекция содержит список элементов типа String.
//она также реализует метод iterator(), который возвращает объект Итератора.
//в методе main() используется объект Итератора для перебора элементов в коллекции и вывода их на экран.

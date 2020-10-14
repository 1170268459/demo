package dome4;

import dome3.Generator;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBehavior {
    private static int count = 5;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < count; i++)
            queue.offer(gen.next());
        while (queue.peek() != null)
            System.out.println(queue.remove() + "");
        System.out.println();
    }
    static class Gen implements Generator<String>{
        String[] strings=("one two three four five").split(" ");
        int i;
        @Override
        public String next() {
            return strings[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(),new Gen());
    }
}

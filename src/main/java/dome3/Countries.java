package dome3;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.*;

public class Countries {

    public static final String[][] DATA = {
            {"USA", "美国"}, {"CNY", "中国"},
    };

    static class FlyweightMap extends AbstractMap<String, String> {


        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return  new FlyweightMap.EntrySet(1);
        }

        private static class Entry implements Map.Entry<String, String> {
            int index;

            Entry(int index) {
                this.index = index;
            }

            public boolean equals(Object o) {
                return DATA[index][0].equals(o);
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

            private int size;

            public EntrySet(int size) {
                if (size < 0)
                    this.size = 0;
                else if (size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }


            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                Iter iter=new Iter();
                return iter;
            }

            public int size() {
                return size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                public Iterator<Map.Entry<String, String>> iterator() {
                    return new Iter();
                }
            }

            static Map<String, String> select(final int size) {
                return new FlyweightMap() {
                    public Set<Map.Entry<String, String>> entrySet() {
                        return new EntrySet(size);
                    }
                };

            }

            static Map<String, String> map = new FlyweightMap();

            public static Map<String, String> capitals() {
                return map;
            }

            public static Map<String, String> capitals(int size) {
                return select(size);
            }

            static List<String> names = new ArrayList<String>(map.keySet());

            public static List<String> names() {
                return names;
            }

            public static List<String> names(int size) {
                return new ArrayList<String>(select(size).keySet());
            }

            public static void main(String[] args) {
                System.out.println(capitals(10));
            }

        }


    }
}

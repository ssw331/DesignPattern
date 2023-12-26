package restaurant.menu;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangYao
 */
public class Menu implements Iterable<Orderable> {
    public List<Orderable> items;

    public Menu() {
        items = new ArrayList<>();
    }

    @Override
    public Iterator<Orderable> iterator() {
        return new MenuIterator();
    }

    private class MenuIterator implements Iterator<Orderable> {

        int index;

        @Override
        public boolean hasNext() {
            return index<items.size();
        }

        @Override
        public Orderable next() {
            return hasNext() ? items.get(index) : null;
        }
    }
}

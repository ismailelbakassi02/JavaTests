package com.project.atelier_2;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<String> items;

    public Panier() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(String item) {
        if (item == null || item.isEmpty()) {
            return false;
        }
        return items.add(item);
    }

    public boolean removeItem(String item) {
        return items.remove(item);
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public void clear() {
        items.clear();
    }

    public int getItemCount() {
        return items.size();
    }
}


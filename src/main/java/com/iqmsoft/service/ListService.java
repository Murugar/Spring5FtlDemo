package com.iqmsoft.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.iqmsoft.domain.ListItem;

@Service
public class ListService {
	private static final Map<Integer, ListItem> items = new LinkedHashMap<>();
	private static int lastId = 1;

	public Collection<ListItem> getItems() {
		return items.values();
	}

	public void removeItem(Integer id) {
		synchronized (items) {
			items.remove(id);
		}
	}

	public void editText(Integer id, String text) {
		synchronized (items) {
			getItem(id).setText(text);
		}
	}

	public void editDone(Integer id, boolean done) {
		synchronized (items) {
			getItem(id).setDone(done);
		}
	}

	private ListItem getItem(Integer id) {
		if (id == null) {
			throw new RuntimeException();
		}

		ListItem item = items.get(id);
		if (item == null) {
			throw new RuntimeException();
		}

		return item;
	}

	public void editItem(Integer id, String text) {
		if (id == null || text == null || text.isEmpty())
			return;

		synchronized (items) {
			ListItem item = items.get(id);
			if (item == null) {
				return;
			}
			item.setText(text);
		}
	}

	public void addItem(String text) {
		if (text == null || text.isEmpty())
			return;

		ListItem item = new ListItem(lastId);
		item.setText(text);
		item.setDone(false);
		items.put(lastId, item);
		lastId++;
	}
}

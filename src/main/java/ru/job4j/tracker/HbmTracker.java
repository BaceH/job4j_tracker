package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        item.setId(Integer.parseInt(id));
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return true;

    }

    @Override
    public boolean delete(String id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item(null);
        item.setId(Integer.parseInt(id));
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ru.job4j.tracker.Item where name =:name ");
        query.setParameter("name", key);
        List result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(String id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}

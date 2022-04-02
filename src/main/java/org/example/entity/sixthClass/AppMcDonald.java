package org.example.entity.sixthClass;

import org.example.entity.sixthClass.Util6.HibernateUtil6;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AppMcDonald {
    public static void main(String[] args) {
//        HibernateUtil6.getSessionFactory();
//        McDonaldFarm mcDonald = new McDonaldFarm(88,7,'M',"Barashek");
//        McDonaldFarm mcDonald = new McDonaldFarm(177,3,'M',"Ferdinand");
//        McDonaldFarm mcDonald = new McDonaldFarm(277, 9, 'M', "Spirit");
//        McDonaldFarm mcDonald = new McDonaldFarm(233,3,'F',"Rain");
//        create(mcDonald);
//        System.out.println(getById(3));
//        for (McDonaldFarm mc:read()
//             ) {
//            System.out.println(mc);
//
//        }

//        update(1,377);
//        delete(3);
        deleteAll();


    }

    public static int create(McDonaldFarm mcDonaldFarm) {
        try (Session session = HibernateUtil6.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(mcDonaldFarm);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mcDonaldFarm.getId();
    }

    public static McDonaldFarm getById(int id) {
        McDonaldFarm mcDonaldFarm = null;
        try (Session session = HibernateUtil6.getSessionFactory().openSession()) {
            session.beginTransaction();
            mcDonaldFarm = session.get(McDonaldFarm.class, id);
            session.getTransaction().commit();
            System.out.println("Successfully got id-" + mcDonaldFarm.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mcDonaldFarm;
    }

    public static List<McDonaldFarm> read() {
        List<McDonaldFarm> mcDonaldFarms = null;
        try (Session session = HibernateUtil6.getSessionFactory().openSession()) {
            session.beginTransaction();
            mcDonaldFarms = session.createQuery("from McDonaldFarm").getResultList();
            session.getTransaction().commit();
            System.out.println("Found  " + mcDonaldFarms.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mcDonaldFarms;
    }

    public static void update(int id, int weight) {
        try (Session session = HibernateUtil6.getSessionFactory().openSession()) {
            session.beginTransaction();
            McDonaldFarm mcDonaldFarm = session.get(McDonaldFarm.class, id);
            mcDonaldFarm.setWeight(weight);
            session.update(mcDonaldFarm);
            session.getTransaction().commit();
            System.out.println("Updated...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        try (Session session = HibernateUtil6.getSessionFactory().openSession()) {
            session.beginTransaction();
            McDonaldFarm mcDonaldFarm = session.get(McDonaldFarm.class, id);
            session.delete(mcDonaldFarm);
            session.getTransaction().commit();
            System.out.println("Deleted id: " + mcDonaldFarm.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAll() {
        try (Session session = HibernateUtil6.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from McDonaldFarm");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Successfully deleted all...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package org.example.entity.fristClass;

import org.example.entity.fristClass.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;


public class AppPin {
    public static void main(String[] args) {

//
//        HibernateUtil.getSessionFactory();

//        Penguin pin = new Penguin("Пин","Фатерлянд, страна Смешариков", "O, du Lieder Augustin","Фантастиш!");

          Penguin pin = new Penguin("Шкипер", "Антарктида", "Заскречено", "Улыбаемся и машем, парни! Улыбаемся и машем!!");
//
//        save(pin);

//        System.out.println(getById(1));

//        System.out.println(read());

//        update(3, "Лол", "Северное море,Адел", "Пи-пи-пи", "О Забавно!");

//        updateAddress(2,"Северное море,Адел");

//        delete(3);

//        deleteAll();

        }


    public static void save(Penguin pin){
//        Transaction transaction=null;
        try(Session session = HibernateUtil
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            session.save(pin);
            session.getTransaction().commit();
            System.out.println("Successfully added \n"+ pin);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Penguin getById(int id) {
        Penguin pin = null;
        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            pin = session.get(Penguin.class, id);
            session.getTransaction().commit();
//            System.out.println("getting " + pin.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pin;
    }

    public static List<Penguin> read() {
        List<Penguin> penguins = null;
        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            penguins = session.createQuery("from Penguin").getResultList();
            session.getTransaction().commit();
            System.out.println("Found " + penguins.size() + " penguin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return penguins;
    }

    public static void update(int id,String name,String address,String song,String favoritePhrase){
        try(Session session = HibernateUtil
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            Penguin penguin=session.get(Penguin.class,id);
            penguin.setName(name);
            penguin.setAddress(address);
            penguin.setSong(song);
            penguin.setFavoritePhrase(favoritePhrase);
            session.getTransaction().commit();
            System.out.println("Successfully updated: "+ " id " +penguin.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateAddress(int id,String address){
        Transaction transaction = null;
        try(Session session = HibernateUtil
                .getSessionFactory()
                .openSession()){
           transaction =session.beginTransaction();
            Penguin penguin=session.get(Penguin.class,id);
            penguin.setAddress(address);
            session.update(penguin);
            session.getTransaction().commit();
            System.out.println("Successfully updated: "+ " id " +penguin.getId() + "\n address "+ penguin.getAddress());
        }catch (HibernateException hibernateException){

            if (transaction!= null)transaction.rollback();
            hibernateException.printStackTrace();
        }
    }

    public static void delete(int id){
        try(Session session = HibernateUtil
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            Penguin penguin=session.get(Penguin.class,id);
            session.delete(penguin);
            session.getTransaction().commit();
            System.out.println(penguin.getName() +" is deleted");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void  deleteAll(){
        try(Session session=HibernateUtil
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            Query query=session.createQuery("delete from Penguin ");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Deleted all dates in Penguin");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

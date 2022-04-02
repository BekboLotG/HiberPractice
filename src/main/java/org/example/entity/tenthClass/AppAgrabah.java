package org.example.entity.tenthClass;
import org.example.entity.tenthClass.util10.HibernateUtil10;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppAgrabah {
    public static void main(String[] args) {
//        HibernateUtil10.getSessionFactory();
//        Agrabah agrabah = new Agrabah("Alladdin","Prince Ali Ababwa","Streets of Agrabah","Jasmine");
//        Agrabah agrabah = new Agrabah("Jasmine","Princess","The Sultan's Palace","Alladdin");
        Agrabah agrabah = new Agrabah("Rajah","tiger","Agrabah","Being with Jasmine, Aladdin");
//         create(agrabah);
//        System.out.println(getById(1));
//        for (Agrabah a:read()) {
//            System.out.println(a);
//        }
//        update(2,"Freedom");
//        delete(1);
        deleteAll();
    }


    public static void create(Agrabah agrabah){

        try(Session session = HibernateUtil10
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            session.save(agrabah);
            session.getTransaction().commit();
            System.out.println("Successfully added \n"+ agrabah);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Agrabah getById(int id) {
        Agrabah agrabah= null;
        try (Session session = HibernateUtil10
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            agrabah = session.get(Agrabah.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agrabah;
    }

    public static List<Agrabah > read() {
        List<Agrabah > agrabahList = null;
        try (Session session = HibernateUtil10
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            agrabahList = session.createQuery("from Agrabah ").getResultList();
            session.getTransaction().commit();
            System.out.println("Found " + agrabahList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agrabahList;
    }

    public static void update(int id,String likes){
        try(Session session = HibernateUtil10
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            Agrabah agrabah=session.get(Agrabah.class,id);
            agrabah.setLikes(likes);
            session.update(agrabah);
            session.getTransaction().commit();
            System.out.println("Successfully updated: "+ " id  " +agrabah.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id){
        try(Session session = HibernateUtil10
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
         Agrabah agrabah = session.get(Agrabah.class,id);
            session.delete(agrabah);
            session.getTransaction().commit();
            System.out.println(agrabah.getName() +" is deleted");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void  deleteAll(){
        try(Session session=HibernateUtil10
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete from Agrabah ");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Deleted all dates from Agrabah's  Sultan palace...");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
